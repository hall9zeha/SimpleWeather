package com.barryzeha.simpleweather.common.adapters

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY

/****
 * Project Simple Weather
 * Created by Barry Zea H. on 19/01/2023
 * Copyright (c)  All rights reserved.
 ***/

    @BindingAdapter("isGone")
    fun bindGone(view:View, isGone:Boolean){
        view.visibility=if (isGone) View.GONE else View.VISIBLE
    }
