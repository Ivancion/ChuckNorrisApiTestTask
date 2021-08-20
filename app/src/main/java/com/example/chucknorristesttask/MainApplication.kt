package com.example.chucknorristesttask

import android.app.Application
import android.content.Intent
import com.onesignal.OneSignal

const val ONESIGNAL_APP_ID = "5ab2e96a-94f5-4bf2-9070-85b5306fecc5"

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()


        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)

        OneSignal.setNotificationOpenedHandler {
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT or Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra("type", "push")
            startActivity(intent)
        }
    }
}