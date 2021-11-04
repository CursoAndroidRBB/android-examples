package com.example.minhaagendav7.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.minhaagendav7.repository.sqlite.*

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
@Entity(tableName = TABLE_CONTATO)
data class Contato (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID) var id: Long = 0,
    @ColumnInfo(name = COLUMN_NOME) var nome: String = "",
    @ColumnInfo(name = COLUMN_TELEFONE) var telefone: String = "",
    @ColumnInfo(name = COLUMN_FAVORITO) var favorito: Boolean = false
)