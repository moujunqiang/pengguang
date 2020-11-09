package com.android.pengguang;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 邮箱或用户名
     */
    private EditText mEtName;
    /**
     * 请输入6-16位数字或字母
     */
    private EditText mEtPwd;
    /**
     * 注册
     */
    private Button mBtnRegister;
    /**
     * 登录
     */
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mEtName = (EditText) findViewById(R.id.et_name);
        mEtPwd = (EditText) findViewById(R.id.et_pwd);
        mBtnRegister = (Button) findViewById(R.id.btn_register);
        mBtnRegister.setOnClickListener(this);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_register:
                startActivity(new Intent(MainActivity.this,RegistActivity.class));

                break;
            case R.id.btn_login:
                if (TextUtils.isEmpty(mEtName.getText().toString())) {
                    Toast.makeText(this, "请输入邮箱或者用户名", Toast.LENGTH_SHORT).show();
                    return;
                }
                SharedPreferences info = getSharedPreferences("info", MODE_PRIVATE);
                String name = info.getString("name", "-1");
                if (name.equals(mEtName.getText().toString())){
                    startActivity(new Intent(MainActivity.this,ChangIconActivity.class));
                }else {
                    Toast.makeText(this, "用户名或者邮箱未注册", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}