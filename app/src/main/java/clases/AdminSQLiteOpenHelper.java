package clases;
//clases necesarios para usar sql
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;


public class AdminSQLiteOpenHelper  extends SQLiteOpenHelper{

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    } // Constructor necesario paral a base de datos

    @Override
    //oncreate configuracion iicial de la base de datos
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE insumos (codigo int primary key, nombre text, precio float,stock int)"); // se crean tablas para guardar los codigos

    }

    @Override
    // onupgrade donde se implementa cambios esquematicos en la base de datos
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
