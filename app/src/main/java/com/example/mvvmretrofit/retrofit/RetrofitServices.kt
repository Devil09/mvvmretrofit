package com.example.mvvmretrofit.retrofit

import com.example.mvvmretrofit.data.CountriesModelItem
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {

    @GET("all")
    fun getCountriesList() : Call<List<CountriesModelItem>>

}