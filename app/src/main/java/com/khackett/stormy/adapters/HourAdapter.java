package com.khackett.stormy.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.khackett.stormy.R;
import com.khackett.stormy.weather.Hour;

/**
 * Created by KHackett on 05/07/15.
 */
public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder> {

    private Hour[] mHours;

    // add a context member variable to be used on the onClick() method. Pass it in to the constructor below also
    private Context mContext;

    // constructor to create this adapter in the activity and then set its data
    public HourAdapter(Context context, Hour[] hours) {
        mContext = context;
        mHours = hours;
    }

    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // this method is called whenever a new viewholder is needed
        // view are still going to be recycled just like they are in a list view
        // this is where we create new ones as they are needed

        // inflate the layout and create the root view
        // get the context from the parent parameter passed in
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hourly_list_item, parent, false);

        // use the view to create the view holder with the constructor we made
        HourViewHolder viewHolder = new HourViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(HourViewHolder holder, int position) {

        // this method is the bridge between the adapter and the bind method we created
        // in our HourViewHolder class below.  Call the method with the correct hour
        // from the array - got using the position parameter passed in
        holder.bindHour(mHours[position]);

    }

    /**
     * Returns the total number of items in the data set hold by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return mHours.length;
    }

    // we want to use view holder objects
    // we need view holders to use a recycler view

    // create a view holder as a nested inner class - this is a nested viewholder class
    public class HourViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // we want a member variable for each view that is going to be in the layout
        public TextView mTimeLabel;
        public TextView mSummaryLabel;
        public TextView mTemperatureLabel;
        public ImageView mIconImageView;

        public HourViewHolder(View itemView) {
            super(itemView);
            // initialise the view (just like we would in an activitys onCreate() method
            // can also use ButterKnife here if you wish
            mTimeLabel = (TextView) itemView.findViewById(R.id.timeLabel);
            mSummaryLabel = (TextView) itemView.findViewById(R.id.summaryLabel);
            mTemperatureLabel = (TextView) itemView.findViewById(R.id.temperatureLabel);
            mIconImageView = (ImageView) itemView.findViewById(R.id.iconImageView);

            // set the onClickListener for the view in the hour view holder
            // attach an onClickListener to this item view
            itemView.setOnClickListener(this);
        }

        // method that maps all of the data to the view
        // (similar to the getView() method in the other list view for DayAdapter)
        public void bindHour(Hour hour) {
            mTimeLabel.setText(hour.getHour());
            mSummaryLabel.setText(hour.getSummary());
            mTemperatureLabel.setText(hour.getTemperature() + "");
            mIconImageView.setImageResource(hour.getIconId());
        }

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {
            // can use this method to start a new activity, open a dialog, toast messsage, etc
            String time = mTimeLabel.getText().toString();
            String temperature = mTemperatureLabel.getText().toString();
            String summary = mSummaryLabel.getText().toString();
            String message = String.format("At %s it will be %s and %s", time, temperature, summary);

            // since we are in a custom adapter, we need to pass in the context of where this adapter is being used
            // see at the top of the class where it is created and set in the constructor
            Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
        }
    }



}
