package com.example.todoapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todoapp1.databinding.ActivityTelaInicialBinding
import com.example.todoapp1.ex1Simples.ListViewSimplesActivity

class TelaInicialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTelaInicialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaInicialBinding.inflate(layoutInflater)

        binding.btListViewSimples.setOnClickListener {
            val intent = Intent(this, ListViewSimplesActivity::class.java)
            startActivity(intent)
        }

        binding.btRecyclerViewSimples.setOnClickListener {
            Toast.makeText(this, resources.getString(R.string.implementar_depois), Toast.LENGTH_SHORT).show()
        }
        
        binding.btRecyclerViewCheckbox.setOnClickListener {
            Toast.makeText(this, resources.getString(R.string.implementar_depois), Toast.LENGTH_SHORT).show()
        }
        
        setContentView(binding.root)
    }
}