package com.bruce32.spotifysearcher

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkingService {

    val apiService: SpotifyService = Retrofit.Builder()
        .baseUrl("https://spotify23.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(SpotifyService::class.java)

    fun getTracks(search: String): LiveData<List<SpotifyItemData>> {
        return object: LiveData<List<SpotifyItemData>>() {
            override fun onActive() {
                super.onActive()

                CoroutineScope(Dispatchers.IO).launch {
                    val response = apiService.getTracks(search, "tracks")

                    withContext(Dispatchers.Main) {
                        value = response.tracks.items.map { it.data }
                    }
                }
            }
        }
    }
}