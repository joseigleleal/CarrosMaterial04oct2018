package com.holamundo.personasmaterial;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorCarro extends
        RecyclerView.Adapter<AdaptadorCarro.CarrosViewHolder> {
    private ArrayList<Carro> carros;

    public AdaptadorCarro(ArrayList<Carro> carros){
        this.carros = carros;
    }
    @Override
    public CarrosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.item_carro,parent,false);
       return new CarrosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CarrosViewHolder holder, int position) {
        Carro c = carros.get(position);
        holder.foto.setImageResource(c.getFoto());
        holder.placa.setText(c.getPlaca());
        holder.precio.setText(c.getPrecio());

    }

    @Override
    public int getItemCount() {
        return carros.size();
    }

    public static class CarrosViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView placa;
        private TextView precio;

        private View v;

        public CarrosViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.foto);
            placa = v.findViewById(R.id.txtplaca);
            precio= v.findViewById(R.id.txtprecio);

        }
    }
}
