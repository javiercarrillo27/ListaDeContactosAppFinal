package com.example.listadecontactosapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//toma los datos de las listas y genera
// myViewHolder es el que optiene la referencia del lo que vamos ingresando
class AdapterContacto(private val lista_de_Contacto: List<Contacto>) :
    RecyclerView.Adapter<AdapterContacto.AdapterContactoHolder>() {

    //declaro el click para seleccionar la informacion y mandar a otro contacto
    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {
        //Al hacer click pasamos esta informacion al otro fragmento
        fun onItemClick(
            position: Int,
            nombre: String,
            numero: String,
            direccion: String
        )
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterContactoHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_contacto, parent, false)
        return AdapterContactoHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: AdapterContactoHolder, position: Int) {
        val contacto: Contacto = lista_de_Contacto[position]

        holder.nombre.text = contacto.nombre
        holder.numero.text = contacto.numero
        holder.direccion.text = contacto.direccion

    }
    // retorna la cantidad de elementos que tenemos en liste
    override fun getItemCount(): Int {
        return lista_de_Contacto.size
    }


    class AdapterContactoHolder(itemView: View, listener: OnItemClickListener) :    //envia la vista que pasa por viewHolder
        RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.nombreContacto)
        val numero: TextView = itemView.findViewById(R.id.numeroContacto)
        val direccion: TextView = itemView.findViewById(R.id.direccionContacto)

        //Cargo los datos en el listener para tenerlos listos para pasar con el click
        init {

            itemView.setOnClickListener {

                listener.onItemClick (
                    bindingAdapterPosition,
                    nombre.text.toString(),
                    numero.text.toString(),
                    direccion.text.toString(),
                )

            }
        }
    }

}
