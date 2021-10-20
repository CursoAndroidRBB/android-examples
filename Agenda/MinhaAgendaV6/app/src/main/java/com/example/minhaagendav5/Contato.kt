package com.example.minhaagendav5

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