package com.code.zzq.myapp.view.guide;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.code.zzq.myapp.R;
import com.code.zzq.myapp.util.ScreenUtil;
import com.code.zzq.myapp.util.ToastUtil;
import com.code.zzq.myapp.view.main.MainActivity;
import com.code.zzq.myapp.widget.CustomVideoView;

/**
 * 引导页
 */
public class GuideActivity extends AppCompatActivity {
    private CustomVideoView mVideoView;
    private Button mSkipBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ScreenUtil.init(this);
        ScreenUtil.setFullScreen(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        initListener();
        initData();
    }

    /**
     * 初始化组件
     */
    private void initView() {
        mVideoView = findViewById(R.id.video_view);
        mSkipBtn = findViewById(R.id.skip_btn);
    }

    /**
     * 初始化监听器
     */
    private void initListener() {
        mSkipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoPage();
            }
        });
    }

    /**
     * 初始化数据
     */
    private void initData() {
        Uri videoUri = resourceIdToUri(this, R.raw.guide);
        mVideoView.setVideoURI(videoUri);
        mVideoView.start();
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                gotoPage();
            }
        });
    }

    /**
     * resourceId转换为Uri
     *
     * @param context
     * @param resourceId
     * @return
     */
    private static Uri resourceIdToUri(Context context, int resourceId) {
        return Uri.parse("android.resource://" + context.getPackageName() + "/" + resourceId);
    }

    /**
     * 进入页面
     */
    private void gotoPage() {
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}