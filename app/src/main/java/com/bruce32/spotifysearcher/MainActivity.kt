package com.bruce32.spotifysearcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bruce32.spotifysearcher.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val intent = Intent(this, SearchResultsActivity::class.java)
            intent.putExtra("term", binding.searchTextInput.text.toString())
            startActivity(intent)
        }
    }
}