package com.khackett.stormy.ui;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.khackett.stormy.R;

public class DailyForecastActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);

        String[] daysOfTheWeek = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

        // adapter to say how the data will be laid out
        // 2nd paramter is the ID of the layout we want to use for each item in the list
        // simple_list_item_1 is a layout provided by android, kept in the R class in android
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                daysOfTheWeek);

        // set this new adapter as the adapter for the list view
        setListAdapter(adapter);
    }

}
