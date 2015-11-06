package com.guangchiguangchi.little_bee_android.store.analysis;

import com.guangchiguangchi.little_bee_android.common.config.UserConfig;
import com.guangchiguangchi.little_bee_android.models.BaseModel;
import com.guangchiguangchi.little_bee_android.store.web.WUser;

import org.json.JSONObject;

/**
 * 用户   登陆
 * Created by jiweibo on 15/7/10.
 */
public class AUser extends ABase{

    private WUser wUser ;

    public AUser(){
        wUser = new WUser();
    }

    /**
     * 登陆
     * @param userName 用户名
     * @param userpwd 密码
     * @return 登录成功失败的对象
     */
    public BaseModel userLogin(String userName,String userpwd) {
        String data = wUser.wUserLogin(userName, userpwd);
        BaseModel bBase = new BaseModel();
        try {
            JSONObject jsonObject = isSuccess(data,bBase);
            if (!bBase.isSuccess()){
                return bBase;
            }
            UserConfig.USER_ID = jsonObject.getJSONObject("data").getString("id");
            UserConfig.USER_NAME = userName;
        }catch (Exception e){
            e.printStackTrace();
            setNetJsonError(bBase);
        }
        return bBase;
    }

}
