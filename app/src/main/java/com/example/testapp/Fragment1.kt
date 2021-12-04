package com.example.testapp


import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//const val CONTACT_NAME = "name"
//const val CONTACT_PHONE = "phone"

class Fragment1 : Fragment(R.layout.fragment_1) {
    private lateinit var listener: OnFragmentClickListener
    private lateinit var inputName: AppCompatEditText
    private lateinit var inputPhone: AppCompatEditText
    private lateinit var recycler : RecyclerView
    private lateinit var adapter : SimpleAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnFragmentClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler = view.findViewById(R.id.recycler)
        //val layoutManager = LinearLayoutManager(requireContext())
        val layoutManager = LinearLayoutManager(activity)
        adapter = SimpleAdapter {
            listener.onClick(it)
        }

        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
        recycler.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))

        view.findViewById<Button>(R.id.add_btn).setOnClickListener {
            addContact()
        }
        inputName = view.findViewById(R.id.input_name)
        inputPhone = view.findViewById(R.id.input_phone)

    }
    private fun addContact() {
        val name = inputName.text.toString()
        val phone = inputPhone.text.toString()

        val contactObj = Contact(name,phone)
        adapter.setData(contactObj)
    }
}