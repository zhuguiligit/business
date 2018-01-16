package com.code.zzq.myapp.network;


import com.code.zzq.myapp.model.ResultData;
import com.code.zzq.myapp.model.response.UserInfoModel;

import java.util.List;
import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作者：周正权 on 2017/6/7
 */

public interface ApiService {

    /**
     * 查找用户信息
     * @param id
     * @param key
     * @return
     */
    @GET("/profile/baisibudejie?")
    Observable<UserInfoModel> queryUser(@Query("id") int id, @Query("apikey") String key);
}
