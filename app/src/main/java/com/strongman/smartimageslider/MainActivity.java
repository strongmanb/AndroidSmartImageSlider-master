package com.strongman.smartimageslider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.strongmanb.smartimageslider.Animations.DescriptionAnimation;
import com.strongmanb.smartimageslider.SliderLayout;
import com.strongmanb.smartimageslider.SliderTypes.BaseSliderView;
import com.strongmanb.smartimageslider.SliderTypes.DefaultSliderView;
import com.strongmanb.smartimageslider.SliderTypes.TextSliderView;
import com.strongmanb.smartimageslider.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private SliderLayout mSlider;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlider = (SliderLayout) findViewById(R.id.slider);
        mListView = (ListView) findViewById(R.id.listview);

        HashMap<String,Integer> file_maps = new HashMap<>();
        file_maps.put("轮播6",R.mipmap.a);
        file_maps.put("轮播5",R.mipmap.b);
        file_maps.put("轮播4",R.mipmap.c);
        file_maps.put("轮播3", R.mipmap.d);
        file_maps.put("轮播2", R.mipmap.e);

        HashMap<String,String> urlMaps = new HashMap<String, String>();
        urlMaps.put("liying1", "http://img1.imgtn.bdimg.com/it/u=1518387780,868647265&fm=206&gp=0.jpg");
        urlMaps.put("liying1", "http://img1.imgtn.bdimg.com/it/u=1518387780,868647265&fm=206&gp=0.jpg");
        urlMaps.put("liying1", "http://img1.imgtn.bdimg.com/it/u=1518387780,868647265&fm=206&gp=0.jpg");
        urlMaps.put("liying1", "http://img1.imgtn.bdimg.com/it/u=1518387780,868647265&fm=206&gp=0.jpg");

        for(String name : urlMaps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image("http://img1.imgtn.bdimg.com/it/u=1518387780,868647265&fm=206&gp=0.jpg")
                    .empty(R.mipmap.ic_launcher)
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mSlider.addSlider(textSliderView);
        }
        mSlider.setPresetTransformer(SliderLayout.Transformer.Foreground2Background);
        mSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSlider.setCustomAnimation(new DescriptionAnimation());
        mSlider.addOnPageChangeListener(this);

        String[] datas = new String[SliderLayout.Transformer.values().length];
        for(int i=0; i<SliderLayout.Transformer.values().length; i++) {
            datas[i] = SliderLayout.Transformer.values()[i].toString();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, datas);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mSlider.setPresetTransformer(SliderLayout.Transformer.values()[i]);
            }
        });
    }


    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
