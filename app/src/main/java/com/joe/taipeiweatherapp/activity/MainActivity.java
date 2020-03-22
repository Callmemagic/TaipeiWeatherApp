package com.joe.taipeiweatherapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.joe.taipeiweatherapp.Bean.ResultBean;
import com.joe.taipeiweatherapp.Bean.WeatherInfoTypeBean;
import com.joe.taipeiweatherapp.ConstantValue;
import com.joe.taipeiweatherapp.Manager.WeatherManager;
import com.joe.taipeiweatherapp.R;
import com.joe.taipeiweatherapp.adapter.WeatherAdapter;
import com.joe.taipeiweatherapp.databinding.ActivityMainBinding;
import com.joe.taipeiweatherapp.listener.OnClickWeatherItemListener;
import com.joe.taipeiweatherapp.util.ProgressDialogUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    ActivityMainBinding activityMainBinding;
    ArrayList<WeatherInfoTypeBean> alWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        getDataByVolley();
    }

    private void getDataByVolley() {
        ProgressDialogUtil.showProgressDialog(this, false);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, ConstantValue.AUTH,
                onSuccessListener, onErrorListener);

        requestQueue.add(stringRequest);
    }

    Response.Listener onSuccessListener = new Response.Listener() {

        @Override
        public void onResponse(Object response) {
            Log.d(TAG, "onResponse: " + response.toString());

            parseDataByGson(response.toString());
        }
    };

    private void parseDataByGson(String strBody) {

        Gson gson = new Gson();
        try {
            JSONObject jsonObject = new JSONObject(strBody);

            ResultBean result = gson.fromJson(jsonObject.toString(), new TypeToken<ResultBean>(){}.getType());
            WeatherManager.getInstance().setResultBean(result);
            
            processAdapter();

            ProgressDialogUtil.dismiss();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void processAdapter() {
        WeatherAdapter weatherAdapter = new WeatherAdapter(this,
                WeatherManager.getInstance().getResultBean().getRecords().getAlLocations().get(0)
                        .getAlWeatherInfoBean().get(2).getAlWeatherInfoTypeBeans(),
                onClickWeatherItemListener);
        activityMainBinding.rvItems.setAdapter(weatherAdapter);
        activityMainBinding.rvItems.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.rvItems.setHasFixedSize(true);

    }

    OnClickWeatherItemListener onClickWeatherItemListener = new OnClickWeatherItemListener() {
        @Override
        public void onClickItem(WeatherInfoTypeBean weatherInfoTypeBean) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(ConstantValue.INTENT_WEATHERINFO, weatherInfoTypeBean);

            startActivity(new Intent(MainActivity.this, WeatherInfoActivity.class).putExtras(bundle));
        }
    };

    Response.ErrorListener onErrorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            ProgressDialogUtil.dismiss();
            Toast.makeText(MainActivity.this, getString(R.string.get_data_error), Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onErrorResponse: " + error.getMessage());
        }
    };
}
