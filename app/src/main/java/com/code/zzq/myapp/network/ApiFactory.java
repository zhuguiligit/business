package com.code.zzq.myapp.network;

import com.code.zzq.myapp.constants.AppConstants;
import com.code.zzq.myapp.model.response.UserInfoModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by zzqybyb1986 on 2017-12-18.
 */

public class ApiFactory {
    private ApiService mApiService;

    public ApiFactory() {
        this.mApiService = ApiManager.getInstance().getApiService();
    }

    /**
     * 查找用户信息
     *
     * @param id
     * @return
     */
    public Observable<UserInfoModel> queryUser(int id, String apikey) {
        return this.mApiService.queryUser(id,apikey).map(new ApiResultFuncOther<UserInfoModel>()).subscribeOn(Schedulers.io());
    }

}
