package com.barryzeha.simpleweather.common.utils

import com.barryzeha.simpleweather.BuildConfig
import com.barryzeha.simpleweather.MyApp
import com.barryzeha.simpleweather.R

/****
 * Project Simple Weather
 * Created by Barry Zea H. on 18/01/2023
 * Copyright (c)  All rights reserved.
 ***/
object Constants {
    const val BASE_URL="https://api.openweathermap.org/"
    const val ONE_CALL_PATH="data/2.5/onecall"
    const val LAT_PARAM="lat"
    const val LON_PARMA="lon"
    const val APP_ID_PARAM="appid"
    const val UNIT_PARAM="units"
    const val LANGUAGE_PARAM="lang"
//Si vas a utilizar el ofuscamiento de una api_key en local.properties o cualquier otro archivo dentro
//del directorio raiz de la aplicación usar esta forma a travéz de BuildConfig
//const val APP_KEY = BuildConfig.WEATHER_API_KEY
}