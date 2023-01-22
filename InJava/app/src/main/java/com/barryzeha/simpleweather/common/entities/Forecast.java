package com.barryzeha.simpleweather.common.entities;

/****
 * Project Simple Weather
 * Created by Barry Zea H. on 21/01/2023
 * Copyright (c)  All rights reserved.
 ***/

public class Forecast extends WeatherBase {
 long sunrise;
  double pop;


 public long getSunrise() {
  return sunrise;
 }

 public double getPop() {
  return pop;
 }

 public void setPop(double pop) {
  this.pop = pop;
 }


}
