package com.wonmirzo.securekey

import android.app.Application
import android.util.Log

class MyApplication : Application() {
    private val TAG = MyApplication::class.java.simpleName

    init {
        System.loadLibrary("keys")
    }

    external fun getApplicationKey(): String?

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, getApplicationKey().toString())
    }
}