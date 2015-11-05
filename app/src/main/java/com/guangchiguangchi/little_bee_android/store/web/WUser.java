package com.guangchiguangchi.little_bee_android.store.web;

import com.guangchiguangchi.little_bee_android.common.config.AppConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * 登陆接口
 * Created by jiweibo on 15/11/3.
 */
public class WUser extends HttpBase{

    private String login_url = "users/login";

    /**
     * 登陆
     * @param userName 用户名
     * @param userpwd 密码
     * @return 登录数据
     */
    public String wUserLogin(String userName,String userpwd){
        Map<String, String> data = new HashMap<String, String>();
        data.put("username", userName);
        data.put("password", userpwd);
        return httpGet(AppConfig.WEB_URL() + login_url, data);
    }

}
