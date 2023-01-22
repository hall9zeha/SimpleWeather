package com.barryzeha.simpleweather.mainModule.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.barryzeha.simpleweather.BR;
import com.barryzeha.simpleweather.R;
import com.barryzeha.simpleweather.common.entities.Forecast;
import com.barryzeha.simpleweather.common.utils.Listener;
import com.barryzeha.simpleweather.databinding.WeatherItemBinding;

/****
 * Project Simple Weather
 * Created by Barry Zea H. on 21/01/2023
 * Copyright (c)  All rights reserved.
 ***/
 
public class ForecastAdapter extends ListAdapter<Forecast,RecyclerView.ViewHolder> {

    private final Listener listener;
    public ForecastAdapter(@NonNull ForecastDiffCallback diffCallback, Listener listener) {
        super(diffCallback);
        this.listener= listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Forecast forecast = getItem(position);
        ViewHolder myHolder = (ViewHolder)holder;
        myHolder.bind.setVariable(BR.forecast,forecast);
        myHolder.bind.executePendingBindings();
        myHolder.setListener(forecast, listener);

    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public final WeatherItemBinding bind= DataBindingUtil.bind(itemView);
        public void setListener(Forecast forecast, Listener listener){
            if(bind!=null){
                bind.getRoot().setOnClickListener(v->{
                    listener.onClick(forecast);

                });
            }
        }
    }

    public static class ForecastDiffCallback extends DiffUtil.ItemCallback<Forecast>{
        @Override
        public boolean areItemsTheSame(@NonNull Forecast oldItem, @NonNull Forecast newItem) {
            return oldItem.getDt() == newItem.getDt();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Forecast oldItem, @NonNull Forecast newItem) {
            //se debe sobreescribir setHashEquals en la clase Forecast (que es la entidad que usamos en este caso)
            //y además en nuestro caso se sobreescribe en la clase Padre de la cual hereda forecast
            return oldItem.equals(newItem);
        }
    }
}
