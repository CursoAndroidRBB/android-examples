package com.example.minhaagendav5

/**
 * Classe Contato para armazenar informações de contatos, é a parte do conjunto "lista de contatos"
 *
 *
 * @property nome o nome do contato
 * @property telefone o telefone do contato
 * @property favorito indica se é um contato favorito ou não
 *
 * @author Rodrigo Barros Bernardino
 * <a href="mailto:rberna.contato@gmail.com">rberna.contato@gmail.com</a>
 */
data class Contato(var nome: String, var telefone: String, var favorito: Boolean = false) {
    val id = getProximoId()

    override fun toString(): String {
        return super.toString()
    }

    companion object {
        var lastId = -1

        fun getProximoId(): Int {
            return lastId++
        }
    }
}