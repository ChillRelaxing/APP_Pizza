package com.example.pizzaleo.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzaleo.R
import com.example.pizzaleo.databinding.FragmentDashboardBinding
import com.example.pizzaleo.ui.adapters.FavoritoAdapter
import com.example.pizzaleo.ui.favorito.Favorito

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Lista de comidas favoritas
        val listaFavoritos = listOf(
            Favorito("Birria", 9.99, R.drawable.birria),
            Favorito("Burritos", 5.99, R.drawable.burritos),
            Favorito("Costillas a la BBQ", 14.99, R.drawable.costillas),
            Favorito("Enchiladas", 10.99, R.drawable.enchilada),
            Favorito("Hamburguesa con Queso", 6.49, R.drawable.hamburguesa),
            Favorito("Palitos", 8.99, R.drawable.palitos),
            Favorito("Quesadilla de queso", 7.99, R.drawable.quesadilla),
            Favorito("Tacos de Carne", 9.49, R.drawable.tacos)
        )

        // Configuración del RecyclerView
        val recyclerView = binding.recyclerViewFavoritos
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = FavoritoAdapter(listaFavoritos)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
