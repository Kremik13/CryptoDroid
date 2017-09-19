package com.example.kremik.cryptodroid.di.module

import android.content.Context
import com.example.kremik.cryptodroid.CryptoDroidApp
import com.example.kremik.cryptodroid.data.local.CurrenciesProvider
import com.example.kremik.cryptodroid.ui.LivePrices.LivePricesPresenter
import com.example.kremik.cryptodroid.ui.LivePrices.RecViewAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: CryptoDroidApp) {

    @Provides
    @Singleton
    fun provideApp() = app

    @Provides
    @Singleton
    fun provideContext() = app.applicationContext as Context

    @Provides
    @Singleton
    fun providesCurrencies() = CurrenciesProvider()

    @Provides
    @Singleton
    fun providesLivePricesPresenter(context: Context) = LivePricesPresenter(RecViewAdapter(context),
            CurrenciesProvider())

    @Provides
    @Singleton
    fun providesRecVAdapter(context: Context) = RecViewAdapter(context)
}