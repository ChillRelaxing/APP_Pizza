package com.example.pizzaleo.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzaleo.R
import com.example.pizzaleo.databinding.FragmentHomeBinding
import com.example.pizzaleo.ui.adapters.PizzaAdapter
import com.example.pizzaleo.ui.pizza.Pizza
import com.example.pizzaleo.ui.pizza.PizzaDetailActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Lista de ejemplo de pizzas
        val pizzaList = listOf(
            Pizza("Margherita", 8.99, R.drawable.margherita, "Tomate, mozzarella y albahaca fresca"),
            Pizza("Pepperoni", 9.99, R.drawable.pepperoni, "Pepperoni, queso mozzarella y salsa de tomate"),
            Pizza("Hawaiian", 10.99, R.drawable.hawaiian, "Jamón, piña y queso mozzarella"),
            Pizza("Vegetariana", 9.49, R.drawable.vegetariana, "Pimientos, cebolla, champiñones y aceitunas"),
            Pizza("Cuatro Quesos", 11.99, R.drawable.cuatro_quesos, "Mozzarella, gorgonzola, parmesano y queso de cabra"),
            Pizza("BBQ Chicken", 10.49, R.drawable.bbq_chicken, "Pollo, salsa BBQ, cebolla roja y cilantro"),
            Pizza("Carbonara", 12.49, R.drawable.carbonara, "Salsa blanca, bacon, huevo y queso parmesano"),
            Pizza("Mediterránea", 11.49, R.drawable.mediterranea, "Aceitunas, alcachofas, espinacas y queso feta")

        )


        // Configura el RecyclerView
        binding.recyclerViewPizzas.layoutManager = GridLayoutManager(context, 2)

        binding.recyclerViewPizzas.adapter = PizzaAdapter(pizzaList) { pizza ->
            // Crea el Intent para abrir PizzaDetailActivity
            val intent = Intent(requireContext(), PizzaDetailActivity::class.java)
            intent.putExtra("PIZZA_NAME", pizza.name)
            intent.putExtra("PIZZA_PRICE", pizza.price)
            intent.putExtra("PIZZA_IMAGE", pizza.imageResId)
            intent.putExtra("PIZZA_DESCRIPTION", pizza.description)
            startActivity(intent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
