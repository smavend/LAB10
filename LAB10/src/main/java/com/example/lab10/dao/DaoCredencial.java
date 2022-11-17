package com.example.lab10.dao;
import java.sql.*;

import com.example.lab10.bean.Cliente;
import com.example.lab10.bean.Credencial;
import java.sql.*;
public class DaoCredencial extends DaoBase{

    public Credencial buscarUsuario(String username, String password) {

        Credencial credencial = null;

        String sql = "SELECT * FROM credentials WHERE nro_documento = ? AND hashedPassword = sha2(?,256)";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery();) {
                if(rs.next()){
                    System.out.println("encontrado");
                    credencial = new Credencial();
                    credencial.setNumDocumento(rs.getString(1));
                    credencial.setTipoUsuario(rs.getInt(4));
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(credencial.getNumDocumento());
        return credencial;
    }



/*
    public boolean createCredentialCliente (Credencial credencial) {

        String sql = "INSERT INTO `lab9`.`arbitro` (`nombre`, `pais`) VALUES (?, ?);";
        DaoArbitros daoArbitros = new DaoArbitros();
        for (Arbitro a : daoArbitros.listarArbitros()){
            if(a.getNombre().equalsIgnoreCase(arbitro.getNombre())){
                return false;
            }
        }
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, arbitro.getNombre());
            pstmt.setString(2, arbitro.getPais());

            pstmt.executeUpdate();

        } catch (SQLException throwables){
            return false;
        }
        return true;
    }*/



}
