package com.example.applicationnotification

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.annotation.RequiresApi
import com.google.firebase.iid.FirebaseInstanceId

class MainActivity : AppCompatActivity() {

    lateinit var btnSend: Button

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSend = findViewById(R.id.button_send_notification)
        btnSend.setOnClickListener{
            this.showNotification("1234", "bootcamp Android", "Kotlin Android curso")
        }

        Log.i("**newToken", FirebaseInstanceId.getInstance().token.toString())
    }
}