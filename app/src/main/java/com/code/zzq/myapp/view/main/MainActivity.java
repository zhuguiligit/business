package com.code.zzq.myapp.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.code.zzq.myapp.R;
import com.code.zzq.myapp.base.BaseActivity;
import com.code.zzq.myapp.constants.AppConstants;
import com.code.zzq.myapp.model.response.UserInfoModel;
import com.code.zzq.myapp.util.ToastUtil;
import com.code.zzq.myapp.view.homepage.HomePageActivity;
import com.code.zzq.myapp.view.list.InfoListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 主页面
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {
    @BindView(R.id.root_first)
    Button rootFirst;
    private TextView mResultTv;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this, this);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mResultTv = findViewById(R.id.result_tv);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mResultTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InfoListActivity.class));
            }
        });
//        rootFirst.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, HomePageActivity.class));
//            }
//        });
    }

    @OnClick(R.id.root_first)
    public void mOnclick(View v) {
        switch (v.getId()) {
            case R.id.root_first:
                Intent mIntent = new Intent(this, HomePageActivity.class);
                startActivity(mIntent);
                break;
        }
    }

    @Override
    protected void nextToDo() {
        super.mPresenter.queryUser(7867718, AppConstants.APP_KEY);
    }

    @Override
    public void querySuccess(UserInfoModel result) {
        ToastUtil.makeToast(this, "查询成功");
        mResultTv.setText(result.toString());
    }

    @Override
    public void queryError(String error) {
        ToastUtil.makeToast(this, "查询失败，错误原因：" + error);
        Log.e("tag", "error=" + error);
//        http://api01.bitspaceman.com:8000/profile/baisibudejie?id=7867718&apikey=vKBZgoOEamCYdVRyB32d8B0MbSDcsEu5Ek2BLcZZjxXGQ1tguZCiFkiDRbvs23QO
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
