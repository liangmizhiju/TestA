package com.bizideal.test;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

import java.text.DecimalFormat;

/**
 * 工具类
 * Created by hanj on 14-12-30.
 */
public class Utility {
    /**
     * 格式化浮点数据，保留1位小数
     */
    public static String formatFloat(double value) {
        DecimalFormat df = new DecimalFormat("0.0");
        return df.format(value);
    }
    public static   void getwindo(Context context){
        //透明状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = ((Activity)context).getWindow();
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明状态栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
}
