package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Volushkova on 3/04/2017.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {

    private String[] mWeatherData;
    public ForecastAdapter() {

    }

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutId = R.layout.forecast_list_item;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View inflate = layoutInflater.inflate(layoutId, parent, shouldAttachToParentImmediately);
        return new ForecastAdapterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        String weatherText = mWeatherData[position];
        holder.mWeatherTextView.setText(weatherText);
    }

    @Override
    public int getItemCount() {
        if(mWeatherData == null) {
            return 0;
        }
        return mWeatherData.length;
    }

    public void setmWeatherData(String[] weatherData) {
        mWeatherData = weatherData;
        notifyDataSetChanged();

    }
    class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {
        public final TextView mWeatherTextView;
        public ForecastAdapterViewHolder(View itemView) {
            super(itemView);
            mWeatherTextView = (TextView) itemView.findViewById(R.id.tv_weather_data);
        }
    }
}
