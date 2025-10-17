package com.example.sparkinstitute

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {

    private lateinit var sharedPrefHelper: SharedPrefHelper
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile_, container, false)

        sharedPrefHelper = SharedPrefHelper(requireContext())
        auth = FirebaseAuth.getInstance()

        val logoutBtn = view.findViewById<Button>(R.id.btnLogout)

        logoutBtn.setOnClickListener {
            // Step 1: Sign out user
            auth.signOut()
            sharedPrefHelper.saveLoginState(false)

            // Step 2: Clear fragment back stack and go to LoginFragment
            val fm = requireActivity().supportFragmentManager
            fm.popBackStack(null, androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE)

            val transaction = fm.beginTransaction()
            transaction.replace(R.id.fragment_container, LoginFragment())
            transaction.commit()
        }

        return view
    }
}
