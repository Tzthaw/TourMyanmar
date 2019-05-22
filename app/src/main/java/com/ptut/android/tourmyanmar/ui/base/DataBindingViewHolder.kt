package com.ptut.android.tourmyanmar.ui.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class DataBindingViewHolder<T>(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: T) {
        binding.setVariable(com.ptut.android.tourmyanmar.BR.notification, item)
        binding.executePendingBindings()
    }
}