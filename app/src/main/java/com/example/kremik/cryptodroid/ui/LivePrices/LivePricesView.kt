package com.example.kremik.cryptodroid.ui.LivePrices

import android.content.Context
import android.support.v7.widget.RecyclerView

interface LivePricesView {
    var recyclerView: RecyclerView
    fun getViewContext(): Context
}