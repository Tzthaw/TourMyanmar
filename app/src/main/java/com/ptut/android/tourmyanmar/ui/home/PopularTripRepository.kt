package com.ptut.android.home.ui

import android.content.Context
import com.ptut.android.tourmyanmar.data.BaseRepository

class PopularTripRepository private constructor(context: Context): BaseRepository(){
    companion object {
        var INSTANCE: PopularTripRepository?=null
        fun getInstance(): PopularTripRepository {
            if(INSTANCE ==null){
                throw RuntimeException("FilterModel is being invoked before initializing")
            }
            val i= INSTANCE
            return i!!
        }
        fun inintModel(context: Context){
            INSTANCE =
                PopularTripRepository(context)
        }
    }

}