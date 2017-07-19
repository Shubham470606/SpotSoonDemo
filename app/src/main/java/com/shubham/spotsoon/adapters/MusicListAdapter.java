package com.shubham.spotsoon.adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shubham.spotsoon.R;
import com.shubham.spotsoon.beans.MusicBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shubham on 7/20/2017.
 */

public class MusicListAdapter extends BaseAdapter {

    private Context context;
    ArrayList<MusicBean> list;


    ViewHolder holder;

    private class ViewHolder {
        TextView heading, content, time;
        ImageView imageView;

    }


    public MusicListAdapter(Context context, ArrayList<MusicBean> beans) {
        this.context = context;
        list = beans;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflator.inflate(R.layout.music_single_item, null);
            holder.heading = (TextView) convertView.findViewById(R.id.heading);
            holder.time = (TextView) convertView.findViewById(R.id.time);
            holder.content = (TextView) convertView.findViewById(R.id.content);
            holder.imageView = (ImageView) convertView.findViewById(R.id.image);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imageView.setImageDrawable(list.get(position).getImage());
        holder.time.setText(list.get(position).getTime());
        holder.content.setText(list.get(position).getContent());
        holder.heading.setText(list.get(position).getMainTitle());

        return convertView;
    }


}

