package com.example.kremik.cryptodroid.data.remote


import com.example.kremik.cryptodroid.data.model.CryptoCurrency

import io.reactivex.Single
import retrofit2.http.GET

interface CMCService {

    @get:GET("ticker/?limit=10")
    val topTenCurrencies: Single<List<CryptoCurrency>>
}
