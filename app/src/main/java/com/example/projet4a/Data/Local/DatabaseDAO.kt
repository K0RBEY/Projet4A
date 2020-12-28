package com.example.projet4a.Data.Local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.projet4a.Data.Local.Models.UserLocal

@Dao
interface DatabaseDAO {
    @Query("SELECT * FROM UserLocal")
    fun getAll() : List<UserLocal>

    @Query("SELECT * FROM UserLocal WHERE email LIKE :email LIMIT 1")
    fun findByName(email : String) : UserLocal?

    @Insert
    fun insert(user : UserLocal)

    @Delete
    fun delete(user : UserLocal)
}