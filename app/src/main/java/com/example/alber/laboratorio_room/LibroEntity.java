package com.example.alber.laboratorio_room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by alber on 2/28/2018.
 */

@Entity(tableName = "Libros")
public class LibroEntity {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name_")
    private String name;

    @ColumnInfo(name = "author_")
    private String author;

    public LibroEntity() {
    }

    @Ignore
    public LibroEntity(String name, String author) {
        this.name = name;
        this.author = author;
        this.id = id;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String toString(){
        return new StringBuilder(name).append("\n").append(author).toString();
    }
  /**  @Override
    public String toString() {
        return "LibroEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }*/
}
