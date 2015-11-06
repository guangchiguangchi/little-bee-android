package com.guangchiguangchi.little_bee_android.common.config;

/**
 * APP配置信息类
 * Created by jiweibo on 14/12/11.
 */
public class AppConfig {

//--------------空间服务器地址-----------------

    /**
     * 服务器IP地址
     */
    public static String WEB_IP = "172.16.248.4";

    /**
     * java后台ip
     */
    public static String WEB_PORT = "8000";

    /**
     * APP状态 控制system和log的输出 true 为debug模式有打印  false 为上线模式无打印
     */
    public static Boolean ISDEBUG = true;

    /**
     * web地址
     * @return web地址
     */
    public static String WEB_URL() {
        return "http://" + WEB_IP + ":" + WEB_PORT + "/little-bee/";
    }


}
