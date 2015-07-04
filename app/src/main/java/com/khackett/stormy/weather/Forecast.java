package com.khackett.stormy.weather;

/**
 * class to group together data from Current, Day and Hour model classes
 *
 * Created by KHackett on 04/07/15.
 */
public class Forecast {

    private Current mCurrent;
    private Hour[] mHourlyForecast;
    private Day[] mDailyForecast;
}
