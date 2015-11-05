package com.guangchiguangchi.little_bee_android.activitys.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.guangchiguangchi.little_bee_android.R;
import com.guangchiguangchi.little_bee_android.common.config.UserConfig;

/**
 * 主界面
 * Created by jiweibo on 15/11/3.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setSubtitle(UserConfig.USER_NAME);
    }



}