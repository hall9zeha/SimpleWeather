package com.barryzeha.simpleweather.common.dataAccess;

import com.barryzeha.simpleweather.common.entities.WeatherEntity;
import com.barryzeha.simpleweather.common.utils.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/****
 * Project Simple Weather
 * Created by Barry Zea H. on 21/01/2023
 * Copyright (c)  All rights reserved.
 ***/

public interface WeatherService {
    @GET(Constants.ONE_CALL_PATH)
    Call<WeatherEntity> getWeatherForecast(
            @Query(Constants.LAT_PARAM)double lat,
            @Query(Constants.LON_PARAM)double lon,
            @Query(Constants.APP_ID_PARAM)String appId,
            @Query(Constants.UNIT_PARAM)String unit,
            @Query(Constants.LANGUAGE_PARAM)String lan
    );

}
