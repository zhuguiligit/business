package com.code.zzq.myapp.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import com.code.zzq.myapp.util.NetWorkUtils;

/**
 * 网络状态监听器
 * Created by zzqybyb1986 on 2017/12/15.
 */

public class NetworkStatusReceiver extends BroadcastReceiver {

    private NetWorkUtils.NetEvent netEvent;
    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            //检查网络状态的类型
            int netWrokState = NetWorkUtils.getNetWorkState(context);
            if (netEvent != null)
                // 接口回传网络状态的类型
                netEvent.onNetChange(netWrokState);
        }
    }

    public void setNetEvent(NetWorkUtils.NetEvent netEvent) {
        this.netEvent = netEvent;
    }
}
