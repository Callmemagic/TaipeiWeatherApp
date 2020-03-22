package com.joe.taipeiweatherapp.Bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * author: Joe Cheng
 */
public class WeatherBean implements Serializable
{
    @SerializedName("datasetDescription")
    private String datasetDescription;

    @SerializedName("location")
    private ArrayList<LocationBean> alLocations;

    public String getDatasetDescription() {
        return datasetDescription;
    }

    public ArrayList<LocationBean> getAlLocations() {
        return alLocations;
    }
}
