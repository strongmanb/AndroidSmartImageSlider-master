package com.strongmanb.smartimageslider;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.IdRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.io.File;

/**
 * Created by Strongman on 2016/9/26.
 */

public class SplashLayout extends RelativeLayout {

    /** background imageview */
    private ImageView mSplashImage;

    private String mImageUrl;
    private File mImageFile;
    private int mImageResId;

    public SplashLayout(Context context) {
        super(context, null);
    }

    public SplashLayout(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public SplashLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater.from(context).inflate(R.layout.splash_layout, this, true);
        final TypedArray ta = context.getTheme().obtainStyledAttributes(attrs,R.styleable.SplashLayout,
                defStyleAttr,0);


        this.mSplashImage = (ImageView) findViewById(R.id.splash_image);

    }



    public SplashLayout setSplashImage(String imageUrl) {
        if(mImageFile != null || mImageResId != 0){
            throw new IllegalStateException("Call multi image function," +
                    "you only have permission to call it once");
        }
        this.mImageUrl = imageUrl;
        return this;
    }


    public SplashLayout setSplashImage(File imageFile) {
        if(mImageUrl != null || mImageResId != 0){
            throw new IllegalStateException("Call multi image function," +
                    "you only have permission to call it once");
        }
        this.mImageFile = imageFile;
        return this;
    }


    public SplashLayout setSplashImage(@IdRes int resId) {
        if(mImageUrl != null || mImageFile != null){
            throw new IllegalStateException("Call multi image function," +
                    "you only have permission to call it once");
        }
        this.mImageResId = resId;
        return this;
    }



}
