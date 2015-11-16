package com.guangchiguangchi.little_bee_android.common.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.guangchiguangchi.little_bee_android.R;

import java.util.List;
import java.util.Map;

public class MyTaskAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String, Object>> mdata;

    @Override
    public int getCount() {
        return mdata.size();
    }

    @Override
    public Object getItem(int position) {
        return mdata.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
          /*  convertView = LayoutInflater.from(mContext).inflate(R.layout.liv_task_item, null);
            viewHolder.work_num = (TextView) convertView.findViewById(R.id.lis_item_id);
            viewHolder.work_time = (TextView) convertView.findViewById(R.id.lis_item_spendtime);
            viewHolder.work_pro = (TextView) convertView.findViewById(R.id.lis_item_project);
            viewHolder.work_title = (TextView) convertView.findViewById(R.id.lis_item_title);
            viewHolder.work_content = (TextView) convertView.findViewById(R.id.lis_item_content);
            viewHolder.linearlayout = (LinearLayout) convertView.findViewById(R.id.state_line);*/
            convertView.setTag(viewHolder);

        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

     /*   viewHolder.work_num.setText(mdata.get(position).get("id").toString());
        viewHolder.work_time.setText(mdata.get(position).get("spendtime").toString());
        viewHolder.work_pro.setText(mdata.get(position).get("projectname").toString());
        viewHolder.work_title.setText(mdata.get(position).get("title").toString());
        viewHolder.work_content.setText(mdata.get(position).get("content").toString());*/

        return convertView;
    }

    class ViewHolder {


    }
}
