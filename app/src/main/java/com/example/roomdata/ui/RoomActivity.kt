package com.example.roomdata.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomdata.R
import com.example.roomdata.data.AppDataBase
import com.example.roomdata.data.EtData
import kotlinx.android.synthetic.main.activity_room.*

class RoomActivity : AppCompatActivity() {

    private var db:AppDataBase?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        db=MyApp.app?.getDataBase()
        setupListeners()
    }

    private fun setupListeners(){
        btnSave.setOnClickListener {
            db?.getDao()?.saveEtData(fetchData())
            val intent=Intent()
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }

    private fun fetchData():EtData{
        return EtData(
            etOne = txt1.text.toString(),
            etTwo = txt2.text.toString()
        )
    }

}