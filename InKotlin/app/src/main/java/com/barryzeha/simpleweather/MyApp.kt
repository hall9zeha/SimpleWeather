package com.barryzeha.simpleweather

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

/****
 * Project Simple Weather
 * Created by Barry Zea H. on 18/01/2023
 * Copyright (c)  All rights reserved.
 ***/
@HiltAndroidApp
class MyApp:Application() {
    companion object{
        lateinit var context:Context
    }
    override fun onCreate() {
        super.onCreate()
        context = this.applicationContext
    }
}