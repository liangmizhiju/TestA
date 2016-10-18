package com.bizideal.test;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;


import com.bizideal.test.View.GoTopScrollView;
import com.bizideal.test.activity.CakeActivity;
import com.bizideal.test.activity.CombinedChartActivity;
import com.bizideal.test.activity.Histogram;
import com.bizideal.test.activity.PopMenu;
import com.bizideal.test.activity.XChartCalc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button1;
    private Intent i;
    private Button button2,button3,button4;
    private ListView mLv;
    private ImageView imageView;
    private Button button5;
    private GoTopScrollView mScrollview;
    private Button button6;
    private PopMenu popMenu;
    private View popView;
    private PopupWindow popupWindow;
    protected static final String IMAGE_TYPE ="image/*";
    private static final int IMAGE_CODE = 0;
    private ImageView mImg;

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //            //透明状态栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setContentView(R.layout.activity_main);
//        Utility u= new Utility();
//        u.getwindo(this);
        //透明状态栏
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Window window = getWindow();
//            // Translucent status bar
//            window.setFlags(
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
////            //透明状态栏
////            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
////            //透明导航栏
////            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        }
        initViews();
        popMenu = new PopMenu(this);
        popMenu.addItems(new String[] { "头像", "昵称", "性别","真实姓名","邮箱","手机号码","省份/城市"});
        mLv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getData()));
    }
    private List<String> getData(){
        List<String> data = new ArrayList<String>();
        data.add("测试数据1");
        data.add("测试数据2");
        data.add("测试数据3");
        data.add("测试数据5");
        data.add("测试数据6");
        data.add("测试数据7");
        data.add("测试数据8");
        data.add("测试数据9");
        data.add("测试数据10");
        data.add("测试数据11");
        data.add("测试数据12");
        data.add("测试数据13");
        data.add("测试数据14");
        data.add("测试数据15");
        data.add("测试数据16");
        data.add("测试数据17");
        data.add("测试数据18");
        return data;
    }
    private void initViews() {
       button1= (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2= (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3= (Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4= (Button)findViewById(R.id.button4);
        button4.setOnClickListener(this); 
        button5= (Button)findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button6= (Button)findViewById(R.id.button6);
        button6.setOnClickListener(this);
        mLv= (ListView) findViewById(R.id.lv);
        mScrollview=(GoTopScrollView)findViewById(R.id.scrollView);
        imageView=(ImageView)findViewById(R.id.imageView);
        mScrollview.setScrollListener(imageView);
        mImg=(ImageView)findViewById(R.id.img);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                i = new Intent(this, CombinedChartActivity.class);
                startActivity(i);
                break;
            case R.id.button2:
                i = new Intent(this, Histogram.class);
                startActivity(i);
                break;
            case R.id.button3:
                i = new Intent(this, CakeActivity.class);
                startActivity(i);
                break;
            case R.id.button4:
                i = new Intent(this, XChartCalc.class);
                startActivity(i);
                break;
            case R.id.button5://上传图片
               /* showImagePickDialog();*/
                initPopuWindow();
                break;
            case R.id.button6:
                popMenu.showAsDropDown(v);
                break;
        }
    }

    /***
     * 相册
     */
    public void initPopuWindow() {
        if (popupWindow == null) {
            LayoutInflater mLayoutInflater = (LayoutInflater) this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            popView = mLayoutInflater.inflate(R.layout.popupwindow_photo, null);
            popupWindow = new PopupWindow(popView,
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
        }
        initViewPop1();
        ColorDrawable cd = new ColorDrawable(0x000000);
        popupWindow.setBackgroundDrawable(cd);
        // 产生背景变暗效果
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.alpha = 0.4f;
        this.getWindow().setAttributes(lp);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
      //  popupWindow.setAnimationStyle(R.style.mypopwindow_anim_style);
        popupWindow.showAtLocation(findViewById(R.id.button1), Gravity.BOTTOM, 0, 0);
        popupWindow.update();
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            // 在dismiss中恢复透明度
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = MainActivity.this.getWindow()
                        .getAttributes();
                lp.alpha = 1f;
                MainActivity.this.getWindow().setAttributes(lp);
            }
        });
    }
/**
     * 初始化相册 popwind数据
     */
    public void initViewPop1() {
        Button photo = (Button) popView
                .findViewById(R.id.btn_take_photo);// 拍照
        Button pick = (Button) popView
                .findViewById(R.id.btn_pick_photo);// 相册
        Button cancel = (Button) popView
                .findViewById(R.id.btn_cancel);// 取消
        // PopuWindow里面的控件点击事件
        photo.setOnClickListener(new View.OnClickListener() {// 拍照

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 1);
            }
        });
        pick.setOnClickListener(new View.OnClickListener() {// 相册

            @Override
            public void onClick(View v) {
                Intent getAlbum = new Intent(Intent.ACTION_GET_CONTENT);
                getAlbum.setType(IMAGE_TYPE);
                startActivityForResult(getAlbum, IMAGE_CODE);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {// 取消

            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode != RESULT_OK) {        //此处的 RESULT_OK 是系统自定义得一个常量
            Log.e("TAG->onresult", "ActivityResult resultCode error");
            return;
        }
        Bitmap bm = null;
        //外界的程序访问ContentProvider所提供数据 可以通过ContentResolver接口
        ContentResolver resolver = getContentResolver();
        //此处的用于判断接收的Activity是不是你想要的那个
        if (requestCode == IMAGE_CODE) {
            try {
                Uri originalUri = data.getData();        //获得图片的uri
                bm = MediaStore.Images.Media.getBitmap(resolver, originalUri);
                mImg.setImageBitmap(bm);
                //这里开始的第二部分，获取图片的路径：
                String[] proj = {MediaStore.Images.Media.DATA};
                //好像是android多媒体数据库的封装接口，具体的看Android文档
                Cursor cursor = managedQuery(originalUri, proj, null, null, null);
                //按我个人理解 这个是获得用户选择的图片的索引值
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                //将光标移至开头 ，这个很重要，不小心很容易引起越界
                cursor.moveToFirst();
                //最后根据索引值获取图片路径
                final String path = cursor.getString(column_index);

                //  imgPath.setText(path);
            }catch (IOException e) {
                Log.e("TAG-->Error", e.toString());
            }
        }else {
            final Bitmap photo = data.getParcelableExtra("data");
            ((ImageView) findViewById(R.id.img)).setImageBitmap(photo);
        }
    }
}
