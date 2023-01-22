package com.barryzeha.simpleweather.mainModule.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.barryzeha.simpleweather.common.entities.WeatherEntity;
import com.barryzeha.simpleweather.mainModule.model.MainRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

/****
 * Project Simple Weather
 * Created by Barry Zea H. on 21/01/2023
 * Copyright (c)  All rights reserved.
 ***/

@HiltViewModel
public class MainViewModel extends ViewModel {
    private final MainRepository repository;
    public @Inject
    MainViewModel (MainRepository repository){
        this.repository=repository;

    }

    public MutableLiveData<WeatherEntity> getResult() {return repository.getWeatherForecast();}
    public final   MutableLiveData<Integer> snackBarMsg = new MutableLiveData<>();
    public  MutableLiveData<Integer> getSnackBarMsg() {return snackBarMsg;}

    public final MutableLiveData<Boolean> loaded = new MutableLiveData<>(false);
    public  MutableLiveData<Boolean> getLoaded(){return loaded;}


    public void callWeatherForecast(double lat, double lon, String appId, String units, String lang){
             repository.callWeatherForecast(lat,lon,appId,units,lang);
    }


}
