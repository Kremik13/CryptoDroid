package com.example.kremik.cryptodroid.data.local

import com.example.kremik.cryptodroid.data.model.CryptoCurrency

interface CurrenciesModel {

    fun getCurrencies(): ArrayList<CryptoCurrency>

    fun setCurrencies(list: List<CryptoCurrency>)
}