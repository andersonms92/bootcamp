package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Button btnBack = (Button) findViewById(R.id.buttonVoltar);
        TextView txtView = (TextView) findViewById(R.id.textView);

    }

    public void btnVoltar(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("A", "Voltei");
        startActivity(i);
    }
}