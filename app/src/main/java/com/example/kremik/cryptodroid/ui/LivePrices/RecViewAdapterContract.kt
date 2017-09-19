package com.example.kremik.cryptodroid.ui.LivePrices

import android.support.v7.widget.RecyclerView
import com.example.kremik.cryptodroid.data.model.CryptoCurrency

interface RecViewAdapterContract {

    var currencyList: List<CryptoCurrency>

    fun setCurrencies(list: List<CryptoCurrency>)

}