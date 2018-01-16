package com.code.zzq.myapp.view.main;

import android.content.Context;

import com.code.zzq.myapp.model.response.UserInfoModel;
import com.code.zzq.myapp.network.ApiSubscriber;
import com.code.zzq.myapp.network.RxSchedulers;
import com.code.zzq.myapp.network.UserRepository;

import rx.Subscription;

/**
 * Created by zzqybyb1986 on 2017/12/15.
 */

public class MainPresenter extends MainContract.Presenter {
    /**
     * 构造方法
     *
     * @param context
     * @param view
     */
    public MainPresenter(Context context, MainContract.View view) {
        super(context, view);
    }

    @Override
    public void queryUser(int id,String apikey) {
        Subscription subscription = UserRepository.getInstance().queryUser(id,apikey).compose(RxSchedulers.<UserInfoModel>io_main()).subscribe(new ApiSubscriber<UserInfoModel>() {
            @Override
            protected void _onNext(UserInfoModel data) {
                mView.querySuccess(data);
            }

            @Override
            protected void _onError(String message) {
                mView.queryError(message);
            }

            @Override
            protected void _onCompleted() {

            }
        });
        super.addSubscribe(subscription);
    }
}
