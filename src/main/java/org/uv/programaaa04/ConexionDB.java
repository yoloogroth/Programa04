/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.Programaaa04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yolotzin Groth Hdez
 */
public class ConexionDB {
    private Connection con=null;
    
    private static ConexionDB cx=null;
    public static ConexionDB getInstance(){
        if(cx==null)
            cx=new ConexionDB();
        return cx;
    }
    private ConexionDB(){
        try {
            String url = "jdbc:postgresql://localhost:8000/ejemplo";
            String user = "postgres";
            String pwd = "postgres";
            con= DriverManager.getConnection(url, user, pwd);
            Logger.getLogger(ConexionDB.class.getName()).log(Level.INFO, "Se conectó..." );
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean execute (String sql){
        return true;
    }
    public boolean execute(TransaccionDB tdb){
        return tdb.execute(con);
    }
}