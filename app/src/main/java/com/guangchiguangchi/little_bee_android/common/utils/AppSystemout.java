package com.guangchiguangchi.little_bee_android.common.utils;


import com.guangchiguangchi.little_bee_android.common.config.AppConfig;

/**
 * APP的System的输出工具类
 * Created by WeiBo on 14/12/11.
 */
public class AppSystemout {
    /**
     * 打印数据
     *
     * @param biaoshi 打印数据标识
     * @param data    打印数据
     */
    public static void println(String biaoshi, String data) {
        if (AppConfig.ISDEBUG) {
            System.out.println("标识为" + biaoshi + "的数据====>[" + data + "]");
        }
    }

    /**
     * 打印数据
     *
     * @param data 打印数据
     */
    public static void println(String data) {
        if (AppConfig.ISDEBUG) {
            System.out.println("打印的数据====>[" + data + "]");
        }
    }
}
