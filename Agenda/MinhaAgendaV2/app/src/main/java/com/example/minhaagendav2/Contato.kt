package com.example.minhaagendav2

data class Contato(var nome: String, var telefone: String) {
    val id = getProximoId()

    // --------------
    // DESCOMENTAR
    override fun toString(): String {
        return "$nome ($telefone)"
    }

    // --------------
    // DESCOMENTAR (um ou outro)
//    override fun toString(): String {
//        return "$nome - $telefone"
//    }

    companion object {
        var lastId = -1

        fun getProximoId(): Int {
            return lastId++
        }
    }
}