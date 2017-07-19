package com.shubham.spotsoon.classes;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shubham.spotsoon.R;

/**
 * Created by user on 19/7/17.
 */

public class TabsLayout extends TabLayout {
    int ICONS[] = {R.drawable.video_icon, R.drawable.image_icon, R.drawable.milestone_icon};
    Context context;

    public TabsLayout(Context context) {
        super(context);
        this.context = context;
    }

    public TabsLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TabsLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter adapter) {
        super.setTabsFromPagerAdapter(adapter);
        this.removeAllTabs();
        int i = 0;
        for (int count = adapter.getCount(); i < count; ++i) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View view = inflater.inflate(R.layout.tab_layout, null, false);
            ImageView image = (ImageView) view.findViewById(R.id.tab_icon);
            image.setImageDrawable(getContext().getResources().getDrawable(ICONS[i]));
            TextView textView = (TextView) view.findViewById(R.id.tab_text);
            textView.setText(adapter.getPageTitle(i));
            this.addTab(this.newTab().setCustomView(view));
        }
    }
}
