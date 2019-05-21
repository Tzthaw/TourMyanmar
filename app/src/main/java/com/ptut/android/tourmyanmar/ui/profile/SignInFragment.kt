package com.ptut.android.tourmyanmar.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ptut.android.shared.ui.BaseFragment
import com.ptut.android.tourmyanmar.R
import com.ptut.android.tourmyanmar.utils.inflate

class SignInFragment:BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.fragment_signin)
    }
}