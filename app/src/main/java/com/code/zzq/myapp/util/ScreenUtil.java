package com.code.zzq.myapp.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import java.lang.reflect.Field;

/**
 * 屏幕工具类
 *
 * @author PengZhenjin
 * @date 2017-1-10
 */
public class ScreenUtil {
    private static final String TAG = "ScreenUtil";

    private static double RATIO = 0.85;

    public static int screenWidth;  // 屏幕的宽度
    public static int screenHeight; // 屏幕的高度
    public static int screenMin;    // 宽高中，小的一边
    public static int screenMax;    // 宽高中，较大的值

    public static float density;    // 密度值
    public static float scaleDensity;   // 缩放的密度值
    public static float xdpi;   // 在屏幕X维度的dpi值
    public static float ydpi;   // 在屏幕Y维度的dpi值
    public static int densityDpi; // 密度dpi值

    public static int dialogWidth;  // 对话框的宽度
    public static int statusBarHeight;  // 状态栏的高度
    public static int navBarHeight; // 导航条的高度

    /**
     * 初始化
     *
     * @param context
     */
    public static void init(Context context) {
        if (null == context) {
            return;
        }
        DisplayMetrics dm = context.getApplicationContext().getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
        screenMin = (screenWidth > screenHeight) ? screenHeight : screenWidth;
        screenMax = (screenWidth < screenHeight) ? screenHeight : screenWidth;
        density = dm.density;
        scaleDensity = dm.scaledDensity;
        xdpi = dm.xdpi;
        ydpi = dm.ydpi;
        densityDpi = dm.densityDpi;
        statusBarHeight = getStatusBarHeight(context);
        navBarHeight = getNavBarHeight(context);
        Log.d(TAG, "screenWidth=" + screenWidth + " screenHeight=" + screenHeight + " density=" + density);
    }

    /**
     * dip转换为px
     *
     * @param dipValue
     * @return
     */
    public static int dip2px(float dipValue) {
        return (int) (dipValue * density + 0.5f);
    }

    /**
     * px转换为dip
     *
     * @param pxValue
     * @return
     */
    public static int px2dip(float pxValue) {
        return (int) (pxValue / density + 0.5f);
    }

    /**
     * sp转换为px
     *
     * @param spValue
     * @return
     */
    public static int sp2px(float spValue) {
        return (int) (spValue * scaleDensity + 0.5f);
    }

    /**
     * 获取对话框的宽
     *
     * @return
     */
    public static int getDialogWidth() {
        dialogWidth = (int) (screenMin * RATIO);
        return dialogWidth;
    }

    /**
     * 获取状态栏的高度
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        if (statusBarHeight == 0) {
            try {
                Class<?> c = Class.forName("com.android.internal.R$dimen");
                Object o = c.newInstance();
                Field field = c.getField("status_bar_height");
                int x = (Integer) field.get(o);
                statusBarHeight = context.getResources().getDimensionPixelSize(x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (statusBarHeight == 0) {
            statusBarHeight = ScreenUtil.dip2px(25);
        }
        return statusBarHeight;
    }

    /**
     * 获取导航条的高度
     *
     * @param context
     * @return
     */
    public static int getNavBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return resources.getDimensionPixelSize(resourceId);
        }
        return 0;
    }

    /**
     * 设置全屏
     *
     * @param activity
     */
    public static void setFullScreen(Activity activity) {
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);   // 全屏
    }

}
