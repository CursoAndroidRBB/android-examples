package com.example.minhaagendav6.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.minhaagendav6.*
import com.example.minhaagendav6.databinding.FragmentListaContatosBinding

class ListaContatosFragment : Fragment() {
    private var _binding: FragmentListaContatosBinding? = null

    private val binding get() = _binding!!

    private lateinit var adapter: ContatosAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListaContatosBinding.inflate(inflater, container, false)

        adapter = ContatosAdapter(mutableListOf(), ::onBtEditarClick)

        binding.rvContatos.layoutManager = LinearLayoutManager(context)
        binding.rvContatos.adapter = adapter
        binding.rvContatos.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )

        carregaLista()

        initTopBar()

        return binding.root
    }

    private fun carregaLista() {
        val config = requireActivity().getSharedPreferences("configuracoes", 0)
        val listaOrdemAlfabetica = config.getBoolean("listaContatosAlfabetico", false)
        if(listaOrdemAlfabetica) {
            val listaOrdenada = Agenda.listaContatos.sortedBy { it.nome }
            adapter.swapData(listaOrdenada)
        } else {
            adapter.swapData(Agenda.listaContatos)
        }
    }

    private fun initTopBar() {
        binding.toolbarContatos.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search_top_bar -> {
                    val searchView = menuItem?.actionView as SearchView
                    searchView.queryHint = "Digite para pesquisar"

                    val listenerDigitacao = object : SearchView.OnQueryTextListener {
                        override fun onQueryTextChange(newText: String?): Boolean =
                            onQueryTextSubmit(newText) // vai buscar a cada letra digitada

                        override fun onQueryTextSubmit(query: String?): Boolean {
                            val queryLowerCase = query.toString().lowercase()

                            val listaFiltrada = Agenda.listaContatos.filter { contatoAtual ->
                                contatoAtual.nome.lowercase().contains(queryLowerCase) ||
                                        contatoAtual.telefone.lowercase().contains(queryLowerCase)
                            }

                            // forma tradicional com loops para explicar o que está ocorrendo acima
//                            val listaFiltrada = mutableListOf<Contato>()
//                            Agenda.listaContatos.forEach {
//                                val nomeLowerCase = it.nome.lowercase()
//                                val telefoneLowerCase = it.telefone.lowercase()
//
//                                if (nomeLowerCase.contains(queryLowerCase) ||
//                                    telefoneLowerCase.contains(queryLowerCase)) {
//                                    listaFiltrada.add(it)
//                                }
//                            }
                            adapter.swapData(listaFiltrada)
                            return true
                        }
                    }

                    searchView.setOnQueryTextListener(listenerDigitacao)

                    true
                }
                else -> false
            }
        }
    }

    override fun onResume() {
        super.onResume()
        carregaLista()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun onBtEditarClick(indiceLista: Int) {
        val intent = Intent(context, EditarContatoActivity::class.java)
        intent.putExtra("indiceContato", indiceLista)
        startActivity(intent)
    }

}