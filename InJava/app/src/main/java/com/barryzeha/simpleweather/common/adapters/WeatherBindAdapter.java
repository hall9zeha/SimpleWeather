package com.barryzeha.simpleweather.common.adapters;

import android.view.View;

import androidx.databinding.BindingAdapter;

/****
 * Project Simple Weather
 * Created by Barry Zea H. on 21/01/2023
 * Copyright (c)  All rights reserved.
 ***/
 
public class WeatherBindAdapter {
    @BindingAdapter("isGone")
    public static void isGone(View view, Boolean isGone){
        view.setVisibility( isGone?View.GONE : View.VISIBLE);
    }
}
