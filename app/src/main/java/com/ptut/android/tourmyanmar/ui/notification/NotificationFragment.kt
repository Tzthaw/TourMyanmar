package com.ptut.android.tourmyanmar.ui.notification


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.ptut.android.tourmyanmar.R
import kotlinx.android.synthetic.main.fragment_notification.view.*

class NotificationFragment : DialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_notification, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.notificationToolbar.setNavigationOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        val dialog= dialog
        if(dialog!=null){
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog.window.setLayout(width, height)
            dialog.window.setWindowAnimations(R.style.AppTheme_Slide)
        }
    }


    companion object {

        val TAG = "example_dialog"

        fun display(fragmentManager: FragmentManager): NotificationFragment {
            val exampleDialog = NotificationFragment()
            exampleDialog.show(fragmentManager, TAG)
            return exampleDialog
        }
    }
}