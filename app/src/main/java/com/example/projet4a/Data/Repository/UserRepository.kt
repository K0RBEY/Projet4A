package com.example.projet4a.Data.Repository

import com.example.projet4a.Data.Local.DatabaseDAO
import com.example.projet4a.Data.Local.Models.toData
import com.example.projet4a.Data.Local.Models.toEntity
import com.example.projet4a.Domain.Entity.User

class UserRepository(
        private val databaseDao : DatabaseDAO
) {
    suspend fun createUser(user : User){
        databaseDao.insert(user.toData())
    }

    fun getUser(email : String) : User? {
        val userLocal = databaseDao.findByName(email)
        return userLocal?.toEntity()
    }
}