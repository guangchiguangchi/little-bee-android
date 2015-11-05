package com.guangchiguangchi.little_bee_android.common.utils;

import android.app.Activity;
import android.content.Intent;


import com.guangchiguangchi.little_bee_android.R;

import java.util.Map;

/**
 * Activity跳转动画
 * Created by jiweibo on 14/12/12.
 */
public class ActivityAnim {
    private static Intent intent = null;


    /**
     * @param startactivity 从哪个activity
     * @param endactivity   Activity间跳转
     *                      实现动画
     */
    public static void intentActivity(Activity startactivity, Class<?> endactivity, Map<String, String> map) {
        if (intent == null) {
            intent = new Intent();
        }
        intent.setClass(startactivity, endactivity);
        if (map != null) { //处理
            for (String o : map.keySet()) {
                intent.putExtra(o, map.get(o));
            }
        }
        startactivity.startActivity(intent);
        startactivity.overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    /**
     * @param endactivity 结束当前activity的动画
     */
    public static void endActivity(Activity endactivity) {
        endactivity.finish();
        endactivity.overridePendingTransition(R.anim.right_in, R.anim.right_out);
    }

    /**
     * @param endactivity 结束当前activity的动画
     */
    public static void homeActivity(Activity endactivity) {
        endactivity.finish();
        endactivity.overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    /**
     * 参数序列化
     *
     * @param strings 参数
     * @return 返回序列化之后的String[]数组
     */
    public String[] initPropertys(String... strings) {
        if (strings[0].equals(""))
            return new String[0];
        return strings;
    }

    private static void intent(Intent intent, String[] key, String[] value) {


        for (int i = 0; i < key.length; i++) {
            intent.putExtra(key[i], value[i]);
        }
    }
}
