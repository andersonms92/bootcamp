package com.example.calculadoranotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.calculadoranotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnCalcular: Button = binding.buttonCalcular
        val txtResultado: TextView = binding.textMostrarResultado

        btnCalcular.setOnClickListener {
            val editNota1: Int = Integer.parseInt(binding.editNota1.text.toString())
            val editNota2: Int = Integer.parseInt(binding.editNota2.text.toString())
            val editFaltas: Int = Integer.parseInt(binding.editFaltas.text.toString())

            val media: Int = (editNota1 + editNota2) / 2

            if (media >= 6 && editFaltas <= 10) {
                txtResultado.setBackgroundColor(Color.GREEN)
                txtResultado.setText("Aprovado ${media}")
            }else{
                txtResultado.setBackgroundColor(Color.RED)
                txtResultado.setText("Reprovado ${media}")
            }
        }
    }
}













/* package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ListAgendaActivityBinding
import com.example.myapplication.ui.main.ListAgendaFragment

class list_agenda : Fragment(R.layout.list_agenda_activity) {

    private lateinit var binding: ListAgendaActivityBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ListAgendaActivityBinding.bind(view)

        val bundle: Bundle? = intent.extras

        if(bundle != null) {
            var lstContent = intent.getStringArrayExtra("A")

            var arrayAdapter: ArrayAdapter<*>
            var lstView = binding.listView

            arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lstContent)

            lstView.adapter = arrayAdapter

        }else{
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }


    fun clickVoltar(view: View) {
        val i = Intent(this, MainActivity::class.java)
        i.putExtra("A", "Vortei")
        i.putExtra("B", "Vortei2")
        startActivity(i)
    }
}

 */