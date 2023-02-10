package com.lostdream.notethename;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addNota extends AppCompatActivity {

    Button salir, agregar;
    EditText tituloEdit;
    String titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nota);

        //Botones
        salir = findViewById(R.id.salir);
        agregar = findViewById(R.id.agregar);

        //TextoEdit
        tituloEdit = findViewById(R.id.Titulo);

        //Tomar titulo
        titulo = getIntent().getStringExtra("TITULO");

        //Editar informacion
        if (titulo != null){
            tituloEdit.setText(titulo);
        }



        //Salir
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelar();
            }
        });

        //Agregar
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetAgregar();
            }
        });


    }


    private void cancelar(){
        super.onBackPressed();
        finish();
    }

    private void SetAgregar(){
        Intent inicio = new Intent(this, MainActivity.class);
        inicio.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(inicio);

    }
}