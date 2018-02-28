package com.example.alber.laboratorio_room;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    public static final String SELECTED_ITEM = "com.jwhh.jim.notekeeper.NOTE_INFO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        Biblioteca prebiblio= intent.getParcelableExtra(SELECTED_ITEM);
    }
}
