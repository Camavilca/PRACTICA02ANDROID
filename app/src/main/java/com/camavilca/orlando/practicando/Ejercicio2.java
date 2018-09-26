package com.camavilca.orlando.practicando;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ejercicio2 extends AppCompatActivity {

    ListView listView;
    TextView res;
    EditText ingre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);
        listView = (ListView)findViewById(R.id.listView);
        res = (TextView)findViewById(R.id.resultado);
        ingre = (EditText)findViewById(R.id.ingresa);
        /*
         //SE REALIZO USANDO UN ARCHIVO XML COMO RECURSO

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,R.array.combo_dias,android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapterView.getContext(),"Seleccionaste :"+listView.getItemAtPosition(i).toString(),Toast.LENGTH_LONG).show();
            }
        });*/

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("orlando");
        arrayList.add("camavilca");
        arrayList.add("chavez");
        arrayList.add("diaz");
        arrayList.add("victoria");
        arrayList.add("alania");
        arrayList.add("fortunato");

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapterView.getContext(),"Seleccionaste :"+listView.getItemAtPosition(i).toString(),Toast.LENGTH_LONG).show();
                res.setText("SELECCIONASTE: "+listView.getItemAtPosition(i).toString());
            }
        });

    }
}
