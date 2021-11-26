package com.example.listadecontactosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //la vista completa de los contactos se infla con la pantalla Landscape

        val lista: Fragment = ListaFragment()

        supportFragmentManager.beginTransaction().replace(R.id.fragmentoLista,lista).commit()
    }
}