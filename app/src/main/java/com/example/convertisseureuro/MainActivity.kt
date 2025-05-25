package com.example.convertisseureuro

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextEuro: EditText = findViewById(R.id.editTextEuro)
        val btnConvertir: Button = findViewById(R.id.btnConvertir)
        val textViewResultat: TextView = findViewById(R.id.textViewResultat)
        val listViewHistorique: ListView = findViewById(R.id.listViewHistorique)

        val data = mutableListOf<String>()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        listViewHistorique.adapter = adapter

        btnConvertir.setOnClickListener {
            val montant = editTextEuro.text.toString().toDoubleOrNull()
            if (montant != null) {
                val result = montant * 11
                val affichage = "%.2f € → %.2f DH".format(montant, result)
                textViewResultat.text = "Résultat : $result DH"
                data.add(affichage)
                adapter.notifyDataSetChanged()
                editTextEuro.text.clear()
            } else {
                Toast.makeText(this, "Veuillez entrer un montant valide", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
