package com.example.mvvmretrofit.flows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class KoltinFlowAdvance : ViewModel() {
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

    private fun collectFlowCount(){
        //Terminal Flow operators
        viewModelScope.launch {
            val count = countDownFlow.filter { time ->
                time % 2 == 0

            }.map {
                    time -> time * time
            }.onEach {
                println(it)
            }.count {
                it % 2 ==0
            }
        }
    }

    private fun collectFlowReduce(){
        //Terminal Flow operators
        viewModelScope.launch {
            // if you want to find sum of n numbers just an example we can use reduce
            val count = countDownFlow.reduce { acc , value -> acc+value }
        }
    }


    private fun collectFlowFold(){
        //Terminal Flow operators
        viewModelScope.launch {
            // if you want to find sum of n numbers just an example we can use fold with an starting value
            val count = countDownFlow.fold(100) { acc , value -> acc+value }
        }
    }


    private fun collectFlowFlatten(){
        //Terminal Flow operators
        val flow1 = flow {
            emit(1)
            delay(500)
            emit(2)
        }

        val flow2 = flow {
            emit(1)
            delay(500)
            emit(2)
        }

        viewModelScope.launch {
            // if you want to find sum of n numbers just an example we can use fold with an starting value
            val finalflow  = flow1.flatMapConcat { flow {
                emit(it + 1 )
            } }
        }
    }
}