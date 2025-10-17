package com.example.sparkinstitute

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPrefHelper: SharedPrefHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPrefHelper = SharedPrefHelper(this)

        val isLoggedIn = sharedPrefHelper.isLoggedIn()
        val user = FirebaseAuth.getInstance().currentUser

        if (isLoggedIn && user != null) {
            replaceFragment(HomeFragment())
        } else {
            replaceFragment(LoginFragment())
        }
    }

    fun replaceFragment(fragment: androidx.fragment.app.Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}
