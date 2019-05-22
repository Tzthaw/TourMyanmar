package com.ptut.android.tourmyanmar.ui.notification

import androidx.recyclerview.widget.DiffUtil
import com.ptut.android.tourmyanmar.R
import com.ptut.android.tourmyanmar.model.PopularTrip
import com.ptut.android.tourmyanmar.ui.base.DataBindingAdapter

class NotificationAdapter : DataBindingAdapter<PopularTrip>(DiffCallback()) {

    class DiffCallback : DiffUtil.ItemCallback<PopularTrip>() {

        override fun areItemsTheSame(oldItem: PopularTrip, newItem: PopularTrip) = when {
             oldItem.id==newItem.id ->true
            else -> oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: PopularTrip, newItem: PopularTrip): Boolean {
            return oldItem == newItem
        }
    }

    override fun getItemViewType(position: Int) = R.layout.item_notification
}