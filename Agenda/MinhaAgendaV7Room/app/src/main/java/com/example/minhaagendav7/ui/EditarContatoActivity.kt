package com.example.minhaagendav7.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.minhaagendav7.R
import com.example.minhaagendav7.databinding.ActivityEditarContatoBinding
import com.example.minhaagendav7.repository.room.AppDatabase
import com.example.minhaagendav7.utils.IntentsConstants
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

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
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditarContatoBinding.inflate(layoutInflater)

        setTitle(getString(R.string.editar_contato))

        val idContato = intent.getLongExtra(IntentsConstants.INT_ID_CONTATO, -1)

        doAsync {
            db = AppDatabase.getDatabase(this@EditarContatoActivity)
            val contato = db.contatoDao().contatoById(idContato)

            uiThread {
                val nome: String = contato.nome
                val telefone: String = contato.telefone
                binding.agendaTxtTelefone.setText(telefone)
                binding.agendaTxtNome.setText(nome)
                binding.switchContatoFavorito.isChecked = contato.favorito

                binding.agendaBtSalvar.setOnClickListener {
                    contato.nome = binding.agendaTxtNome.text.toString()
                    contato.telefone = binding.agendaTxtTelefone.text.toString()
                    doAsync {
                        db.contatoDao().update(contato)
                        uiThread {
                            Toast.makeText(this@EditarContatoActivity, getString(R.string.contato_salvo), Toast.LENGTH_SHORT).show()
                            finish()
                        }
                    }
                }

                binding.btDeletar.setOnClickListener {
                    val dialog = MaterialAlertDialogBuilder(this@EditarContatoActivity)
                        .setTitle(getString(R.string.deletar_contato))
                        .setMessage(getString(R.string.realmente_deletar))
                        .setNegativeButton(getString(R.string.cancelar), null)
                        .setPositiveButton(getString(R.string.deletar)) { _, _ ->
                            doAsync {
                                db.contatoDao().delete(contato)
                                uiThread {
                                    Toast.makeText(this@EditarContatoActivity, getString(R.string.contato_removido), Toast.LENGTH_SHORT).show()
                                    finish()
                                }
                            }
                        }
                    dialog.show()
                }

                binding.switchContatoFavorito.setOnCheckedChangeListener { _, isChecked ->
                    contato.favorito = isChecked
                    doAsync {
                        db.contatoDao()
                    }
                }
            }
        }

        setContentView(binding.root)
    }
}