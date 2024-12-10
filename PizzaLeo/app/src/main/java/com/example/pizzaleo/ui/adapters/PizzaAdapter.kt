package com.example.pizzaleo.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaleo.R
import com.example.pizzaleo.ui.pizza.Pizza

class PizzaAdapter(private val pizzaList: List<Pizza>, private val onPizzaClick: (Pizza) -> Unit) :
    RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder>() {

    inner class PizzaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pizzaImage: ImageView = itemView.findViewById(R.id.imagePizza)
        val pizzaName: TextView = itemView.findViewById(R.id.textPizzaName)
        val pizzaPrice: TextView = itemView.findViewById(R.id.textPizzaPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pizza, parent, false)
        return PizzaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val pizza = pizzaList[position]
        holder.pizzaName.text = pizza.name
        holder.pizzaPrice.text = "$${pizza.price}"
        holder.pizzaImage.setImageResource(pizza.imageResId)

        // Configura el clic para abrir PizzaDetailActivity
        holder.itemView.setOnClickListener {
            onPizzaClick(pizza)
        }
    }

    override fun getItemCount(): Int = pizzaList.size
}
