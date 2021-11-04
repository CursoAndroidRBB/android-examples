package com.example.minhaagendav7.viewmodel

import com.example.minhaagendav7.model.Contato
import com.example.minhaagendav7.repository.room.AppDatabase
import com.example.minhaagendav7.repository.room.ContatoRepository

class ListaContatosViewModel(appDatabase: AppDatabase) {
    private val contatoRepository = ContatoRepository(appDatabase)

    fun getAllContatos(): List<Contato> {
        return contatoRepository.getAllContatos()
    }
}