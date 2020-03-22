package com.joe.taipeiweatherapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joe.taipeiweatherapp.Bean.WeatherInfoTypeBean;
import com.joe.taipeiweatherapp.R;
import com.joe.taipeiweatherapp.listener.OnClickWeatherItemListener;

import java.util.ArrayList;

/**
 * author: Joe Cheng
 */
public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {
    Context context;
    ArrayList<WeatherInfoTypeBean> alWeather;
    OnClickWeatherItemListener onClickWeatherItemListener;
    public WeatherAdapter(Context context, ArrayList<WeatherInfoTypeBean> alWeather, OnClickWeatherItemListener onClickWeatherItemListener) {
        this.context = context;
        this.alWeather = alWeather;
        this.onClickWeatherItemListener = onClickWeatherItemListener;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_weather_item, parent,false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        WeatherInfoTypeBean bean = alWeather.get(0);
        holder.tvWeather.setText(bean.getStartTime() + "\n" +
                bean.getEndTime() + "\n" +
                bean.getParams().getParameterName() +
                bean.getParams().getParameterUnit());
    }

    @Override
    public int getItemCount() {
        if(alWeather != null)
        {
            return alWeather.size();
        }
        return 0;
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImg;
        TextView tvWeather;

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImg = itemView.findViewById(R.id.ivIcon);
            tvWeather = itemView.findViewById(R.id.tvWeather);

            tvWeather.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickWeatherItemListener.onClickItem(alWeather.get(getAdapterPosition()));
                }
            });
        }
    }
}
