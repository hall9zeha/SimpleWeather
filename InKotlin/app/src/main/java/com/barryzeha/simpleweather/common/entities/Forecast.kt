package com.barryzeha.simpleweather.common.entities

/****
 * Project Simple Weather
 * Created by Barry Zea H. on 18/01/2023
 * Copyright (c)  All rights reserved.
 ***/
data class Forecast(
    val dt: Long,
    val humidity: Int,
    val temp: Double,
    val weather: List<Weather>,
    val sunrise: Long,
    val pop: Double
) : WeatherBase(dt, humidity, temp, weather)
