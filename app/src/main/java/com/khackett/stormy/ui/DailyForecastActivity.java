package com.khackett.stormy.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.khackett.stormy.R;
import com.khackett.stormy.adapters.DayAdapter;
import com.khackett.stormy.weather.Day;

import java.util.Arrays;

/**
 * class uses a list view to display forecast data for each day of the week ahead
 */
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

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        // we can use this method to toast a message or start a new activity - we will just start a toast here
        String dayOfTheWeek = mDays[position].getDayOfTheWeek();
        String conditions = mDays[position].getSummary();
        String hightTemp = mDays[position].getTemperatureMax() + "";
        String message = String.format("On %s the high will be %s and it will be %s", dayOfTheWeek, hightTemp, conditions);
        // shows the following toast message when we tap on an item
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
