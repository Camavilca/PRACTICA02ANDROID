package com.camavilca.orlando.practicando.utilidades;

public class Utilidades {

    //constantes de la tabla restaurante
    public static final String NOMBRE_TABLA = "restaurante";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_UBICACION = "ubicacion";
    public static final String CAMPO_TELEFONO = "telefono";
    public static final String CREAR_TABLA_RESTAURANTE =
            "CREATE TABLE "+NOMBRE_TABLA+" (" +
                    ""+CAMPO_ID+" INTEGER,"+CAMPO_NOMBRE+" TEXT,"+CAMPO_UBICACION+" TEXT,"+CAMPO_TELEFONO+" TEXT)";

}
