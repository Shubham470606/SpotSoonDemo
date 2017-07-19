package com.shubham.spotsoon.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.shubham.spotsoon.beans.TrendingPostBean;
import com.shubham.spotsoon.fragments.TrendingFragment;
import com.shubham.spotsoon.fragments.VideoImageFragment;

import java.util.ArrayList;

/**
 * Created by user on 19/7/17.
 */

public class TrendingPagerAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {

    private String[] TITLES = {"VIDEOS", "IMAGES", "MILESTONE"};

    private ArrayList<TrendingPostBean> list;
    private Context context;

    public TrendingPagerAdapter(FragmentManager fm, Context context, ArrayList<TrendingPostBean> list) {
        super(fm);
        this.list = list;
        this.context = context;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getTitle();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fragment getItem(int position) {
        TrendingFragment fragment = TrendingFragment.newInstance(position,list.get(position));
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
