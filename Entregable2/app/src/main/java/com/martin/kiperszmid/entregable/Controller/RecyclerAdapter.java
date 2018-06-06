package com.martin.kiperszmid.entregable.Controller;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.martin.kiperszmid.entregable.Model.POJO.Receta;
import com.martin.kiperszmid.entregable.R;

import java.util.Collections;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter implements RecyclerTouchCallback.ItemTouchHelperAdapter {

    private List<Receta> recetas;
    private OnItemClickListener itemClickListener;
    private RecyclerTouchCallback.OnStartDragListener startDragListener;
    private NotificadorRecetaCelda notificadorRecetaCelda;

    public RecyclerAdapter(List<Receta> recetas, RecyclerTouchCallback.OnStartDragListener startDragListener, NotificadorRecetaCelda notificadorRecetaCelda) {
        this.recetas = recetas;
        this.startDragListener = startDragListener;
        this.notificadorRecetaCelda = notificadorRecetaCelda;
    }

    public void updateList(List<Receta> recetas){
        this.recetas = recetas;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
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

    @Override
    public boolean onItemMove(int startPos, int endPos) {
        if (startPos < recetas.size() && endPos < recetas.size()) {
            if (startPos < endPos) {
                for (int i = startPos; i < endPos; i++) {
                    Collections.swap(recetas, i, i + 1);
                }
            } else {
                for (int i = startPos; i > endPos; i--) {
                    Collections.swap(recetas, i, i - 1);
                }
            }
            notifyItemMoved(startPos, endPos);
        }
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        recetas.remove(position);
        notifyItemRemoved(position);
    }

    public class CeldaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, RecyclerTouchCallback.ItemTouchHelperViewHolder {

        TextView titulo;
        TextView ingredientes;
        ImageView imagen;

        public CeldaViewHolder(View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.textviewCeldaTitulo);
            ingredientes = itemView.findViewById(R.id.textviewCeldaIngredientes);
            imagen = itemView.findViewById(R.id.imageviewCelda);
            itemView.setOnClickListener(this);
        }

        public void bindHolder(Receta receta){
            titulo.setText(receta.getTitulo());
            ingredientes.setText(receta.getIngredientes());
            imagen.setImageResource(receta.getImagen());
        }

        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY);
        }

        @Override
        public void onItemClear() {
            itemView.setBackgroundColor(0);
        }

        @Override
        public void onClick(View v) {
            if(itemClickListener != null)
                itemClickListener.onItemClick(v, getAdapterPosition());

            int pos = getAdapterPosition();
            notificadorRecetaCelda.notificarRecetaClickeada(recetas.get(pos));
        }
    }

    public interface NotificadorRecetaCelda{
        void notificarRecetaClickeada(Receta receta);
    }
}
