package com.example.islamy_project_kt.ui.hadethDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamy_project_kt.R

class VersesHadethAdapter : RecyclerView.Adapter<VersesHadethAdapter.ViewHolder>() {

     var items :List<String>?=null
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val verse:TextView = itemView.findViewById(R.id.hadethItemVerse)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemhadethverse,parent,false)
        return ViewHolder(view)
     }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = items?.get(position)
        holder?.verse.setText(data)

    }

    override fun getItemCount(): Int =items?.size?:0

    fun changeData(verses: List<String>) {
        this.items=verses
        notifyDataSetChanged()
    }
}