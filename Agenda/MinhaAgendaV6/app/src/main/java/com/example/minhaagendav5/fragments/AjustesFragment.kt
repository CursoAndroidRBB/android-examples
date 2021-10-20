package com.example.minhaagendav5.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.minhaagendav5.R
import com.example.minhaagendav5.databinding.FragmentAjustesBinding

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

        binding.radioGroupOrdenacao.setOnCheckedChangeListener { _, checkedId ->
            val editor = config.edit()
            editor.putInt("ordenacaoContatos", checkedId)
            editor.apply()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val config = requireActivity().getSharedPreferences("configuracoes", 0)

        val radioOrdenacaoSelecionada_id = config.getInt("ordenacaoContatos", R.id.radioOrdenacaoInsercao)
        val radioOrdenacaoSelecionada_view = requireView().findViewById<RadioButton>(radioOrdenacaoSelecionada_id)

        radioOrdenacaoSelecionada_view.isChecked = true
    }

}