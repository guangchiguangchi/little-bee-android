package com.guangchiguangchi.little_bee_android.common.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.guangchiguangchi.little_bee_android.R;

import java.util.List;
import java.util.Map;

/**
 * 任务adapter
 * Created by jiweibo on 15/11/6.
 */
public class TaskAdapter extends BaseAdapter {

    private List<Map<String, Object>> mdata;
    private Context mContext;


    /**
     * Constructor
     *
     * @param context The context where the View associated with this SimpleAdapter is running
     * @param data    A List of Maps. Each entry in the List corresponds to one row in the list. The
     *                Maps contain the data for each row, and should include all the entries specified in
     *                "from"
     *                ,
     *                <p/>
     *                R.layout.liv_task_item,
     *                new String[]{"id", "projectname","title","spendtime","content"},
     *                new int[]{R.id.lis_item_id, R.id.lis_item_project, R.id.lis_item_title,
     *                R.id.lis_item_spendtime, R.id.lis_item_content}
     */
    public TaskAdapter(Context context, List<Map<String, Object>> data) {
        this.mContext = context;
        this.mdata = data;
    }

    @Override
    public int getCount() {
        return mdata.size();
    }

    /**
     * 得到任务对象
     * @param position 第几个任务
     * @return 任务对象
     */
    @Override
    public Object getItem(int position) {
        return mdata.get(position);
    }

    /**
     * 得到任务状态
     * @param position 第几个任务
     * @return 返回状态数值
     */
    public int getItemState(int position) {
        return Integer.parseInt(mdata.get(position).get("123").toString());
    }

    /**
     * 得到任务id
     * @param position 第几个任务
     * @return 返回任务id
     */
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    static class ViewHolder {
        TextView title;

    }
}
