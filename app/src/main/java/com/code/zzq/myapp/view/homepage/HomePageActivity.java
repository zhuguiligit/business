package com.code.zzq.myapp.view.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.code.zzq.myapp.R;
import com.code.zzq.myapp.base.BaseActivity;
import com.code.zzq.myapp.base.BasePresenter;
import com.code.zzq.myapp.view.slide.NormalListViewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：Created by zhuguili on 2018/1/15.
 * <p>
 * 作用：
 */

public class HomePageActivity extends BaseActivity {
    @BindView(R.id.btn_normal)
    Button btnNormal;
    @BindView(R.id.btn_simple)
    Button btnSimple;
    @BindView(R.id.btn_header_footer)
    Button btnHeaderFooter;
    @BindView(R.id.btn_header_footer_view_type)
    Button btnHeaderFooterViewType;
    @BindView(R.id.btn_view_type)
    Button btnViewType;
    @BindView(R.id.btn_touch_drag)
    Button btnTouchDrag;
    @BindView(R.id.btn_simple_adapter)
    Button btnSimpleAdapter;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_homepage;
    }

    @OnClick(R.id.btn_normal)
    public void mOnclick(View v) {
        switch (v.getId()) {
            case R.id.btn_normal:
                Intent mIntent = new Intent(this, NormalListViewActivity.class);
                startActivity(mIntent);
                break;
        }
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
}
