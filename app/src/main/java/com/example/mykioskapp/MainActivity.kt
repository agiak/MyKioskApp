package com.example.mykioskapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.mykioskapp.databinding.ActivityMainBinding
import com.example.mykioskapp.utils.disableImmersiveMode
import com.example.mykioskapp.utils.enableImmersiveMode
import com.example.mykioskapp.utils.isInLockTaskMode
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: KioskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initSubscriptions()
    }

    private fun initSubscriptions(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.isKioskEnable.collect { isEnable ->
                    if (isEnable){
                        enableKioskMode()
                    }else{
                        disableKioskMode()
                    }
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.isImmersiveEnable.collect { isEnable ->
                    if (isEnable){
                        enableImmersiveMode()
                    }else{
                        disableImmersiveMode()
                    }
                }
            }
        }
    }

    // At android 10 and below immersive mode is canceled when a dialog is displayed
    // Re-enable when window focus is changed
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        val isImmersiveEnable = viewModel.isImmersiveEnable.value
        if (isImmersiveEnable){
            enableImmersiveMode()
        }else{
            disableImmersiveMode()
        }
    }

    private fun enableKioskMode(){
        if (!isInLockTaskMode()) startLockTask()
    }

    private fun disableKioskMode(){
        if (isInLockTaskMode()) stopLockTask()
    }

}
