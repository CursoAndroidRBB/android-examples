package com.example.minhaagendav2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.minhaagendav2.databinding.ActivityTelaInicialBinding

class TelaInicialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTelaInicialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaInicialBinding.inflate(layoutInflater)

        incializaLista()

        binding.rvContatos.layoutManager = LinearLayoutManager(this)
        binding.rvContatos.adapter = ContatosAdapter(Agenda.listaContatos)
        binding.rvContatos.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        setContentView(binding.root)
    }

    private fun incializaLista() {
        Agenda.listaContatos.addAll(
            listOf(
                Contato("1 Rodrigo", "1111"),
                Contato("2 João", "22222"),
                Contato("3 Maria", "33333"),
                Contato("4 Maria", "33333"),
                Contato("5 Maria", "33333"),
                Contato("6 Maria", "33333"),
                Contato("7 Maria", "33333"),
                Contato("8 Maria", "33333"),
                Contato("9 Maria", "33333"),
                Contato("10 Maria", "33333"),
                Contato("11 Maria", "33333"),
                Contato("12 Maria", "33333"),
                Contato("13 Maria", "33333"),
                Contato("14 Maria", "33333"),
                Contato("15 Maria", "33333"),
                Contato("16 Maria", "33333"),
                Contato("17 Maria", "33333"),
                Contato("18 Maria", "33333")
            )
        )
    }
}