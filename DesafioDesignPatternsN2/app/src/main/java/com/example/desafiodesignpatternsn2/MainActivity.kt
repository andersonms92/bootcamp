package com.example.desafiodesignpatternsn2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     val button1: Button = findViewById(R.id.btn_esporte)
     val button2: Button = findViewById(R.id.btn_ciencia)
     val button3: Button = findViewById(R.id.btn_tecnologia)
     val button4: Button = findViewById(R.id.btn_turismo)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)

    }
    override fun onClick(view: View?) {
        val intent = Intent(this, ArticlesActivity::class.java)

        when(view?.id) {
            R.id.btn_esporte -> {
                intent.putExtra(ARTICLE_URL, "Esporte")
                startActivity(intent)
            }
            R.id.btn_ciencia -> {
                intent.putExtra(ARTICLE_URL, "Ciencia")
                startActivity(intent)
            }
            R.id.btn_tecnologia -> {
                intent.putExtra(ARTICLE_URL, "Tecnologia")
                startActivity(intent)
            }
            R.id.btn_turismo -> {
                intent.putExtra(ARTICLE_URL, "Turismo")
                startActivity(intent)
            }
        }
    }
}
