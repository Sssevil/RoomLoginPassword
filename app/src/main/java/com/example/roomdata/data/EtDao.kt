package com.example.roomdata.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao

interface EtDao {

    @Insert
    fun saveEtData(data:EtData)
    @Query("select * from EtData")
    fun getAllData():List<EtData>
    @Delete
    fun delete(data:EtData)
}