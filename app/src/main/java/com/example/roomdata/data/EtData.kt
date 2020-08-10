package com.example.roomdata.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EtData (
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var etOne:String,
    var etTwo:String
)
