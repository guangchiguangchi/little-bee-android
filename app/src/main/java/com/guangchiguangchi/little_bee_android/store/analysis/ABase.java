package com.guangchiguangchi.little_bee_android.store.analysis;

import com.guangchiguangchi.little_bee_android.common.config.AppFinishedMessage;
import com.guangchiguangchi.little_bee_android.common.utils.AppSystemout;
import com.guangchiguangchi.little_bee_android.models.BaseModel;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 数据解析基础类
 * Created by WeiBo on 14/12/11.
 */
public class ABase {

    /**
     * 判断网络请求
     *
     * @param data     网络数据
     * @param errorMsg 错误数据对象
     * @return JSONObject 网络数据对象
     * @throws JSONException 解析错误异常
     */
    protected JSONObject isSuccess(String data, BaseModel errorMsg) {
        AppSystemout.println(data);
        if (data == null) {
            setNetConnectionsError(errorMsg);
            return null;
        }
        try {
            JSONObject jsonObject = new JSONObject(data);
            if (jsonObject.getBoolean("issuccess")) {
                errorMsg.setSuccess(true);
                return jsonObject;
            } else {
                setNetDataError(jsonObject, errorMsg);
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            setNetJsonError(errorMsg);
            return null;
        }
    }

    /**
     * 判断网络请求
     *
     * @param data 网络数据
     * @return BBase 判断对象
     */
    protected BaseModel isSuccess(String data) {
        BaseModel bb = new BaseModel();
        isSuccess(data, bb);
        return bb;
    }


    /**
     * 请求数据错误
     *
     * @param errorMsg 错误信息对象
     */
    protected void setNetDataError(JSONObject jsonObject, BaseModel errorMsg) {
        try {
            errorMsg.setSuccess(false);
            errorMsg.setData(
                    jsonObject.getString("message")+"...");
        } catch (JSONException e) {
            e.printStackTrace();
            setNetJsonError(errorMsg);
        }
    }

    /**
     * 网络数据JSON格式异常
     *
     * @param errorMsg 错误信息对象
     */
    protected void setNetJsonError(BaseModel errorMsg) {
        errorMsg.setSuccess(false);
        errorMsg.setData(AppFinishedMessage.MESSAGE_NET_JSON_EXCEPTION);
    }

    /**
     * 网络连接异常
     *
     * @param errorMsg 错误信息对象
     */
    protected void setNetConnectionsError(BaseModel errorMsg) {
        errorMsg.setSuccess(false);
        errorMsg.setData(AppFinishedMessage.MESSAGE_NET_CONNECTIONS_EXCEPTION);
    }


}
