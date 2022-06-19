package com.bruce32.spotifysearcher

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TrackCell(trackView: View): RecyclerView.ViewHolder(trackView)  {
    val titleLabel: TextView = trackView.findViewById(R.id.titleView)
    val durationLabel: TextView = trackView.findViewById(R.id.durationView)
}