package com.example.roomdata.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.roomdata.R
import com.example.roomdata.data.LoginData
import kotlinx.android.synthetic.main.activity_login_pass.*

class LoginPass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_pass)
        setupListeners()
        setupUser()
    }

    private fun setupListeners() {
        btnEnter.setOnClickListener {
            if (isEdNotEmpty()) {
               MyApp.app?.getDataBase()?.getDao()?.addUser(
                   LoginData(
                       login = etLogin.text.toString(),
                       password = etPass.text.toString())
               )
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                Toast.makeText(this, "Введите верные данные", Toast.LENGTH_LONG).show()
            }

        }
    }

    private fun setupUser(){
        val result=MyApp.app?.getDataBase()?.getDao()?.getAllUsers()
        if (result !=null && result.isNotEmpty()){
            val result1=result.first()
            etLogin.setText(result1?.login)
            etPass.setText(result1?.password)
        } else {
            Toast.makeText(this, "Введите верные данные", Toast.LENGTH_LONG).show()
        }
    }

    private fun isEdNotEmpty():Boolean{
        val resultLogin=etLogin.text.toString().length > 4
        val resultPass=etPass.text.toString().length > 6

        return resultLogin && resultPass
    }
}