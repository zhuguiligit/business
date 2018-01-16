package com.code.zzq.myapp.view.splash;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.code.zzq.myapp.R;
import com.code.zzq.myapp.base.BaseActivity;
import com.code.zzq.myapp.base.BasePresenter;
import com.code.zzq.myapp.view.guide.GuideActivity;

/**
 * 闪屏页
 */
public class SplashActivity extends BaseActivity {
    private TextView mTimeTv;
    private Button mFastInBtn;
    private boolean mIsRun = true;
    private int mStartTime = 3;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                mStartTime--;
                if (mStartTime != -1) {
                    mTimeTv.setText(mStartTime + "s");
                } else {
                    Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
                    SplashActivity.this.startActivity(intent);
                    SplashActivity.this.finish();
                }
            }
        }
    };

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        mTimeTv = findViewById(R.id.time_tv);
        mFastInBtn = findViewById(R.id.fast_in_btn);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mFastInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.removeCallbacksAndMessages(null);
                Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }
        });
    }

    @Override
    protected void nextToDo() {
        startRun();
    }

    /**
     * 开启倒计时
     */
    private void startRun() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mIsRun) {
                    try {
                        Thread.sleep(1000); // sleep 1000ms
                        Message message = Message.obtain();
                        message.what = 1;
                        mHandler.sendMessage(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
