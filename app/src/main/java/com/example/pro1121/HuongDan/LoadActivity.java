package com.example.pro1121.HuongDan;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.pro1121.R;

import me.relex.circleindicator.CircleIndicator;

public class LoadActivity extends AppCompatActivity {
    private TextView tvSkip;
    private ViewPager vp;
    private RelativeLayout bottom;
    private CircleIndicator circleIndicator;
    private LinearLayout next;

    private PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        tvSkip = findViewById(R.id.tvSkip);
        vp = findViewById(R.id.vp);
        bottom = findViewById(R.id.bottom);
        circleIndicator = findViewById(R.id.circleIndicator);
        next = findViewById(R.id.next);

        pageAdapter = new PageAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vp.setAdapter(pageAdapter);
        circleIndicator.setViewPager(vp);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 3){
                    tvSkip.setVisibility(View.GONE);
                    bottom.setVisibility(View.GONE);
                }else {
                    tvSkip.setVisibility(View.VISIBLE);
                    bottom.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(3);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vp.getCurrentItem() < 3){
                    vp.setCurrentItem(vp.getCurrentItem()+1);
                }
            }
        });

    }

}