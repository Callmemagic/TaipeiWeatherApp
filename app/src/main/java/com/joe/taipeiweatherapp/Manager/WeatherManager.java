package com.joe.taipeiweatherapp.Manager;

import com.joe.taipeiweatherapp.Bean.ResultBean;

/**
 * author: Joe Cheng
 */
public class WeatherManager {
    private static WeatherManager weatherManager;
    private ResultBean resultBean;

    public static WeatherManager getInstance() {
        if(weatherManager == null)
        {
            weatherManager = new WeatherManager();
        }
        return weatherManager;
    }

    public ResultBean getResultBean() {
        return resultBean;
    }

    public void setResultBean(ResultBean resultBean) {
        this.resultBean = resultBean;
    }
}
