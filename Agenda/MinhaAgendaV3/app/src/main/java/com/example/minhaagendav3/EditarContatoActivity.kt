package com.example.minhaagendav3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.minhaagendav3.databinding.ActivityEditarContatoBinding

class EditarContatoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditarContatoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditarContatoBinding.inflate(layoutInflater)

        setTitle("Editar Contato")

        val indiceContato = intent.getIntExtra("indiceContato", -1)

        val nome: String = Agenda.listaContatos[indiceContato].nome
        val telefone: String = Agenda.listaContatos[indiceContato].telefone
        binding.agendaTxtTelefone.setText(telefone)
        binding.agendaTxtNome.setText(nome)

        binding.agendaBtSalvar.setOnClickListener {
            Agenda.listaContatos[indiceContato].nome = binding.agendaTxtNome.text.toString()
            Agenda.listaContatos[indiceContato].telefone = binding.agendaTxtTelefone.text.toString()
            Toast.makeText(this, "Contato Salvo com Sucesso!", Toast.LENGTH_SHORT).show()
            finish()
        }

        setContentView(binding.root)
    }
}