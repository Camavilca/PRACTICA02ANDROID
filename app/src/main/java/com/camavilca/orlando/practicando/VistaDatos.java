package com.camavilca.orlando.practicando;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.camavilca.orlando.practicando.modelo.Restaurantes;
import com.camavilca.orlando.practicando.utilidades.Utilidades;

import java.util.ArrayList;

public class VistaDatos extends AppCompatActivity {

    ArrayList<Restaurantes> restaurantesArrayList;
    RecyclerView recyclerView;

    Conexion con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_datos);

        con = new Conexion(getApplicationContext(), "restaurante",null,1);


        restaurantesArrayList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycleRestaurantes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        consultarListaRestaurante();

        Adaptador2 adaptador2 = new Adaptador2(restaurantesArrayList);
        recyclerView.setAdapter(adaptador2);

    }

    private void consultarListaRestaurante() {
        SQLiteDatabase db = con.getReadableDatabase();
        Restaurantes restaurantes = null;
        Cursor cursor = db.rawQuery("SELECT * FROM "+Utilidades.NOMBRE_TABLA,null);
        while(cursor.moveToNext()){
            restaurantes.setNombre(cursor.getString(0));
            restaurantes.setTelefono(cursor.getString(1));
            //restaurantes.setUbicacion(cursor.getString(3));
            restaurantesArrayList.add(restaurantes);
        }
    }
}
