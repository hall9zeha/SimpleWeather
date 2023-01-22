package com.barryzeha.simpleweather.common.entities;

import java.util.List;
import java.util.Objects;

/****
 * Project Simple Weather
 * Created by Barry Zea H. on 21/01/2023
 * Copyright (c)  All rights reserved.
 ***/
public class WeatherBase {
    long dt;
    int humidity;
    double temp;
    List<Weather> weather;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherBase that = (WeatherBase) o;
        return dt == that.dt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dt);
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
}
