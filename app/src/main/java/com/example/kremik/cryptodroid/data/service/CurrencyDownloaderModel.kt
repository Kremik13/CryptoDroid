package com.example.kremik.cryptodroid.data.service

import com.example.kremik.cryptodroid.data.model.CryptoCurrency

interface CurrencyDownloaderModel {
    fun getCurrencies(): List<CryptoCurrency>
}