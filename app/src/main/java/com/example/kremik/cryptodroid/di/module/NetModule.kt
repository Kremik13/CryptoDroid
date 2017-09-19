package com.example.kremik.cryptodroid.di.module

import com.example.kremik.cryptodroid.data.local.CurrenciesProvider
import com.example.kremik.cryptodroid.data.remote.CMCService
import com.example.kremik.cryptodroid.data.service.CurrencyDataPresenter
import com.example.kremik.cryptodroid.ui.LivePrices.LivePricesPresenter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val BASE_URL: String) {

    @Provides
    @Singleton
    fun providesCurrencyDataPresenter(provider: CurrenciesProvider, pricesPresenter: LivePricesPresenter) =
            CurrencyDataPresenter(provider, pricesPresenter)

    @Provides
    @Singleton
    fun providesRetrofit() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providesCMCService(retrofit: Retrofit) = retrofit.create(CMCService::class.java)
}