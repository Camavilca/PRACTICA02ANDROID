package com.camavilca.orlando.practicando;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ejercicio1(View view) {
        Intent intent =  new Intent(MainActivity.this,Ejercicio1.class);
        startActivity(intent);
    }

    public void ejercicio2(View view) {
        Intent intent = new Intent(MainActivity.this,Ejercicio2.class);
        startActivity(intent);
    }

    public void ejercicio3(View view) {
        Intent intent = new Intent(MainActivity.this,Ejercicio3.class);
        startActivity(intent);
    }
}
