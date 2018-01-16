package com.code.zzq.myapp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;

import com.code.zzq.myapp.base.MyRealmMigration;
import com.code.zzq.myapp.base.NetworkStatusReceiver;
import com.code.zzq.myapp.util.NetWorkUtils;
import com.code.zzq.myapp.util.ToastUtil;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * 主app类
 * Created by zzqybyb1986 on 2017/12/15.
 */

public class MyApp extends Application implements Application.ActivityLifecycleCallbacks, NetWorkUtils.NetEvent {
    private int mActivityCount; // activity计数器
    private NetworkStatusReceiver mNetReceiver;//网络状态接收器
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        registerActivityLifecycleCallbacks(this);
        mNetReceiver = new NetworkStatusReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mNetReceiver, filter);
        mNetReceiver.setNetEvent(this);
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("myApp.realm")//设置数据库名称
                .schemaVersion(0)//设置版本号
                .migration(new MyRealmMigration())
                .build();
        Realm.setDefaultConfiguration(configuration);//设置配置
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        unregisterReceiver(mNetReceiver);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {
        this.mActivityCount++;
        if (0 == this.mActivityCount - 1) {
            Log.e("tag", "App 从后台回到前台了" + activity.getLocalClassName());
        }
    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
        this.mActivityCount--;
        if (0 == this.mActivityCount) {
            Log.e("tag", "App 从前台切换到后台了" + activity.getLocalClassName());
        }
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }

    @Override
    public void onNetChange(int netMobile) {
        switch (netMobile) {
            case 1://wifi
                ToastUtil.makeToast(this, "当前网络类型:wifi");
                break;
            case 0://移动数据
                ToastUtil.makeToast(this, "当前网络类型:移动数据");
                break;
            case -1://没有网络
                ToastUtil.makeToast(this, "网络连接失败，请检查您的网络配置");
                android.os.Process.killProcess(android.os.Process.myPid());
                break;
        }
    }

    public static Context getContext() {
        return mContext;
    }
}
