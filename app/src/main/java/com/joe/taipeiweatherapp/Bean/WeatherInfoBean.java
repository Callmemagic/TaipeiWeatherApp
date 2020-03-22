package com.joe.taipeiweatherapp.Bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * author: Joe Cheng
 */
public class WeatherInfoBean {
    @SerializedName("elementName")
    private String elementName;

    @SerializedName("time")
    private ArrayList<WeatherInfoTypeBean> alWeatherInfoTypeBeans;

    public String getElementName() {
        return elementName;
    }

    public ArrayList<WeatherInfoTypeBean> getAlWeatherInfoTypeBeans() {
        return alWeatherInfoTypeBeans;
    }
}
