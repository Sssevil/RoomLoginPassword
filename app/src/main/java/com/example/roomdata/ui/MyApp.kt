package com.example.roomdata.ui

import android.app.Application
import androidx.room.Room
import com.example.roomdata.data.AppDataBase

class MyApp:Application() {
    private var dataB:AppDataBase?=null

    override fun onCreate() {
        super.onCreate()
        app=this
        dataB=Room.databaseBuilder(this, AppDataBase::class.java, "MY_DATA")
            .allowMainThreadQueries()
            .build()
    }

    fun getDataBase()=dataB



    companion object{
        var app:MyApp?=null
    }




}