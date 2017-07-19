package com.shubham.spotsoon.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shubham.spotsoon.R;
import com.shubham.spotsoon.adapters.TrendingPagerAdapter;
import com.shubham.spotsoon.adapters.VideoImagePagerAdapter;
import com.shubham.spotsoon.beans.TrendingPostBean;
import com.shubham.spotsoon.classes.TabsLayout;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabsLayout tabLayout;
    private ViewPager viewPager;
    private VideoImagePagerAdapter pagerAdapter;
    private ViewPager trendingViewPager;
    private TrendingPagerAdapter trendingPagerAdapter;
    private CircleIndicator circleIndicator;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        tabLayout.setupWithViewPager(viewPager);

        pagerAdapter = new VideoImagePagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setTabsFromPagerAdapter(pagerAdapter);

        ArrayList<TrendingPostBean> trendingList = setTrendingPostData();
        trendingPagerAdapter = new TrendingPagerAdapter(getSupportFragmentManager(), this, trendingList);
        trendingViewPager.setAdapter(trendingPagerAdapter);
        circleIndicator.setViewPager(trendingViewPager);
        setCirculationOfPager(trendingList.size(), trendingViewPager);
        trendingViewPager.setCurrentItem(1);
        trendingViewPager.setCurrentItem(0);


    }

    private void init() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.appColor));
        }
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white);// whatever your icon name
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Home");

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        trendingViewPager = (ViewPager) findViewById(R.id.trendingViewPager);
        circleIndicator = (CircleIndicator) findViewById(R.id.indicator);
        tabLayout = (TabsLayout) findViewById(R.id.sliding_tabs);


    }


    private void setCirculationOfPager(final int size, final ViewPager pager) {
        if (size >= 2) {
            pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                        countDownTimer = null;
                    }

                    countDownTimer = new CountDownTimer(5000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            if (size > 1) {
                                runOnUiThread(new Runnable() {
                                    public void run() {
                                        if (pager != null) {
                                            if (pager.getCurrentItem() == size - 1) {
                                                pager.setCurrentItem(0);
                                            } else {
                                                pager.setCurrentItem(pager.getCurrentItem() + 1);
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }.start();
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

        }
    }

    private ArrayList<TrendingPostBean> setTrendingPostData() {
        ArrayList<TrendingPostBean> list = new ArrayList<>();
        TrendingPostBean bean = new TrendingPostBean();
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);

        return list;
    }


}
