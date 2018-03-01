package com.example.alber.laboratorio_room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by alber on 2/28/2018.
 */

@Database(entities =  {LibroEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{

    private static AppDatabase sInstance;

    public static final String DATABASE_NAME = "basic-sample-db";

    public abstract LibroDAO libroDAO();

    public static AppDatabase getInstance(Context context){
        if(sInstance == null){
            sInstance =

                    Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,DATABASE_NAME)
                    .fallbackToDestructiveMigration().build();
        }
        return sInstance;
    }
}
