package com.example.minhaagendav3

data class Contato(var nome: String, var telefone: String) {
    val id = getProximoId()

    companion object {
        var lastId = -1

        fun getProximoId(): Int {
            return lastId++
        }
    }
}