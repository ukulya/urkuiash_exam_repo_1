package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), OnFragmentClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, Fragment1())
            .commit()
    }

    override fun onClick(contact: Contact) {
        val fragment2 = Fragment2()
        val bundle = Bundle()
        bundle.putString("name", contact.name)
        bundle.putString("phone", contact.phone)
        fragment2.arguments = bundle

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment2)
            .addToBackStack(null)
            .commit()
    }
}