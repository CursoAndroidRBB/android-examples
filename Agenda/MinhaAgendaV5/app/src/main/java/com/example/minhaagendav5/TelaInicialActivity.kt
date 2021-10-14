package com.example.minhaagendav5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.minhaagendav5.databinding.ActivityTelaInicialBinding
import com.example.minhaagendav5.fragments.AjustesFragment
import com.example.minhaagendav5.fragments.ListaContatosFragment

class TelaInicialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTelaInicialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaInicialBinding.inflate(layoutInflater)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, ListaContatosFragment())
            .commit()

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.ic_home -> {
                    loadFragments(ListaContatosFragment(), FRAGMENT_HOME)
                    true
                }
                R.id.ic_ajustes -> {
                    loadFragments(AjustesFragment(), FRAGMENT_AJUSTES)
                    true
                }
                else ->
                    false
            }
        }

        setContentView(binding.root)
    }

    //Carrega os fragments e os empilha
    private fun loadFragments(fragment: Fragment, tag: String){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment, tag)
            commit()
        }
    }

    companion object {
        private const val FRAGMENT_HOME = "FRAGMENT_HOME"
        private const val FRAGMENT_AJUSTES = "FRAGMENT_AJUSTES"
    }
}