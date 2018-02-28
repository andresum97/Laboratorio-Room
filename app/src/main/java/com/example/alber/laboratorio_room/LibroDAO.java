package com.example.alber.laboratorio_room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by alber on 2/28/2018.
 */
@Dao
public interface LibroDAO {

    @Query("SELECT * FROM Libros")
    List<LibroEntity> getAll();

}
