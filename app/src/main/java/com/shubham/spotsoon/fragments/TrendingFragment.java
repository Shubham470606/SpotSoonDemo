package com.shubham.spotsoon.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shubham.spotsoon.R;
import com.shubham.spotsoon.beans.TrendingPostBean;

import java.util.ArrayList;

/**
 * Created by user on 19/7/17.
 */

public class TrendingFragment extends Fragment {
    private Activity activity;
    private static final String ARG_POSITION = "position";
    private TrendingPostBean bean;


    public static TrendingFragment newInstance(int position, TrendingPostBean bean) {
        TrendingFragment f = new TrendingFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        b.putSerializable("bean", bean);
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.trending_fragment, container, false);
        if (activity == null) {
            this.activity = getActivity();
        }

        bean = (TrendingPostBean) getArguments().getSerializable("bean");
        int pos = getArguments().getInt(ARG_POSITION);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        TextView textView = (TextView) view.findViewById(R.id.text);
        if (pos % 2 == 0) {
            textView.setText("chain smoker new ablum 2016\nft. rihana and user");
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.og_image));

        } else {
            textView.setText("pink floyd\nft.rihana and music");
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.trending));

        }
        return view;
    }


}
