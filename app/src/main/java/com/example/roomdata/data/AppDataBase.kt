package com.example.roomdata.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [EtData::class, LoginData::class], version = 1)
 abstract class AppDataBase:RoomDatabase() {
    abstract fun getDao():EtDao
}