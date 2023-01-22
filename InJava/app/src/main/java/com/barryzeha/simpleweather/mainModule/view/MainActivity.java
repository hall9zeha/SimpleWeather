package com.barryzeha.simpleweather.mainModule.view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.barryzeha.simpleweather.BR;
import com.barryzeha.simpleweather.R;
import com.barryzeha.simpleweather.common.entities.Forecast;
import com.barryzeha.simpleweather.common.utils.CommonUtils;
import com.barryzeha.simpleweather.common.utils.Constants;
import com.barryzeha.simpleweather.common.utils.Listener;
import com.barryzeha.simpleweather.databinding.ActivityMainBinding;
import com.barryzeha.simpleweather.mainModule.view.adapters.ForecastAdapter;
import com.barryzeha.simpleweather.mainModule.viewModel.MainViewModel;
import com.google.android.material.snackbar.Snackbar;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements Listener {
    private MainViewModel viewModel;
    private ActivityMainBinding bind;
    private ForecastAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind= DataBindingUtil.setContentView(this,R.layout.activity_main);

        setUpViewModel();
        setUpObservers();
        setUpAdapter();
        setUpRecyclerView();
    }

    private void setUpViewModel() {
        viewModel = new  ViewModelProvider(this).get(MainViewModel.class);
        bind.setLifecycleOwner(this);
        bind.setVariable(BR.viewModel,viewModel);
    }

    private void setUpObservers() {

        if(bind.getViewModel() !=null){
            bind.getViewModel().getResult().observe(this, weatherEntity -> {
                try {
                    viewModel.loaded.setValue(false);
                    if(weatherEntity != null) {
                        adapter.submitList(weatherEntity.getHourly());
                        Log.e("TAG", weatherEntity.toString());
                    }

                } catch (Exception e) {
                    bind.getViewModel().snackBarMsg.postValue(R.string.error_server_msg);
                    Log.e("ERROR_SERVER", e.getMessage().toString() );
                } finally {
                    viewModel.loaded.setValue(true);
                }

            });
        }
    }

    private void setUpAdapter() {
        adapter= new ForecastAdapter(new ForecastAdapter.ForecastDiffCallback(),this);

    }

    private void setUpRecyclerView() {
        bind.rvForecast.setHasFixedSize(true);
        bind.rvForecast.setLayoutManager(new LinearLayoutManager(this));
        bind.rvForecast.setAdapter(adapter);
    }

    @Override
    public void onClick(Forecast forecast) {
        Snackbar.make(bind.getRoot(), CommonUtils.getFullTime(forecast.getDt()),Snackbar.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.callWeatherForecast(33.44,-94.04, getString(R.string.you_api_key),"metric","es");

    }
}