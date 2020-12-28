package com.example.projet4a.Presentation.HomePage

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projet4a.Data.Repository.WeatherRepository
import com.example.projet4a.Domain.Entity.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomePageViewModel(
        private val weatherRepository: WeatherRepository
) : ViewModel() {

    var weather : MutableLiveData<MutableList<Response>> = MutableLiveData()

    var flag : MutableLiveData<FlagStatus> = MutableLiveData()

    fun makeApiCall(){
        viewModelScope.launch(Dispatchers.IO){
            flag.postValue(FlagFalse)
            val cities = listOf("Paris","Marseille","Lyon","Toulouse","Nice","Nantes","Montpellier","Strasbourg","Bordeaux","Lille")
            var response_list : MutableList<Response> = mutableListOf()
            for(city in cities) {
                response_list.add(weatherRepository.getWeather(city))
            }
            withContext(Dispatchers.Main){
                weather.postValue(response_list)
                flag.postValue(FlagTrue)
            }
        }
    }

}