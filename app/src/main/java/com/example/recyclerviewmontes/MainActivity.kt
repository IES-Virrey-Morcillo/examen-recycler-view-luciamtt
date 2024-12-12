package com.example.recyclerviewmontes

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewmontes.adapter.MontesAdapter
import com.example.recyclerviewmontes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var montesAdapter: MontesAdapter

    // Llamada para abrir la actividad para agregar un nuevo monte
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val nuevoMonte = result.data?.getSerializableExtra("nuevoMonte") as Montes
            // Agregar el nuevo monte a la lista y actualizar el RecyclerView
            val updatedList = MontesProvider.montesList.toMutableList()
            updatedList.add(nuevoMonte)
            montesAdapter = MontesAdapter(updatedList)
            binding.recyclerView.adapter = montesAdapter
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuración del RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        montesAdapter = MontesAdapter(MontesProvider.montesList)
        binding.recyclerView.adapter = montesAdapter

        // Configuración del SearchView
        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Puedes realizar alguna acción cuando el usuario envíe la consulta
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Filtrar los elementos del RecyclerView cuando el texto cambie
                montesAdapter.filtrar(newText ?: "")
                return true
            }
        })

        // Configuración del botón "Agregar Monte"
        binding.btnAdd.setOnClickListener {
            // Abrir nueva actividad para agregar un monte
            val intent = Intent(this, AddMonte::class.java)
            startForResult.launch(intent)
        }
    }
}
