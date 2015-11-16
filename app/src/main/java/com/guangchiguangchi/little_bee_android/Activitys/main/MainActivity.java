package com.guangchiguangchi.little_bee_android.activitys.main;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.guangchiguangchi.little_bee_android.R;
import com.guangchiguangchi.little_bee_android.activitys.base.AppCompatActBase;
import com.guangchiguangchi.little_bee_android.common.adapter.TaskAdapter;
import com.guangchiguangchi.little_bee_android.common.config.UserConfig;
import com.guangchiguangchi.little_bee_android.common.utils.AppToast;
import com.guangchiguangchi.little_bee_android.models.BaseModel;
import com.guangchiguangchi.little_bee_android.models.TaskModel;
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
    private LinearLayout lin1;
    private BaseModel baseModel;
    private TaskAdapter adapter;
    private ATask aTask;
    private TaskModel taskModel;

    @Override
    public void init() {
        baseModel = new BaseModel();
        aTask = new ATask();
        taskModel = new TaskModel();
        list = new ArrayList<Map<String, Object>>();

    }

    @Override
    public void setView() {
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setSubtitle(UserConfig.USER_NAME);
        setSupportActionBar(toolbar);
        lsv_tasks = (ListView) findViewById(R.id.lsv_tasks);
        adapter = new TaskAdapter(MainActivity.this, list);
        lsv_tasks.setAdapter(adapter);
        lin1 = (LinearLayout) findViewById(R.id.lin1);
    }

    @Override
    public void setListener() {
        lsv_tasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                UserConfig.TaskId = list.get(position).get("id").toString();
                UserConfig.Status = list.get(position).get("status").toString();

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.ic_bee);
                builder.setTitle("小蜜蜂");
                //    指定下拉列表的显示数据
                final String[] cities = new String[]{"任务开始", "任务完成"};
                String[] citiesparams = new String[]{"任务完成"};
                //    设置一个下拉的列表选择项
                builder.setItems(cities, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {

                            case 0:
                                if (UserConfig.Status == "0") {
                                    new StartTaskThread().start();
                                }else{

                                    AppToast.show_SHORT(MainActivity.this,"任务已开始");
                                }


                                break;

                            case 1:

                                break;

                        }
                    }
                });
                builder.show();

            }
        });
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
                if (list.size() == 0)
                    lin1.setVisibility(View.VISIBLE);
                else
                    lin1.setVisibility(View.INVISIBLE);
            } else {
                showMsg(baseModel.getData());
            }
        }
    };


    class StartTaskThread extends Thread {

        @Override
        public void run() {

            baseModel = aTask.startTask(UserConfig.TaskId, UserConfig.Status);
            uiHandler.post(run1);

        }


    }

    private Runnable run1 = new Runnable() {
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu m = menu.addSubMenu("任务管理");
        m.add(1, 1, 1, "添加");
        m.add(1, 2, 1, "修改");
        m.add(1, 3, 1, "删除");
        menu.add(2, 4, 2, "我的任务");
        menu.add(2, 5, 2, "已完成的任务");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getGroupId() == 1) {
            switch (item.getItemId()) {
                case 1:
                    Toast.makeText(MainActivity.this, "a" +
                            "dd", Toast.LENGTH_SHORT).show();
                    break;
            }

        } else if (item.getItemId() == 4) {
            Toast.makeText(MainActivity.this, "add", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == 5) {
            Toast.makeText(MainActivity.this, "ss", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


}