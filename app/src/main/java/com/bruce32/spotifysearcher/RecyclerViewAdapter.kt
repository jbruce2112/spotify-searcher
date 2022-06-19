package com.bruce32.spotifysearcher

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter: RecyclerView.Adapter<TrackCell>() {

   private var items = emptyList<SpotifyItemData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackCell {
        val trackView = LayoutInflater.from(parent.context).inflate(R.layout.track_cell, parent, false)
        return TrackCell(trackView)
    }

    override fun onBindViewHolder(holder: TrackCell, position: Int) {
        val item = items[position]
        holder.titleLabel.text = item.name

        val seconds = item.duration.totalMilliseconds / 1000
        holder.durationLabel.text = "${seconds / 60}:${seconds % 60}"
    }

    override fun getItemCount(): Int = items.size

    fun update(items: List<SpotifyItemData>) {
        this.items = items
        notifyDataSetChanged()
    }
}