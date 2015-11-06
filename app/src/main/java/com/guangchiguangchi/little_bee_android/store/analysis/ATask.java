package com.guangchiguangchi.little_bee_android.store.analysis;

import com.guangchiguangchi.little_bee_android.models.BaseModel;
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
public class ATask extends ABase{

    private WTask wTask ;

    public ATask(){
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
            JSONObject jsonObject = isSuccess(data,bBase);
            if (!bBase.isSuccess()){
                return bBase;
            }
            JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("assigee");

            int arraySize = jsonArray.length();

            for (int i =0 ; i<arraySize ; i++){

                Map<String, Object> map = new HashMap<>();
                map.put("id","编号:"+jsonArray.getJSONObject(i).getString("id"));
                map.put("title","任务标题:\n   "+jsonArray.getJSONObject(i).getString("title"));
                map.put("projectname","项目:"+jsonArray.getJSONObject(i).getString("projectname"));
                map.put("spendtime","工时:"+jsonArray.getJSONObject(i).getString("spendtime")+"小时");
                map.put("content","内容:\n   "+jsonArray.getJSONObject(i).getString("content"));
                list.add(map);
            }

        }catch (Exception e){
            e.printStackTrace();
            setNetJsonError(bBase);
        }
        return bBase;
    }

}
