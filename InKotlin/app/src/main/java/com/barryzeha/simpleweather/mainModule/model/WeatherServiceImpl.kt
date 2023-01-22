package com.barryzeha.simpleweather.mainModule.model

import com.barryzeha.simpleweather.common.dataAccess.WeatherService
import com.barryzeha.simpleweather.common.entities.WeatherEntity
import com.barryzeha.simpleweather.common.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/****
 * Project Simple Weather
 * Created by Barry Zea H. on 18/01/2023
 * Copyright (c)  All rights reserved.
 ***/
@Module
@InstallIn(SingletonComponent::class)
class WeatherServiceImpl {

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val service = retrofit.create(WeatherService::class.java)
    suspend fun getWeatherForecast(lat:Double, lon:Double, appId:String, units:String, lang:String): WeatherEntity =
        withContext(Dispatchers.IO){
            service.getWeatherForecast(lat,lon,appId,units,lang)
        }

    @Singleton
    @Provides
    fun providerRepository() = MainRepository(this)

}