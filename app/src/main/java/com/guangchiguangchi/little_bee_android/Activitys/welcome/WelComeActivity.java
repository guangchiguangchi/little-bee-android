package com.guangchiguangchi.little_bee_android.activitys.welcome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.guangchiguangchi.little_bee_android.R;
import com.guangchiguangchi.little_bee_android.activitys.usermanage.LoginActivity;


/**
 * 欢迎界面
 * Created by jiweibo on 15/11/3.
 */
public class WelComeActivity extends Activity{
    private Handler UiHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        UiHandler.postDelayed(runnable,2000);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {

            Intent intent = new Intent();
            intent.setClass(WelComeActivity.this.getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }
    };

}
