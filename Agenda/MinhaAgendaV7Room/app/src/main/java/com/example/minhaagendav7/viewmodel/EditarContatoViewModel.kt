package com.example.minhaagendav7.viewmodel

import com.example.minhaagendav7.model.Contato
import com.example.minhaagendav7.repository.room.AppDatabase
import com.example.minhaagendav7.repository.room.ContatoRepository

class EditarContatoViewModel(database: AppDatabase) {
    private val contatoRepository = ContatoRepository(database)

    fun getContatoById(id: Long): Contato {
        return contatoRepository.contatoById(id)
    }

    fun saveContato(contato: Contato){
        contatoRepository.save(contato)
    }

    fun deleteContato(contato: Contato) {
        contatoRepository.delete(contato)
    }
}