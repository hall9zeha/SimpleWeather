package com.barryzeha.simpleweather.mainModule.view.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.barryzeha.simpleweather.BR
import com.barryzeha.simpleweather.R
import com.barryzeha.simpleweather.common.entities.Forecast
import com.barryzeha.simpleweather.databinding.WeatherItemBinding

/****
 * Project Simple Weather
 * Created by Barry Zea H. on 19/01/2023
 * Copyright (c)  All rights reserved.
 ***/
class ForecastAdapter(private val onClick:(forecast:Forecast)->Unit) :ListAdapter<Forecast,RecyclerView.ViewHolder>(ForecastDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.weather_item,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val forecast = getItem(position)
        with(holder as ViewHolder){
            holder.bind?.setVariable(BR.forecast,forecast)
            holder.bind?.executePendingBindings()
                setListener(forecast)
        }
    }

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val bind = DataBindingUtil.bind<WeatherItemBinding>(view)

        fun setListener(forecast:Forecast){
            bind?.root?.setOnClickListener {
                onClick(forecast)
            }
        }
    }
    class ForecastDiffCallback : DiffUtil.ItemCallback<Forecast>(){
        override fun areItemsTheSame(oldItem: Forecast, newItem: Forecast):Boolean = oldItem.dt == newItem.dt

        override fun areContentsTheSame(oldItem: Forecast, newItem: Forecast):Boolean = oldItem == newItem
    }
}