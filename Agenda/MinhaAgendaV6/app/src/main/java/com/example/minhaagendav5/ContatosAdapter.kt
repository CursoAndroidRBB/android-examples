package com.example.minhaagendav5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.minhaagendav5.databinding.ItemContatoBinding

/**
 * Classe ContatosAdapter para exibir cada contato usando um RecyclerView
 *
 * Cada um contém dois textos: nome e telefone, além de um botão para edição
 *
 * @property listaContatos a lista de contatos a ser montada no RecyclerView
 * @property onBtEditarClick a função a ser chamada quando o botão Editar for clicado
 *
 * @author Rodrigo Barros Bernardino
 * <a href="mailto:rberna.contato@gmail.com">rberna.contato@gmail.com</a>
 */
class ContatosAdapter(
    val listaContatos: MutableList<Contato>,
    val onBtEditarClick: (Int) -> Unit
    ) : RecyclerView.Adapter<ContatosAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemContatoBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemContatoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
    }

    override fun getItemCount(): Int {
        return listaContatos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtNome.text = listaContatos[position].nome
        holder.binding.txtTelefone.text = listaContatos[position].telefone
        
//        holder.binding.root.setOnClickListener {
//            onItemClick(position)
//        }
        
        holder.binding.btEditarContato.setOnClickListener {
            onBtEditarClick(position)
        }
    }

    fun swapData(novaListaContatos: List<Contato>){
        listaContatos.clear()
        listaContatos.addAll(novaListaContatos)
        notifyDataSetChanged()
    }
}