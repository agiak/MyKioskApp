package com.example.mykioskapp.utils

import android.app.ActivityManager
import android.content.Context


/**
 * Checks if the current context runs in lock task mode.
 * LOCK_TASK_MODE_PINNED is the state in which context is running at lock task mode.
 * */
fun Context.isInLockTaskMode(): Boolean{

    val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    return when(activityManager.lockTaskModeState){
        ActivityManager.LOCK_TASK_MODE_LOCKED -> false
        ActivityManager.LOCK_TASK_MODE_NONE -> false
        ActivityManager.LOCK_TASK_MODE_PINNED -> true
        else -> false
    }
}