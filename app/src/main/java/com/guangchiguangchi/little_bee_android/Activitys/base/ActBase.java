package com.guangchiguangchi.little_bee_android.activitys.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Gravity;
//import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jiweibo on 15/7/10.
 * BaseActivity
 */
public abstract class ActBase extends Activity {

    protected ProgressDialog pDialog;
    private Toast msgToast;
//    private TextView txtv_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseinit();
        init();
        setView();
        setListener();
        getdata();
    }

    /**
     * base初始化对象
     */
    private void baseinit(){
        if (android.os.Build.VERSION.SDK_INT > 11) {
            pDialog = new ProgressDialog(this, AlertDialog.THEME_HOLO_LIGHT);
        } else {
            pDialog = new ProgressDialog(this);
        }
    }

    /**
     *  初始化对象
     */
    public abstract void init();

    /**
     *  绑定控件
     */
    public abstract void setView();

    /**
     *  设置控件的监听事件
     */
    public abstract void setListener();
    /**
     *  获取数据
     */
    protected void getdata(){}

    /**
     *  显示耗时操作的dialog
     * @param title 标题
     * @param msg 消息
     */
    protected void showProgressDialog(String title, String msg) {
        if (pDialog != null) {
            // 设置ProgressDialog点击其他地方不退出
            pDialog.setCanceledOnTouchOutside(false);
            pDialog.setCancelable(false);
            pDialog.setTitle(title);
            pDialog.setMessage(msg);
            if (!pDialog.isShowing()) {
                pDialog.show();
            }
        } else {
            System.out.println("ERRORRRRRRRRRRRR!需要先声明ProgressDialog!");
        }
    }
    /**
     *  显示耗时操作的dialog
     */
    protected void showProgressDialog() {
        if (pDialog != null) {
            // 设置ProgressDialog点击其他地方不退出
            pDialog.setCanceledOnTouchOutside(false);
            pDialog.setCancelable(false);
            pDialog.setMessage("拼命加载中...");
            if (!pDialog.isShowing()) {
                pDialog.show();
            }
        } else {
            System.out.println("ERRORRRRRRRRRRRR!需要先声明ProgressDialog!");
        }
    }

    /**
     * 关闭耗时操作的dialog
     */
    protected void dismissProgressDialog() {
        if (pDialog.isShowing()) {
            pDialog.dismiss();
        }
    }

    /**
     * 短时间显示Toast
     */
    protected void showMsg(String msg) {
        if (msgToast == null) {
            msgToast = Toast.makeText(ActBase.this, msg, Toast.LENGTH_SHORT);
            msgToast.setGravity(Gravity.CENTER, 0, 300);
        } else {
            msgToast.setText(msg);
        }
        msgToast.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

//    /**
//     * 设置Activity标题
//     * @param title
//     */
//    protected void setActTitle(String title){
//        txtv_title= (TextView) findViewById(R.id.txtv_title);
//        txtv_title.setText(title);
//    }

}
