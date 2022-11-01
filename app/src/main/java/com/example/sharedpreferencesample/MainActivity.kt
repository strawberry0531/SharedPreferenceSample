package com.example.sharedpreferencesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.sharedpreferencesample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppPreferences.init(this)
        binding.btnLogin.setOnClickListener {
            AppPreferences.username = binding.etUsername.text.toString()
            AppPreferences.password = binding.etPassword.text.toString()
            Toast.makeText(this, "You have successfully logged in!", Toast.LENGTH_LONG).show()
            showWelcome()
        }

        if (AppPreferences.username.isNotBlank() && AppPreferences.password.isNotBlank()) {
            showWelcome()
        }
    }

    private fun showWelcome() {
        binding.apply {
            etPassword.visibility = View.GONE
            etUsername.visibility = View.GONE
            btnLogin.visibility = View.GONE
            txtWelcome.visibility = View.VISIBLE
        }
    }
}