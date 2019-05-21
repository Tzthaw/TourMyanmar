package com.ptut.android.tourmyanmar.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.ptut.android.shared.ui.BaseFragment
import com.ptut.android.tourmyanmar.R
import com.ptut.android.tourmyanmar.model.PopularTrip
import com.ptut.android.tourmyanmar.ui.home.PopularTripAdapter
import com.ptut.android.tourmyanmar.utils.inflate
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment:BaseFragment() {
    private lateinit var trendingTripAdapter:PopularTripAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.fragment_search)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpTrendingTrip()
    }

    private fun setUpTrendingTrip(){
        val popularList = ArrayList<PopularTrip>()
        popularList.add(
            PopularTrip(1,
                "https://thelocalist.com/wp-content/uploads/2014/02/thelocalist.com_ShwedagonPagoda-.jpg",
                "Yangon")
        )
        popularList.add(
            PopularTrip(2,
                "https://upload.wikimedia.org/wikipedia/commons/0/09/Mandalay_Fort_Wall.jpg",
                "Mandalay")
        )
//        popularList.add(PopularTrip(3, "", "Naypyitaw"))
//        popularList.add(PopularTrip(4, "", "Mawlamyine"))

        trendingTripAdapter= PopularTripAdapter()
        val layoutManager=GridLayoutManager(context!!,2)
        trendingTripRecycler.layoutManager=layoutManager
        trendingTripRecycler.hasFixedSize()
        trendingTripRecycler.adapter=trendingTripAdapter
        trendingTripAdapter.submitList(popularList)
    }
}