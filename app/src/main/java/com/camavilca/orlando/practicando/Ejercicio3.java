package com.camavilca.orlando.practicando;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Ejercicio3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);

        Conexion con = new Conexion(this,"db_restaurantes",null,1);
    }

    public void onclick(View view) {
        switch (view.getId()){
            case R.id.btninsertar:
                Intent intent = new Intent(Ejercicio3.this,Insertar.class);
                startActivity(intent);
                break;
            case R.id.btnconsultar:
                Intent intent1 = new Intent(Ejercicio3.this,Buscar.class);
                startActivity(intent1);
                break;
        }
    }
}
