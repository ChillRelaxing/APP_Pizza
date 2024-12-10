package com.example.pizzaleo.ui.pizza

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.example.pizzaleo.R

class PizzaDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_detail)

        val pizzaImageView = findViewById<ImageView>(R.id.pizzaImageView)
        val pizzaNameTextView = findViewById<TextView>(R.id.pizzaNameTextView)
        val pizzaPriceTextView = findViewById<TextView>(R.id.pizzaPriceTextView)
        val pizzaDescriptionTextView = findViewById<TextView>(R.id.pizzaDescriptionTextView) // Nuevo TextView para la descripción


        // Obtiene los datos de la pizza desde el Intent y valida
        val pizzaName = intent.getStringExtra("PIZZA_NAME") ?: "Sin nombre"
        val pizzaPrice = intent.getDoubleExtra("PIZZA_PRICE", 0.0)
        val pizzaImageResId = intent.getIntExtra("PIZZA_IMAGE", R.drawable.ic_pizza_24dp)
        val pizzaDescription = intent.getStringExtra("PIZZA_DESCRIPTION") ?: "Sin descripción" // Nueva línea para la descripción


        pizzaNameTextView.text = pizzaName
        pizzaPriceTextView.text = "$$pizzaPrice"
        pizzaImageView.setImageResource(pizzaImageResId)

        pizzaDescriptionTextView.text = pizzaDescription // Mostrar la descripción

    }
}