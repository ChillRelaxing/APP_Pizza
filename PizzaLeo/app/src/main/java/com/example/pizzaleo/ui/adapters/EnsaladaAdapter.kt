package com.example.pizzaleo.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaleo.R
import com.example.pizzaleo.ui.ensalada.Ensalada

class EnsaladaAdapter(private val ensaladas: List<Ensalada>) : RecyclerView.Adapter<EnsaladaAdapter.EnsaladaViewHolder>() {

    class EnsaladaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageEnsalada: ImageView = view.findViewById(R.id.imageEnsalada)
        val textEnsaladaName: TextView = view.findViewById(R.id.textEnsaladaName)
        val textEnsaladaPrice: TextView = view.findViewById(R.id.textEnsaladaPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EnsaladaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ensalada, parent, false)
        return EnsaladaViewHolder(view)
    }

    override fun onBindViewHolder(holder: EnsaladaViewHolder, position: Int) {
        val ensalada = ensaladas[position]
        holder.imageEnsalada.setImageResource(ensalada.imageResId)
        holder.textEnsaladaName.text = ensalada.name
        holder.textEnsaladaPrice.text = "$${ensalada.price}"
    }

    override fun getItemCount() = ensaladas.size
}
