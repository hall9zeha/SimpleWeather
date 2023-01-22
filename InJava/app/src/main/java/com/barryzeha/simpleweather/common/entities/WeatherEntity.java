package com.barryzeha.simpleweather.common.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/****
 * Project Simple Weather
 * Created by Barry Zea H. on 21/01/2023
 * Copyright (c)  All rights reserved.
 ***/

public class WeatherEntity {
   @SerializedName("timezone")
   String timeZone;
   Current current;
   List<Forecast> hourly;

   public String getTimeZone() {
    return timeZone;
   }

   public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
   }

   public Current getCurrent() {
    return current;
   }

   public void setCurrent(Current current) {
    this.current = current;
   }

   public List<Forecast> getHourly() {
    return hourly;
   }

}
