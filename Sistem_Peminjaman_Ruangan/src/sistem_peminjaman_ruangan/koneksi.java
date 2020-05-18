/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem_peminjaman_ruangan;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author yusti
 */
public class koneksi {
    static Connection koneksi;
    static PreparedStatement pst;
    public static Connection getkoneksi(){
        if(koneksi==null) {
            try{
            String url = new String();
            String user = new String();
            String password = new String();
            url = "jdbc:mysql://localhost:3306/peminjaman_ruangan";
            user = "root";
            password = "";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            koneksi = (Connection) DriverManager.getConnection(url, user, password);
        } catch(SQLException t) {
            System.out.println("Koneksi Error");
        }
        }
        
        return koneksi;
        
    }
    
}
