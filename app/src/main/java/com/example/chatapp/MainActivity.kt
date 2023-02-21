package com.example.chatapp

import  android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    //adapter
    lateinit var  adapter:Adapt
    lateinit var adapter1:madapt
    val arr: ArrayList<Int> = arrayListOf(R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,R.drawable.pic6,R.drawable.pic7,R.drawable.cir)
    val arr1:ArrayList<String> = arrayListOf("Men","Women","Kids","New","Old","Trendy","Oversize","Deals")
    val arrc:ArrayList<Int> =arrayListOf(R.drawable.cool,R.drawable.pho,R.drawable.pho1,R.drawable.sam)
    val arrc1:ArrayList<String> = arrayListOf("Coolpad","Iphone12","Iphone14","Samsung")
    private lateinit var  arrs:ArrayList<String>


    //drawer
 lateinit var toggle :ActionBarDrawerToggle
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

        setupview()
        //search
        arrs= arrayListOf<String>()
        arrs.addAll(arr1)


    }

    fun setupview()
    {
        setupdrawer()
    }
    fun setupdrawer()
    {
            setSupportActionBar(topAppBar)
           toggle= ActionBarDrawerToggle(this,drawer,R.string.app_name,R.string.app_name)
            toggle.syncState()


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuinflator = menuInflater
        menuinflator.inflate(R.menu.search, menu)
        val searchItem = menu?.findItem(R.id.search) // apna jo item hai usko dhunda
        val searchView = searchItem?.actionView as SearchView // abb vo item kaisa display hona chiye search view jaisa
        val manager=getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView.setSearchableInfo(manager.getSearchableInfo(componentName))
        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{   // abb jab mai usma text dalunga tho kaisa honga
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                searchView.setQuery("",false)
                searchItem.collapseActionView()
                Toast.makeText(this@MainActivity,"done",Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
//               arrs.clear()
//                val searchtext= newText!!.toLowerCase(Locale.getDefault())//covert all text to lowecase
//                if(searchtext.isNotEmpty())
//                {
//                    arrs.forEach{
//                        if(it.toLowerCase(Locale.getDefault()).contains(searchtext))
//                        {
//                            arrs.add(it)
//                        }
//                        else{
//                            arrs.clear()
//                            arrs.addAll(arrs)
//                        }
//                    }
//
//                }
            return false
            }

        })



        return super.onCreateOptionsMenu(menu)


    }

}






