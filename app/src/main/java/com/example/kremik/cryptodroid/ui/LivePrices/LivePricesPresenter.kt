package com.example.kremik.cryptodroid.ui.LivePrices

import android.support.v7.widget.LinearLayoutManager
import com.example.kremik.cryptodroid.data.local.CurrenciesModel
import com.example.kremik.cryptodroid.data.model.CryptoCurrency
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LivePricesPresenter @Inject constructor(private var adapter: RecViewAdapter,
                                              private var model: CurrenciesModel) {

    private var view: LivePricesView? = null

    fun bind(view: LivePricesView ) {
        this.view = view
    }

    fun unbind() {
        view = null
    }

    fun loadCurrencies(currencyList: ArrayList<CryptoCurrency>) {
            updateViewCurrencies(currencyList)
    }

    fun setRecyclerView() {
        view?.recyclerView?.layoutManager = LinearLayoutManager(view?.getViewContext())
        updateViewCurrencies(model.getCurrencies())
    }

    private fun updateViewCurrencies(currencies: ArrayList<CryptoCurrency>) {
        adapter.setCurrencies(currencies)
        view?.recyclerView?.adapter = adapter
    }
}