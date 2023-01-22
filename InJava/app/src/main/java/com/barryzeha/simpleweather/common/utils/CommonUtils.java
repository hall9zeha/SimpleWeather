package com.barryzeha.simpleweather.common.utils;

import com.barryzeha.simpleweather.common.entities.Weather;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/****
 * Project Simple Weather
 * Created by Barry Zea H. on 21/01/2023
 * Copyright (c)  All rights reserved.
 ***/
 
public class CommonUtils {
    public static String getHour(long epoch){
        return getFormattedTime(epoch, "HH:mm");
    }
    public static String getFullTime(long epoch){
        return getFormattedTime(epoch, "dd/MM/yy HH:mm");
    }

    private static String getFormattedTime(long epoch, String pattern){
        return new SimpleDateFormat(pattern, Locale.getDefault()).format(epoch * 1_000);
    }
    public static String getWeatherMain(List<Weather> weather){
        return weather != null && !weather.isEmpty() ? weather.get(0).getMain() : "-";
    }
    public static String getWeatherDesc(List<Weather> weather){
        return weather != null && !weather.isEmpty() ? weather.get(0).getDescription() : "-";
    }
}
