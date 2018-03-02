package com.example.alber.laboratorio_room;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    public static final String SELECTED_ITEM = "com.jwhh.jim.notekeeper.NOTE_INFO";
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<LibroEntity> libroEntities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        Biblioteca prebiblio= intent.getParcelableExtra(SELECTED_ITEM);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, "basic-sample-db")
                .allowMainThreadQueries()
                .build();
        libroEntities = db.libroDAO().getAll();

        recyclerView = findViewById(R.id.Lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LibroAdapter(libroEntities);
        recyclerView.setAdapter(adapter);

    }
}
