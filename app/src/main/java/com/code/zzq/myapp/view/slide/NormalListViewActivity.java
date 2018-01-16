package com.code.zzq.myapp.view.slide;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.code.zzq.myapp.R;
import com.code.zzq.myapp.adapter.CommonAdapter;
import com.code.zzq.myapp.adapter.CommonHolder;
import com.code.zzq.myapp.base.BaseActivity;
import com.code.zzq.myapp.base.BasePresenter;
import com.code.zzq.myapp.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：Created by zhuguili on 2018/1/15.
 * <p>
 * 作用：
 */

public class NormalListViewActivity extends BaseActivity implements View.OnClickListener{
    private static final String TAG = NormalListViewActivity.class.getSimpleName();
    @BindView(R.id.lv_normal)
    ListView listView;
    @BindView(R.id.btn_sld)
    Button btnSld;

    private List<ApplicationInfo> mAppList;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_slide_listview;
    }

    @Override
    protected void initView() {
        mAppList = getPackageManager().getInstalledApplications(0);

        btnSld.setOnClickListener(this);
        View header = LayoutInflater.from(this).inflate(R.layout.item_slide_header_footer, null);
        View footer = LayoutInflater.from(this).inflate(R.layout.item_slide_header_footer, null);
        footer.setBackgroundColor(0xff0000bb);
        listView.addHeaderView(header);
        listView.addFooterView(footer);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.i(TAG, "onItemClick   position--->" + position);
                ToastUtil.makeToast(NormalListViewActivity.this, "onItemClick   position--->" + position);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.i(TAG, "onItemLongClick   position--->" + position);
                ToastUtil.makeToast(NormalListViewActivity.this, "onItemLongClick   position--->" + position);
                return false;
            }
        });
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sld:
//                startActivity(new Intent(this, NormalListViewActivity.class));
                ToastUtil.makeToast(this, "btn click--");
                break;
        }
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Object o = v.getTag();
            if (o instanceof Integer) {
                ToastUtil.makeToast(NormalListViewActivity.this, "button click-->" + ((Integer) o));
            }
        }
    };

    private BaseAdapter mAdapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return mAppList.size();
        }

        @Override
        public Object getItem(int position) {
            return mAppList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return mAppList.get(position).hashCode();
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            CustomViewHolder cvh;
            if (view == null){
                cvh = new CustomViewHolder();
                view = LayoutInflater.from(NormalListViewActivity.this).inflate(R.layout.item_slide_custom_btn, null);
                cvh.imgLogo = (ImageView) view.findViewById(R.id.img_item_edit);
                cvh.txtName = (TextView) view.findViewById(R.id.txt_item_edit);
                cvh.btnClick = (TextView) view.findViewById(R.id.tv_item_click);
                cvh.btnClick.setOnClickListener(mOnClickListener);
                view.setTag(cvh);
            } else {
                cvh = (CustomViewHolder) view.getTag();
            }
            ApplicationInfo item = (ApplicationInfo) this.getItem(position);
            cvh.txtName.setText(item.loadLabel(getPackageManager()));
            cvh.imgLogo.setImageDrawable(item.loadIcon(getPackageManager()));
            cvh.btnClick.setText(position + "");
            cvh.btnClick.setTag(position);
            return view;
        }

        class CustomViewHolder {
            public ImageView imgLogo;
            public TextView txtName;
            public TextView btnClick;
        }

        private View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object o = v.getTag();
                if (o instanceof Integer) {
                    ToastUtil.makeToast(NormalListViewActivity.this, "button click-->" + ((Integer) o));
                }
            }
        };
    };
}
