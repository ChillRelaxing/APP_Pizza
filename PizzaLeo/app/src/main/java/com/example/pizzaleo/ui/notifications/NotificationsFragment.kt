package com.example.pizzaleo.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pizzaleo.R
import com.example.pizzaleo.databinding.FragmentNotificationsBinding
import com.example.pizzaleo.ui.adapters.EnsaladaAdapter
import com.example.pizzaleo.ui.ensalada.Ensalada

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Lista de ensaladas de ejemplo
        val listaEnsaladas = listOf(
            Ensalada("Ensalada César", 8.99, R.drawable.ensalada_cesar),
            Ensalada("Ensalada Griega", 7.99, R.drawable.ensalada_griega),
            Ensalada("Ensalada de Atún", 9.99, R.drawable.ensalada_atun),
            Ensalada("Ensalada de Pollo", 10.99, R.drawable.ensalada_pollo),
            Ensalada("Ensalada de Quinoa", 11.49, R.drawable.ensalada_quinoa),
            Ensalada("Ensalada Caprese", 9.49, R.drawable.ensalada_caprese),
            Ensalada("Ensalada de Frutas", 6.99, R.drawable.ensalada_frutas),
            Ensalada("Ensalada de Espinacas", 8.49, R.drawable.ensalada_espinacas)
        )

        // Configuración del RecyclerView
        val recyclerView = binding.recyclerViewEnsaladas
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = EnsaladaAdapter(listaEnsaladas)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
