package com.code.zzq.myapp.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * activity基类
 * Created by zzqybyb1986 on 2017/12/15.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        ButterKnife.bind(this);
        mPresenter = this.createPresenter();
        initView();
        initData();
        nextToDo();
        initListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.unSubscribe();
        }
    }

    /**
     * 创建presenter
     *
     * @return
     */
    protected abstract P createPresenter();

    /**
     * 获取资源配置文件id
     *
     * @return
     */
    protected abstract int getLayoutResourceId();

    /**
     * 初始化界面
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化控件监听器
     */
    protected abstract void initListener();

    /**
     * 控件和数据初始化完成后的后续工作
     */
    protected abstract void nextToDo();
}
