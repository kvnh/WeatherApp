package com.khackett.stormy.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.khackett.stormy.R;
import com.khackett.stormy.adapters.DayAdapter;
import com.khackett.stormy.weather.Day;

import java.util.Arrays;

public class DailyForecastActivity extends ListActivity {

    private Day[] mDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);

        // get the intent that started this activity
        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);

        // convert this into an array of Day objects, using code from the Day class
        // use copyOf() method to copy one array into another - parcelables into Day[]
        mDays = Arrays.copyOf(parcelables, parcelables.length, Day[].class);

        DayAdapter adapter = new DayAdapter(this, mDays);
        setListAdapter(adapter);
    }

}
