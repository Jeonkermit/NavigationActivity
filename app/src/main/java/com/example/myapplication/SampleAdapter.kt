package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SampleAdapter(
    val list: ArrayList<SampleData> = ArrayList()
) : RecyclerView.Adapter<SampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        return SampleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.management_recycler, parent, false)
        )
    }

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }

    private lateinit var itemClick: OnItemClickListener

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick.onClick(it, position)
        }
        holder.justName.text = list.get(position).text_1
    }

    override fun getItemCount(): Int {
        return list.size
    }
}