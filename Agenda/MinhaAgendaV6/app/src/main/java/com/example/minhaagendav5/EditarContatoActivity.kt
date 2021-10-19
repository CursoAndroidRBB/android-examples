package com.example.minhaagendav5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.minhaagendav5.databinding.ActivityEditarContatoBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class EditarContatoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditarContatoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditarContatoBinding.inflate(layoutInflater)

        setTitle(getString(R.string.editar_contato))

        val indiceContato = intent.getIntExtra("indiceContato", -1)

        val nome: String = Agenda.listaContatos[indiceContato].nome
        val telefone: String = Agenda.listaContatos[indiceContato].telefone
        binding.agendaTxtTelefone.setText(telefone)
        binding.agendaTxtNome.setText(nome)

        binding.agendaBtSalvar.setOnClickListener {
            Agenda.listaContatos[indiceContato].nome = binding.agendaTxtNome.text.toString()
            Agenda.listaContatos[indiceContato].telefone = binding.agendaTxtTelefone.text.toString()
            Toast.makeText(this, getString(R.string.contato_salvo), Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.btDeletar.setOnClickListener {
            val dialog = MaterialAlertDialogBuilder(this)
                .setTitle(getString(R.string.deletar_contato))
                .setMessage(getString(R.string.realmente_deletar))
                .setNegativeButton(getString(R.string.cancelar), null)
                .setPositiveButton(getString(R.string.deletar)) { _, _ ->
                    Agenda.listaContatos.removeAt(indiceContato)
                    Toast.makeText(this, getString(R.string.contato_removido), Toast.LENGTH_SHORT).show()
                    finish()
                }
            dialog.show()
        }

        setContentView(binding.root)
    }
}