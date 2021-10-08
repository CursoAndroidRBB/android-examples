package com.example.minhaagendav2

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.minhaagendav2.databinding.ActivityTelaInicialBinding

class TelaInicialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTelaInicialBinding

    private lateinit var adapter: ArrayAdapter<Contato>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaInicialBinding.inflate(layoutInflater)

        Agenda.listaContatos.add(Contato("1 Rodrigo", "1111"))
        Agenda.listaContatos.add(Contato("2 João", "22222"))
        Agenda.listaContatos.add(Contato("3 Maria", "33333"))
        Agenda.listaContatos.add(Contato("4 Maria", "33333"))
        Agenda.listaContatos.add(Contato("5 Maria", "33333"))
        Agenda.listaContatos.add(Contato("6 Maria", "33333"))
        Agenda.listaContatos.add(Contato("7 Maria", "33333"))
        Agenda.listaContatos.add(Contato("8 Maria", "33333"))
        Agenda.listaContatos.add(Contato("9 Maria", "33333"))
        Agenda.listaContatos.add(Contato("10 Maria", "33333"))
        Agenda.listaContatos.add(Contato("11 Maria", "33333"))
        Agenda.listaContatos.add(Contato("12 Maria", "33333"))
        Agenda.listaContatos.add(Contato("13 Maria", "33333"))
        Agenda.listaContatos.add(Contato("14 Maria", "33333"))
        Agenda.listaContatos.add(Contato("15 Maria", "33333"))
        Agenda.listaContatos.add(Contato("16 Maria", "33333"))
        Agenda.listaContatos.add(Contato("17 Maria", "33333"))
        Agenda.listaContatos.add(Contato("18 Maria", "33333"))

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, Agenda.listaContatos)
        binding.lvContatos.adapter = adapter
        binding.lvContatos.setOnItemClickListener { parent, view, position, id ->
//            val contato = adapter.getItem(position) // obtém o contato se quiser fazer algo com ele
//            Toast.makeText(this, "${contato!!.nome}", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, EditarContatoActivity::class.java)
            intent.putExtra("indiceContato", position)
            startActivity(intent)
        }

        setContentView(binding.root)
    }

    // --------------
    // DESCOMENTAR
    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
    // --------------
}