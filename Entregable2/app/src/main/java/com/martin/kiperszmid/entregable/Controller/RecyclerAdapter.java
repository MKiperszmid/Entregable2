package com.martin.kiperszmid.entregable.Controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.martin.kiperszmid.entregable.Model.POJO.Receta;
import com.martin.kiperszmid.entregable.R;

import java.util.Collections;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter {

    private List<Receta> recetas;

    private NotificadorRecetaCelda notificadorRecetaCelda;

    public RecyclerAdapter(List<Receta> recetas, NotificadorRecetaCelda notificadorRecetaCelda) {
        this.recetas = recetas;
        this.notificadorRecetaCelda = notificadorRecetaCelda;
    }

    public void updateList(List<Receta> recetas){
        this.recetas = recetas;
        notifyDataSetChanged();
    }

    public void swapRecetas(Integer indexA, Integer indexB){
        Collections.swap(recetas, indexA, indexB );
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.celda_recycler, parent, false);
        CeldaViewHolder holder = new CeldaViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Receta receta = recetas.get(position);
        CeldaViewHolder cvh = (CeldaViewHolder) holder;
        cvh.bindHolder(receta);
    }

    public void removeReceta(int position){
        recetas.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreReceta(Receta receta, int position){
        recetas.add(position, receta);
        notifyItemInserted(position);
    }

    @Override
    public int getItemCount() {
        return recetas.size();
    }

    public class CeldaViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView ingredientes;
        ImageView imagen;
        RelativeLayout viewForeground, viewBackground; //TODO: Agregar Esto!

        public CeldaViewHolder(View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.textviewCeldaTitulo);
            ingredientes = itemView.findViewById(R.id.textviewCeldaIngredientes);
            imagen = itemView.findViewById(R.id.imageviewCelda);
            viewForeground = itemView.findViewById(R.id.viewForeground);
            viewBackground = itemView.findViewById(R.id.viewBackground);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    notificadorRecetaCelda.notificarRecetaClickeada(recetas.get(pos));
                }
            });
        }

        public void bindHolder(Receta receta){
            titulo.setText(receta.getTitulo());
            ingredientes.setText(receta.getIngredientes());
            imagen.setImageResource(receta.getImagen());
        }
    }

    public interface NotificadorRecetaCelda{
        void notificarRecetaClickeada(Receta receta);
    }
}
