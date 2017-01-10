package com.strongmanb.smartimageslider.SliderTypes;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;

/**
 * Created by strongman on 2016/9/16.
 */
public abstract class GlideSliderView extends BaseSliderView {

    protected GlideSliderView(Context context) {
        super(context);
    }

    @Override
    protected void bindEventAndShow(View v, ImageView targetImageView) {
        final BaseSliderView me = this;

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnSliderClickListener != null){
                    mOnSliderClickListener.onSliderClick(me);
                }
            }
        });

        if (targetImageView == null)
            return;

        if (getLoadListener() != null) {
            getLoadListener().onStart(me);
        }

        DrawableTypeRequest dtr;
        if(getUrl() != null){
            dtr = Glide.with(mContext).load(getUrl());
        }else if(getFile() != null){
            dtr = Glide.with(mContext).load(getFile());
        }else if(getRes() != 0){
            dtr = Glide.with(mContext).load(getRes());
        }else{
            return;
        }

        if(dtr == null){
            return;
        }

        if(getEmpty() != 0){
            dtr.placeholder(getEmpty());
        }

        if(getError() != 0){
            dtr.error(getError());
        }

        //dtr.fitCenter();
        switch (getScaleType()){
            case FitCenterCrop:
                dtr.fitCenter();
                break;
            case CenterCrop:
                dtr.centerCrop();
                break;
        }

        dtr.crossFade()
                .into(targetImageView);
    }
}
