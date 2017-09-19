package com.example.kremik.cryptodroid.data.service

import com.example.kremik.cryptodroid.data.local.CurrenciesModel
import com.example.kremik.cryptodroid.ui.LivePrices.LivePricesPresenter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CurrencyDataPresenter @Inject constructor(private var currenciesModel: CurrenciesModel,
                                                private var livePricesPresenter: LivePricesPresenter) {
    private var downloaderModel: CurrencyDownloaderModel? = null

    fun bindService(service: CurrencyDownloaderModel) {
        downloaderModel = service
    }

    fun unbindService() = {
        downloaderModel = null
    }

    fun notifyFetchedNewCurrencies() {
        currenciesModel.setCurrencies(downloaderModel!!.getCurrencies())
        livePricesPresenter.loadCurrencies(currenciesModel.getCurrencies())
    }

}