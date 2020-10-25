package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import clases.AdminSQLiteOpenHelper;

public class basedatos_act extends AppCompatActivity {
    private EditText editex1, editex2,editex3,editex4 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basedatos_act);
        editex1= (EditText)findViewById(R.id.editex1);
        editex2=(EditText)findViewById(R.id.editex2);
        editex3=(EditText) findViewById(R.id.editex3);
        editex4=(EditText)findViewById(R.id.editex4);

    }
    // añadir insumos
    public void añadirinsumo(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"fichero", null , 1);
        SQLiteDatabase db = admin.getWritableDatabase();// permiten darle permisos de escritura sobre la b.d

        if(!editex1.getText().toString().isEmpty()){
            ContentValues cont = new ContentValues(); // permite contener mas de 1 valor
            cont.put("codigo",editex1.getText().toString()); //
            cont.put("nombre",editex2.getText().toString());
            cont.put("precio",editex3.getText().toString());
            cont.put("stock",editex4.getText().toString());

            db.insert("insumos", null,cont);
            db.close();
            Toast.makeText(this, " guardastes el insumo",Toast.LENGTH_LONG).show();
            editex1.setText("");
            editex2.setText("");
            editex3.setText("");
            editex4.setText("");
        }
        else{
            Toast.makeText(this, " debe ingresar el codigo del insumo",Toast.LENGTH_LONG).show();
        }
    }
    public void mostrarinsumo(View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( this, "fichero", null,1);
        SQLiteDatabase db = admin.getWritableDatabase(); // permisos sobre escritura
        //validador
        String codigo = editex1.getText().toString();
        if ( !codigo.isEmpty()){
            // mostrar insumos
            Cursor fila = db.rawQuery("SELECT nombre, precio, stock FROM insumos WHERE codigo = "+codigo, null);
            if (fila.moveToFirst()){ // si no hay campos devuelve vacio
                editex2.setText(fila.getString(0)); // nombre
                editex3.setText(fila.getString(1));// precio
                editex4.setText(fila.getString(2)); // stock

            }else {
                Toast.makeText(this, " no hay campos en la tabla ",Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this, " no hay insuomo con el codigo asociado",Toast.LENGTH_LONG).show();
        }

    }
    // eliminar insumos
    public void eliminarinsumo(View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db= admin.getWritableDatabase();

        String codigo = editex1.getText().toString(); // guardo el codigo del cliente para poder eliminarlo
        db.delete("insumos","codigo="+codigo, null);
        db.close();
        Toast.makeText(this, " has eliminado un insumo",Toast.LENGTH_LONG).show();

    }
    public void actualizarinsumo(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"fichero", null , 1);
        SQLiteDatabase db = admin.getWritableDatabase();// permiten darle permisos de escritura sobre la b.d

        String codigo = editex1.getText().toString();
        ContentValues cont = new ContentValues();

        cont.put("codigo", editex1.getText().toString()); //
        cont.put("nombre", editex2.getText().toString());
        cont.put("precio", editex3.getText().toString());
        cont.put("stock", editex4.getText().toString());

        if(!codigo.isEmpty()) {
            db.update("insumo",cont, "codigo="+codigo, null);
            db.close();
            Toast.makeText(this, " actualizastes un insumo",Toast.LENGTH_LONG).show();

        }
    }
}