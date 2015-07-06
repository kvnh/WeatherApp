package com.khackett.stormy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.khackett.stormy.R;
import com.khackett.stormy.adapters.HourAdapter;
import com.khackett.stormy.weather.Hour;

import java.util.Arrays;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class HourlyForecastActivity extends ActionBarActivity {

    // set a property for the array of hours
    private Hour[] mHours;


    // get the recycler view from the layout using Butterknife
    @InjectView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_forecast);

        // since we are using Butterknife, we need to call this after setContentView
        ButterKnife.inject(this);

        // set a Parcelable array variable
        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.HOURLY_FORECAST);
        // copy the parcelables array into mHours
        mHours = Arrays.copyOf(parcelables, parcelables.length, Hour[].class);

        // create the adapter
        HourAdapter adapter = new HourAdapter(this, mHours);
        // set it as the adapter for the recycler view
        mRecyclerView.setAdapter(adapter);

        // add a linear layout manager
        // this determines when list items are no longer visible and can be reused
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        // set this as the layout manager for the recycler view
        mRecyclerView.setLayoutManager(layoutManager);

        // this next line helps improve performance if we are using data with a fixed size -
        // our hourly forecast array will always have the same number of items so it can be used here
        mRecyclerView.setHasFixedSize(true);
    }
}
