package com.example.projet4a.Injection

import android.content.Context
import androidx.room.Room
import com.example.projet4a.Data.Local.AppDatabase
import com.example.projet4a.Data.Local.DatabaseDAO
import com.example.projet4a.Data.Remote.AuthInterceptor
import com.example.projet4a.Data.Remote.WeatherApiService
import com.example.projet4a.Data.Repository.WeatherRepository
import com.example.projet4a.Data.Repository.UserRepository
import com.example.projet4a.Domain.UseCase.CreateUserUseCase
import com.example.projet4a.Domain.UseCase.GetResponseUseCase
import com.example.projet4a.Domain.UseCase.GetUserUseCase
import com.example.projet4a.Presentation.HomePage.HomePageViewModel
import com.example.projet4a.Presentation.Main.MainViewModel
import com.example.projet4a.Presentation.Registration.RegistrationViewModel
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val presentationModule = module(){
    factory { MainViewModel(get()) }
    factory { RegistrationViewModel(get(),get()) }
    factory { HomePageViewModel(get()) }
}

val domainModule = module(){
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
    factory { GetResponseUseCase(get()) }
}

val dataModule = module(){
    single { UserRepository(get()) }
    single { createDatabase(androidContext())}
    factory { WeatherRepository(get()) }
    factory { AuthInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideFootballApi(get()) }
    single { provideRetrofit(get()) }
}

fun createDatabase(context : Context) : DatabaseDAO {
    val appDatabase = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-name"
    )
            .fallbackToDestructiveMigration()
            .build()
    return appDatabase.databaseDAO()
}

fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
    return Retrofit.Builder().baseUrl("http://api.openweathermap.org/data/2.5/").client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(authInterceptor: AuthInterceptor) : OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(authInterceptor).build()
}

fun provideFootballApi(retrofit: Retrofit) : WeatherApiService = retrofit.create(WeatherApiService::class.java)