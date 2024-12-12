package com.example.recyclerviewmontes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerviewmontes.databinding.ActivityAddMonteBinding


class AddMonte : AppCompatActivity() {

    private lateinit var binding: ActivityAddMonteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMonteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGuardar.setOnClickListener {
            val nombre = binding.etNombre.text.toString()
            val altura = binding.etAltura.text.toString()
            val continente = binding.etContinente.text.toString()
            val foto = binding.etFoto.text.toString()



            val nuevoMonte = Montes(nombre, altura, continente, foto)

            val resultIntent = Intent()
            resultIntent.putExtra("nuevoMonte", nuevoMonte)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
