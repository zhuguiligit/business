package com.code.zzq.myapp.view.list;


import com.code.zzq.myapp.R;
import com.code.zzq.myapp.base.BaseActivity;

public class InfoListActivity extends BaseActivity<ListPresenter> implements ListContract.View  {

    @Override
    protected ListPresenter createPresenter() {
        return new ListPresenter(this,this);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_info_list;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void nextToDo() {

    }

    @Override
    public void querySuccess(String result) {

    }

    @Override
    public void queryError(String error) {

    }
}
