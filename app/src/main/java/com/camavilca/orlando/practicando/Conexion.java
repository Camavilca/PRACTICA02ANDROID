package com.camavilca.orlando.practicando;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.camavilca.orlando.practicando.utilidades.Utilidades;

public class Conexion extends SQLiteOpenHelper{


    public Conexion(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    /**
     * contexto->contexto de la aplicacion
     * name->nombre de la base de datos
     *version ->version de la base de datos
     * */

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_RESTAURANTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS restaurante");
        onCreate(db);
    }
}
