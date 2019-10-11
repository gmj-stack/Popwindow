package com.dialog.utils;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Hello World!
     */
    private TextView mTv;
    /**
     * 居中显示
     */
    private Button mButton;
    /**
     * Button
     */
    private Button mButton2;
    private PopWindowUtils popWindowUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //传参 activity为null  则背景不透明
        popWindowUtils =
                new PopWindowUtils(this, MainActivity.this);

        popWindowUtils.setTvTitle("我是头部", 0, "#fff000")
                .setContent("这是一段测试decent的哈")
                .setOnCickListener(new PopWindowUtils.OnCickListener() {
                    @Override
                    public void onLeftClickListener(String content) {
                        popWindowUtils.dismiss();
                    }

                    @Override
                    public void onRightClickListener(String content) {
                        popWindowUtils.dismiss();
                    }

                    @Override
                    public void onCancelClickLietener() {

                    }
                });
    }


    private void initView() {
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                popWindowUtils.showAtLocation(Gravity.CENTER, 0, 0, false);
                break;
            case R.id.button2:

                PopUpWindowPhoto popUpWindowPhoto =
                        new PopUpWindowPhoto(ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, this, MainActivity.this);

                popUpWindowPhoto.setOnCickListener(new BasePopUpWindow.OnCickListener() {
                    @Override
                    public void onLeftClickListener(String content) {
                        Toast.makeText(MainActivity.this, "拍照", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onRightClickListener(String content) {
                        Toast.makeText(MainActivity.this, "相册", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelClickLietener() {

                    }
                }).showAtLocation(Gravity.BOTTOM, 0, 0, true);

                break;
        }
    }

}
