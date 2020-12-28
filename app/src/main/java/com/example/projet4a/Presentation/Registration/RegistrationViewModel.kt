package com.example.projet4a.Presentation.Registration

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projet4a.Domain.Entity.User
import com.example.projet4a.Domain.UseCase.CreateUserUseCase
import com.example.projet4a.Domain.UseCase.GetUserUseCase
import com.example.projet4a.Presentation.Main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegistrationViewModel(
        private val createUserUseCase: CreateUserUseCase,
        private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    val registrationLiveData : MutableLiveData<RegistrationStatus> = MutableLiveData()

    fun onClickedVerifyRegistration(emailUser : String, passwd : String, passwd_val : String) {
        viewModelScope.launch(Dispatchers.IO) {
            val already_exist = getUserUseCase.invoke(emailUser)
            val registrationStatus = if(emailUser == "" || passwd == "" || passwd_val == ""){
                RegistrationNoInfoError
            }else if(already_exist != null){
                RegistrationAlreadyExistError
            }else if(passwd != "" && passwd_val != "" && passwd != passwd_val){
                RegistrationPasswordMatchingError
            }else if(emailUser != "" && android.util.Patterns.EMAIL_ADDRESS.matcher(emailUser).matches() && passwd != "" && passwd_val != "" && passwd == passwd_val) {
                RegistrationSuccess
            }else{
                RegistrationError
            }
            withContext(Dispatchers.Main){
                registrationLiveData.value = registrationStatus
            }
        }
    }

    fun register(emailUser : String, passwd : String) {
        viewModelScope.launch(Dispatchers.IO) {
            createUserUseCase.invoke(User(emailUser, passwd))
        }
    }
}