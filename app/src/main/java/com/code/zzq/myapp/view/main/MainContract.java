package com.code.zzq.myapp.view.main;

import android.content.Context;

import com.code.zzq.myapp.base.BaseFragment;
import com.code.zzq.myapp.base.BasePresenter;
import com.code.zzq.myapp.base.BaseView;
import com.code.zzq.myapp.model.response.UserInfoModel;

import java.util.List;


/**
 * 登录契约类，MVP规范
 */
public interface MainContract {

    interface View extends BaseView {
        void querySuccess(UserInfoModel result);

        void queryError(String error);
    }

    abstract class Presenter extends BasePresenter<View> {

        /**
         * 构造方法
         *
         * @param context
         * @param view
         */
        public Presenter(Context context, View view) {
            super(context, view);
        }

        public abstract void queryUser(int id,String apikey);
    }
}
