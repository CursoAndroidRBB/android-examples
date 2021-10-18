package com.example.minhaagendav1

data class Contato(var nome: String, var telefone: String) {
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
}