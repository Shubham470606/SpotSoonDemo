package com.shubham.spotsoon.beans;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by shubham on 7/20/2017.
 */

public class MusicBean implements Serializable {
    private String mainTitle,time,content;
    private Drawable image;

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
