package com.example.alber.laboratorio_room;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by alber on 2/28/2018.
 */

public class Libro implements Parcelable{
    protected String nombre;
    protected int numerodelibro;
    protected String autor;

    public Libro(){
        nombre = "";
        autor = "";
        numerodelibro = 0;
    }

    protected Libro(Parcel in) {
        nombre = in.readString();
        numerodelibro = in.readInt();
        autor = in.readString();
    }

    public static final Creator<Libro> CREATOR = new Creator<Libro>() {
        @Override
        public Libro createFromParcel(Parcel in) {
            return new Libro(in);
        }

        @Override
        public Libro[] newArray(int size) {
            return new Libro[size];
        }
    };

    public String getNombre(){
        return nombre;
    }
    public String getAutor(){
        return autor;
    }
    public int getNumerodelibro(){
        return numerodelibro;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public void setNumerodelibro(int numerodelibro){
        this.numerodelibro = numerodelibro;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeInt(numerodelibro);
        parcel.writeString(autor);
    }
}
