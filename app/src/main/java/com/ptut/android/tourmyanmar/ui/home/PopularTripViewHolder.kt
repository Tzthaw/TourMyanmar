package com.ptut.android.home.ui

import android.view.View
import com.ptut.android.shared.ui.BaseViewHolder
import com.ptut.android.tourmyanmar.model.PopularTrip
import com.ptut.android.tourmyanmar.utils.loadImage
import kotlinx.android.synthetic.main.item_popular_trip.view.*


class PopularTripViewHolder(itemView: View): BaseViewHolder<PopularTrip>(itemView) {

    override fun bindData(item: PopularTrip) {
        super.bindData(item)
        itemView.popularTripName.text=item.popularTripName
//        itemView.popularImage.loadImage(item.popularImage)
    }
    override fun onClick(v: View?) {

    }
}