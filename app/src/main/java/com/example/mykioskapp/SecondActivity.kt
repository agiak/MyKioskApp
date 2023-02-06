package com.example.mykioskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mykioskapp.databinding.ActivityMainBinding
import com.example.mykioskapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            onBackPressed()
        }
    }
}