package com.example.projet4a.Domain.UseCase

import com.example.projet4a.Data.Repository.UserRepository
import com.example.projet4a.Domain.Entity.User

class CreateUserUseCase(
        private val userRepository : UserRepository
) {
    suspend fun invoke(user : User) {
        userRepository.createUser(user)
    }
}