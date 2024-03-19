package com.example.challange2foodapp.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.challange2foodapp.R
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
        setBottomNavigation()
    }

    private fun setBottomNavigation(){
        val navController = findNavController(R.id.main_nav_host)
        binding.bnvMain.setupWithNavController(navController)
    }
}