package com.example.kremik.cryptodroid.ui.common

import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.kremik.cryptodroid.R
import com.example.kremik.cryptodroid.ui.LivePrices.LivePricesFragment

class BasicActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment {
        return LivePricesFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_fragment)
    }
}
