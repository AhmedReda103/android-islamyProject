package com.example.islamy_project_kt.ui.suraDetails

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBindings
import com.example.islamy_project_kt.R

class VersesAdapter :RecyclerView.Adapter<VersesAdapter.ViewHolder>(){

   var items :List<String>?=null
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        val content :TextView = itemView.findViewById(R.id.content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_verse,parent,false);
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     val content =items?.get(position)
        holder.content.setText(content)
    }

    fun changeData(verses:List<String>)
    {
        this.items=verses
        notifyDataSetChanged() //reload
    }

    override fun getItemCount(): Int = items?.size?:0
}