package com.lostdream.notethename;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ClickedListener{

    RecyclerView recyclerView;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ajuste del recycler view a vertical
        recyclerView = findViewById(R.id.notas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //Botones
        add = findViewById(R.id.add);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddNota();
            }
        });

        //Array para almacenar información en el recyclerView
        List<NoteList> noteLists = new ArrayList<>();

        //Test de recyclersViews
        NoteList nota1 = new NoteList();
        nota1.titulo = "Titulo1";
        noteLists.add(nota1);

        NoteList nota2 = new NoteList();
        nota2.titulo = "Titulo2";
        noteLists.add(nota2);

        NoteList nota3 = new NoteList();
        nota3.titulo = "Titulo3";
        noteLists.add(nota3);

        NoteList nota4 = new NoteList();
        nota4.titulo = "Titulo4";
        noteLists.add(nota4);

        NoteList nota5 = new NoteList();
        nota5.titulo = "Titulo5";
        noteLists.add(nota5);

        NoteList nota6 = new NoteList();
        nota6.titulo = "Titulo6";
        noteLists.add(nota6);

        NoteList nota7 = new NoteList();
        nota7.titulo = "Titulo7";
        noteLists.add(nota7);

        //Llamar al adaptador para organizar la informacion y cantidad de notas
        NoteListAdapter adapter = new NoteListAdapter(noteLists, recyclerView, this);
        //Mostrar en pantalla
        recyclerView.setAdapter(adapter);

    }

    //Implementación de función para saber que recyclerView se esta pulsando
    @Override
    public void onPictureClicked(int position, String titulo) {
        //Toast.makeText(this, titulo, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Detalles.class);
        intent.putExtra("TITULO", titulo);
        startActivity(intent);
    }

    private void AddNota(){
        Intent intent = new Intent(this, addNota.class);
        startActivity(intent);
    }

}