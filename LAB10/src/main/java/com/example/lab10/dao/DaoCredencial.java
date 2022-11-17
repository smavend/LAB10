package com.example.lab10.dao;
import java.sql.*;
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

}
