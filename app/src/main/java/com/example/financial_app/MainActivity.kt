package com.example.financial_app

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.financial_app.databinding.ActivityBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityBinding
    private lateinit var navController: NavController
    private val viewModel: FirstSettingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.loggedIn.observe(this) { logged ->
            binding.bottomNavigationView.isVisible = logged
        }

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        setupBottomNavigation(navController)
    }

    private fun setupBottomNavigation(navController: NavController) {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setupWithNavController(navController)
    }
}