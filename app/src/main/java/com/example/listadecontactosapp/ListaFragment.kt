package com.example.listadecontactosapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    private lateinit var lista_de_Contactos: ArrayList<Contacto>
    private lateinit var adapter: AdapterContacto

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_lista, container, false)

        recyclerView = view.findViewById(R.id.recyclerView_Lista)   //instancio recycler y asigno el managerLayout
        recyclerView.layoutManager = LinearLayoutManager(context)

        lista_de_Contactos = arrayListOf(
            Contacto("Javier","29955245", "Villegas 745"),
            Contacto("Carolina","52685426", "Arenales 785"),
            Contacto("Luis","78512145", "Roca 145"),
            Contacto("Mariela","2998684525", "Suiza 568"),
            Contacto("Pedro","298655663", "San Maritin 7256"),

        )
        adapter= AdapterContacto(lista_de_Contactos)
        recyclerView.adapter=adapter

        adapter.setOnItemClickListener(object : AdapterContacto.OnItemClickListener {
            override fun onItemClick(
                position: Int,
                nombre: String,
                numero: String,
                direccion: String
            ) {
                val bundle = Bundle()
                bundle.putString("nombre", nombre)
                bundle.putString("numero", numero)
                bundle.putString("direccion", direccion)

                val detalleContacto= DetallesFragment()
                detalleContacto.arguments=bundle
               activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragDetallesContacto,detalleContacto)?.commit()
            }
        })

        return view
    }

}
