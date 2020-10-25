package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Menu_act extends AppCompatActivity {
    private ViewFlipper vf;
    private int[] imagenes = {R.drawable.a,R.drawable.b,R.drawable.c };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);
        vf =(ViewFlipper)findViewById(R.id.slider);

        for (int i=0; i< imagenes.length; i++){
            flip_imagenes(imagenes[i]);
        }
    }

    //configuracion del slider
    public  void flip_imagenes( int i){
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);
        vf.addView(view);
        vf.setFlipInterval(2800);
        vf.setAutoStart(true);

        vf.setInAnimation( this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }
    public void maps (View v){
        Intent i = new Intent( this, Maps_act.class);
        startActivity(i);
    }
    public  void info (View v){
        Intent i = new Intent (this,info_act.class);
        startActivity(i);
    }
    public void cliente (View v){
        //creo el array list para enviar datos
        ArrayList<String> clientes = new ArrayList<String>(); //para el spinner1
        clientes.add("Oscar");
        clientes.add("Ivan");
        //spiner2
        ArrayList<String> planes = new ArrayList<String>();
        planes.add("xtreme");
        planes.add("mindfullnes");

        Intent i = new Intent ( this, cliente_actv.class);
        i.putExtra("listaClientes",clientes); // preparo el dato para ser enviado
        i.putExtra("listaPlanes",planes);
        startActivity(i);
    }

    public void basedatos (View v){
        Intent i = new Intent(this, basedatos_act.class);
        startActivity(i);
    }
}