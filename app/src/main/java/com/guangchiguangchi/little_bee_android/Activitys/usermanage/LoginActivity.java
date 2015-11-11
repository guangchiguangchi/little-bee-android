package com.guangchiguangchi.little_bee_android.activitys.usermanage;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.guangchiguangchi.little_bee_android.R;
import com.guangchiguangchi.little_bee_android.activitys.base.ActBase;
import com.guangchiguangchi.little_bee_android.activitys.main.MainActivity;
import com.guangchiguangchi.little_bee_android.common.utils.SharedPrefsUtil;
import com.guangchiguangchi.little_bee_android.common.utils.ActivityAnim;
import com.guangchiguangchi.little_bee_android.models.BaseModel;
import com.guangchiguangchi.little_bee_android.store.analysis.AUser;

/**
 * 登陆界面
 * Created by jiweibo on 15/11/3.
 */
public class LoginActivity extends ActBase{

    private Button btn_login;
    private EditText edt_username,edt_password;
    private String str_username,str_password;
    private BaseModel baseModel;
    private AUser aUser;
    private Handler uiHandler = new Handler();

    @Override
    public void init() {
        baseModel = new BaseModel();
        aUser = new AUser();
    }

    @Override
    public void setView() {

        setContentView(R.layout.activity_login);
        btn_login = (Button)findViewById(R.id.btn_login);
        edt_username = (EditText)findViewById(R.id.edt_name);
        edt_password = (EditText)findViewById(R.id.edt_pwd);

    }

    @Override
    public void setListener() {

        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                str_username = edt_username.getText().toString();
                str_password = edt_password.getText().toString();

                if (str_username.equals("")||str_password.equals(""))
                    return;

                showProgressDialog();
                new LoginThread().start();

            }
        });

    }

    class LoginThread extends Thread{
        @Override
        public void run() {
            baseModel = aUser.userLogin(str_username,str_password);
            uiHandler.post(runnable);
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            dismissProgressDialog();
            if (baseModel.isSuccess()){
                SharedPrefsUtil.putUserInfo(getApplicationContext());
                ActivityAnim.intentActivity(LoginActivity.this, MainActivity.class, null);
                finish();
            }else{
                showMsg(baseModel.getData());
            }

        }
    };

}
