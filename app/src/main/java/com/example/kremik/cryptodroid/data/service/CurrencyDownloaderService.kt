package com.example.kremik.cryptodroid.data.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.example.kremik.cryptodroid.CryptoDroidApp
import com.example.kremik.cryptodroid.app
import com.example.kremik.cryptodroid.data.model.CryptoCurrency
import com.example.kremik.cryptodroid.data.remote.CMCService
import com.example.kremik.cryptodroid.di.module.NetModule
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CurrencyDownloaderService : Service(), CurrencyDownloaderModel{

    @Inject lateinit var cmcService: CMCService
    @Inject lateinit var presenter: CurrencyDataPresenter


    private var currencyList: List<CryptoCurrency> = ArrayList()
    private lateinit var timerObserver: Disposable
    private lateinit var dataObserver: DisposableSingleObserver<List<CryptoCurrency>>

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {


        timerObserver = Observable.interval(0, 10, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{ loadTenCurrencies() }

        return Service.START_STICKY
    }

    override fun onCreate() {
        ( application as CryptoDroidApp).component.inject(this)
        super.onCreate()
        presenter.bindService(this)
    }

    private fun loadTenCurrencies() {


        val single = cmcService.topTenCurrencies
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        dataObserver = object : DisposableSingleObserver<List<CryptoCurrency>>() {

            override fun onSuccess(currencies: List<CryptoCurrency>) {
                if (currencyList != currencies) {
                    currencyList = currencies
                    presenter.notifyFetchedNewCurrencies()
                }
            }
            override fun onError(e: Throwable) {
            }
        }
        single.subscribe(dataObserver)
    }

    override fun onDestroy() {
        presenter.unbindService()

        if (!timerObserver.isDisposed) {
            timerObserver.dispose()
        }

        if (!dataObserver.isDisposed) {
            dataObserver.dispose()
        }

        super.onDestroy()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return  null
    }

    override fun getCurrencies(): List<CryptoCurrency> {
        return currencyList
    }
}