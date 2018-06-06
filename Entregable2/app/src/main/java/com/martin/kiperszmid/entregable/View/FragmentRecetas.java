package com.martin.kiperszmid.entregable.View;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.martin.kiperszmid.entregable.Controller.RecetaController;
import com.martin.kiperszmid.entregable.Controller.RecyclerAdapter;
import com.martin.kiperszmid.entregable.Controller.RecyclerItemTouchHelper;
import com.martin.kiperszmid.entregable.Model.POJO.Receta;
import com.martin.kiperszmid.entregable.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRecetas extends Fragment implements RecyclerAdapter.NotificadorRecetaCelda, RecyclerItemTouchHelper.NotificadorRITH {

    private NotificarResetaActivity notificarResetaActivity;
    private List<Receta> recetas;
    private List<Receta> filtrado;
    private CoordinatorLayout coordinatorLayout;
    RecyclerAdapter adapter;
    private boolean isFiltered = false;
    public FragmentRecetas() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        this.notificarResetaActivity = (NotificarResetaActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_recetas, container, false);
        coordinatorLayout = view.findViewById(R.id.coordinatorLayout);
        recetas = RecetaController.getListaRecetas();

        final RecyclerView recyclerView = view.findViewById(R.id.recetasRecycler);

        adapter = new RecyclerAdapter(recetas, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        ItemTouchHelper.SimpleCallback itemHelper = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemHelper).attachToRecyclerView(recyclerView);




        final EditText filtrar = view.findViewById(R.id.buscador);

        // Opcion 2 del Destacado
        filtrar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filtrado = new ArrayList<>();
                String filtro = filtrar.getText().toString().toLowerCase();
                if(filtro.length() > 0){
                    for(Receta receta : recetas){
                        if(receta.getIngredientes().toLowerCase().contains(filtro)
                                || receta.getTitulo().toLowerCase().contains(filtro)){
                            filtrado.add(receta);
                        }
                    }
                    adapter.updateList(filtrado);
                }
                isFiltered = filtro.length() > 0;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }

    @Override
    public void notificarRecetaClickeada(Receta receta) {
        notificarResetaActivity.notificarReseta(receta);
    }

    // Opcion 3 del Destacado
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if(viewHolder instanceof RecyclerAdapter.CeldaViewHolder){
            List<Receta> miRecetas;
            if(isFiltered)
                miRecetas = filtrado;
            else
                miRecetas = recetas;

            String name = miRecetas.get(viewHolder.getAdapterPosition()).getTitulo();
            final Receta recetaEliminada = miRecetas.get(viewHolder.getAdapterPosition());
            final Integer posicionEliminada = viewHolder.getAdapterPosition();

            adapter.removeReceta(posicionEliminada);

            Snackbar.make(coordinatorLayout, name + " fue removido!", Snackbar.LENGTH_SHORT).setAction("DESHACER", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapter.restoreReceta(recetaEliminada, posicionEliminada);
                }
            }).show();
        }
    }

    public interface NotificarResetaActivity{
        public void notificarReseta(Receta receta);
    }
}
