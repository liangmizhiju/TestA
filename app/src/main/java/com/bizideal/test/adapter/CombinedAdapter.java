package com.bizideal.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.bizideal.test.R;
import com.bizideal.test.bean.CommbinedBean;

import java.util.List;

/**
 * Created by mengweikang on 2016/8/17.
 */
public class CombinedAdapter extends BaseAdapter {
    private final List<CommbinedBean> mDatas;
    /** 上下文 */
    protected Context mContext;
    /** 数据源 */
    private int mLayoutId;

    public CombinedAdapter(Context mContext, List<CommbinedBean> mList) {
        super();
        this.mContext = mContext;
        this.mDatas=mList;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return (Object) (mDatas == null ? 0 : mDatas.get(position));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        // TODO Auto-generated method stub
        HolderView holder=null;
        if (convertView == null || convertView.getTag() == null) {
            holder=new HolderView();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.item_comnined, null);
            holder.tv_name=(TextView) convertView.findViewById(R.id.tv);
            holder.tv_num=(TextView) convertView.findViewById(R.id.tv2);
            holder.progressBar=(ProgressBar) convertView.findViewById(R.id.progressBar);
            convertView.setTag(holder);
        }else {
            holder=(HolderView) convertView.getTag();
        }
        final CommbinedBean bean = mDatas.get(position);
        holder.tv_name.setText(bean.getContent());
        holder.tv_num.setText(String.valueOf(bean.getPercent()));
        holder.progressBar.setProgress(bean.getPercent());
        return convertView;
    }
    private class HolderView{
        public TextView tv_name,tv_num;
        public ProgressBar progressBar;

    }
}