package com.lostdream.notethename;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ClickedListener{

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.notas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<NoteList> noteLists = new ArrayList<>();

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

        NoteListAdapter adapter = new NoteListAdapter(noteLists, recyclerView, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onPictureClicked(int position, String titulo) {
        Toast.makeText(this, titulo, Toast.LENGTH_SHORT).show();
    }
}