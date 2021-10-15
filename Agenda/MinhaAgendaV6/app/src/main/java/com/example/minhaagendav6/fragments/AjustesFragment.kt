package com.example.minhaagendav6.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.minhaagendav6.Agenda
import com.example.minhaagendav6.Contato
import com.example.minhaagendav6.databinding.FragmentAjustesBinding

class AjustesFragment: Fragment() {
    private var _binding: FragmentAjustesBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAjustesBinding.inflate(inflater, container, false)

        val config = requireActivity().getSharedPreferences("configuracoes", 0)

        binding.switch1.isChecked = config.getBoolean("listaContatosAlfabetico", false)

        binding.switch1.setOnCheckedChangeListener { compoundButton, b ->
            val editor = config.edit()
            editor.putBoolean("listaContatosAlfabetico", compoundButton.isChecked)
            editor.apply()
        }

        return binding.root
    }

}