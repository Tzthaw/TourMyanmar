package com.ptut.android.shared.model


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ptut.android.shared.data.Error

open class BaseViewModel: ViewModel() {
    private lateinit var mErrorLD: MutableLiveData<Error>

    val errorLD: MutableLiveData<Error>
        get() = mErrorLD

    open fun initViewModel() {
        mErrorLD = MutableLiveData()
    }
}