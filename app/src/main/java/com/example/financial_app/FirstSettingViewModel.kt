package com.example.financial_app

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.core.SharedPreference.SharedPreferenceManager
import com.example.core.database.DatabaseModule
import com.example.core.database.RepositoryModule
import com.example.core.database.entity.CurrencyEntity
import com.example.core.database.repository.CurrencyRepository

class FirstSettingViewModel(application: Application): AndroidViewModel(application) {

    private val currencyRepository: CurrencyRepository
    private var sharedPrefs: SharedPreferenceManager

    private val _loggedIn = MutableLiveData<Boolean>(false)
    val loggedIn: LiveData<Boolean> = _loggedIn

    init {
        val database = DatabaseModule.getDatabase(application.applicationContext)
        currencyRepository = RepositoryModule(database).provideCurrencyRepository()
        sharedPrefs = SharedPreferenceManager(application.applicationContext)
        _loggedIn.value = sharedPrefs.getLoggedIn()
    }

    fun saveLoggedIn(flag: Boolean) {
        _loggedIn.value = flag
        sharedPrefs.saveLoggedIn(flag)
    }

    fun saveUserName(name: String) {
        sharedPrefs.saveUserName(name)
    }

    suspend fun saveMainCurrency(symbol: String, code: String) {
        currencyRepository.insertCurrency(
            currency = CurrencyEntity(
                symbol = symbol,
                code = code
            )
        )
        sharedPrefs.saveMainCurrencyId(0)
    }
}