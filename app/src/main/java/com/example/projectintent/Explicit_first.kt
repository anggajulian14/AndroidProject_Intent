package com.example.projectintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.projectintent.databinding.ActivityExplicit1Binding

class Explicit_first : AppCompatActivity() {

    private lateinit var binding: ActivityExplicit1Binding

    companion object {
        const val KEY_NAME: String = "NAMA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExplicit1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val spinner = binding.spinner
        val options = arrayOf("Explicit", "Implicit")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, options)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = options[position]

                when (selectedItem) {
                    "Implicit" -> {
                        val intent = Intent(this@Explicit_first, Implicit::class.java)
                        startActivity(intent)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }


        binding.buttonSend.setOnClickListener {
            val nama = binding.etNama.text.toString()
            if (nama.isNotEmpty()) {
                val intent = Intent(this, Explicit_second::class.java)
                intent.putExtra(KEY_NAME, nama)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Namamu siapa?", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


