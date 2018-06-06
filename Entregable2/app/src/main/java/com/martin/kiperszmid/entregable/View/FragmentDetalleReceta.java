package com.martin.kiperszmid.entregable.View;


import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.martin.kiperszmid.entregable.Model.POJO.Receta;
import com.martin.kiperszmid.entregable.R;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetalleReceta extends Fragment {

    public static final String RECETA_KEY = "Receta";
    private Receta receta;
    public FragmentDetalleReceta() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle_receta, container, false);
        Bundle bundle = getArguments();
        receta = (Receta) bundle.getSerializable(RECETA_KEY);
        TextView titulo = view.findViewById(R.id.detalleTitulo);
        TextView ingredientes = view.findViewById(R.id.detalleIngredientes);
        TextView preparacion = view.findViewById(R.id.detallePreparacion);
        CircleImageView imagen = view.findViewById(R.id.detalleImagen);
        ImageView background = view.findViewById(R.id.detalleBackgroundImage);

        String ings = "";

        String[] ingreds = receta.getIngredientes().split(", ");

        for (String i : ingreds) {
            ings += "- " + i + "\n";
        }

        titulo.setText(receta.getTitulo());
        ingredientes.setText(ings);
        preparacion.setText(receta.getPreparacion());
        imagen.setImageResource(receta.getImagen());
        background.setImageResource(receta.getImagen());
        return view;
    }

}
