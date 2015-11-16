package com.guangchiguangchi.little_bee_android.store.web;

import com.guangchiguangchi.little_bee_android.common.config.AppConfig;
import com.guangchiguangchi.little_bee_android.common.config.UserConfig;
import com.guangchiguangchi.little_bee_android.models.TaskModel;
import com.guangchiguangchi.little_bee_android.models.UserModel;

import java.util.HashMap;
import java.util.Map;

/**
 * 任务
 * Created by jiweibo on 15/11/5.
 */
public class WTask extends HttpBase {
    private TaskModel taskModel;

    public WTask() {
        taskModel = new TaskModel();

    }

    /**
     * 任务的url地址
     */
    private String url1 = "tasks/getTaskList";

    /**
     * 开始任务
     */
    private String url2 = "tasks/changeTaskStatus";

    /**
     * 获取任务数据
     */
    public String wGetTasks() {
        Map<String, String> data = new HashMap<String, String>();
        data.put("userid", UserConfig.USER_ID);
        return httpGet(AppConfig.WEB_URL() + url1, data);
    }


    /**
     * 开始任务 #
     */
    public String wStartTask(String taskid, String status) {
        Map<String, String> SData = new HashMap<String, String>();


        SData.put("taskid", taskid);
        SData.put("status", status);
        return httpGet(AppConfig.WEB_URL() + url2, SData);


    }

    /**
     * 结束任务 #
     */
    public String wStopTask() {
        return "";
    }

    /**
     * 暂停任务 #
     */
    public String wPauseTask() {
        return "";
    }
}
