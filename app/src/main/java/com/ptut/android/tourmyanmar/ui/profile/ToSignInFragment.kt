package com.ptut.android.tourmyanmar.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ptut.android.shared.ui.BaseFragment
import com.ptut.android.tourmyanmar.R
import com.ptut.android.tourmyanmar.utils.FragmentChangeListener
import com.ptut.android.tourmyanmar.utils.SIGN_IN
import com.ptut.android.tourmyanmar.utils.inflate
import kotlinx.android.synthetic.main.fragment_show_tosignin.*

class ToSignInFragment:BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.fragment_show_tosignin)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toLoginButton.setOnClickListener {
            val fc = activity as FragmentChangeListener?
            fc!!.replaceFragment(SIGN_IN)
        }
    }
}