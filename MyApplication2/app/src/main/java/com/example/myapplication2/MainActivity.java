package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
      
        TextView txtView = (TextView) findViewById(R.id.textView2);
        Button btnIr = (Button) findViewById(R.id.buttonIr);

        String string = getIntent().getStringExtra("A");

        txtView.setText(string);

    }

    public void btnIr(View view) {
        Intent i = new Intent(this, SegundaActivity.class);
        startActivity(i);
    }
}