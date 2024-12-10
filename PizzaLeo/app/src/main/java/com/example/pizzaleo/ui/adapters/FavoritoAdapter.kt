package com.example.pizzaleo.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaleo.R
import com.example.pizzaleo.ui.favorito.Favorito

class FavoritoAdapter(private val listaFavoritos: List<Favorito>) :
    RecyclerView.Adapter<FavoritoAdapter.FavoritoViewHolder>() {

    inner class FavoritoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageFavorito: ImageView = itemView.findViewById(R.id.imageFavorito)
        val nameTextView: TextView = itemView.findViewById(R.id.textFavoritoName)
        val priceTextView: TextView = itemView.findViewById(R.id.textFavoritoPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_favorito, parent, false)
        return FavoritoViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoritoViewHolder, position: Int) {
        val favorito = listaFavoritos[position]
        holder.nameTextView.text = favorito.name
        holder.priceTextView.text = "$${favorito.price}"
        holder.imageFavorito.setImageResource(favorito.imageResId)
    }

    override fun getItemCount(): Int {
        return listaFavoritos.size
    }
}
