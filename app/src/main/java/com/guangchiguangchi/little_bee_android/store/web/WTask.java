package com.guangchiguangchi.little_bee_android.store.web;

import com.guangchiguangchi.little_bee_android.common.config.AppConfig;
import com.guangchiguangchi.little_bee_android.common.config.UserConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * 任务
 * Created by jiweibo on 15/11/5.
 */
public class WTask extends HttpBase{

    private String url = "tasks/getTaskList";

    /**
     * 获取任务数据
     */
    public String wGetTasks(){
        Map<String, String> data = new HashMap<String, String>();
        data.put("userid", UserConfig.USER_ID);
        return httpGet(AppConfig.WEB_URL() + url, data);
    }

}