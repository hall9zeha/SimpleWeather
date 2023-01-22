package com.barryzeha.simpleweather.common.entities

import com.google.gson.annotations.SerializedName

/****
 * Project Simple Weather
 * Created by Barry Zea H. on 18/01/2023
 * Copyright (c)  All rights reserved.
 ***/
data class WeatherEntity(
    @SerializedName("timezone") val timeZone:String,
    val current: Current,
    val hourly:List<Forecast>
)
