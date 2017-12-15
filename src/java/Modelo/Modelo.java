/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MASTER
 */
public class Modelo {
    Conexion conexion = new Conexion();
    
    public boolean validaLogin(String usuario, String password){
   //simplificar en una linea 
        Connection cnn = conexion.getConexion();
        ResultSet rs;
        PreparedStatement psmt;
        try {
            psmt = cnn.prepareStatement("call get_usuario(?, ?)");
            psmt.setString(1, usuario);
            psmt.setString(2, password);
            rs = psmt.executeQuery();   
  //simplificar en una linea 
            
//            while(rs.next()){
//            Usuarios d = new Usuarios();
//            d.setUsuario(rs.getString("usuario"));
//            d.setPassword(rs.getString("password"));
//            lista.add(d);
//        }

            if(rs.next())
            {
                return true;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(admindaoimplement.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }
}
