package com.guangchiguangchi.little_bee_android.store.analysis;

import com.guangchiguangchi.little_bee_android.common.config.UserConfig;
import com.guangchiguangchi.little_bee_android.common.utils.AppSystemout;
import com.guangchiguangchi.little_bee_android.models.BaseModel;
import com.guangchiguangchi.little_bee_android.models.TaskModel;
import com.guangchiguangchi.little_bee_android.store.web.WTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiweibo on 15/7/10.
 * 获取任务列表
 */
public class ATask extends ABase {

    private WTask wTask;
    private TaskModel taskmodl;
    private TaskModel taskModel;

    public ATask() {
        wTask = new WTask();
    }

    /**
     * 获取任务列表
     */
    public BaseModel getTasks(List<Map<String, Object>> list) {
        list.clear();
        String data = wTask.wGetTasks();
        BaseModel bBase = new BaseModel();

        try {
            JSONObject jsonObject = isSuccess(data, bBase);
            if (!bBase.isSuccess()) {
                return bBase;
            }
            JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("assigee");

            int arraySize = jsonArray.length();

            for (int i = 0; i < arraySize; i++) {

                taskmodl = new TaskModel();
                taskmodl.setId(jsonArray.getJSONObject(i).getString("id"));
                taskmodl.setTitle(jsonArray.getJSONObject(i).getString("title"));
                taskmodl.setProjectname(jsonArray.getJSONObject(i).getString("projectname"));
                taskmodl.setSpendtime(jsonArray.getJSONObject(i).getString("spendtime"));
                taskmodl.setContent(jsonArray.getJSONObject(i).getString("content"));
                taskmodl.setStatus(jsonArray.getJSONObject(i).getString("status"));
                Map<String, Object> map = new HashMap<>();

                map.put("id", taskmodl.getId());
                map.put("title",  taskmodl.getTitle());
                map.put("projectname",  taskmodl.getProjectname());
                map.put("spendtime", taskmodl.getSpendtime() + "小时");
                map.put("content", taskmodl.getContent());
                map.put("status", taskmodl.getStatus());

                list.add(map);
            }

        } catch (Exception e) {
            e.printStackTrace();
            setNetJsonError(bBase);
        }
        return bBase;
    }


    /**
     * 开始任务  #
     *
     * @param taskid 任务id
     * @param status 任务状态
     * @return 修改是否成功
     */
    public BaseModel startTask(String taskid, String status) {
        String data = wTask.wStartTask(taskid, status);
        BaseModel bBase = new BaseModel();
        try {
            JSONObject jsonObject = isSuccess(data, bBase);
            if (!bBase.isSuccess()) {
                return bBase;
            }
        } catch (Exception e) {
            e.printStackTrace();
            setNetJsonError(bBase);
        }
        return bBase;
    }

    /**
     * 结束任务  #
     *
     * @param taskId 任务id
     * @return 修改是否成功
     */
    public BaseModel stopTask(int taskId) {
        String data = wTask.wGetTasks();
        BaseModel bBase = new BaseModel();
        try {
            JSONObject jsonObject = isSuccess(data, bBase);
            if (!bBase.isSuccess()) {
                return bBase;
            }
            JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("assigee");

            int arraySize = jsonArray.length();

            for (int i = 0; i < arraySize; i++) {

                Map<String, Object> map = new HashMap<>();
                map.put("id", "编号:" + jsonArray.getJSONObject(i).getString("id"));
                map.put("title", "任务标题:\n   " + jsonArray.getJSONObject(i).getString("title"));
                map.put("projectname", "项目:" + jsonArray.getJSONObject(i).getString("projectname"));
                map.put("spendtime", "工时:" + jsonArray.getJSONObject(i).getString("spendtime") + "小时");
                map.put("content", "内容:\n   " + jsonArray.getJSONObject(i).getString("content"));


            }

        } catch (Exception e) {
            e.printStackTrace();
            setNetJsonError(bBase);
        }
        return bBase;
    }

    /**
     * 暂停任务  #
     *
     * @param taskId 任务id
     * @return 修改是否成功
     */
    public BaseModel pauseTask(int taskId) {
        String data = wTask.wGetTasks();
        BaseModel bBase = new BaseModel();
        try {
            JSONObject jsonObject = isSuccess(data, bBase);
            if (!bBase.isSuccess()) {
                return bBase;
            }
            JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("assigee");

            int arraySize = jsonArray.length();

            for (int i = 0; i < arraySize; i++) {

                Map<String, Object> map = new HashMap<>();
                map.put("id", "编号:" + jsonArray.getJSONObject(i).getString("id"));
                map.put("title", "任务标题:\n   " + jsonArray.getJSONObject(i).getString("title"));
                map.put("projectname", "项目:" + jsonArray.getJSONObject(i).getString("projectname"));
                map.put("spendtime", "工时:" + jsonArray.getJSONObject(i).getString("spendtime") + "小时");
                map.put("content", "内容:\n   " + jsonArray.getJSONObject(i).getString("content"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            setNetJsonError(bBase);
        }
        return bBase;
    }

}
