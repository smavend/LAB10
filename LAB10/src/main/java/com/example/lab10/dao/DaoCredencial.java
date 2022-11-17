package com.example.lab10.dao;
import java.sql.*;

import com.example.lab10.bean.Cliente;
import com.example.lab10.bean.Credencial;

public class DaoCredencial extends DaoBase{

    public Credencial buscarUsuario(String user, String passw ){
        Credencial credencial = null;
        String sql = "SELECT * FROM credentials WHERE nro_documento = ? and password = ? ";

        try(Connection conn = this.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user);
            pstmt.setString(2, passw);


            try (ResultSet rs = pstmt.executeQuery()){
                if (rs.next()){
                    credencial.setNumDocumento(rs.getString(1));
                    credencial.setTipoUsuario(rs.getInt(4));

                }
            }
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
        return credencial;
    }

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
    }



}
