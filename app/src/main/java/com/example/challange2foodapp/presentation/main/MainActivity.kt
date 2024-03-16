package com.example.challange2foodapp.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.challange2foodapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG: String? = MainActivity::class.java.name

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: Activity Created")
        setContentView(binding.root)
    }
}