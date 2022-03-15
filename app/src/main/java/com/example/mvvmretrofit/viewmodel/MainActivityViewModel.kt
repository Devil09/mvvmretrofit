package com.example.mvvmretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmretrofit.data.CountriesModelItem
import com.example.mvvmretrofit.retrofit.RetrofitInstance
import com.example.mvvmretrofit.retrofit.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {

    lateinit var liveDataList: MutableLiveData<List<CountriesModelItem>>

    init {
        liveDataList = MutableLiveData()
    }


    fun getLiveDataObserver(): MutableLiveData<List<CountriesModelItem>> {
        return liveDataList;
    }

    fun makeAPICall() {
        val retrofitInstance = RetrofitInstance.getRetroInstance()
        val retroService = retrofitInstance.create(RetrofitServices::class.java)
        val call = retroService.getCountriesList();
        call.enqueue(object : Callback<List<CountriesModelItem>>{
            override fun onResponse(p0: Call<List<CountriesModelItem>>, p1: Response<List<CountriesModelItem>>) {
                liveDataList.postValue(p1.body())
                System.out.println(p1.body()?.get(0)?.name)
            }

            override fun onFailure(p0: Call<List<CountriesModelItem>>, p1: Throwable) {
                liveDataList.postValue(null)
            }

        })
    }
}