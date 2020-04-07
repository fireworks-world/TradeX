package com.example.tradex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class IntroSlider extends AppCompatActivity {
    private ViewPager viewPager;
    private int[] layouts={R.layout.intro_slider_one,R.layout.intro_slider_two,R.layout.intro_slider_three};
    public MPagerAdapter Mpager;
    private LinearLayout dots_layout;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_slider);
        viewPager=findViewById(R.id.viewpager);
        Mpager=new MPagerAdapter(layouts,this);
        viewPager.setAdapter(Mpager);
        dots_layout=findViewById(R.id.linear);
        creaetDots(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                creaetDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    public void creaetDots(int position)
    {
        if(dots_layout!=null)
        {
            dots_layout.removeAllViews();
            dots=new ImageView[layouts.length];
            for(int i=0;i<layouts.length;i++)
            {
                dots[i]=new ImageView(this);
                if(i==position)
                {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.active_dots));
                }
                else
                {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.inactive_dots));
                }
                LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setMargins(3,0,3,0);
                dots_layout.addView(dots[i],params);
            }
        }
    }
}

