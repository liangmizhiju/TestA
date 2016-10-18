package com.bizideal.test.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;


import com.bizideal.test.R;
import com.bizideal.test.adapter.CombinedAdapter;
import com.bizideal.test.bean.CommbinedBean;

import java.util.ArrayList;


/**
 * Created by mengweikang on 2016/8/16.
 */
public class CombinedChartActivity extends Activity {

    private ListView mLv;
    private ArrayList<CommbinedBean> mList;
    private CombinedAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_combined);
        mLv= (ListView)findViewById(R.id.lv);
        mList = new ArrayList<>();
        CommbinedBean message = new CommbinedBean();
        message.percent = 224;
        message.content = "校级正职";
        mList.add(message);

        CommbinedBean mes0 = new CommbinedBean();
        mes0.percent = 264;
        mes0.content = "校级副职";
        mList.add(mes0);

        CommbinedBean mes1 = new CommbinedBean();
        mes1.percent = 110;
        mes1.content = "中层";
        mList.add(mes1);

        CommbinedBean mes = new CommbinedBean();
        mes.percent = 294;
        mes.content = "教师";
        mList.add(mes);

        CommbinedBean mes2 = new CommbinedBean();
        mes2.percent = 90;
        mes2.content = "研究人员";
        mList.add(mes2);

        CommbinedBean mes3 = new CommbinedBean();
        mes3.percent = 40;
        mes3.content = "省厅";
        mList.add(mes3);

        CommbinedBean mes4 = new CommbinedBean();
        mes4.percent = 144;
        mes4.content = "嘉宾媒体";
        mList.add(mes4);

        CommbinedBean mes5 = new CommbinedBean();
        mes5.percent = 124;
        mes5.content = "其他";
        mList.add(mes5);

        mAdapter = new CombinedAdapter(CombinedChartActivity.this,mList);
        mLv.setAdapter(mAdapter);
    }
}