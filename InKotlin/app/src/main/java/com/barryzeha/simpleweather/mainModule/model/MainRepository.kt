package com.barryzeha.simpleweather.mainModule.model

/****
 * Project Simple Weather
 * Created by Barry Zea H. on 18/01/2023
 * Copyright (c)  All rights reserved.
 ***/

class MainRepository(private val service:WeatherServiceImpl) {

   suspend fun getWeatherForecast(lat:Double, lon:Double,appId:String,units:String,lang:String)
    =service.getWeatherForecast(lat,lon,appId,units,lang)
}