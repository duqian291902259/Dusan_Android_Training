package com.nonolive.login;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Description:JavaScript 与 android 交互的接口
 *
 * @author 杜乾-duqian,Created on 2017/8/14 - 15:13.
 *         E-mail:duqian2010@gmail.com
 */
public class WebAppInterface {
    private static final String TAG = WebAppInterface.class.getSimpleName();
    private Context mContext;
    private Handler handler;

    public WebAppInterface(Context c) {
        mContext = c;
        handler = new Handler(Looper.getMainLooper());
    }

    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface//webApp传递参数给android
    public void sendData2Android(String data) {
        if (data.contains("param")){

        }
    }

    //android传递参数给 webApp
    @JavascriptInterface
    public String sendDate2Web() {
        return "test duqian";
    }

}