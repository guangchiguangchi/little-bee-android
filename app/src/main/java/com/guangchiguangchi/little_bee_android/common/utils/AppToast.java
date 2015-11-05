package com.guangchiguangchi.little_bee_android.common.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * APP的Toast输出工具类
 * Created by WeiBo on 14/12/11.
 */
public class AppToast {

    private static Toast mtoast;

    /**
     * 短时间Toast数据
     *
     * @param context content
     * @param data    数据
     */
    public static void show_SHORT(Context context, String data) {
        if (mtoast == null) {
            mtoast = Toast.makeText(context, data, Toast.LENGTH_SHORT);
            mtoast.setGravity(Gravity.CENTER, 0, 300);
        } else {
            mtoast.setText(data);
        }
        mtoast.show();
    }

    /**
     * 长时间Toast数据
     *
     * @param context content
     * @param data    数据
     */
    public static void show_LONG(Context context, String data) {
        if (mtoast == null) {
            mtoast = Toast.makeText(context, data, Toast.LENGTH_LONG);
            mtoast.setGravity(Gravity.CENTER, 0, 300);
        } else {
            mtoast.setText(data);
        }
        mtoast.show();
    }
}
