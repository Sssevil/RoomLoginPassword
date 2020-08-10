package com.example.roomdata.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdata.R
import com.example.roomdata.data.EtData

class Adapter(private val listener:Help):RecyclerView.Adapter<ViewHolder>() {

    private var data= arrayListOf<EtData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount()=data.size

    fun update (data : List<EtData>){
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position],listener)
    }

}
