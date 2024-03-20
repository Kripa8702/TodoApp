package com.example.todoapp.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.todoapp.R
import com.google.firebase.auth.FirebaseAuth

class SplashFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("SPLASH", "In Splash")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init(view)

        val isLoggedIn: Boolean = auth.currentUser != null
        Log.d("SplashFragment", "auth: $auth")

        val handler = Handler(Looper.myLooper()!!)

        handler.postDelayed({
            if (isLoggedIn)
                navController.navigate(R.id.action_splashFragment_to_homeFragment)
            else
                navController.navigate(R.id.action_splashFragment_to_signInFragment)
        }, 2000)
    }

    private fun init(view: View) {
        navController = Navigation.findNavController(view)
        auth = FirebaseAuth.getInstance()
        Log.v("SplashFragment", "auth: $auth")

    }

}