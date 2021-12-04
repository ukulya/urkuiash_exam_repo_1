package com.example.testapp


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

const val CONTACT_NAME = "name"
const val CONTACT_PHONE = "phone"

class Fragment1 : Fragment(R.layout.fragment_1) {
    private lateinit var listener: OnFragmentClickListener
    private lateinit var input_name: AppCompatEditText
    private lateinit var input_phone: AppCompatEditText


    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnFragmentClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        val layoutManager = LinearLayoutManager(requireContext())
        val adapter = SimpleAdapter {
            Toast.makeText(requireContext(), "ITEM -$it", Toast.LENGTH_SHORT).show()
            listener.onClick("$it")
        }

        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
        recycler.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))

        val list = mutableListOf<String>()
        for (i in 0..20) {
            list.add("ITEM -$i")
        }
        adapter.setData(list)

        //
        view.findViewById<Button>(R.id.add_btn).setOnClickListener {
            addFlower()
        }
        input_name = view.findViewById(R.id.input_name)
        input_phone = view.findViewById(R.id.input_phone)

    }
    private fun addFlower() {
        val resultIntent = Intent()

        if (addFlowerName.text.isNullOrEmpty() || addFlowerDescription.text.isNullOrEmpty()) {
            setResult(Activity.RESULT_CANCELED, resultIntent)
        } else {
            val name = addFlowerName.text.toString()
            val description = addFlowerDescription.text.toString()
            resultIntent.putExtra(CONTACT_NAME, name)
            resultIntent.putExtra(CONTACT_PHONE, description)
            setResult(Activity.RESULT_OK, resultIntent)
        }
        finish()
    }
}