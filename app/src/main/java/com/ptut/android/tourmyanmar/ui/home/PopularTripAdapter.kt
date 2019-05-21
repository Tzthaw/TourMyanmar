package com.ptut.android.tourmyanmar.ui.home


import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.ptut.android.home.ui.PopularTripViewHolder
import com.ptut.android.tourmyanmar.utils.inflate
import com.ptut.android.shared.ui.BaseAdapter
import com.ptut.android.tourmyanmar.R
import com.ptut.android.tourmyanmar.model.PopularTrip


var diffUtilCallBack=object: DiffUtil.ItemCallback<PopularTrip>(){
    override fun areItemsTheSame(oldItems: PopularTrip, newItems: PopularTrip): Boolean {
        return oldItems.id==newItems.id
    }

    override fun areContentsTheSame(oldItems: PopularTrip, newItems: PopularTrip): Boolean {
        return oldItems==newItems
    }
}

class PopularTripAdapter : BaseAdapter<PopularTripViewHolder, PopularTrip>(diffUtilCallBack) {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PopularTripViewHolder {
        return PopularTripViewHolder(viewGroup.inflate(R.layout.item_popular_trip))
    }

}