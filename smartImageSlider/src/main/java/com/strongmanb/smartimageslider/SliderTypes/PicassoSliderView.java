package com.strongmanb.smartimageslider.SliderTypes;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

//import com.squareup.picasso.Callback;
//import com.squareup.picasso.Picasso;
//import com.squareup.picasso.RequestCreator;

/**
 * Created by strongman on 2016/9/16.
 */
@Deprecated
public abstract class PicassoSliderView extends BaseSliderView {

    //private Picasso mPicasso;

    protected PicassoSliderView(Context context) {
        super(context);
    }

    @Override
    protected void bindEventAndShow(View v, ImageView targetImageView) {
        /*final BaseSliderView me = this;

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

        Picasso p = (mPicasso != null) ? mPicasso : Picasso.with(mContext);
        RequestCreator rq;
        if(getUrl() !=null){
            rq = p.load(getUrl());
        }else if(getFile() != null){
            rq = p.load(getFile());
        }else if(getRes() != 0){
            rq = p.load(getRes());
        }else{
            return;
        }

        if(rq == null){
            return;
        }

        if(getEmpty() != 0){
            rq.placeholder(getEmpty());
        }

        if(getError() != 0){
            rq.error(getError());
        }

        switch (mScaleType){
            case Fit:
                rq.fit();
                break;
            case CenterCrop:
                rq.fit().centerCrop();
                break;
            case CenterInside:
                rq.fit().centerInside();
                break;
        }

        rq.into(targetImageView, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {
                if(mLoadListener != null){
                    mLoadListener.onEnd(false,me);
                }
            }
        });
    }*/
    }
}