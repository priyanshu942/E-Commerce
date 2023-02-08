package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var  adapter:Adapt
    lateinit var adapter1:madapt
    val arr= arrayOf(R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,R.drawable.pic6,R.drawable.pic7,R.drawable.cir)
    val arr1= arrayOf("Men","Women","Kids","New","Old","Trendy","Oversize","Deals")
    val arrc=arrayOf(R.drawable.cool,R.drawable.pho,R.drawable.pho1,R.drawable.sam)
    val arrc1= arrayOf("Coolpad","Iphone12","Iphone14","Samsung")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        //First Recycle View
        adapter=Adapt(this@MainActivity,arr,arr1)
        RecView.adapter=adapter
        RecView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        //Second Recycle View
        adapter1=madapt(this@MainActivity,arrc,arrc1)
        recycler.adapter=adapter1
        recycler.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        //bottom nav
        navi.setOnItemSelectedListener {

            when(it.itemId) {
                R.id.home -> {
                    return@setOnItemSelectedListener true
                }
                R.id.heart -> {
                    val intent = Intent(this@MainActivity, LogIn::class.java)
                    startActivity(intent)
                }
                R.id.profile -> {
                    val intent = Intent(this@MainActivity, LogIn::class.java)
                    startActivity(intent)
                }

            }
            return@setOnItemSelectedListener true

        }

    }



}




