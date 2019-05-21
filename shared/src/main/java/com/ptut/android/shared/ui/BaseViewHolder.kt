package com.ptut.android.shared.ui


import android.view.View
import androidx.annotation.CallSuper
import androidx.recyclerview.widget.RecyclerView

@Suppress("LeakingThis")
abstract class BaseViewHolder<T : Any>(itemView: View) :
        RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
    private lateinit var current: T

    @CallSuper
    open fun bindData(item: T) {
        current = item
    }

    init {
        itemView.setOnClickListener(this)
    }
}