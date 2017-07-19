package com.shubham.spotsoon.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.shubham.spotsoon.fragments.VideoImageFragment;

import java.util.ArrayList;

/**
 * Created by user on 19/7/17.
 */

public class VideoImagePagerAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {

    private String[] TITLES = {"VIDEOS", "IMAGES", "MILESTONE"};

    private Context context;

    public VideoImagePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public Fragment getItem(int position) {
        VideoImageFragment fragment = VideoImageFragment.newInstance(position);
        return fragment;
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int arg0) {

    }


}
