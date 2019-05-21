package com.ptut.android.tourmyanmar.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors

val threadCt = Runtime.getRuntime().availableProcessors() + 1
val executor = Executors.newFixedThreadPool(threadCt)!!
val scheduler = Schedulers.from(executor)

fun <T> lazyAndroid(initializer: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE, initializer)

fun ViewGroup.inflate(layoutId: Int): View = LayoutInflater.from(this.context).inflate(layoutId, this, false)

fun ImageView.loadImage(url: String) = Glide.with(this).load(url).into(this)

fun ImageView.loadImageRound(url: String) =
    Glide.with(this).load(url).apply(RequestOptions.circleCropTransform()).into(this)

