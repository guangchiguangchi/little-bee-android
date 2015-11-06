package com.guangchiguangchi.little_bee_android.activitys.main;

import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.guangchiguangchi.little_bee_android.R;
import com.guangchiguangchi.little_bee_android.activitys.base.AppCompatActBase;
import com.guangchiguangchi.little_bee_android.common.config.UserConfig;
import com.guangchiguangchi.little_bee_android.models.BaseModel;
import com.guangchiguangchi.little_bee_android.store.analysis.ATask;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 主界面
 * Created by jiweibo on 15/11/3.
 */
public class MainActivity extends AppCompatActBase {

    private ListView lsv_tasks;
    private Toolbar toolbar;
    private List<Map<String, Object>> list;
    private Handler uiHandler = new Handler();
    private BaseModel baseModel;
    private SimpleAdapter adapter;
    private ATask aTask;

    @Override
    public void init() {
        baseModel = new BaseModel();
        aTask = new ATask();
        list = new ArrayList<Map<String, Object>>();
        adapter = new SimpleAdapter(MainActivity.this, list,
                R.layout.liv_task_item,
                new String[]{"id", "projectname","title","spendtime","content"},
                new int[]{R.id.lis_item_id, R.id.lis_item_project, R.id.lis_item_title,
                        R.id.lis_item_spendtime, R.id.lis_item_content});
    }

    @Override
    public void setView() {
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setSubtitle(UserConfig.USER_NAME);
        setSupportActionBar(toolbar);
        lsv_tasks = (ListView) findViewById(R.id.lsv_tasks);
        lsv_tasks.setAdapter(adapter);
    }

    @Override
    public void setListener() {

    }

    @Override
    protected void getdata() {
        super.getdata();
        new GetTaskListThread().start();
    }

    class GetTaskListThread extends Thread {
        @Override
        public void run() {
            baseModel = aTask.getTasks(list);
            uiHandler.post(runnable);
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            dismissProgressDialog();
            if (baseModel.isSuccess()) {
                adapter.notifyDataSetChanged();
            } else {
                showMsg(baseModel.getData());
            }
        }
    };


}