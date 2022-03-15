package com.example.mvvmretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmretrofit.adapter.RecyclerViewAdapter
import com.example.mvvmretrofit.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var recyclerViewAdapter : RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview()
        initializeViewModel()
    }


    fun recyclerview() {
        recyclerViewCountries.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = RecyclerViewAdapter()
        recyclerViewCountries.adapter = recyclerViewAdapter
    }

    private fun initializeViewModel(){
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this , {
            if (it != null){
                recyclerViewAdapter.setCountryList(it)
                recyclerViewAdapter.notifyDataSetChanged()
            }
            else{
                System.out.println("No Data")
            }
        })

        viewModel.makeAPICall()
    }


}