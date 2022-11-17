package com.example.lab10.dao;

import com.example.lab10.bean.Contrato;

import java.util.ArrayList;

public class DaoContrato extends DaoBase{
    public ArrayList<Contrato> listarContratos(String idCliente){
        ArrayList<Contrato> lista = new ArrayList<>();
        String sql = "SELECT * FROM jm_cotr_bis where client_nro_id = ?";
        try()


        return lista;
    }
}
