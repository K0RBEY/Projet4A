package com.example.projet4a.Data.Remote

import com.example.projet4a.Domain.Entity.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("weather")
    suspend fun getWeather(@Query("q") city : String, @Query("lang") lang : String, @Query("units") units : String) : Response
}