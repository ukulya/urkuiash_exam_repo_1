package com.example.testapp


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment2 : Fragment(R.layout.fragment_2) {
    private lateinit var txt: AppCompatTextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txt = view.findViewById(R.id.txt)

        val text = arguments?.getString("key") ?: "defaultText"
        txt.text = text

        val btn = view.findViewById<AppCompatButton>(R.id.btn_fr_2)
        val layoutManager = LinearLayoutManager(requireContext())
        val adapter = SimpleAdapter {
            Toast.makeText(requireContext(), "ITEM -$it", Toast.LENGTH_SHORT).show()
            goTo(it)
        }
    }

    private fun goTo(position: Int) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("https://www.javatpoint.com/"))
        intent.putExtra("item", position) // ключ - значение
        startActivity(intent)
    }

    companion object {
        const val TAG = "Fragment2"
    }
}