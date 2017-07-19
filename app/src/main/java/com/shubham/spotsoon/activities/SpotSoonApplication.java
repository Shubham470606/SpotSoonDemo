package com.shubham.spotsoon.activities;

import android.app.Application;

import com.shubham.spotsoon.R;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;

/**
 * Created by shubham on 7/20/2017.
 */
@ReportsCrashes(formKey = "", // will not be used
        mailTo = "shubham4706@gmail.com", mode = ReportingInteractionMode.TOAST, resToastText = R.string.crash_text)
public class SpotSoonApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ACRA.init(this);

    }
}
