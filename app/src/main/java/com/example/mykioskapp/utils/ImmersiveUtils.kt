package com.example.mykioskapp.utils

import android.os.Build
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.appcompat.app.AppCompatActivity


/**
 * Enables and disables immersive mode for an application. More specifically hides navigation bar,
 * making it translucent when user swipes up.
 * */
fun AppCompatActivity.enableImmersiveMode() {
    window.enableImmersiveMode()
}

fun AppCompatActivity.disableImmersiveMode() {
    window.disableImmersiveMode()
}

@Suppress("DEPRECATION")
fun Window.enableImmersiveMode() {
    Log.d("ImmersiveUtils","Enables immersive mode")
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        insetsController?.hide(WindowInsets.Type.navigationBars())
        insetsController?.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    } else {
        decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
}

@Suppress("DEPRECATION")
fun Window.disableImmersiveMode() {
    Log.d("ImmersiveUtils","Disables immersive mode")
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        insetsController?.show(WindowInsets.Type.navigationBars())
    } else {
        clearFlags (
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
}