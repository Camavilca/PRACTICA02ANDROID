package com.camavilca.orlando.practicando;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ejercicio1 extends AppCompatActivity {

    Spinner dias;
    TextView estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);
        dias = (Spinner)findViewById(R.id.idSpinner);
        estado = (TextView)findViewById(R.id.estado);

        ArrayList<String> comboDiasList = new ArrayList<String>();
        comboDiasList.add("Seleccione:");
        comboDiasList.add("Lunes");
        comboDiasList.add("Martes");
        comboDiasList.add("Miercoles");
        comboDiasList.add("Jueves");
        comboDiasList.add("Viernes");
        comboDiasList.add("Sabado");
        comboDiasList.add("Domingo");

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,comboDiasList);

        dias.setAdapter(adapter);

        dias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapterView.getContext(),"Seleccionado: " + adapterView.getItemAtPosition(i).toString()
                        , Toast.LENGTH_LONG).show();
                estado.setText("Seleccionado: "+ adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
