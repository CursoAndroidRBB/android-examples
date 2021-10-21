package com.example.minhaagendav5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.minhaagendav5.databinding.ActivityEditarContatoBinding
import com.example.minhaagendav5.utils.IntentsConstants
import com.google.android.material.dialog.MaterialAlertDialogBuilder

/**
 * Classe EditarContatoActivity tela que abre ao apertar em EditarContatos, é chamada
 * a partir do Fragment ListaContatos
 *
 * Possui botão de salvar, deletar e marcar contato como favorito
 *
 * @author Rodrigo Barros Bernardino
 * <a href="mailto:rberna.contato@gmail.com">rberna.contato@gmail.com</a>
 */
class EditarContatoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditarContatoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditarContatoBinding.inflate(layoutInflater)

        setTitle(getString(R.string.editar_contato))

        val indiceContato = intent.getIntExtra(IntentsConstants.INT_INDICE_CONTATO, -1)

        val nome: String = Agenda.listaContatos[indiceContato].nome
        val telefone: String = Agenda.listaContatos[indiceContato].telefone
        binding.agendaTxtTelefone.setText(telefone)
        binding.agendaTxtNome.setText(nome)
        binding.switchContatoFavorito.isChecked = Agenda.listaContatos[indiceContato].favorito

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

        binding.switchContatoFavorito.setOnCheckedChangeListener { _, isChecked ->
            Agenda.listaContatos[indiceContato].favorito = isChecked
        }

        setContentView(binding.root)
    }
}