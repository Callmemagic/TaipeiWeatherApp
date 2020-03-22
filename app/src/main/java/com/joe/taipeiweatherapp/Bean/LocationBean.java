package com.joe.taipeiweatherapp.Bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * author: Joe Cheng
 */
public class LocationBean implements Serializable {
    @SerializedName("locationName")
    private String locationName;

    @SerializedName("weatherElement")
    private ArrayList<WeatherInfoBean> alWeatherInfoBean;

    public String getLocationName() {
        return locationName;
    }

    public ArrayList<WeatherInfoBean> getAlWeatherInfoBean() {
        return alWeatherInfoBean;
    }
}
