package com.example.islamy_project_kt.ui.home.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamy_project_kt.R

class HadethNamesAdapter(var items :MutableList<String>) :RecyclerView.Adapter<HadethNamesAdapter.ViewHolder>() {

    var onItemClick :onItemClickListener?=null
    interface onItemClickListener{
        fun onItemClick(pos :Int , nameHadeth:String)
    }

    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)
    {
        val name :TextView = itemView.findViewById(R.id.hadethName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     val view = LayoutInflater.from(parent.context).inflate(R.layout.hadeth_item ,parent , false )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var text = items.get(position)
        holder.name.setText(text)

        if(onItemClick!=null)
        {
            holder.itemView.setOnClickListener{
                onItemClick?.onItemClick(position , text)
            }
        }
    }

    override fun getItemCount(): Int =items.size
}