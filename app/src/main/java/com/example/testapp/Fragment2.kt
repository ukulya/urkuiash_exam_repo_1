package com.example.testapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment2 : Fragment(R.layout.fragment_2) {
    private lateinit var text_name: AppCompatTextView
    private lateinit var text_phone: AppCompatTextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        text_name = view.findViewById(R.id.text_name)
        text_phone = view.findViewById(R.id.text_phone)

        val text = arguments?.getString("name") ?: "defaultText"
        val textPhone = arguments?.getString("phone") ?: "defaultText"
        text_name.text = text
        text_phone.text = textPhone

    }

}