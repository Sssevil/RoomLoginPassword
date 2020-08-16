package com.example.roomdata.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
 data class LoginData (
    @PrimaryKey(autoGenerate = true)
     var id:Int=1,
     var login:String,
     var password:String
 )
