package com.example.projet4a.Data.Repository

import com.example.projet4a.Data.Remote.WeatherApiService
import com.example.projet4a.Domain.Entity.Response

class WeatherRepository(
        private val weatherApiService: WeatherApiService
) {
    suspend fun getWeather(city : String) : Response {
        return weatherApiService.getWeather(city,"fr","metric")
    }
}