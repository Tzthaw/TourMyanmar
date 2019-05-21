package com.ptut.android.shared.ui

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


abstract class BaseAdapter<VH: BaseViewHolder<T>, T: Any> (
        diffCallback: DiffUtil.ItemCallback<T>) : ListAdapter<T, VH>(diffCallback){
    override fun onBindViewHolder(holder: VH, position: Int) {
        if (holder.adapterPosition != RecyclerView.NO_POSITION){
            holder.bindData(getItem(holder.adapterPosition)!!)
        }
    }

}
