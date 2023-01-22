package com.barryzeha.simpleweather.mainModule.model;

import androidx.lifecycle.MutableLiveData;

import com.barryzeha.simpleweather.common.entities.WeatherEntity;

/****
 * Project Simple Weather
 * Created by Barry Zea H. on 21/01/2023
 * Copyright (c)  All rights reserved.
 ***/
 
public class MainRepository {
    private final WeatherServiceImpl weatherService;
    public MainRepository(WeatherServiceImpl weatherService){
        this.weatherService = weatherService;
    }

    public void callWeatherForecast(double lat, double lon ,String appId, String units, String lang){
        weatherService.callWeatherForecast(lat,lon,appId,units,lang);
    }
    public MutableLiveData<WeatherEntity> getWeatherForecast(){
        return weatherService.getWeatherForecast();
    }
}
