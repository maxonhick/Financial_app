package com.example.core.SharedPreference

import android.content.Context
import android.content.SharedPreferences
import android.icu.util.Currency
import androidx.core.content.edit

class SharedPreferenceManager (private val context: Context) {

    companion object {
        const val PREFERENCE_NAME = "app_preference"
        const val MAIN_CURRENCY = "currency"
        const val USER_NAME = "user_name"
        const val IS_LOGGED_IN = "is_logged_in"
    }

    private val sharedPref: SharedPreferences = context.getSharedPreferences(
        PREFERENCE_NAME,
        Context.MODE_PRIVATE
    )

    fun saveUserName(name: String) {
        sharedPref.edit {
            putString(USER_NAME, name)
        }
    }

    fun saveMainCurrencyId(currency: Int) {
        sharedPref.edit {
            putInt(MAIN_CURRENCY, currency)
        }
    }

    fun saveLoggedIn(isLoggedIn: Boolean) {
        sharedPref.edit {
            putBoolean(IS_LOGGED_IN, isLoggedIn)
        }
    }

    fun getLoggedIn(): Boolean {
        return sharedPref.getBoolean(IS_LOGGED_IN, false)
    }

    fun getUserName(): String? {
        return sharedPref.getString(USER_NAME, null)
    }

    fun getMainCurrencyID(): String? {
        return sharedPref.getString(MAIN_CURRENCY, null)
    }

}