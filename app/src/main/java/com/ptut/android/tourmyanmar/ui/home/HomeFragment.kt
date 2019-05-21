package com.ptut.android.tourmyanmar.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ptut.android.tourmyanmar.R
import com.ptut.android.tourmyanmar.model.PopularTrip
import com.ptut.android.tourmyanmar.ui.home.PopularTripAdapter
import com.ptut.android.tourmyanmar.utils.inflate
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    private lateinit var popularTripAdapter: PopularTripAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.fragment_home)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPopularTrip()
    }

    private fun setUpPopularTrip() {
        val popularList = ArrayList<PopularTrip>()
        popularList.add(PopularTrip(1,
            "https://thelocalist.com/wp-content/uploads/2014/02/thelocalist.com_ShwedagonPagoda-.jpg",
            "Yangon"))
        popularList.add(PopularTrip(2,
            "https://upload.wikimedia.org/wikipedia/commons/0/09/Mandalay_Fort_Wall.jpg",
            "Mandalay"))
//        popularList.add(PopularTrip(3, "", "Naypyitaw"))
//        popularList.add(PopularTrip(4, "", "Mawlamyine"))
        popularList.add(PopularTrip(4,
            "https://upload.wikimedia.org/wikipedia/commons/0/0d/Pyin_Oo_Lwin%2C_Myanmar_%28Burma%29_-_panoramio.jpg",
            "PyinOoLwin"))

        popularTripAdapter = PopularTripAdapter()
        popularTripRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        popularTripRecycler.hasFixedSize()
        popularTripRecycler.isNestedScrollingEnabled = true

        popularTripRecycler.adapter = PopularTripAdapter()
//        viewModel.books().observe(this, Observer {
//            it?.let(adapter::submitList)
//        })
        popularTripAdapter.submitList(popularList)
        popularTripRecycler.adapter = popularTripAdapter

        ar_indicator.attachTo(popularTripRecycler, true)

        val layoutManager= GridLayoutManager(context!!,2)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position % 3 == 2) 2 else 1
            }
        }
        mostLookingRecycler.layoutManager=layoutManager
        mostLookingRecycler.hasFixedSize()
        mostLookingRecycler.adapter=popularTripAdapter
    }


}