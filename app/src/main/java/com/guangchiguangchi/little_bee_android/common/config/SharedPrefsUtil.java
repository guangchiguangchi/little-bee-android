package com.guangchiguangchi.little_bee_android.common.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.guangchiguangchi.little_bee_android.models.UserModel;

/**
 * 配置信息类
 */
public class SharedPrefsUtil {

    /**
     * app配置文件
     */
    public static final String CONFIG_FILE = "APP_CONFIG";
    /**
     * 用户名
     */
    public static final String USER_NAME = "USER_NAME";

    /**
     * 用户密码
     */
    public static final String USER_PSW = "USER_PSW";

    /**
     * 用户id
     */
    public static final String USER_ID = "USER_ID";

    /**
     * 判断是否登陆
     */
    public static final String IS_LOGIN = "IS_LOGIN";

    /**
     * 设置已经登陆
     *
     * @param context   上下文
     */
    public static void putDingDianTuiSong(Context context) {

        Editor sp = context.getSharedPreferences(CONFIG_FILE, Context.MODE_PRIVATE)
                .edit();
        sp.putBoolean(IS_LOGIN, true);
        sp.apply();

    }

    /**
     * 判断是否登陆
     *
     * @param context   上下文
     * @return 是否已经登陆
     */
    public static boolean getAutoLoadInfo(Context context ) {

        SharedPreferences sp = context.getSharedPreferences(CONFIG_FILE,
                Context.MODE_PRIVATE);
        UserConfig.USER_ID = sp.getString(USER_ID, "");
        return sp.getBoolean(IS_LOGIN, false);

    }

    /**
     * 保存用户名和密码
     *
     * @param context   上下文
     * @param username  用户名
     * @param userpsw   用户密码
     */
    public static void putUserInfo(Context context, String username, String userpsw) {

        Editor sp = context.getSharedPreferences(CONFIG_FILE, Context.MODE_PRIVATE)
                .edit();
        sp.putString(USER_NAME, username);
        sp.putString(USER_PSW, userpsw);
        sp.apply();

    }

    /**
     * 获取用户信息
     * 手机号和密码
     *
     * @param context   上下文
     * @return 用户对象
     */
    public static UserModel getUserInfo(Context context) {

        SharedPreferences sp = context.getSharedPreferences(CONFIG_FILE,
                Context.MODE_PRIVATE);
        UserModel me = new UserModel();
        me.setUsername(sp.getString(USER_NAME, ""));
        me.setPassword(sp.getString(USER_PSW, ""));
        me.setUserid(sp.getString(USER_ID,""));
        return me;

    }





}
