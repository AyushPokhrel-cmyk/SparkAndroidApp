package com.example.sparkinstitute

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    private lateinit var prefs: SharedPrefHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment__home, container, false)

        val profileIcon = view.findViewById<ImageView>(R.id.profile)
        val navodayaBtn = view.findViewById<LinearLayout>(R.id.NavodayaBtn)
        val competativaBtn = view.findViewById<LinearLayout>(R.id.CompetitiveBtn)
        val computerBtn = view.findViewById<LinearLayout>(R.id.ComputerBtn)
        val coachingBtn = view.findViewById<LinearLayout>(R.id.CoachingBtn)

        profileIcon.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, ProfileFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        navodayaBtn.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, Navodaya())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        competativaBtn.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, Competative())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        computerBtn.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, Computer_Fragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        coachingBtn.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, Coaching_Fragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return view
    }
}
