package com.example.minhaagendav7.repository.room.dao

import androidx.room.*
import com.example.minhaagendav7.model.Contato
import com.example.minhaagendav7.repository.sqlite.COLUMN_ID
import com.example.minhaagendav7.repository.sqlite.TABLE_CONTATO

@Dao
interface ContatoDao {
    @Insert
    fun insert(obj: Contato): Long

    @Update
    fun update(obj: Contato)

    @Delete
    fun delete(obj: Contato)

    @Query("""SELECT * FROM $TABLE_CONTATO WHERE $COLUMN_ID = :id""")
    fun contatoById(id: Long): Contato

    @Query("""SELECT * FROM $TABLE_CONTATO""")
    fun getAllContatos(): List<Contato>
}