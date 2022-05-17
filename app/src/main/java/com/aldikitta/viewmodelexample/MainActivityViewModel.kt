package com.aldikitta.viewmodelexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int, startingCount: Int) : ViewModel() {
    private var count = MutableLiveData<Int>()
    val countData: LiveData<Int>
        get() = count

    private var total = MutableLiveData<Int>()
    val totalData: LiveData<Int>
        get() = total

    init {
        total.value = startingTotal
        count.value = startingCount
    }

    fun getUpdatedCount() {
        count.value = (count.value)?.plus(1)
    }

    fun setTotal(input: Int) {
        total.value = (total.value)?.plus(input)
    }
}