package com.camavilca.orlando.practicando;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolder> {

    ArrayList<String> list;

    public AdapterDatos(ArrayList<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterDatos.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDatos.ViewHolder holder, int position) {
        holder.asignarDatos(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView dato;

        TextView docu,nomb,telf,ubi;

        public ViewHolder(View itemView) {
            super(itemView);
            dato = (TextView)itemView.findViewById(R.id.idDato);
        }

        public void asignarDatos(String s) {
            dato.setText(s);
        }
    }
}
