package com.triplebro.aran.sandw.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.triplebro.aran.sandw.R;

public class ChangePassWordActivity extends Activity implements View.OnClickListener {

    private ImageView iv_close_change_password;
    private EditText et_old_password;
    private EditText et_new_password;
    private EditText et_new_password_r;
    private Button bt_change_password;
    private String old_password;
    private String new_password;
    private String new_password_r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass_word);
        initView();
        initData();
        setOnClickListener();
    }

    private void initView() {
        iv_close_change_password = (ImageView) findViewById(R.id.iv_close_change_password);
        et_old_password = (EditText) findViewById(R.id.et_old_password);
        et_new_password = (EditText) findViewById(R.id.et_new_password);
        et_new_password_r = (EditText) findViewById(R.id.et_new_password_r);
        bt_change_password = (Button) findViewById(R.id.bt_change_password);
    }

    private void initData() {

        old_password = et_old_password.getText().toString().trim();
        new_password = et_new_password.getText().toString().trim();
        new_password_r = et_new_password_r.getText().toString().trim();


    }

    private void setOnClickListener() {

        iv_close_change_password.setOnClickListener(this);
        bt_change_password.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.iv_close_change_password:
                finish();
                break;
            case R.id.bt_change_password:
                if(old_password.length()==0||new_password.length()==0||new_password_r.length()==0){
                    Toast.makeText(this, "信息不能为空！", Toast.LENGTH_SHORT).show();
                }
                if(new_password.equals(old_password)){
                    Toast.makeText(this, "新密码不能与旧密码相同！", Toast.LENGTH_SHORT).show();
                }
                if(!new_password.equals(new_password_r)){
                    Toast.makeText(this, "新密码与确认新密码不相同！", Toast.LENGTH_SHORT).show();
                } else {
                    //TODO 服务器通信修改密码
                }
                break;
        }

    }
}
