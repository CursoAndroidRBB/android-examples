package com.example.minhaagendav7.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.minhaagendav7.databinding.FragmentAjustesBinding
import com.example.minhaagendav7.enums.TipoOrdenacao
import com.example.minhaagendav7.model.Contato
import com.example.minhaagendav7.repository.room.AppDatabase
import com.example.minhaagendav7.utils.PrefsConstants
import org.jetbrains.anko.doAsync

/**
 * Classe AjustesFragment para ajustar as configurações do app
 *
 * Opções implementadas: tipo de ordenação da lista de contatos
 *
 * @author Rodrigo Barros Bernardino
 * <a href="mailto:rberna.contato@gmail.com">rberna.contato@gmail.com</a>
 */
class AjustesFragment : Fragment() {
    private var _binding: FragmentAjustesBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAjustesBinding.inflate(inflater, container, false)
        val view = binding.root

        val config = requireActivity().getSharedPreferences(PrefsConstants.FILE_CONFIGURACOES, 0)

        // descobre configuração atual de ordenação e marca RadioButton apropriado
        val ordenacaoSelecionada_str = config.getString(
            PrefsConstants.KEY_TIPO_ORDENACAO_CONTATOS,
            TipoOrdenacao.ORDEM_INSERCAO.toString()
        )
        val ordenacaoSelecionada: TipoOrdenacao = TipoOrdenacao.valueOf(ordenacaoSelecionada_str!!)
        when (ordenacaoSelecionada) {
            TipoOrdenacao.ALFABETICA_AZ -> binding.radioOrdenacaoAZ.isChecked = true
            TipoOrdenacao.ALFABETICA_ZA -> binding.radioOrdenacaoZA.isChecked = true
            TipoOrdenacao.ORDEM_INSERCAO -> binding.radioOrdenacaoInsercao.isChecked = true
        }

        binding.radioGroupOrdenacao.setOnCheckedChangeListener { _, checkedId ->
            var novoTipoOrdenacao = when (checkedId) {
                binding.radioOrdenacaoAZ.id -> TipoOrdenacao.ALFABETICA_AZ
                binding.radioOrdenacaoZA.id -> TipoOrdenacao.ALFABETICA_ZA
                binding.radioOrdenacaoInsercao.id -> TipoOrdenacao.ORDEM_INSERCAO
                else -> TipoOrdenacao.ORDEM_INSERCAO
                // Impossível o else ocorrer no nosso caso, pois colocamos todos os RadioButtons
            }

            val editor = config.edit()
            editor.putString(
                PrefsConstants.KEY_TIPO_ORDENACAO_CONTATOS,
                novoTipoOrdenacao.toString()
            )
            editor.apply()
        }

        binding.btAdicionarPadrao.setOnClickListener {
            doAsync {
                val db = AppDatabase.getDatabase(requireContext())
                LISTA_CONTATOS_PADRAO.forEach {
                    db.contatoDao().insert(it)
                }
            }
        }

        return view
    }

    companion object {
        val LISTA_CONTATOS_PADRAO = listOf(
            Contato(nome = "Genival Lima", telefone = "12345"),
            Contato(nome = "Luis Felipe INÁCIO", telefone = "12345"),
            Contato(nome = "Israel da Silva", telefone = "12345"),
            Contato(nome = "Vanessa Sobral", telefone = "33333"),
            Contato(nome = "José Augusto", telefone = "33333"),
            Contato(nome = "Pedro Henrique", telefone = "33333"),
            Contato(nome = "William Miguel", telefone = "12345"),
            Contato(nome = "Robert Luis", telefone = "12345"),
            Contato(nome = "Varlei Barbosa", telefone = "12345"),
            Contato(nome = "Sabrina de Souza", telefone = "12345"),
            Contato(nome = "Jéssica Rodrigues", telefone = "33333"),
            Contato(nome = "Ivan Carvalho", telefone = "12345"),
            Contato(nome = "Mario Mascarenhas", telefone = "33333"),
            Contato(nome = "MARIA CAROLINE", telefone = "12345"),
            Contato(nome = "RONEY JUNIOR", telefone = "12345"),
            Contato(nome = "Milena Dias", telefone = "12345"),
            Contato(nome = "Ecson Gama", telefone = "12345"),
            Contato(nome = "Maria Garcia", telefone = "33333"),
            Contato(nome = "RAIANE FERREIRA", telefone = "12345"),
            Contato(nome = "JAQUELINE LIMA", telefone = "12345"),
            Contato(nome = "Larissa Da Silva", telefone = "12345"),
            Contato(nome = "Erigeyce Gama", telefone = "12345"),
            Contato(nome = "Rodrigo Bernardino", telefone = "33333"),
            Contato(nome = "Narla Chagas", telefone = "12345"),
            Contato(nome = "Luiz Felipe de SOUZA", telefone = "12345"),
            Contato(nome = "Keitiane Nogueira", telefone = "12345"),
            Contato(nome = "Thalia de Souza", telefone = "12345"),
            Contato(nome = "José Santos", telefone = "33333"),
            Contato(nome = "Alex", telefone = "12345")
        )

    }
}