package com.example.minhaagendav2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.minhaagendav2.databinding.ItemContatoBinding

class ContatosAdapter(
    val listaContatos: MutableList<Contato>
    ) : RecyclerView.Adapter<ContatosAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemContatoBinding): RecyclerView.ViewHolder(binding.root)

    // Criar o layout, converter o XML "item_contato.xml" em um
    // objeto do Kotlin que possa ser manipulado e usado para compor
    // a lista na hora que o código rodar
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemContatoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
    }

    // função interna usada na hora que o RecyclerView precisa inserir
    // os itens na tela (ele conta pra saber quantos cabem)
    override fun getItemCount(): Int {
        return listaContatos.size
    }

    // depois que a View é criada usando o "onCreateViewHolder", ele preenche
    // com os dados do item sendo mostrado
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtNome.text = listaContatos[position].nome
        holder.binding.txtTelefone.text = listaContatos[position].telefone
    }

}