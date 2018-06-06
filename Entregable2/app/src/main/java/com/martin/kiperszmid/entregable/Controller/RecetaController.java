package com.martin.kiperszmid.entregable.Controller;

import com.martin.kiperszmid.entregable.Model.DAO.RecetaDao;
import com.martin.kiperszmid.entregable.Model.POJO.Receta;

import java.util.List;

public class RecetaController {

    public static List<Receta> getListaRecetas(){
        return RecetaDao.getListaRecetas();
    }
}
