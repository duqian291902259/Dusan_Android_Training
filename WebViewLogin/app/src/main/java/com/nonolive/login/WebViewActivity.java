package com.nonolive.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class WebViewActivity extends Activity {

    private static final String TAG = "duqian-" + WebViewActivity.class.getSimpleName();
    private WebView webView;
    private ProgressBar pbLoading;
    private Context context;
    private static String currentUrl = "http://www.nonolive.com";
    //测试环境地址：//facebook，twitter，google
    private static String server = "http://52.77.95.9:5203/";
    private static String currentUrl2 = server + "mob_login?channel=facebook&guest_id=d0d2aed9-2cc6-4a3e-a5ba-8c82e6c71bb4";
    private static final String schema = "login://nonolive.com?";
    private EditText etUrl;
    private Button btnGo;
    private long firstClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_web_view);

        initView();
        initWebView();
    }

    private void initView() {
        webView = (WebView) findViewById(R.id.webview);
        pbLoading = (ProgressBar) findViewById(R.id.pbLoading);
        etUrl = (EditText) findViewById(R.id.et_url);
        etUrl.setImeOptions(EditorInfo.IME_ACTION_GO);
        etUrl.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_GO) {
                    //处理事件
                    go2Web();
                }
                return false;
            }
        });
        btnGo = (Button) findViewById(R.id.btn_go);
        btnGo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (System.currentTimeMillis() - firstClick >= 1500) {
                    firstClick = System.currentTimeMillis();
                    go2Web();
                }else{
                    etUrl.setText("");
                }
            }
        });
        btnGo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                etUrl.setText(currentUrl2);
                go2Web();
                return true;
            }
        });
    }

    private void go2Web() {
        initUrl();
        if (TextUtils.isEmpty(currentUrl)) {
            showToast("url为空，请先输入完整的网址");
            return;
        }
        if (!currentUrl.startsWith("http")) {
            currentUrl = "http://" + currentUrl;
        }
        webView.loadUrl(currentUrl);
    }

    private void initUrl() {
        currentUrl = etUrl.getText().toString().trim();
    }

    private void initWebView() {
        WebSettings settings = webView.getSettings();
        String userAgentString = settings.getUserAgentString();
        Log.d(TAG, "userAgentString1=" + userAgentString);
        userAgentString = userAgentString.replace("; wv)", ")");
        Log.d(TAG, "userAgentString2=" + userAgentString);
        settings.setUserAgentString(userAgentString);

        settings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebAppInterface(context), "nonoJsBridge");
        webView.setWebViewClient(new MyWebViewClient());
        webView.loadUrl(currentUrl);
        //webView.loadUrl("javascript:window.nonoJsBridge.showToast('Hello nonolive')");
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.contains(schema)) {
                String jsonBase64 = url.replace(schema, "");
                String json = Base64Utils.decode(jsonBase64);
                Log.d(TAG, "json =" + json);
                Intent intent = new Intent(context, LoginActivity.class);
                intent.putExtra("login", json);
                startActivity(intent);
                finish();
                return false;
            }
            webView.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            pbLoading.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            pbLoading.setVisibility(View.GONE);
            try {
                Uri uri = Uri.parse(url);
                String host = uri.getHost();
                etUrl.setText(url);
                Log.d(TAG, "onPageFinished=" + url + " ,host =" + host);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void showToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //测试获取外部intent
    private void getDate() {
        Intent intent = getIntent();
        Uri uri = intent.getData();
        if (uri == null) return;
        currentUrl = uri.toString();//获得Uri路径 intent.getDataString();
        Log.d(TAG, "currentUrl =" + currentUrl);
    }

    public void javaCallJS() {
        webView.loadUrl("javascript:callFromJava('call from java')");
    }

}
