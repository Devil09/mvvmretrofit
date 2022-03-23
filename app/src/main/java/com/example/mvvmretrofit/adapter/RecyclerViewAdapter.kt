package com.example.mvvmretrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmretrofit.R
import com.example.mvvmretrofit.data.CountriesModelItem
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var countryList : List<CountriesModelItem>? = null

    fun setCountryList(countryList : List<CountriesModelItem>?){
        this.countryList = countryList
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerViewAdapter.MyViewHolder {
       val view = LayoutInflater.from(p0.context).inflate(R.layout.recyclerview_item , p0 , false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(p0: RecyclerViewAdapter.MyViewHolder, p1: Int) {
        p0.bind(countryList!!.get(p1))
    }

    override fun getItemCount(): Int {
        if (countryList == null) return  0
        else return countryList?.size!!
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.nameOfTheCountry

        fun bind(data : CountriesModelItem){
            name.text = data.name
        }

    }
}