package com.example.lab10.dao;

import com.example.lab10.bean.Contrato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoContrato extends DaoBase{
    public ArrayList<Contrato> listarContratos(String idCliente){
        ArrayList<Contrato> lista = new ArrayList<>();
        Contrato contrato = null;
        String sql = "SELECT * FROM jm_cotr_bis where client_nro_id = ?";
        try(Connection connection = this.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1,idCliente);
            try(ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){
                    contrato = new Contrato();
                    contrato.setNroContrato(rs.getString(1));
                    contrato.setCliente(rs.);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return lista;
    }
}
