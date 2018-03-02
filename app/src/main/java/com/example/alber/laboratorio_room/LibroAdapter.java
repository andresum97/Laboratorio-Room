package com.example.alber.laboratorio_room;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by alber on 3/1/2018.
 */

public class LibroAdapter extends RecyclerView.Adapter<LibroAdapter.ViewHolder> {

    List<LibroEntity> libroEntities;

    public LibroAdapter(List<LibroEntity> libroEntities){
        this.libroEntities = libroEntities;
    }
    @Override
    public LibroAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(LibroAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
