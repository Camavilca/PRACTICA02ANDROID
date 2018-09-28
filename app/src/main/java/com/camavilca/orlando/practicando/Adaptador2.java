package com.camavilca.orlando.practicando;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.camavilca.orlando.practicando.modelo.Restaurantes;

import java.util.ArrayList;

public class Adaptador2 extends RecyclerView.Adapter<Adaptador2.ViewHolder> {

    ArrayList<Restaurantes> restaurantesArrayList;

    public Adaptador2(ArrayList<Restaurantes> restaurantesArrayList) {
        this.restaurantesArrayList = restaurantesArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurante,null,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.documento.setText(restaurantesArrayList.get(position).getId());
        holder.nomb.setText(restaurantesArrayList.get(position).getNombre().toString());
        holder.tele.setText(restaurantesArrayList.get(position).getTelefono().toString());
        //holder.ubica.setText(restaurantesArrayList.get(position).getUbicacion());
    }
    @Override
    public int getItemCount() {
        return restaurantesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView documento,nomb,tele,ubica;

        public ViewHolder(View itemView) {
            super(itemView);
            nomb = itemView.findViewById(R.id.nombre);
            tele = itemView.findViewById(R.id.telefono);
        }
    }
}
