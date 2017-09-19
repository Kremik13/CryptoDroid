package com.example.kremik.cryptodroid.ui.common

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.kremik.cryptodroid.R

abstract class SingleFragmentActivity : AppCompatActivity() {

    abstract fun createFragment(): Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_fragment)
        val fm = supportFragmentManager
        var fragment = fm.findFragmentById(R.id.single_fragment_container)
        if (fragment == null) {
            fragment = createFragment()
            fm.beginTransaction().add(R.id.single_fragment_container, fragment).commit()
        }
    }
}

