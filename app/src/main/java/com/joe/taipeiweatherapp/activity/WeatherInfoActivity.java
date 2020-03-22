package com.joe.taipeiweatherapp.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.joe.taipeiweatherapp.Bean.ResultBean;
import com.joe.taipeiweatherapp.Bean.WeatherInfoTypeBean;
import com.joe.taipeiweatherapp.ConstantValue;
import com.joe.taipeiweatherapp.R;
import com.joe.taipeiweatherapp.databinding.ViewWeatherInfoBinding;
import com.joe.taipeiweatherapp.util.CustomDialogUtility;
import com.joe.taipeiweatherapp.util.SharedPreferenceUtil;

/**
 * author: Joe Cheng
 */
public class WeatherInfoActivity extends AppCompatActivity {
    WeatherInfoTypeBean weatherInfoTypeBean;
    ViewWeatherInfoBinding viewWeatherInfoBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewWeatherInfoBinding = ViewWeatherInfoBinding.inflate(getLayoutInflater());
        setContentView(viewWeatherInfoBinding.getRoot());

        initView();
    }

    private void initView() {
        if(getIntent() != null)
        {
            weatherInfoTypeBean = (WeatherInfoTypeBean) getIntent().getSerializableExtra(ConstantValue.INTENT_WEATHERINFO);
        }

        if(weatherInfoTypeBean != null)
        {
            viewWeatherInfoBinding.tvWeatherInfo.setText(weatherInfoTypeBean.getStartTime() + "\n" +
                    weatherInfoTypeBean.getEndTime() + "\n" +
                    weatherInfoTypeBean.getParams().getParameterName() +
                    weatherInfoTypeBean.getParams().getParameterUnit());
        }

        if(true == SharedPreferenceUtil.getInstance(this).readBoolPref(ConstantValue.PREF_WEATHER, ConstantValue.PREF_ENTERED))
        {
            //有進來過，顯示訊息
            Toast.makeText(this, getString(R.string.welcome_back), Toast.LENGTH_SHORT).show();
            CustomDialogUtility.showDialog(this, getString(R.string.welcome_back), getString(R.string.welcome_back));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferenceUtil.getInstance(this).writePref(ConstantValue.PREF_WEATHER, ConstantValue.PREF_ENTERED, true);
    }
}
