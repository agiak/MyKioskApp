package com.example.mykioskapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class KioskViewModel: ViewModel() {

    private var _isKioskEnable = MutableStateFlow(false)
    val isKioskEnable = _isKioskEnable.asStateFlow()

    private var _isImmersiveEnable = MutableStateFlow(false)
    val isImmersiveEnable = _isImmersiveEnable.asStateFlow()

    fun handleKiosk(isEnable: Boolean){
        viewModelScope.launch {
            _isKioskEnable.emit(isEnable)
        }
    }

    fun handleImmersive(isEnable: Boolean){
        viewModelScope.launch {
            _isImmersiveEnable.emit(isEnable)
        }
    }
}