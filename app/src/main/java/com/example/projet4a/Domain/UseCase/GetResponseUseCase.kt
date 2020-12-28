package com.example.projet4a.Domain.UseCase

import com.example.projet4a.Data.Repository.WeatherRepository
import com.example.projet4a.Domain.Entity.Response

class GetResponseUseCase(
        private val weatherRepository: WeatherRepository
) {
    suspend fun invoke(city : String): Response {
        return weatherRepository.getWeather(city)
    }
}