package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.app.AlertDialog
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast

class FragmentOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val frag = inflater.inflate(R.layout.fragment_one, container, false)
        val insertButton = frag.findViewById<Button>(R.id.insert_button)
        val nameText = frag.findViewById<EditText>(R.id.name_text)

        val list = ArrayList<SampleData>()
        val adapter = SampleAdapter(list)
        val recyclerView = frag.findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        setEdit(nameText, insertButton)

        insertButton.apply {
            setOnClickListener {
                if(nameText.text.isNotBlank()) {
                    adapter.addText(nameText.text.toString())
                    recyclerView.layoutManager = LinearLayoutManager(view?.context)
                    recyclerView.adapter = adapter
                }
                nameText.setText("")
            }
        }

        adapter.setOnItemClickListener(object : SampleAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                val builder = AlertDialog.Builder(view?.context)
                builder.setMessage(R.string.delete_message)
                builder.setPositiveButton("Yes") { dialog, which ->
                    adapter.deleteText(position)
                }
                builder.setNegativeButton("No") { dialog, which ->
                    dialog.dismiss()
                }
                builder.show()
            }
        })

        adapter.setOnItemLongClickListener(object : SampleAdapter.OnItemLongClickListener {
            override fun onLongClick(v: View, position: Int): Boolean {
                val dialogLayout = layoutInflater.inflate(R.layout.alertdialog_button, null)
                val dialogText = dialogLayout.findViewById<EditText>(R.id.alertdialog_text)
                val eButton = dialogLayout.findViewById<Button>(R.id.alertdialog_eButton)
                val cButton = dialogLayout.findViewById<Button>(R.id.alertdialog_cButton)
                val builder = AlertDialog.Builder(view?.context)
                    .create()
                setEdit(dialogText, eButton)

                eButton.setOnClickListener {
                    adapter.newName(position, dialogText.text.toString())
                    recyclerView.layoutManager = LinearLayoutManager(view?.context)
                    recyclerView.adapter = adapter
                    builder.dismiss()
                }

                cButton.setOnClickListener {
                    builder.dismiss()
                }

                builder.setView(dialogLayout)
                builder.show()

                return true
            }
        })

        return frag
    }

    private fun setEdit(editText: EditText, button: Button) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(i1: CharSequence?, i2: Int, i3: Int, i4: Int) {
            }

            override fun onTextChanged(i1: CharSequence?, i2: Int, i3: Int, i4: Int) {
                if (i1.toString().length == 0) {
                    button.isEnabled = false
                } else {
                    button.isEnabled = true
                }
            }

            override fun afterTextChanged(i1: Editable?) {
            }
        })
    }

}