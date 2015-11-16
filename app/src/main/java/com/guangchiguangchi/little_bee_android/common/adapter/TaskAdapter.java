package com.guangchiguangchi.little_bee_android.common.adapter;

import android.content.Context;
import android.test.suitebuilder.TestMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.guangchiguangchi.little_bee_android.R;
import com.guangchiguangchi.little_bee_android.common.config.UserConfig;
import com.guangchiguangchi.little_bee_android.common.utils.AppSystemout;
import com.guangchiguangchi.little_bee_android.models.TaskModel;
import com.guangchiguangchi.little_bee_android.models.UserModel;

import java.util.List;
import java.util.Map;

/**
 * 任务adapter
 * Created by jiweibo on 15/11/6.
 */
public class TaskAdapter extends BaseAdapter {

    private List<Map<String, Object>> mdata;
    private Context mContext;
    private TaskModel tskmo;

    public TaskAdapter(Context context, List<Map<String, Object>> data) {
        tskmo=new  TaskModel();
        this.mContext = context;
        this.mdata = data;

    }

    @Override
    public int getCount() {
        return mdata.size();
    }

    /**
     * 得到任务对象
     *
     * @param position 第几个任务
     * @return 任务对象
     */
    @Override
    public Object getItem(int position) {
        return mdata.get(position);
    }

    /**
     * 得到任务状态
     *
     * @param position 第几个任务
     * @return 返回状态数值
     */
    public int getItemState(int position) {
        return Integer.parseInt(mdata.get(position).get("123").toString());
    }

    /**
     * 得到任务id
     *
     * @param position 第几个任务
     * @return 返回任务id
     */
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.liv_task_item, null);
            viewHolder.work_num = (TextView) convertView.findViewById(R.id.lis_item_id);
            viewHolder.work_time = (TextView) convertView.findViewById(R.id.lis_item_spendtime);
            viewHolder.work_pro = (TextView) convertView.findViewById(R.id.lis_item_project);
            viewHolder.work_title = (TextView) convertView.findViewById(R.id.lis_item_title);
            viewHolder.work_content = (TextView) convertView.findViewById(R.id.lis_item_content);
            viewHolder.linearlayout = (LinearLayout) convertView.findViewById(R.id.state_line);
            convertView.setTag(viewHolder);

        } else {


            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.work_num.setText("编号:" + mdata.get(position).get("id").toString());
        viewHolder.work_time.setText("任务标题:\n   " + mdata.get(position).get("spendtime").toString());
        viewHolder.work_pro.setText("项目:" + mdata.get(position).get("projectname").toString());
        viewHolder.work_title.setText("工时:" + mdata.get(position).get("title").toString());
        viewHolder.work_content.setText("内容:\n   " + mdata.get(position).get("content").toString());


       if (mdata.get(position).get("status").toString().equals("0")) {
           viewHolder.linearlayout.setBackgroundResource(R.drawable.x_liv_frame_color_red);
        } else if (mdata.get(position).get("status").toString().equals("1")) {
            viewHolder.linearlayout.setBackgroundResource(R.drawable.x_liv_frame_color_huang);
        } else if (mdata.get(position).get("status").toString().equals("2")) {
            viewHolder.linearlayout.setBackgroundResource(R.drawable.x_liv_frame_color_lv);
        }


        return convertView;
    }

    static class ViewHolder {
        TextView work_num;
        TextView work_time;
        TextView work_pro;
        TextView work_title;
        TextView work_content;
        LinearLayout linearlayout;
    }
}
