package com.camavilca.orlando.practicando;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.camavilca.orlando.practicando.utilidades.Utilidades;

public class Buscar extends AppCompatActivity {

    EditText bid;
    EditText bnom;
    EditText bubi;
    EditText btel;
    Conexion con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        bid = (EditText)findViewById(R.id.buscarid);
        bnom = (EditText)findViewById(R.id.buscarnombre);
        bubi = (EditText)findViewById(R.id.buscarubicacion);
        btel = (EditText)findViewById(R.id.buscatelefono);
        con = new Conexion(getApplicationContext(),"db_restaurantes",null,1);
    }

    public void Onclick(View view) {
        switch (view.getId()){
            case R.id.btnbuscar:
                consultar();
                break;
            case R.id.btnactualizar:
                break;
            case R.id.btneliminar:
                break;

        }
    }

    private void consultar() {
        SQLiteDatabase db = con.getReadableDatabase();
        String[] parametros = {bid.getText().toString()};
        String[] campos = {Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_UBICACION,Utilidades.CAMPO_TELEFONO};
        try {
            Cursor cursor = db.query(Utilidades.NOMBRE_TABLA,campos,Utilidades.CAMPO_ID+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            bnom.setText(cursor.getString(0));
            bubi.setText(cursor.getString(1));
            btel.setText(cursor.getString(2));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Los datos no Existen", Toast.LENGTH_LONG).show();
            limpiar();
        }

    }

    private void limpiar() {
        bnom.setText("");
        bid.setText("");
        bubi.setText("");
        btel.setText("");
    }
}
