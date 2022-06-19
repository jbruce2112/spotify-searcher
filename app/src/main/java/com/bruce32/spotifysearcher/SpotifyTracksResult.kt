package com.bruce32.spotifysearcher

data class SpotifyTracksResult(
    val tracks: SpotifyTracks
)

data class SpotifyTracks(
    val items: List<SpotifyItem>
)

data class SpotifyItem(
    val data: SpotifyItemData
)

data class SpotifyItemData(
    val name: String,
    val duration: SpotifyItemDuration
)

data class SpotifyItemDuration(
    val totalMilliseconds: Long
)
