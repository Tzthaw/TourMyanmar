package com.ptut.android.tourmyanmar.ui.notification


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ptut.android.tourmyanmar.R
import com.ptut.android.tourmyanmar.model.PopularTrip
import com.ptut.android.tourmyanmar.ui.home.PopularTripAdapter
import kotlinx.android.synthetic.main.fragment_notification.view.*


class NotificationFragment : DialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_notification, container, false)
        val popularList = ArrayList<PopularTrip>()
        popularList.add(
            PopularTrip(1,
                "https://thelocalist.com/wp-content/uploads/2014/02/thelocalist.com_ShwedagonPagoda-.jpg",
                "ငပလီကို လေယာဉ် ကား နဲ့သွားလို့အဆင်ပြေ ပါတယ်။လေယာဉ်လက်မှတ်ခကရန်ကုန်-")
        )
        popularList.add(
            PopularTrip(2,
                "https://upload.wikimedia.org/wikipedia/commons/0/09/Mandalay_Fort_Wall.jpg",
                "ငပလီကို လေယာဉ် ကား နဲ့သွားလို့အဆင်ပြေ ပါတယ်။လေယာဉ်လက်မှတ်ခကရန်ကုန်-")
        )
        popularList.add(
            PopularTrip(4,
                "",
                "ငပလီကို လေယာဉ် ကား နဲ့သွားလို့အဆင်ပြေ ပါတယ်။လေယာဉ်လက်မှတ်ခကရန်ကုန်-")
        )

        view.notificationRecycler.layoutManager=LinearLayoutManager(context)
        view.notificationRecycler.hasFixedSize()
        val adapter=NotificationAdapter()
        adapter.submitList(popularList)
        view.notificationRecycler.adapter=adapter


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.notificationToolbar.setNavigationOnClickListener {
            dismiss()
        }
        view.notificationToolbar.inflateMenu(R.menu.main)
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