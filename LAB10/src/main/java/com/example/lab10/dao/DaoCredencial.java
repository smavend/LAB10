package com.example.lab10.dao;
import java.sql.*;

import com.example.lab10.bean.Cliente;
import com.example.lab10.bean.Credencial;

public class DaoCredencial extends DaoBase{

    public Credencial buscarUsuario(String username, String password) {

        Credencial credencial = null;

        String sql = "SELECT * FROM employees_credentials WHERE email = ? AND password = ?";

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery();) {
                if(rs.next()){
                    int employeeId = rs.getInt(1);
                    employee = this.obtenerEmpleado(employeeId);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return employee;
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
