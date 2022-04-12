package com.nadi.interviewprojecttest.ui.weatherlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.nadi.interviewprojecttest.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherListViewModel @Inject constructor(
    var repo: WeatherRepository
) : ViewModel() {

    fun getWeather() = viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repo.getResponse().asLiveData()
            }
        }

    init {
        getWeather()
    }
}