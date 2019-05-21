package com.ptut.android.shared.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.ptut.android.shared.data.Error


@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity(), Observer<Error> {
    override fun onChanged(error: Error?) {

    }
}