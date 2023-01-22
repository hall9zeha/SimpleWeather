package com.barryzeha.simpleweather.common.dataAccess

import com.barryzeha.simpleweather.common.entities.WeatherEntity
import com.barryzeha.simpleweather.common.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

/****
 * Project Simple Weather
 * Created by Barry Zea H. on 18/01/2023
 * Copyright (c)  All rights reserved.
 ***/
interface WeatherService {
    @GET(Constants.ONE_CALL_PATH)
    suspend fun getWeatherForecast(
        @Query(Constants.LAT_PARAM) lat:Double,
        @Query(Constants.LON_PARMA) lon:Double,
        @Query(Constants.APP_ID_PARAM)appId:String,
        @Query(Constants.UNIT_PARAM)unit:String,
        @Query(Constants.LANGUAGE_PARAM)lan:String
    ): WeatherEntity
}