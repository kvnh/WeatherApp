package com.khackett.stormy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;

import com.khackett.stormy.R;
import com.khackett.stormy.weather.Hour;

import java.util.Arrays;

public class HourlyForecastActivity extends ActionBarActivity {

    // set a property for the array of hours
    private Hour[] mHours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_forecast);

        // set a Parcelable array variable
        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.HOURLY_FORECAST);
        // copy the parcelables array into mHours
        mHours = Arrays.copyOf(parcelables, parcelables.length, Hour[].class);
    }

}
