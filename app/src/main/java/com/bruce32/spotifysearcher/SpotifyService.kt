package com.bruce32.spotifysearcher

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SpotifyService {

    //https://spotify23.p.rapidapi.com/search/?q=smashing%20pumpkins&type=tracks&offset=0&limit=10&numberOfTopResults=5

    @Headers(
        "X-RapidAPI-Key: RAPID_API_KEY",
        "X-RapidAPI-Host: spotify23.p.rapidapi.com"
    )
    @GET("search/")
    suspend fun getTracks(
        @Query("q")
        search: String,
        @Query("type")
        type: String = "tracks"
    ): SpotifyTracksResult
}