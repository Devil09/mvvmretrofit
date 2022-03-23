package com.example.mvvmretrofit.flows

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ParallelNetworkCallsViewModel() : ViewModel() {

    private val list = listOf(1..100)
    private val list2 = listOf(101..200)
    private lateinit var finalListLiveData: MutableLiveData<List<IntRange>>


    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            list
                .zip(list2) { list1Elements, list2Elements ->
                    val finalListOutput = mutableListOf<IntRange>()

                    finalListOutput.add(list1Elements)
                    finalListOutput.add(list2Elements)


                    return@zip finalListOutput


                }
                .asFlow()
                .catch { e ->
                    println("Error")
                }
                .collect {
                    finalListLiveData.postValue(it)
                }
        }
    }

    fun getfinalListLiveData(): LiveData<List<IntRange>> {
        return finalListLiveData
    }

}