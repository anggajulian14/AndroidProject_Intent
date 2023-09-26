package com.example.projectintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.projectintent.databinding.ActivityImplicitBinding

class Implicit : AppCompatActivity() {

    private lateinit var binding : ActivityImplicitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImplicitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val spinner = binding.spinner
        val options = arrayOf("Implicit", "Explicit")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, options)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = options[position]

                when (selectedItem) {
                    "Explicit" -> {
                        val intent = Intent(this@Implicit, Explicit_first::class.java)
                        startActivity(intent)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }


        binding.button.setOnClickListener {
            val url = binding.editText.text.toString()

            if (url.isNotEmpty()) {
                try {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intent)
                } catch (e: Exception) {
                    Toast.makeText(this, "URL tidak valid", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "URL harus diisi", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
