package com.code.zzq.myapp.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 作者：Created by zhuguili on 2018/1/15.
 * <p>
 * 作用：
 */

public class CommonHolder {
    private SparseArray<View> mViews;
    private View mConvertView;

    public CommonHolder() {
    }

    public CommonHolder(Context ctx, ViewGroup parent, int layId) {
        this.mViews = new SparseArray<>();
        mConvertView = LayoutInflater.from(ctx).inflate(layId, parent, false);
        mConvertView.setTag(this);
    }

    public static CommonHolder getHolder(Context ctx, ViewGroup parent, View convertView, int layId) {
        CommonHolder holder;
        if (convertView == null) {
            holder = new CommonHolder(ctx, parent, layId);
        } else {
            holder = (CommonHolder) convertView.getTag();
        }
        return holder;
    }

    public <M extends View> M getView(int resId) {
        View view = mViews.get(resId);
        if (view == null) {
            view = mConvertView.findViewById(resId);
            mViews.put(resId, view);
        }
        return (M) view;
    }

    public View getmConvertView() {
        return mConvertView;
    }

    public TextView getTextView(int resId) {
        return (TextView) getView(resId);
    }

    public ImageView getImageView(int resId) {
        return (ImageView) getView(resId);
    }
}
