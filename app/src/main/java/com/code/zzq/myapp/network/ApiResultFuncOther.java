package com.code.zzq.myapp.network;

import com.code.zzq.myapp.model.ResultData;

import rx.functions.Func1;

/**
 * 作者：周正权 on 2017/6/8
 * 邮箱：zhouzhengquan@shixinyun.com
 */

public class ApiResultFuncOther<T> implements Func1<T, T> {

    @Override
    public T call(T resultData) {
        return resultData;
    }
}
