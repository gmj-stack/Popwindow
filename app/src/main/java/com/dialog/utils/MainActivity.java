//package com.dialog.utils;
//
//import android.os.Bundle;
//import android.view.Gravity;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ListView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.AppCompatEditText;
//import androidx.appcompat.widget.AppCompatTextView;
//
//import java.util.ArrayList;
//
//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//
//    /**
//     * Hello World!
//     */
//    private TextView mTv;
//    /**
//     * 居中显示
//     */
//    private Button mButton;
//    /**
//     * Button
//     */
//    private Button mButton2;
//    private PopWindowUtils popWindowUtils;
//    /**
//     * 加载弹窗
//     */
//    private Button mButton3;
//    /**
//     * 弹窗位置
//     */
//    private Button mButton4;
//
//    private TestDialog testDialog;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        initView();
//        //传参 activity为null  则背景不透明
//        popWindowUtils =
//                new PopWindowUtils(this, MainActivity.this);
//        //textview 示范
////        AppCompatTextView appCompatTextView = new AppCompatTextView(this);
////        appCompatTextView.setText("dajhdajsdnkas");
//        //edittext 示范
////        AppCompatEditText appCompatEditText = new AppCompatEditText(this);
////        appCompatEditText.setText("dadasdas");
//
//        //listview示范
//        ListView listView = new ListView(this);
//        ArrayList<String> strings = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            strings.add("dasd" + i);
//        }
//
//        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strings));
//
//        popWindowUtils.setTvTitle("我是头部", 0, "#fff000")
//                .addView(listView)
//                .setOnCickListener(new PopWindowUtils.OnCickListener() {
//                    @Override
//                    public void onLeftClickListener(String content) {
//                        popWindowUtils.dismiss();
//                        Toast.makeText(MainActivity.this, content, Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onRightClickListener(String content) {
//                        popWindowUtils.dismiss();
//                    }
//
//                    @Override
//                    public void onCancelClickLietener() {
//
//                    }
//                });
//        //设置宽度
////        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) appCompatEditText.getLayoutParams();
////        layoutParams.width = 1000;
////        appCompatEditText.setLayoutParams(layoutParams);
//        testDialog = new TestDialog(this);
//    }
//
//
//    private void initView() {
//        mButton = (Button) findViewById(R.id.button);
//        mButton.setOnClickListener(this);
//        mButton2 = (Button) findViewById(R.id.button2);
//        mButton2.setOnClickListener(this);
//        mButton3 = (Button) findViewById(R.id.button3);
//        mButton3.setOnClickListener(this);
//        mButton4 = (Button) findViewById(R.id.button4);
//        mButton4.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.button:
//                //设置edittext时 需要设置为true允许获取焦点
//                popWindowUtils.showAtLocation(Gravity.CENTER, 0, 0, true);
//                break;
//            case R.id.button2:
//
//                PopUpWindowPhoto popUpWindowPhoto =
//                        new PopUpWindowPhoto(ViewGroup.LayoutParams.MATCH_PARENT,
//                                ViewGroup.LayoutParams.WRAP_CONTENT, this, MainActivity.this);
//
//                popUpWindowPhoto.setOnCickListener(new BasePopUpWindow.OnCickListener() {
//                    @Override
//                    public void onLeftClickListener(String content) {
//                        Toast.makeText(MainActivity.this, "拍照", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onRightClickListener(String content) {
//                        Toast.makeText(MainActivity.this, "相册", Toast.LENGTH_SHORT).show();
//
//                    }
//
//                    @Override
//                    public void onCancelClickLietener() {
//
//                    }
//                }).showAtLocation(Gravity.BOTTOM, 0, 0, true);
//
//                break;
//            case R.id.button3:
//                //加载框 可以二次封装成单例
//                PopDIalogLoading popDIalogLoading = new PopDIalogLoading(this, MainActivity.this);
//                popDIalogLoading.showAtLocation(Gravity.CENTER, 0, 0, true);
//                break;
//            case R.id.button4:
//
//                if (testDialog.isShowing()) {
//                    testDialog.dismiss();
//                } else {
//                    testDialog.showAsDropDown(mButton4, 0, 0, false);//
//
//                }
//                break;
//        }
//    }
//
//}
