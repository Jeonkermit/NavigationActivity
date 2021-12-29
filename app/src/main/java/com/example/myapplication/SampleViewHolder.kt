package com.example.myapplication

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val justName=itemView.findViewById<TextView>(R.id.just_name)
}