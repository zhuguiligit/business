package com.code.zzq.myapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 作者：Created by zhuguili on 2018/1/15.
 * <p>
 * 作用：listview通用封装的适配器
 */

public abstract class CommonAdapter<T> extends BaseAdapter {
    private int mLayoutId;
    private Context mContext;
    private List<T> mDatas;

    public CommonAdapter(int mLayoutId, Context mContext, List<T> mDatas) {
        this.mLayoutId = mLayoutId;
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    public Context getContext() {
        return mContext;
    }

    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CommonHolder myHolder = CommonHolder.getHolder(mContext, viewGroup, view, mLayoutId);
        convertView(myHolder, mDatas.get(i), i);
        return myHolder.getmConvertView();
    }

    public abstract void convertView(CommonHolder holder, T item, int position);
}
