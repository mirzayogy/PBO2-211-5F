/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirzayogy.pbo2.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    
    private final String URL = "jdbc:mysql://localhost:3306/";
    private final String DB_NAME = "praktikum_penjualan";
    private final String USER = "root";
    private final String PASS = "";
    
    public Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL+DB_NAME, USER, PASS);
            System.out.println("Koneksi Berhasil");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.toString());
        }
        return con;
    }
    
}