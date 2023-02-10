package com.lostdream.notethename;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Detalles extends AppCompatActivity {

    Button salir, eliminar, editar;
    TextView titulo;

    private String tituloV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        //Botones
        salir = findViewById(R.id.salir);
        eliminar = findViewById(R.id.eliminar);
        editar = findViewById(R.id.editar);

        //TextoView
        titulo = findViewById(R.id.Titulo);

        //Obtener titulo
        tituloV = getIntent().getStringExtra("TITULO");

        //Mostrando titulo
        titulo.setText(tituloV);


        //Salir
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelar();
            }
        });

        //Eliminar
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Delete();
            }
        });

        //Editar
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Edit();
            }
        });

    }

    private void cancelar(){
        super.onBackPressed();
        finish();
    }

    private void Delete(){
        Intent inicio = new Intent(this, MainActivity.class);
        inicio.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(inicio);

    }

    private void Edit(){
        Intent intent =  new Intent(this, addNota.class);
        intent.putExtra("TITULO", tituloV);
        startActivity(intent);
    }
}