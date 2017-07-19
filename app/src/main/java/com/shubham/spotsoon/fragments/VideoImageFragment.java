package com.shubham.spotsoon.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.shubham.spotsoon.R;
import com.shubham.spotsoon.adapters.MusicListAdapter;
import com.shubham.spotsoon.beans.MusicBean;

import java.util.ArrayList;

/**
 * Created by user on 19/7/17.
 */

public class VideoImageFragment extends Fragment {
    private Activity activity;
    private static final String ARG_POSITION = "position";
    private ListView listView;
    private MusicListAdapter adapter;


    public static VideoImageFragment newInstance(int position) {
        VideoImageFragment f = new VideoImageFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);

        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_image_fragment, container, false);
        if (activity == null) {
            this.activity = getActivity();
        }

        listView = (ListView) view.findViewById(R.id.listview);
        ArrayList<MusicBean> list = setUpList();
        adapter = new MusicListAdapter(activity, list);
        listView.setAdapter(adapter);

        return view;
    }

    private ArrayList<MusicBean> setUpList() {
        ArrayList<MusicBean> li = new ArrayList<>();
        MusicBean bean = new MusicBean();
        bean.setTime("20 hours ago");
        bean.setContent("Lorem Ipsum is simply dummy text of the printing and typesetting industry");
        bean.setMainTitle("I'M Falling love with you");
        bean.setImage(activity.getResources().getDrawable(R.drawable.og_image));

        MusicBean bean1 = new MusicBean();
        bean1.setTime("18 hours ago");
        bean1.setContent("Lorem Ipsum is simply dummy text of the printing and typesetting industry");
        bean1.setMainTitle("Baby ft. justin baber");
        bean1.setImage(activity.getResources().getDrawable(R.drawable.trending));

        li.add(bean);
        li.add(bean1);
        li.add(bean);
        li.add(bean1);
        li.add(bean);
        li.add(bean1);
        li.add(bean);
        li.add(bean1);

        return li;
    }


}
