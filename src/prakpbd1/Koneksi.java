/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prakpbd1;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author WIN11
 */
public class Koneksi {
    public Koneksi(){
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Memuat driver JDBC MySQL
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lat-java-crud-1","root",""); // Mendapatkan koneksi ke database MySQL
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex); // Menangani kesalahan jika kelas driver tidak ditemukan
        } catch(SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex); // Menangani kesalahan jika koneksi ke database gagal
        }
    }
}
