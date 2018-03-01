package com.example.alber.laboratorio_room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by alber on 2/28/2018.
 */
@Dao
public interface LibroDAO {

    @Query("SELECT * FROM Libros")
    List<LibroEntity> getAll();

    @Query("SELECT * FROM Libros WHERE name_ LIKE  :name AND author_ LIKE :author")
    List<LibroEntity> findByName(String name,String author);

    @Query("SELECT COUNT(*) from Libros")
    int countLibros();

    @Insert
    void insertAll(LibroEntity... libros);

    @Delete
    void delete(LibroEntity libroEntity);

}
