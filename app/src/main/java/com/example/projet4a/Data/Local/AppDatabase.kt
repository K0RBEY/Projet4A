package com.example.projet4a.Data.Local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.projet4a.Data.Local.Models.UserLocal

@Database(entities = arrayOf(
        UserLocal::class
), version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDAO() : DatabaseDAO
}