package com.example.kremik.cryptodroid.data.local

import com.example.kremik.cryptodroid.data.model.CryptoCurrency

class CurrenciesProvider : CurrenciesModel {
    private var currencyList: ArrayList<CryptoCurrency> = ArrayList()

    override fun getCurrencies(): ArrayList<CryptoCurrency> {
        return currencyList
    }

    override fun setCurrencies(list: List<CryptoCurrency>) {
        if (!(currencyList.containsAll(list) && list.containsAll(currencyList))) {
            currencyList = list as ArrayList<CryptoCurrency>
        }
    }
}