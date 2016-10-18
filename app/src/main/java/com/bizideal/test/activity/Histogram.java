package com.bizideal.test.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;

import com.bizideal.test.R;
import com.bizideal.test.View.HistogramView;


/**
 * Created by mengweikang on 2016/8/16.
 */
public class Histogram extends Activity {
    private int[] data = new int[] {
            820,300
    };

    private HistogramView histogramView;
    private static final int FLING_MIN_DISTANCE = 50;
    private static final int FLING_MIN_VELOCITY = 0;
    GestureDetector mGestureDetector;

    public static int screenWidth;
    public static int screenHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        screenWidth = getWindowManager().getDefaultDisplay().getWidth();       // 屏幕宽（像素，如：480px）
        screenHeight = getWindowManager().getDefaultDisplay().getHeight();      // 屏幕高（像素，如：800p）
        Log.i("custom", "screenWidth=" + screenWidth);
        Log.i("custom", "screenHeight=" + screenHeight);
        setContentView(R.layout.histogram);
        histogramView = (HistogramView) this.findViewById(R.id.histogram);
        histogramView.setProgress(data);
        histogramView.setLongClickable(true);
    }
    }