package com.example.lab10.dao;
import java.sql.*;

import com.example.lab10.bean.Cliente;
import com.example.lab10.bean.Credencial;
import java.sql.*;
import java.util.ArrayList;

public class DaoCredencial extends DaoBase{

    public Credencial buscarUsuario(String username, String password) {

        Credencial credencial = null;

        String sql = "SELECT * FROM credentials WHERE nro_documento = ? AND hashedPassword = sha2(?,256)";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()){
                    credencial = new Credencial();
                    credencial.setNumDocumento(rs.getString(1));
                    credencial.setTipoUsuario(rs.getInt(4));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return credencial;
    }

    public boolean createCredentialCliente (String nroDocumento, String password){
        DaoCliente daoCliente = new DaoCliente();

        String sql = "INSERT INTO credentials (nro_documento, password, hashedPassword, tipoUsuario) VALUES (?,?, sha2(?,256), 2)";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            if(!daoCliente.clientIsInCredentials(nroDocumento) && daoCliente.buscarCliente(nroDocumento)!=null && password!=""){
                pstmt.setString(1, nroDocumento);
                pstmt.setString(2, password);
                pstmt.setString(3, password);

                pstmt.executeUpdate();
                return true;
            }
            else{
                return false;
            }

        } catch (SQLException throwables){
            return false;
        }

    }

}
