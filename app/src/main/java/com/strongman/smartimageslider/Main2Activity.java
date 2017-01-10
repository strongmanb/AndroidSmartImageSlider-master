package com.strongman.smartimageslider;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.strongmanb.smartimageslider.Animations.DescriptionAnimation;
import com.strongmanb.smartimageslider.SliderLayout;
import com.strongmanb.smartimageslider.SliderTypes.BaseSliderView;
import com.strongmanb.smartimageslider.SliderTypes.DefaultSliderView;

import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {

    private SliderLayout mSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mSlider = (SliderLayout) findViewById(R.id.slider);

        HashMap<String,Integer> file_maps = new HashMap<>();
        file_maps.put("轮播6",R.mipmap.a);
        file_maps.put("轮播5",R.mipmap.b);
        file_maps.put("轮播4",R.mipmap.c);
        file_maps.put("轮播3", R.mipmap.d);
        file_maps.put("轮播2", R.mipmap.e);

        for(String name : file_maps.keySet()){
            DefaultSliderView textSliderView = new DefaultSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .empty(R.mipmap.ic_launcher)
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mSlider.addSlider(textSliderView);
        }
        mSlider.setPresetTransformer(SliderLayout.Transformer.RotateUp);
        mSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSlider.setCustomAnimation(new DescriptionAnimation());

    }


}
