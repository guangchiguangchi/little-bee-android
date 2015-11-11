package com.guangchiguangchi.little_bee_android.activitys.welcome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.guangchiguangchi.little_bee_android.R;
import com.guangchiguangchi.little_bee_android.activitys.main.MainActivity;
import com.guangchiguangchi.little_bee_android.activitys.usermanage.LoginActivity;
import com.guangchiguangchi.little_bee_android.common.utils.SharedPrefsUtil;
import com.guangchiguangchi.little_bee_android.common.utils.ActivityAnim;


/**
 * 欢迎界面
 * Created by jiweibo on 15/11/3.
 */
public class WelComeActivity extends Activity{
    private Handler UiHandler = new Handler();

    private boolean islogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        islogin = SharedPrefsUtil.isUserInfo(this);
        UiHandler.post(updata_runnable);
    }


    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent();
            if (islogin){
                ActivityAnim.intentActivity(WelComeActivity.this, MainActivity.class, null);
            }
            else{
                ActivityAnim.intentActivity(WelComeActivity.this, LoginActivity.class, null);
            }
            finish();
        }
    };

    private Runnable updata_runnable = new Runnable() {
        @Override
        public void run() {

            //检查更新的代码




            UiHandler.postDelayed(runnable,1000);
        }
    };

}
