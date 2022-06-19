package com.bruce32.spotifysearcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bruce32.spotifysearcher.databinding.ActivitySearchResultsBinding

class SearchResultsActivity : AppCompatActivity() {

    private val networking = NetworkingService()
    private val adapter = RecyclerViewAdapter()
    private lateinit var binding: ActivitySearchResultsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_results)

       binding = ActivitySearchResultsBinding.inflate(layoutInflater)
       setContentView(binding.root)

        binding.recylerView.layoutManager = LinearLayoutManager(this)
        binding.recylerView.adapter = adapter

        val searchTerm = intent.getStringExtra("term")
        supportActionBar?.title = searchTerm

        if (searchTerm == null) {
            return
        }

        networking.getTracks(searchTerm).observe(this) { items ->
            items.forEach { println("jb $it") }
            adapter.update(items)
        }
    }
}