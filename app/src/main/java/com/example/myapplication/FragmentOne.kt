package com.example.myapplication

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val frag = inflater.inflate(R.layout.fragment_one, container, false)
        val insertButton = frag.findViewById<Button>(R.id.insert_button)
        val nameText = frag.findViewById<TextView>(R.id.name_text)

        val list = ArrayList<SampleData>()
        val adapter = SampleAdapter(list)
        val recyclerView = frag.findViewById<RecyclerView>(R.id.recycler_view)

        insertButton.setOnClickListener {
            list.apply {
                val raelText = nameText.text.toString()
                add(SampleData(raelText))
                recyclerView.layoutManager = LinearLayoutManager(null)
                recyclerView.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        }

        return frag
    }

}