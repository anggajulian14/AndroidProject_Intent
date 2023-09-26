package com.example.projectintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectintent.Explicit_first.Companion.KEY_NAME
import com.example.projectintent.databinding.ActivityExplicit2Binding

class Explicit_second : AppCompatActivity() {

    private lateinit var binding: ActivityExplicit2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExplicit2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val nama = intent.getStringExtra(KEY_NAME)

        if (nama != null) {
            binding.tvName.text = "$nama!"
        }
    }
}

