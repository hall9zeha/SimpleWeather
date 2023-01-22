package com.barryzeha.simpleweather.mainModule.model;

import androidx.lifecycle.MutableLiveData;

import com.barryzeha.simpleweather.common.dataAccess.WeatherService;
import com.barryzeha.simpleweather.common.entities.WeatherEntity;
import com.barryzeha.simpleweather.common.utils.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/****
 * Project Simple Weather
 * Created by Barry Zea H. on 21/01/2023
 * Copyright (c)  All rights reserved.
 ***/
@Module
@InstallIn(SingletonComponent.class)
public class WeatherServiceImpl {
    private final MutableLiveData<WeatherEntity> responseServer = new MutableLiveData<>();
    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private final WeatherService service =retrofit.create(WeatherService.class);

    public void callWeatherForecast(double lat, double lon, String appId, String units, String lang){

        service.getWeatherForecast(lat, lon, appId, units, lang).enqueue(new Callback<WeatherEntity>() {
            @Override
            public void onResponse(Call<WeatherEntity> call, Response<WeatherEntity> response) {
                if(response.isSuccessful()){
                    responseServer.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<WeatherEntity> call, Throwable t) {

            }
        });

    }
    public MutableLiveData<WeatherEntity> getWeatherForecast(){
        return responseServer;
    }

    @Provides
    @Singleton
    public MainRepository providerRepository(){return new MainRepository(this);}

}
