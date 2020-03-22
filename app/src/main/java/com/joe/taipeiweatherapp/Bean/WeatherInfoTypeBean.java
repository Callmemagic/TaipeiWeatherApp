package com.joe.taipeiweatherapp.Bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * author: Joe Cheng
 */
public class WeatherInfoTypeBean implements Serializable {
    @SerializedName("startTime")
    private String startTime;

    @SerializedName("endTime")
    private String endTime;

    @SerializedName("parameter")
    private Param Params;

    public class Param implements Serializable
    {
        @SerializedName("parameterName")
        private String parameterName;

        @SerializedName("parameterUnit")
        private String parameterUnit;

        public String getParameterName() {
            return parameterName;
        }

        public String getParameterUnit() {
            return parameterUnit;
        }
    }

    public Param getParams() {
        return Params;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}
