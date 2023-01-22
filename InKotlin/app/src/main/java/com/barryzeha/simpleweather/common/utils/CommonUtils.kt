package com.barryzeha.simpleweather.common.utils

import com.barryzeha.simpleweather.common.entities.Weather
import java.text.SimpleDateFormat
import java.util.*

/****
 * Project Simple Weather
 * Created by Barry Zea H. on 19/01/2023
 * Copyright (c)  All rights reserved.
 ***/
object CommonUtils {
    fun getHour(epoch:Long):String=getFormattedTime(epoch, "HH:mm")
    fun getFullTime(epoch:Long):String=getFormattedTime(epoch, "dd/MM/yy HH:mm")

    private fun getFormattedTime(epoch: Long, pattern: String):String {
        return SimpleDateFormat(pattern, Locale.getDefault()).format(epoch  * 1_000)
    }

    fun getWeatherMain(weather:List<Weather>?):String{
       return if(weather!=null && weather.isNotEmpty()) weather[0].main else "-"
            }
    fun getWeatherDesc(weather:List<Weather>?):String{
        return if(weather!=null && weather.isNotEmpty()) weather[0].description else "-"

    }
}