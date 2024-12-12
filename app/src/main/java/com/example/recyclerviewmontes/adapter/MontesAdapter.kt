package com.example.recyclerviewmontes.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewmontes.Montes
import com.example.recyclerviewmontes.R

class MontesAdapter(private val montes: List<Montes>) : RecyclerView.Adapter<MontesAdapter.MontesHolder>() {

    private var montesFiltrados: List<Montes> = montes

    // ViewHolder
    class MontesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgFoto: ImageView = itemView.findViewById(R.id.IvimgFoto)
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        val tvAltura: TextView = itemView.findViewById(R.id.tvAltura)
        val tvContinente: TextView = itemView.findViewById(R.id.tvContinente)
        val tvVerMas: TextView = itemView.findViewById(R.id.btnVerMas)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MontesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_montes, parent, false)
        return MontesHolder(view)
    }

    override fun onBindViewHolder(holder: MontesHolder, position: Int) {
        val monte = montesFiltrados[position]
        holder.tvNombre.text = monte.nombre
        holder.tvAltura.text = "Altura: ${monte.altura}"
        holder.tvContinente.text = "Continente: ${monte.continente}"

        Glide.with(holder.itemView.context)
            .load(monte.foto)
            .into(holder.imgFoto)

        holder.tvVerMas.setOnClickListener {
            val url = monte.foto
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            holder.itemView.context.startActivity(intent)
        } // Acción al hacer clic en "Ver Más"

    }

    override fun getItemCount(): Int = montesFiltrados.size

    // Función para filtrar los elementos
    fun filtrar(query: String) {
        montesFiltrados = if (query.isEmpty()) {
            montes // Mostrar todos los montes si no hay filtro
        } else {
            montes.filter {
                it.nombre.contains(query, ignoreCase = true) ||
                        it.continente.contains(query, ignoreCase = true)
            }
        }
        notifyDataSetChanged() // Notificar que los datos han cambiado
    }
}


