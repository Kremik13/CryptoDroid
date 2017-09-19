package com.example.kremik.cryptodroid

import android.app.Application
import android.content.Intent
import android.util.Log
import com.example.kremik.cryptodroid.data.service.CurrencyDownloaderService
import com.example.kremik.cryptodroid.di.component.AppComponent
import com.example.kremik.cryptodroid.di.component.DaggerAppComponent
import com.example.kremik.cryptodroid.di.module.AppModule
import com.example.kremik.cryptodroid.di.module.NetModule

class CryptoDroidApp : Application() {

    private val BASE_URL = "http://api.coinmarketcap.com/v1/"

    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .netModule(NetModule(BASE_URL))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
        startDownloaderService()
    }

    override fun onTerminate() {
        stopService(Intent(this,
                CurrencyDownloaderService::class.java))
        super.onTerminate()
    }

    private fun startDownloaderService() {
        val intent = Intent(this, CurrencyDownloaderService::class.java)
        startService(intent)
    }
}