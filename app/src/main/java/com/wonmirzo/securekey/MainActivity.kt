package com.wonmirzo.securekey

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var serverKey = BuildConfig.SERVER_KEY
    var smsKey = BuildConfig.SMS_KEY

    init {
        System.loadLibrary("keys")
    }

    external fun getPublicKey(): String?
    external fun getPrivateKey(): String?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("TAG", "serverKey : $serverKey")
        Log.d("TAG", "smsKey : $smsKey")

        Log.d("TAG", getPublicKey().toString())
        Log.d("TAG", getPrivateKey().toString())
    }
}