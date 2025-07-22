package com.example.financial_app

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.core.SharedPreference.SharedPreferenceManager

class StartFragment : Fragment(R.layout.start_fragment) {

    private lateinit var sharedPrefs: SharedPreferenceManager

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPrefs = SharedPreferenceManager(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (sharedPrefs.getLoggedIn()) {
            findNavController().navigate(R.id.nav_graph_home)
        } else {
            findNavController().navigate(R.id.firstSettingFragment)
        }
    }

}