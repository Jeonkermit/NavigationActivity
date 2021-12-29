package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentTwo : Fragment() {
    private var result = 0
    private var temp = "0"
    private var number = "0"
    private var list = mutableListOf<Int>()
    private var newList = mutableListOf<String>()
    private var simbList = mutableListOf<Char>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val frag = inflater.inflate(R.layout.fragment_two, container, false)
        val textView = frag.findViewById<TextView>(R.id.textView)
        val button0 = frag.findViewById<Button>(R.id.button0)
        val button1 = frag.findViewById<Button>(R.id.button1)
        val button2 = frag.findViewById<Button>(R.id.button2)
        val button3 = frag.findViewById<Button>(R.id.button3)
        val button4 = frag.findViewById<Button>(R.id.button4)
        val button5 = frag.findViewById<Button>(R.id.button5)
        val button6 = frag.findViewById<Button>(R.id.button6)
        val button7 = frag.findViewById<Button>(R.id.button7)
        val button8 = frag.findViewById<Button>(R.id.button8)
        val button9 = frag.findViewById<Button>(R.id.button9)

        val buttonC = frag.findViewById<Button>(R.id.buttonC)
        val buttonRmd = frag.findViewById<Button>(R.id.buttonRmd)
        val buttonDiv = frag.findViewById<Button>(R.id.buttonDiv)
        val buttonMtp = frag.findViewById<Button>(R.id.buttonMtp)
        val buttonMinus = frag.findViewById<Button>(R.id.buttonMinus)
        val buttonPlus = frag.findViewById<Button>(R.id.buttonPlus)
        val buttonEql = frag.findViewById<Button>(R.id.buttonEql)

        button0.setOnClickListener {
            if (list.isEmpty()) {
                textView.text = "0"
            } else {
                list.add(0)
                temp = list.joinToString("")
                textView.text = temp
            }
        }

        button1.setOnClickListener {
            list.add(1)
            temp = list.joinToString("")
            textView.text = temp
        }

        button2.setOnClickListener {
            list.add(2)
            temp = list.joinToString("")
            textView.text = temp
        }

        button3.setOnClickListener {
            list.add(3)
            temp = list.joinToString("")
            textView.text = temp
        }

        button4.setOnClickListener {
            list.add(4)
            temp = list.joinToString("")
            textView.text = temp
        }

        button5.setOnClickListener {
            list.add(5)
            temp = list.joinToString("")
            textView.text = temp
        }

        button6.setOnClickListener {
            list.add(6)
            temp = list.joinToString("")
            textView.text = temp
        }

        button7.setOnClickListener {
            list.add(7)
            temp = list.joinToString("")
            textView.text = temp
        }

        button8.setOnClickListener {
            list.add(8)
            temp = list.joinToString("")
            textView.text = temp
        }

        button9.setOnClickListener {
            list.add(9)
            temp = list.joinToString("")
            textView.text = temp
        }

        buttonC.setOnClickListener {
            result = 0
            list = mutableListOf()
            newList = mutableListOf()
            simbList = mutableListOf()
            textView.text = "0"
        }

        buttonRmd.setOnClickListener {
            list = mutableListOf()
            simbList.add('%')
            newList.add(temp)
            textView.text = "%"
        }

        buttonDiv.setOnClickListener {
            list = mutableListOf()
            simbList.add('/')
            newList.add(temp)
            number = "1"
            textView.text = "/"
        }

        buttonMtp.setOnClickListener {
            list = mutableListOf()
            simbList.add('*')
            newList.add(temp)
            number = "2"
            textView.text = "x"
        }

        buttonMinus.setOnClickListener {
            list = mutableListOf()
            simbList.add('-')
            newList.add(temp)
            number = "3"
            textView.text = "-"
        }

        buttonPlus.setOnClickListener {
            list = mutableListOf()
            simbList.add('+')
            newList.add(temp)
            number = "4"
            textView.text = "+"
        }

        buttonEql.setOnClickListener {
            list = mutableListOf()
            simbList.add('=')
            newList.add(temp)
            result = newList.removeFirst().toInt()

            for (i in 0 until newList.size) {
                if (simbList[i] == '%') {
                    result = result % newList[i].toInt()
                } else if (simbList[i] == '/') {
                    result = result / newList[i].toInt()
                } else if (simbList[i] == '*') {
                    result = result * newList[i].toInt()
                } else if (simbList[i] == '-') {
                    result = result - newList[i].toInt()
                } else if (simbList[i] == '+') {
                    result = result + newList[i].toInt()
                }

                textView.text = result.toString()
            }

        }
        return frag
    }

}