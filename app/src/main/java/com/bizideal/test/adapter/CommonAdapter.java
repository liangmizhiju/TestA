package com.bizideal.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.bizideal.test.R;
import com.bizideal.test.bean.BaseMessage;

import java.util.List;

/**
 * Created by mengweikang on 2016/8/17.
 */
public class CommonAdapter extends BaseAdapter {
    private final List<BaseMessage> mDatas;
    /** 上下文 */
    protected Context mContext;
    /** 数据源 */
    private int mLayoutId;

    public CommonAdapter(Context mContext, List<BaseMessage> mList) {
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
            convertView= LayoutInflater.from(mContext).inflate(R.layout.layout_aa, null);
            holder.tv_name=(TextView) convertView.findViewById(R.id.tv);
            holder.view=(View) convertView.findViewById(R.id.view);
            convertView.setTag(holder);
        }else {
            holder=(HolderView) convertView.getTag();
        }
        final BaseMessage bean = mDatas.get(position);
        holder.tv_name.setText(bean.getContent());
        holder.view.setBackgroundColor(bean.getColor());
        return convertView;
    }
    private class HolderView{
        public TextView tv_name;
        public  View view;
    }
}