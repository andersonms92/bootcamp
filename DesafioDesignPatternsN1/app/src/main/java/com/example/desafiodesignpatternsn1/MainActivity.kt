package com.example.desafiodesignpatternsn1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.desafiodesignpatternsn1.cpfcnpj.CpfCnpj
import com.example.desafiodesignpatternsn1.verificacao.ValidadorFactory

class MainActivity : AppCompatActivity() {

    private lateinit var cpfCnpj: CpfCnpj

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val et_cpf_cnpj: EditText =  findViewById(R.id.et_CpfCnpj)
        val btn_verificar: Button = findViewById(R.id.btn_verificar)
        val tv_resultado: TextView = findViewById(R.id.tv_resultado)

        cpfCnpj = CpfCnpj(ValidadorFactory())

        btn_verificar.setOnClickListener{
            if (cpfCnpj.isValid(et_cpf_cnpj.text.toString())) {
                tv_resultado.text = "Válido"
            } else {
                tv_resultado.text = "Inválido"
            }
        }

    }
}