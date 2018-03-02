package com.example.alber.laboratorio_room;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private EditText name;
    private EditText author;
    private EditText id;
    private Button button;
    private Button datos;
    private static final String TAG = "Createlibro";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.lista);

        //Database
        //AppDatabase appDatabase = AppDatabase.getInstance(this);
        final  AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, "basic-sample-db")
                .allowMainThreadQueries()
                .build();
        List<LibroEntity> libroentity = db.libroDAO().getAll();
        name = findViewById(R.id.name);
        author = findViewById(R.id.author);
        id = findViewById(R.id.id);
        button = findViewById(R.id.Guardar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // TODO: 3/01/18 Save to Database
                Editable x = id.getText();
                Log.d(TAG, "onClick: Name: "+name.getText().toString());
                LibroEntity libroEntity = new LibroEntity(name.getText().toString(), author.getText().toString());
                db.libroDAO().insertAll(libroEntity);
               // Intent intent = new Intent(MainActivity.class, Main2Activity.class);
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                Biblioteca biblioteca = new Biblioteca();
                intent.putExtra(Main2Activity.SELECTED_ITEM,biblioteca);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
