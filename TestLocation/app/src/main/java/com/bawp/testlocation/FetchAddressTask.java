package com.bawp.testlocation;

import android.content.Context;
import android.location.Location;
import android.os.AsyncTask;
import android.util.Log;

import static android.support.constraint.Constraints.TAG;

public class FetchAddressTask extends AsyncTask<Location, Void, String> {
    private final OnTaskCompleted listener;

    public FetchAddressTask(Context context, OnTaskCompleted listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(Location... locations) {
        //Setting our Geocoder
        Location location = locations[0];
        String resultString = "";

        resultString = String.valueOf(location.getLatitude());
        Log.e(TAG, "res" + ". " +
                "Latitude = " + location.getLatitude() +
                ", Longitude = " +
                location.getLongitude());

        return resultString;
    }

     interface OnTaskCompleted {
        void onTaskCompleted(String result);
    }

    @Override
    protected void onPostExecute(String message) {
        listener.onTaskCompleted(message);
        super.onPostExecute(message);
    }
}
