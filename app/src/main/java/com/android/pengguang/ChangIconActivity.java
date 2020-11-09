package com.android.pengguang;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.bumptech.glide.Glide;

import java.io.File;

public class ChangIconActivity extends AppCompatActivity implements View.OnClickListener {
    private static int RESULT_LOAD_IMAGE = 1;

    private ImageView mImage;
    /**
     * 修改头像
     */
    private Button mBtnIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chang_icon);
        initView();
    }

    private void initView() {
        mImage = (ImageView) findViewById(R.id.image);
        mBtnIcon = (Button) findViewById(R.id.btn_icon);
        mBtnIcon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_icon:
                //打开本地相册
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                photoPickerIntent.setType("image/*");
                //设定结果返回
                startActivityForResult(photoPickerIntent, RESULT_LOAD_IMAGE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            //使用glide加载图片
            Glide.with(ChangIconActivity.this).load(data.getData()).into(mImage);
        }

    }


}