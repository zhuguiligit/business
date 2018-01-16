package com.code.zzq.myapp.util;

import android.content.Context;
import android.widget.Toast;

/**
 * 吐司工具类
 * Created by zzqybyb1986 on 2017/12/15.
 */

public class ToastUtil {
    private static Toast mToast;

    public static void makeToast(Context ctx, String str) {
        if (mToast == null) {
            mToast = Toast.makeText(ctx, str, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(str);
        }
        mToast.show();
    }
}
