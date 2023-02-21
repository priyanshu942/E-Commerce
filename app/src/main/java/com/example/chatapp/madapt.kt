package com.example.chatapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class madapt(val context1: Context,val array: ArrayList<Int>,val array1: ArrayList<String>) :RecyclerView.Adapter<madapt.card>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): card {
        val view:View=LayoutInflater.from(context1).inflate(R.layout.card,parent,false)
        return card(view)
    }

    override fun onBindViewHolder(holder: card, position: Int) {
        holder.pimg.setImageResource(array[position])
        holder.desc.setText(array1[position])
    }

    override fun getItemCount(): Int {
        return array.size
    }

    class card(itemView: View) :RecyclerView.ViewHolder(itemView)
    {
         val pimg =itemView.findViewById<ImageView>(R.id.phone_image)
        val desc=itemView.findViewById<TextView>(R.id.phone_title)
    }
}