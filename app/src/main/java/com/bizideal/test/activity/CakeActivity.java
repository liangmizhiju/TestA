package com.bizideal.test.activity;

/**
 * Created by mengweikang on 2016/8/16.
 */


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;


import com.bizideal.test.R;
import com.bizideal.test.View.CakeView;
import com.bizideal.test.adapter.CommonAdapter;
import com.bizideal.test.bean.BaseMessage;

import java.util.ArrayList;
import java.util.List;

public class CakeActivity extends Activity {

        private CakeView cv;
        private List<BaseMessage> mList;
        private ListView mLv;
        private CommonAdapter mAdapter;

    private  String  string="测试";

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.cake);
            initViews();

            Log.e("cv", "cv>>>>>>" + cv);
            cv.setTextColor(Color.parseColor("#000000"));
            mList = new ArrayList<>();
            BaseMessage message = new BaseMessage();
            message.percent = 220;
            message.content = "大众创业万众创新220人";
            message.color = Color.parseColor("#28D8A5");
            mList.add(message);

            BaseMessage mes0 = new BaseMessage();
            mes0.percent = 281;
            mes0.content = "互联网+背景下的人才培养";
            mes0.color = Color.parseColor("#029FEA");
            mList.add(mes0);

            BaseMessage mes1 = new BaseMessage();
            mes1.percent = 277;
            mes1.content = "现代学徒制试点";
            mes1.color = Color.parseColor("#FE6665");
            mList.add(mes1);

            BaseMessage mes = new BaseMessage();
            mes.percent = 180;
            mes.content = "校企对接180人";
            mes.color = Color.parseColor("#FED35A");
            mList.add(mes);

            cv.setCakeData(mList);
            mAdapter = new CommonAdapter(CakeActivity.this,mList);
            mLv.setAdapter(mAdapter);
        }

        private void initViews() {
            cv = (CakeView) findViewById(R.id.cv);
            mLv=(ListView)findViewById(R.id.lv);
        }

    }


