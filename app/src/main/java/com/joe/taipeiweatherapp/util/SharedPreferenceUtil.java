package com.joe.taipeiweatherapp.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * author: Joe Cheng
 */
public class SharedPreferenceUtil {
    private static Context mContext;
    private static SharedPreferenceUtil sharedPreferenceUtil;

    public static SharedPreferenceUtil getInstance(Context context) {
        if(sharedPreferenceUtil == null)
        {
            mContext = context;
            sharedPreferenceUtil = new SharedPreferenceUtil();
        }
        return sharedPreferenceUtil;
    }

    public void writePref(String prefFileName, String prefKey, String prefValue)
    {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(prefKey, prefValue).commit();
    }

    public void writePref(String prefFileName, String prefKey, boolean prefValue)
    {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(prefKey, prefValue).commit();
    }

    public String readPref(String prefFileName, String prefKey)
    {
        return mContext.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)
                .getString(prefKey, "");
    }

    public boolean readBoolPref(String prefFileName, String prefKey)
    {
        return mContext.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)
                .getBoolean(prefKey, false);
    }
}
