package com.lostdream.notethename;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.NoteListViewHolder> {

    //Adaptador para utilizar el recyclerView

    private final List<NoteList> noteLists;
    private RecyclerView recyclerView ;
    private final ClickedListener clickedListener;

    public NoteListAdapter(List<NoteList> noteLists, RecyclerView recyclerView, ClickedListener clickedListener){
        this.noteLists = noteLists;
        this.recyclerView = recyclerView;
        this.clickedListener = clickedListener;
    }

    @NonNull
    @Override
    public NoteListAdapter.NoteListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.nota,
                parent,
                false
        );

        return new NoteListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteListAdapter.NoteListViewHolder holder, int position) {
        holder.RellenarDatos(noteLists.get(position));
    }

    @Override
    public int getItemCount() {
        return noteLists.size();
    }

    public class NoteListViewHolder extends RecyclerView.ViewHolder {

        private final TextView textTitulo;

        public NoteListViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitulo = itemView.findViewById(R.id.titulo);
        }

        public void RellenarDatos(NoteList noteList) {
            textTitulo.setText(noteList.titulo);
            textTitulo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickedListener.onPictureClicked(getAdapterPosition(), noteList.titulo);
                }
            });
        }
    }
}
