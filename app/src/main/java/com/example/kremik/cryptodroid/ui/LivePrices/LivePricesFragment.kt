package com.example.kremik.cryptodroid.ui.LivePrices

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kremik.cryptodroid.CryptoDroidApp
import com.example.kremik.cryptodroid.R
import kotlinx.android.synthetic.main.fragment_live_prices.view.*
import javax.inject.Inject

class LivePricesFragment : Fragment(), LivePricesView {

    @Inject lateinit var presenter: LivePricesPresenter

    override lateinit var recyclerView: RecyclerView

    override fun getViewContext(): Context {
        return context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (activity.application as CryptoDroidApp).component.inject(this)
        super.onCreate(savedInstanceState)
        presenter.bind(this as LivePricesView)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.fragment_live_prices, container, false)
        recyclerView = view.livePricesRecV
        presenter.setRecyclerView()
        return view
    }

    override fun onDestroy() {
        presenter.unbind()
        super.onDestroy()
    }
}

