package com.nonolive.login;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        String login = getIntent().getStringExtra("login");

        TextView tvResult = (TextView) findViewById(R.id.tv_result);
        tvResult.setText(login);
        Log.d("duqian", "login info = " + login);

        /*
        login info = {"code":0,"msg":"login success","user":{"account_dev":0,"_id":"58bfa87763cae467376573a7","user_id":20477,"mobile_region":"+86","location":"Indonesia","loginname":"杜乾1","my_id":20477,"avatar":"http://graph.facebook.com/790811584402809/picture?type=large","email":"790811584402809","medals":[],"exp":0,"level":1,"gift_send_history":0,"broadcast_times":0,"app_open_times":0,"watch_times":0,"viewers":0,"fans":0,"following":0,"gift_revenue_history":0,"fit_in_locations":[],"style":[],"sort":0,"anchor_group":[],"status":10,"account_total":15,"account":15,"active_at":"2017-08-15T11:58:50.668Z","update_at":"2017-08-15T11:58:50.668Z","create_at":"2017-08-15T11:53:47.000Z","guest_id":"d0d2aed9-2cc6-4a3e-a5ba-8c82e6c71bb4"}}
        * */
    }
}
