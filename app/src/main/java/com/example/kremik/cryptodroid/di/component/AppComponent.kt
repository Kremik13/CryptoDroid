package com.example.kremik.cryptodroid.di.component

import com.example.kremik.cryptodroid.CryptoDroidApp
import com.example.kremik.cryptodroid.data.service.CurrencyDownloaderService
import com.example.kremik.cryptodroid.di.module.AppModule
import com.example.kremik.cryptodroid.di.module.NetModule
import com.example.kremik.cryptodroid.ui.LivePrices.LivePricesFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, NetModule::class))
interface AppComponent {
    fun inject(app: CryptoDroidApp)

    fun inject(fragment: LivePricesFragment)

    fun inject(service: CurrencyDownloaderService)
}