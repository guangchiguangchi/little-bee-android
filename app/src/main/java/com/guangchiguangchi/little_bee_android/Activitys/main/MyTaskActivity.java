package com.guangchiguangchi.little_bee_android.activitys.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.guangchiguangchi.little_bee_android.R;
import com.guangchiguangchi.little_bee_android.activitys.base.AppCompatActBase;
import com.guangchiguangchi.little_bee_android.common.config.UserConfig;
import com.guangchiguangchi.little_bee_android.models.BaseModel;
import com.guangchiguangchi.little_bee_android.store.analysis.ATask;

import java.util.List;
import java.util.Map;


public class MyTaskActivity extends AppCompatActBase {

    private ListView my_tasklist;
    private Toolbar toolbar;
    private List<Map<String, Object>> list;
    private Handler uiHandler = new Handler();
    private LinearLayout lin1;
    private BaseModel baseModel;
    private SimpleAdapter adapter;
    private ATask aTask;

    @Override
    public void init() {
        setContentView(R.layout.activity_mytask);
    }

    @Override
    public void setView() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("我的任务");
        my_tasklist = (ListView) findViewById(R.id.my_tasklist);

    }

    @Override
    public void setListener() {

    }

    @Override
    protected void getdata() {
        super.getdata();
      /*  new GetTaskListThread().start();*/
    }


}