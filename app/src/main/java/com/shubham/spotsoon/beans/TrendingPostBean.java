package com.shubham.spotsoon.beans;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by shubham on 7/19/2017.
 */

public class TrendingPostBean implements Serializable {
    private String title;
    private Drawable image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
