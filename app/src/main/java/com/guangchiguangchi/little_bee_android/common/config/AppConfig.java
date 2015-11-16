package com.guangchiguangchi.little_bee_android.common.config;

/**
 * APP配置信息类
 * Created by jiweibo on 14/12/11.
 */
public class AppConfig {

//--------------空间服务器地址-----------------

    /**
     * 友加  Ip  port
     */
    public static String YWEB_IP = "172.16.255.165";
    public static String YWEB_PORT = "8089";

    /**
     * 恒铭  Ip  port
     */
    public static String ZWEB_IP = "172.16.252.241";
    public static String ZWEB_PORT = "8080";
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
     *  + "/little-bee/"
     * @return web地址
     */
    public static String WEB_URL() {
        return "http://" + ZWEB_IP + ":" + ZWEB_PORT+"/" ;
    }


}
