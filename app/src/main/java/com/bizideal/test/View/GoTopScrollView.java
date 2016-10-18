package com.bizideal.test.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.bizideal.test.R;


/**
 * 一键置顶功能
 * Created by chenbin on 2016/8/17.
 */
public class GoTopScrollView extends ScrollView implements View.OnClickListener {
    /**
     * 置顶按钮
     */
    private ImageView goTopBtn;

    public GoTopScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setScrollListener(ImageView goTopBtn) {
        this.goTopBtn = goTopBtn;
        this.goTopBtn.setOnClickListener(this);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        /**
         * 滑动距离超过200px,出现向上按钮,可以做为自定义属性
         */
        if (t >= 200) {
            goTopBtn.setVisibility(View.VISIBLE);
        } else {
            goTopBtn.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imageView) {
            this.smoothScrollTo(0, 0);
        }
    }
}
