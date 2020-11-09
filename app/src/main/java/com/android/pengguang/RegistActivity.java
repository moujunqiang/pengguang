package com.android.pengguang;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 请输入邮箱或者用户名
     */
    private EditText mEtEmail;
    /**
     * 提交
     */
    private Button mBtnCommit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        initView();
    }

    private void initView() {
        mEtEmail = (EditText) findViewById(R.id.et_email);
        mBtnCommit = (Button) findViewById(R.id.btn_commit);
        mBtnCommit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_commit:
                if (TextUtils.isEmpty(mEtEmail.getText().toString())) {
                    Toast.makeText(this, "请输入邮箱或者用户名", Toast.LENGTH_SHORT).show();
                    return;
                }
                //把用户名密码 保存到本地 用作登录
                SharedPreferences info = getSharedPreferences("info", MODE_PRIVATE);
                info.edit().putString("name",mEtEmail.getText().toString()).commit();

                finish();
                break;
        }
    }
}