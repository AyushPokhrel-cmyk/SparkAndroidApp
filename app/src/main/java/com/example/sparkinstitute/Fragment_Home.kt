package com.example.sparkinstitute

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    private lateinit var prefs: SharedPrefHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment__home, container, false)

        val profileIcon = view.findViewById<ImageView>(R.id.profile)
        profileIcon.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, ProfileFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return view
    }
}
