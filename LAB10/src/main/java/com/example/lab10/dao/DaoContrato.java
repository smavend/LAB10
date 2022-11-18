package com.example.lab10.dao;

import com.example.lab10.bean.Cliente;
import com.example.lab10.bean.Contrato;
import com.example.lab10.dto.CantContratos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoContrato extends DaoBase{
    public ArrayList<Contrato> listarContratos(String idCliente){
        ArrayList<Contrato> lista = new ArrayList<>();
        Contrato contrato = null;
        DaoCliente daoCliente = new DaoCliente();
        String sql = "SELECT * FROM jm_cotr_bis where client_nro_id = ?";
        try(Connection connection = this.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1,idCliente);
            try(ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){
                    contrato = new Contrato();
                    contrato.setNroContrato(rs.getString(1));
                    Cliente cliente = daoCliente.buscarCliente(rs.getString(2));
                    contrato.setCliente(cliente);
                    contrato.setDivisa(rs.getString(3));
                    int estado = rs.getInt(4);
                    contrato.setEstado(estado==0?"Normal":(estado==1)?"Cura":"Mora");
                    contrato.setMesesEnEstado(rs.getInt(5));
                    lista.add(contrato);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public ArrayList<CantContratos> lisarContradoEstado(String idCliente){
        ArrayList<CantContratos> lista = new ArrayList<>();
        CantContratos cantContratos = null;
        DaoCliente daoCliente = new DaoCliente();
        String sql = "select contr.G6789_status, count(contr.g6789_contract) " +
                "from jm_cotr_bis contr, jm_client_bii cli " +
                "where contr.client_nro_id = cli.g4093_nro_id and cli.g4093_nro_id = ? " +
                "group by contr.G6789_status";

        try(Connection connection = this.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1,idCliente);
            try(ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){
                    cantContratos = new CantContratos();
                    int estado = rs.getInt(1);
                    cantContratos.setEstado(estado==0?"Normal":(estado==1)?"Cura":"Mora");
                    cantContratos.setCantidadContrato(rs.getInt(2));


                    lista.add(cantContratos);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
