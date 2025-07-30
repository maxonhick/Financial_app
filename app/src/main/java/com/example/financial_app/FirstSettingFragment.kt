package com.example.financial_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.financial_app.databinding.FirstSettingFragmentBinding
import kotlinx.coroutines.launch

class FirstSettingFragment(): Fragment(R.layout.first_setting_fragment) {

    private lateinit var binding: FirstSettingFragmentBinding
    private val viewModel: FirstSettingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FirstSettingFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveButton.setOnClickListener {
            saveSettings()
        }
    }

    private fun saveSettings() {
        if (binding.editName.text.isEmpty() or binding.editCurrency.text.isEmpty() or
            binding.editShortCurrency.text.isEmpty() or (binding.editShortCurrency.text.length > 3)) {
            Toast.makeText(context,
                "Все поля должны быть заполнены. Проверьте корректность их заполнения",
                Toast.LENGTH_LONG).show()
        } else {
            viewModel.saveLoggedIn(true)
            viewModel.saveUserName(binding.editName.text.toString())
            lifecycleScope.launch {
                viewModel.saveMainCurrency(
                    symbol = binding.editShortCurrency.text.toString(),
                    code = binding.editCurrency.text.toString()
                )
            }
            findNavController().navigate(com.example.feature_home.R.id.nav_graph_home)
        }
    }
}