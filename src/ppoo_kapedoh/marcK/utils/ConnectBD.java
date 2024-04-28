/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppoo_kapedoh.marcK.utils;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author adral
 */
public class ConnectBD {
    public static Connection seConnecter(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         String bd_url="jdbc:mysql://localhost:3306/db_mcapedoh";
         String user="root";
         String passwd="";
        try {
            Connection connexion=DriverManager.getConnection(bd_url,user,passwd);
            return connexion;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
