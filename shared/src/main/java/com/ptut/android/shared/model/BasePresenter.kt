package com.ptut.android.shared.model


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ptut.android.shared.data.Error

abstract class BasePresenter<T : BaseView> : ViewModel() {

    protected lateinit var mView: T
    private lateinit var mErrorLD: MutableLiveData<Error>

    val errorLD: MutableLiveData<Error>
        get() = mErrorLD

    open fun initPresenter(mView: T) {
        this.mView = mView
        mErrorLD = MutableLiveData()
    }
}