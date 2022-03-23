package com.example.mvvmretrofit.flows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class KoltinFlowBasics : ViewModel() {

    val countDownFlow = flow<Int> {
        val statingValue = 10
        var currentValue = statingValue
        emit(statingValue)
        while(currentValue > 0){
            delay(1000L)
            currentValue--
            emit(currentValue)
        }
    }

    private fun collectFlow(){
        viewModelScope.launch {
            countDownFlow.filter { time ->
                time % 2 == 0

            }.map {
                time -> time * time
            }
                .collect { time ->
                println("time is $time")
            }
        }
    }
 }


//StateFlow and SharedFlows

