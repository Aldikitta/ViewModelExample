package com.aldikitta.viewmodelexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int) : ViewModel() {
    private var count = 0
//    private var total = 0
    var total = MutableLiveData<Int>()

    init {
        total.value = startingTotal
    }

    fun getCurrentCount(): Int {
        return count

    }


    fun getUpdatedCount(): Int {
        return ++count
    }



    fun setTotal(input: Int) {
        total.value = (total.value)?.plus(input)
    }


}