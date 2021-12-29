package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SampleAdapter(
    private var list: MutableList<SampleData> = mutableListOf()
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

    interface OnItemLongClickListener {
        fun onLongClick(v: View, position: Int): Boolean
    }

    private lateinit var itemLongClickListener: OnItemLongClickListener

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClick = onItemClickListener
    }

    fun setOnItemLongClickListener(onItemLongClickListener: OnItemLongClickListener) {
        this.itemLongClickListener = onItemLongClickListener
    }

    fun addText(text_1: String) {
        list.add(SampleData(text_1))
        notifyItemInserted(itemCount)
        notifyDataSetChanged()
    }

    fun deleteText(position: Int) {
        list.removeAt(position)
        notifyDataSetChanged()
    }

    fun newList(newList: MutableList<SampleData>) {
        list = newList.toMutableList()
        notifyDataSetChanged()
    }

    fun newName(position: Int, newName: String) {
        list.get(position).text_1 = newName
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick.onClick(it, position)
        }

        holder.itemView.setOnLongClickListener {
            itemLongClickListener.onLongClick(it, position)
        }

        holder.justName.text = list.get(position).text_1
    }

    override fun getItemCount(): Int {
        return list.size
    }
}