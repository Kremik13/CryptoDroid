package com.example.kremik.cryptodroid

import android.app.Activity
import android.app.Service

val Activity.app: CryptoDroidApp
    get() = application as CryptoDroidApp

val Service.app: CryptoDroidApp
    get() = application as CryptoDroidApp