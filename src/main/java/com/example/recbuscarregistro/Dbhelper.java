package com.example.recbuscarregistro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Dbhelper extends SQLiteOpenHelper {
    public Dbhelper(Context context) {
        super(context, "Inventario6", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table producto(codigo_pro TEXT,nombre_pro TEXT,precio_pro TEXT,cantidad_pro TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists producto");
    }

    public Boolean insertarDatos(String codigo, String nombre, String precio, String cantidad) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("codigo_pro", codigo);
        contentValues.put("nombre_pro", nombre);
        contentValues.put("precio_pro", precio);
        contentValues.put("cantidad_pro", cantidad);
        long resultado = DB.insert("producto", null, contentValues);
        try {
            if (resultado == -1) {
                return false;
            }

        } catch (Exception exception) {
            System.out.println("Error Es :" + exception);


        }
        return true;


    }
    public ArrayList<usuario> Buscar(String busregistro) {
        ArrayList<usuario> RegistrosEncontrados = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from producto WHERE codigo_pro = '" + busregistro + "' limit 1", null);

        if (cursor.moveToFirst()) {
            do {
                RegistrosEncontrados.add(new usuario(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            } while (cursor.moveToNext());
        }
        return RegistrosEncontrados;
    }
}


