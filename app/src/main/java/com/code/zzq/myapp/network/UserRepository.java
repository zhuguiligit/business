package com.code.zzq.myapp.network;

import com.code.zzq.myapp.model.response.UserInfoModel;

import java.util.List;

import rx.Observable;

/**
 * Created by zzqybyb1986 on 2017-12-18.
 */

public class UserRepository {
    private static volatile UserRepository mInstance;

    private ApiFactory mApiFactory;

    private UserRepository() {
        this.mApiFactory = new ApiFactory();
    }

    public static UserRepository getInstance() {
        if (null == mInstance) {
            synchronized (UserRepository.class) {
                if (null == mInstance) {
                    mInstance = new UserRepository();
                }
            }
        }
        return mInstance;
    }

    /**
     * 查询用户信息
     */
    public Observable<UserInfoModel> queryUser(int id, String apikey) {
        return this.mApiFactory.queryUser(id,apikey);
    }
}
