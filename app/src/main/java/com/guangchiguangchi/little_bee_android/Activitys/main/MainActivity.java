package com.guangchiguangchi.little_bee_android.activitys.main;

import android.content.DialogInterface;
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
import com.guangchiguangchi.little_bee_android.common.utils.AppSystemout;
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
    private LinearLayout lin1;
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
        lin1 = (LinearLayout)findViewById(R.id.lin1);
    }

    @Override
    public void setListener() {
        lsv_tasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.ic_bee);
                builder.setTitle("小蜜蜂");
                //    指定下拉列表的显示数据
                final String[] cities  = new String[1];

                cities[0] = "开始任务";

                //    设置一个下拉的列表选择项
                builder.setItems(cities, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {


            AppSystemout.println("1234234234234234");


            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}