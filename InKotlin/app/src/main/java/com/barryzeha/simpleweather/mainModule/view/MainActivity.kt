package com.barryzeha.simpleweather.mainModule.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.barryzeha.simpleweather.BR
import com.barryzeha.simpleweather.R
import com.barryzeha.simpleweather.common.utils.CommonUtils
import com.barryzeha.simpleweather.common.utils.Constants
import com.barryzeha.simpleweather.databinding.ActivityMainBinding
import com.barryzeha.simpleweather.mainModule.view.adapters.ForecastAdapter
import com.barryzeha.simpleweather.mainModule.viewModel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel:MainViewModel by viewModels()
    private lateinit var bind:ActivityMainBinding
    private lateinit var adapter: ForecastAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind= DataBindingUtil.setContentView(this,R.layout.activity_main)

        setUpViewModel()
        setUpObserver()
        setUpAdapter()
        setUpRecyclerView()
    }
    private fun setUpViewModel(){
        bind.lifecycleOwner=this
        bind.setVariable(BR.viewModel,viewModel)

    }
    private fun setUpObserver(){
        bind.viewModel?.let{
            it.getResult().observe(this){ result->
                adapter.submitList(result.hourly)
                Log.e("Forecast", result.hourly.toString() )
            }


        }
    }

    private fun setUpAdapter(){
        adapter=ForecastAdapter {
            Snackbar.make(bind.root,CommonUtils.getFullTime(it.dt),Snackbar.LENGTH_SHORT).show()
        }
    }
    private fun setUpRecyclerView(){
        bind.rvForecast.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter= this@MainActivity.adapter
        }
    }
    override fun onStart() {
        super.onStart()
        lifecycleScope.launch {
            viewModel.getWeatherForecast(33.44,-94.04,getString(R.string.you_api_key),"metric","es")
        }
    }

}