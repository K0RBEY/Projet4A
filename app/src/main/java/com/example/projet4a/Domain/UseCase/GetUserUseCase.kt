package com.example.projet4a.Domain.UseCase

import com.example.projet4a.Data.Repository.UserRepository
import com.example.projet4a.Domain.Entity.User

class GetUserUseCase(
        private val userRepository : UserRepository
) {
    suspend fun invoke(email : String) : User? {
        return userRepository.getUser(email)
    }
}