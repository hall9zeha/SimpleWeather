package com.barryzeha.simpleweather.mainModule.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barryzeha.simpleweather.R
import com.barryzeha.simpleweather.common.entities.WeatherEntity
import com.barryzeha.simpleweather.mainModule.model.MainRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/****
 * Project Simple Weather
 * Created by Barry Zea H. on 18/01/2023
 * Copyright (c)  All rights reserved.
 ***/
@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository):ViewModel()  {
    private val result = MutableLiveData<WeatherEntity>()
    fun getResult():LiveData<WeatherEntity> = result

    private val snackBarMsg = MutableLiveData<Int>()
    fun getSnackBarMsg() = snackBarMsg

    private val loaded = MutableLiveData<Boolean>()
    fun getLoaded() = loaded

    suspend fun getWeatherForecast(lat:Double, lon:Double, appId:String, units:String, lang:String){
        viewModelScope.launch {
            try {
                loaded.value= false
                val resultServer=repository.getWeatherForecast(lat,lon,appId, units, lang)
                result.value = resultServer
            } catch (e: Exception) {
                snackBarMsg.value = R.string.error_server_msg
                Log.e("ERROR", e.message.toString() )
            } finally {
                loaded.value = true
            }
        }
    }
}