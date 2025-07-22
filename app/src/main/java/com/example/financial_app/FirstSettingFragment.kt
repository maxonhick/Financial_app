package com.example.financial_app

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.core.SharedPreference.SharedPreferenceManager

class FirstSettingFragment: Fragment(R.layout.first_setting_fragment) {

    private lateinit var sharedPrefs: SharedPreferenceManager

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPrefs = SharedPreferenceManager(context)
    }
}