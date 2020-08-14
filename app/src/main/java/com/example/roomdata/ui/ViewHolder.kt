package com.example.roomdata.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdata.data.EtData
import kotlinx.android.synthetic.main.item_view.view.*

class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
    fun bind(etData:EtData,listener:Help){
        itemView.txt.text=etData.etOne
        itemView.txt0.text=etData.etTwo

        itemView.btnDelete.setOnClickListener {
            listener.itemClick(etData)
        }
    }
}