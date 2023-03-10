package com.example.chatapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class Adapt(val context: Context,val users:ArrayList<Int>,val usert:ArrayList<String>):RecyclerView.Adapter <Adapt.userView>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userView {
        val view:View=LayoutInflater.from(context).inflate(R.layout.users,parent,false)
        return userView(view)
    }

    override fun onBindViewHolder(holder: userView, position: Int) {
        val pimg=users[position]
        val text=usert[position]
        holder.img.setImageResource(pimg)
        holder.txt.setText(text)

    }

    override fun getItemCount(): Int {
        return users.size
    }

    class userView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img=itemView.findViewById<ImageView>(R.id.imj)
        val txt=itemView.findViewById<TextView>(R.id.txt)

    }

}