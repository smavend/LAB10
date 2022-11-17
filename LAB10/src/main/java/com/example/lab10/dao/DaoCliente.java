package com.example.lab10.dao;

import com.example.lab10.bean.Cliente;
import com.example.lab10.bean.Contrato;

import java.sql.*;
import java.util.ArrayList;

public class DaoCliente extends DaoBase{
    public Cliente buscarCliente(String numDocumento){
        Cliente cliente = null;
        String sql = "SELECT * FROM jm_client_bii where g4093_nro_id = ?";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1,numDocumento);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    cliente = new Cliente();
                    cliente.setNumDocumento(numDocumento);
                    cliente.setNombreCliente(rs.getString(2));
                    cliente.setEdad(rs.getString(3));
                    String tipo = rs.getString(4);
                    cliente.setTipoCliente(tipo.equals("N")?"Natural":"Jurídica");
                    cliente.setTipoDocumento(rs.getString(5));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }

    public ArrayList<Cliente> listarClientes(){
        ArrayList<Cliente> listarclientes = new ArrayList<>();

        String sql = "SELECT * FROM jm_client_bii ";


        try(Connection connection = this.getConnection();
            Statement stmt= connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql)  ){


            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setNumDocumento(rs.getString(1));
                cliente.setNombreCliente(rs.getString(2));
                cliente.setEdad(rs.getString(3));
                cliente.setTipoCliente(rs.getString(4));
                cliente.setTipoDocumento(rs.getString(5));

                listarclientes.add(cliente);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listarclientes;
    }
}
