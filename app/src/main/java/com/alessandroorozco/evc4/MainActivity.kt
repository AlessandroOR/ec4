package com.alessandroorozco.evc4

import Fragments.FavoritosFragment
import Fragments.InfoFragment
import Fragments.ListaFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(navItemSelectedListener)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ListaFragment())
            .commit()
    }

    private val navItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val selectedFragment: Fragment = when (item.itemId) {
                R.id.action_lista -> ListaFragment()
                R.id.action_favoritos -> FavoritosFragment()
                R.id.action_info -> InfoFragment()
                else -> ListaFragment()
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, selectedFragment)
                .commit()
            true
        }
}