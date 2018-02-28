package com.example.alber.laboratorio_room;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by alber on 2/28/2018.
 */

public class Biblioteca implements Parcelable{
    protected String nameList;
    protected ArrayList<Libro> Listalibros;

    public Biblioteca(){
        nameList = "";
        Listalibros = new ArrayList<>();
        Libro l1 = new Libro();
        Listalibros.add(l1);
    }

    protected Biblioteca(Parcel in) {
        nameList = in.readString();
        Listalibros = in.createTypedArrayList(Libro.CREATOR);
    }

    public static final Creator<Biblioteca> CREATOR = new Creator<Biblioteca>() {
        @Override
        public Biblioteca createFromParcel(Parcel in) {
            return new Biblioteca(in);
        }

        @Override
        public Biblioteca[] newArray(int size) {
            return new Biblioteca[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nameList);
        parcel.writeTypedList(Listalibros);
    }
}
