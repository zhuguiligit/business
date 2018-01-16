package com.code.zzq.myapp.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * fragment基类
 * Created by zzqybyb1986 on 2017/12/15.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    protected View mRootView;
    protected Activity mActivity;

    protected P mPresenter;

    private boolean mIsViewPrepared;    // 标识fragment视图已经初始化完毕
    private boolean mHasLoadData;   // 标识已经触发过懒加载数据

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (this.mRootView == null) {
            this.mRootView = inflater.inflate(this.getContentViewId(), container, false);
            this.initView();
            this.initListener();
        }
        return this.mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mPresenter = this.createPresenter();
        this.mIsViewPrepared = true;
        this.lazyLoadData();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            this.lazyLoadData();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (this.mRootView != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
        this.mHasLoadData = false;
        this.mIsViewPrepared = false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.mPresenter != null) {
            this.mPresenter.unSubscribe();
        }
    }

    /**
     * 懒加载数据
     */
    private void lazyLoadData() {
        if (super.getUserVisibleHint() && !this.mHasLoadData && this.mIsViewPrepared) {
            this.mHasLoadData = true;
            this.initData();
        }
    }

    /**
     * 获取布局文件id
     *
     * @return
     */
    protected abstract int getContentViewId();

    /**
     * 初始化组件
     */
    protected abstract void initView();

    /**
     * 初始化监听器
     */
    protected abstract void initListener();

    /**
     * 创建presenter
     *
     * @return
     */
    protected abstract P createPresenter();

    /**
     * 初始化数据
     */
    protected abstract void initData();
}
