package com.strongman.smartimageslider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.strongmanb.smartimageslider.SplashLayout;

public class SplashActivity extends AppCompatActivity {

    private SplashLayout mSplashLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        this.mSplashLayout = (SplashLayout) findViewById(R.id.splash_layout);
        //this.mSplashLayout.setSplashImage(R.mipmap.d);
    }
}
