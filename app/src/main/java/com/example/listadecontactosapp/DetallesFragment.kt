package com.example.listadecontactosapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView



class DetallesFragment : Fragment() {

    //lateinit para decir que inicializo despues las variables

    private lateinit var nombre: TextView
    private lateinit var numero: TextView
    private lateinit var direccion: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_detalles, container, false)


        nombre = view.findViewById(R.id.tvNombreDescripcion)
        numero = view.findViewById(R.id.tvNumeroDescripcion)
        direccion = view.findViewById(R.id.tvDireccionDescripcion)

        nombre.text = "${arguments?.getString("nombre")}"
        direccion.text = "${arguments?.getString("direccion")}"
        numero.text = "${arguments?.getString("numero")}"

        return view
    }

}