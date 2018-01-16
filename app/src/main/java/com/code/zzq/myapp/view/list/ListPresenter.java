package com.code.zzq.myapp.view.list;

import android.content.Context;

import com.code.zzq.myapp.model.response.UserInfoModel;
import com.code.zzq.myapp.network.ApiSubscriber;
import com.code.zzq.myapp.network.RxSchedulers;
import com.code.zzq.myapp.network.UserRepository;

import rx.Subscription;

/**
 * Created by zzqybyb1986 on 2017/12/15.
 */

public class ListPresenter extends ListContract.Presenter {
    /**
     * 构造方法
     *
     * @param context
     * @param view
     */
    public ListPresenter(Context context, ListContract.View view) {
        super(context, view);
    }

    @Override
    public void queryCaptures(String key, int catid) {

    }

}
