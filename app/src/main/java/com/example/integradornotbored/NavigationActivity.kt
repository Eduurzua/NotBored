package com.example.integradornotbored

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.integradornotbored.databinding.NavActivityBinding


class NavigationActivity : AppCompatActivity() {

    private lateinit var binding : NavActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NavActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}