package com.example.minhaagendav1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.minhaagendav1.databinding.ActivityTelaInicialBinding

class TelaInicialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTelaInicialBinding

    private var indiceAtual = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaInicialBinding.inflate(layoutInflater)

        Agenda.listaContatos.add(Contato("Rodrigo", "1111"))
        Agenda.listaContatos.add(Contato("João", "22222"))
        Agenda.listaContatos.add(Contato("Maria", "33333"))

        binding.btEditarContato.setOnClickListener {
            val intent = Intent(this, EditarContatoActivity::class.java)
            if(Agenda.listaContatos.size == 0) {
                Toast.makeText(this, "Agenda vazia!", Toast.LENGTH_SHORT).show()
            } else {
                intent.putExtra("indiceContato", indiceAtual)
                startActivity(intent)
            }
        }

        binding.agendaBtImprimirProx.setOnClickListener {
            if (Agenda.listaContatos.size != 0) {
                indiceAtual = getProximoIndice()
                atualizaContatoExibido()
            } else {
                setTxtAviso("Agenda vazia!", COR_LARANJA)
            }
        }

        binding.btVerTodos.setOnClickListener {

        }

        setContentView(binding.root)
    }

    // --------------
    // DESCOMENTAR
//    override fun onResume() {
//        super.onResume()
//        atualizaContatoExibido()
//    }
    // --------------

    fun atualizaContatoExibido() {
        if (Agenda.listaContatos.size != 0) {
            val contatoAtual = Agenda.listaContatos[indiceAtual]
            val novoTexto = """
                    Nome: ${contatoAtual.nome}
                    Telefone: ${contatoAtual.telefone}
                """.trimIndent()
            binding.agendaTxtMostrarContato.text = novoTexto
        } else {
            binding.agendaTxtMostrarContato.text = ""
        }
    }

    fun getProximoIndice(): Int {
        if(Agenda.listaContatos.size == 0)
            throw Error("Lista de contatos vazia! Use temContato antes de chamar isso")

        if(indiceAtual + 1 == Agenda.listaContatos.size)
            return 0
        else
            return indiceAtual + 1
    }

    fun setTxtAviso(mensagem: String, cor: Int) {
        binding.agendaTxtAvisos.text = mensagem
        binding.agendaTxtAvisos.setTextColor(cor)
    }

    companion object {
        val COR_LARANJA = Color.rgb(214, 127, 0)
//        val COR_VERDE = Color.rgb(5, 128, 8)
    }
}