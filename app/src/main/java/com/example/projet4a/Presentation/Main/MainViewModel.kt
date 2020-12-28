package com.example.projet4a.Presentation.Main

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projet4a.Domain.UseCase.CreateUserUseCase
import com.example.projet4a.Domain.UseCase.GetUserUseCase
import kotlinx.coroutines.*
import okhttp3.Dispatcher

class MainViewModel(
        private val getUserUseCase: GetUserUseCase
) : ViewModel(){

    val loginLiveData : MutableLiveData<LoginStatus> = MutableLiveData()

    fun onClickedLogin(emailUser : String, passwdUser : String){
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(emailUser)
            val loginStatus = if(user != null && user.password == passwdUser){
                LoginSuccess
            } else {
                LoginError
            }
            withContext(Dispatchers.Main) {
                loginLiveData.value = loginStatus
            }
        }
    }
}