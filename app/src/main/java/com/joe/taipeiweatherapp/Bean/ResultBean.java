package com.joe.taipeiweatherapp.Bean;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * author: Joe Cheng
 */
public class ResultBean implements Serializable {
    @SerializedName("success")
    private String success;

    @SerializedName("result")
    private Object result;

    @SerializedName("records")
    private WeatherBean records;

    public WeatherBean getRecords() {
        return records;
    }
}
