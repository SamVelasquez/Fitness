package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import clases.Planes;

public class cliente_actv extends AppCompatActivity {
    private Spinner spin, spiner;
    private EditText editext;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_actv);
        spin = (Spinner)findViewById(R.id.spin);
        spiner=(Spinner)findViewById(R.id.spiner2);
        editext =( EditText)findViewById(R.id.editext);
        textView= (TextView)findViewById(R.id.textView);

        //recibo el dato para el spiner1
        ArrayList<String> listaClientes = (ArrayList<String>)getIntent().getSerializableExtra("listaClientes");
        //creo el array adapter para el spinner
        ArrayAdapter<String> adapter=new ArrayAdapter<> (this, android.R.layout.simple_list_item_1, listaClientes);
        spin.setAdapter(adapter);
        //recibo el dato para el spiner2
        ArrayList<String> listaPlanes = (ArrayList<String>)getIntent().getSerializableExtra("listaPlanes");
        ArrayAdapter<String> adapt =new ArrayAdapter<> (this, android.R.layout.simple_list_item_1, listaPlanes);
        spiner.setAdapter(adapt);

    }
    public void calcular (View view){

        String cliente = spin.getSelectedItem().toString();
        String Planes = spiner.getSelectedItem().toString();

        Planes planes = new Planes(); // importo la clase y creo el objeto


        if (cliente.equals("Oscar") && Planes.equals("xtreme")){
            textView.setText("El precio del plan es: "+ planes.getXtreme());
        }
        if (cliente.equals("Oscar") && Planes.equals("mindfullnes")){
            textView.setText("El precio del plan es: "+ planes.getMindfullnes());
        }
        if (cliente.equals("Ivan") && Planes.equals("xtreme")){
            textView.setText("El precio del plan es: "+ planes.getXtreme());
        }
        if (cliente.equals("Ivan") && Planes.equals("mindfullnes")){
            textView.setText("El precio del plan es: "+ planes.getMindfullnes());
        }
    }
}