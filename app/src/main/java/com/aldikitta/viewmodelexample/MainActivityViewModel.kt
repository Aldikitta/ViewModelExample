package com.aldikitta.viewmodelexample

import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int) : ViewModel() {
    private var count = 0
    private var total = 0

    init {
        total = startingTotal
    }
    fun getCurrentCount(): Int{
        return count

    }



    fun getUpdatedCount(): Int{
        return ++count
    }

    fun getTotal():Int{
        return total
    }

    fun setTotal(input:Int){
        total += input
    }


}