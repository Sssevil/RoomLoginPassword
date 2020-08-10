package com.example.roomdata.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.roomdata.R
import com.example.roomdata.data.AppDataBase
import com.example.roomdata.data.EtData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),Help {
    private var db: AppDataBase?=null
    private var adapter:Adapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db=MyApp.app?.getDataBase()
        setupAdapter()
    }

    private fun setupAdapter() {
        adapter=Adapter(this)
        recycler.adapter=adapter
        val data=db?.getDao()?.getAllData()
        if (data!=null)
            adapter?.update(data)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent=Intent(applicationContext, RoomActivity::class.java)
        when(item.itemId){
            R.id.dobav-> startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun itemClick(data: EtData) {
        val newData=db?.getDao()?.getAllData()
        if(newData!=null)
            adapter?.update(newData)

    }
}