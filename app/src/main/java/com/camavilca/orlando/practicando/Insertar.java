package com.camavilca.orlando.practicando;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.camavilca.orlando.practicando.utilidades.Utilidades;

public class Insertar extends AppCompatActivity {

    EditText id;
    EditText nom;
    EditText ubi;
    EditText tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);
        id = (EditText)findViewById(R.id.textid);
        nom = (EditText)findViewById(R.id.textnombre);
        ubi = (EditText)findViewById(R.id.textubicacion);
        tel = (EditText)findViewById(R.id.texttelefono);
    }

    public void Onclick(View view) {
        switch (view.getId()){
            case R.id.btnguardar:
                //registrarUsuario();
                registrarUsuarioSQL();
                break;
            case  R.id.btnatras:
                Intent intent = new Intent(Insertar.this,Ejercicio3.class);
                startActivity(intent);

        }
    }

    private void registrarUsuarioSQL() {
        Conexion con = new Conexion(this,"db_restaurantes",null,1);
        SQLiteDatabase bd = con.getWritableDatabase();

        String insert = "INSERT INTO "+Utilidades.NOMBRE_TABLA+"" +
                "("+Utilidades.CAMPO_ID+","+Utilidades.CAMPO_NOMBRE+"," +
                ""+Utilidades.CAMPO_UBICACION+","+Utilidades.CAMPO_TELEFONO+") " +
                "VALUES ("+id.getText().toString()+",'"+nom.getText().toString()+"','"+ubi.getText().toString()+"','"+tel.getText().toString()+"')";
        bd.execSQL(insert);
        Toast.makeText(this,"INGRESO EXITO",Toast.LENGTH_LONG).show();
        limpiar();
        bd.close();
    }

    private void limpiar() {
        id.setText("");
        nom.setText("");
        ubi.setText("");
        tel.setText("");
    }

    private void registrarUsuario() {

        Conexion con = new Conexion(this,"db_restaurantes",null,1);
        SQLiteDatabase bd = con.getWritableDatabase();//estamos abriendo la base de datos para insertar

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID,id.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,nom.getText().toString());
        values.put(Utilidades.CAMPO_UBICACION,ubi.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,tel.getText().toString());

        Long idResultante = bd.insert(Utilidades.NOMBRE_TABLA,Utilidades.CAMPO_ID,values);
        Toast.makeText(getApplicationContext(),"ID REGISTRO: "+idResultante,Toast.LENGTH_SHORT).show();
        bd.close();
    }
}
