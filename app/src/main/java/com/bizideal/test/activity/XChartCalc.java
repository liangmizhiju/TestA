package com.bizideal.test.activity;

import android.app.Activity;
import android.os.Bundle;

import com.bizideal.test.R;


/**
 *
 * Created by mengweikang on 2016/8/16.
 */
public class XChartCalc extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
       // this.setTitle("给饼图标上百分比");
        PieChartView pieChartView = (PieChartView) findViewById(R.id.pie_chart);
        PieChartView.PieItemBean[] items = new PieChartView.PieItemBean[]{
                new PieChartView.PieItemBean("已缴费院校378个", 378),
                new PieChartView.PieItemBean("未缴费院校14个", 14),
        };
        pieChartView.setPieItems(items);
    }
}
