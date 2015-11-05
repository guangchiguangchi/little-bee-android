package com.guangchiguangchi.little_bee_android.store.web;

import com.guangchiguangchi.little_bee_android.common.utils.AppSystemout;

import java.util.Iterator;
import java.util.Map;

/**
 * WebService基本工具方法
 * Created by WeiBo on 14/12/11.
 */
public class HttpBase {

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


    /**
     * get 请求
     *
     * @param url 请求地址
     * @return Json字符串
     * 3秒超时
     */
    public String httpGet(String url) {
        String data = null;
        try {
            data = HttpRequest.get(url).connectTimeout(3000).body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * get 请求
     *
     * @param url 请求地址
     * @param map 参数map
     * @return Json字符串
     * 3秒超时
     */
    public String httpGet(String url, Map<String, String> map) {
        String data = null;
        try {
            url = url + "?";
            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                url = url + entry.getKey() + "="
                        + new String(entry.getValue().toString().getBytes(), "iso-8859-1") + "&";
            }
            url = url.substring(0, url.length() - 1);
            data = HttpRequest.get(url).connectTimeout(3000).body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }


    /**
     * Post方法
     *
     * @param url 请求地址
     * @param map 参数map
     * @return Json字符串
     * 3秒超时
     */
    public String httpPost(String url, Map<String, String> map) {
        String data = null;
        try {
            data = HttpRequest.post(url).connectTimeout(3000).form(map).body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

//    /**
//     * Post方法
//     *
//     * @param url 请求地址
//     * @param map 参数map
//     * @return Json字符串
//     * 3秒超时
//     */
//    public String httpPost(String url, String map) {
//        String data = null;
//        try {
//            data = HttpRequest.post(url).connectTimeout(3000).body(map);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return data;
//    }

    /**
     * Post方法
     *
     * @param url 请求地址
     * @return Json字符串
     * 3秒超时
     */
    public String httpPost(String url) {
        String data = null;
        try {
            data = HttpRequest.post(url).connectTimeout(3000).body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * Put方法
     *
     * @param url 请求地址
     * @param map 参数map
     * @return Json字符串
     * 3秒超时
     */
    public String httpPut(String url, Map<String, String> map) {
        String data = null;
        try {
            data = HttpRequest.put(url).connectTimeout(3000).form(map).body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * Put方法
     *
     * @param url 请求地址
     * @return Json字符串
     * 3秒超时
     */
    public String httpPut(String url) {
        String data = null;
        try {
            data = HttpRequest.put(url).connectTimeout(3000).body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * Delete方法
     *
     * @param url 请求地址
     * @param map 参数map
     * @return Json字符串
     * 3秒超时
     */
    public String httpDelete(String url, Map<String, String> map) {
        String data = null;
        try {
            data = HttpRequest.delete(url).connectTimeout(3000).form(map).body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * Delete方法
     *
     * @param url 请求地址
     * @return Json字符串
     * 3秒超时
     */
    public String httpDelete(String url) {
        String data = null;
        try {
            data = HttpRequest.delete(url).connectTimeout(3000).body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }


}
