package com.example.roomdata.data

import androidx.room.*

@Dao

interface EtDao {

    @Insert
    fun saveEtData(data:EtData)
    @Query("select * from EtData")
    fun getAllData():List<EtData>
    @Delete
    fun delete(data:EtData)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user:LoginData)
    @Query("Select * from LoginData where login=:loginTxt and password=:passTxt")
    fun getUser(loginTxt:String,passTxt:String):LoginData
    @Query("select * from LoginData")
    fun getAllUsers():List<LoginData>
}