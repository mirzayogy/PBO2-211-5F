package com.mirzayogy.pbo2.model;

import com.mirzayogy.pbo2.db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Barang {
    private int id;
    private String namaBarang;
    private double harga;
    private JenisBarang jenisBarang;
    
    private Database database;
    private Connection connection;
    
    public boolean create(){
        String insertSQL = "INSERT INTO barang VALUES (NULL, ?, ?, ?)";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(insertSQL);
            preparedStatement.setInt(1, this.jenisBarang.getId());
            preparedStatement.setString(2, this.namaBarang);
            preparedStatement.setDouble(3, this.harga);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean update(){
        String updateSQL = "UPDATE barang SET idjenisbarang=?, namabarang=?, harga=? WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(updateSQL);
            preparedStatement.setInt(1, this.jenisBarang.getId());
            preparedStatement.setString(2, this.namaBarang);
            preparedStatement.setDouble(3, this.harga);
            preparedStatement.setInt(4, this.id);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean delete(){
        String deleteSQL = "DELETE FROM barang WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, this.id);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Barang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Barang> read(){
        ArrayList<Barang> list = new ArrayList<>();
        
        String selectSQL = "SELECT barang.*, jenisbarang.namajenisbarang FROM barang \n" +
"INNER JOIN jenisbarang ON barang.idjenisbarang = jenisbarang.id" ;
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Barang b = new Barang();
                
                b.setId(rs.getInt("id"));
                b.setNamaBarang(rs.getString("namabarang"));
                b.setHarga(rs.getDouble("harga"));
                
                JenisBarang jb = new JenisBarang();
                jb.setId(rs.getInt("idjenisbarang"));
                jb.setNamajenisbarang(rs.getString("namajenisbarang"));
                
                b.setJenisBarang(jb);
                
                list.add(b);
            }
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ArrayList<Barang> search(String keywords){
        keywords = "%" + keywords + "%";
        ArrayList<Barang> list = new ArrayList<>();
        
        String selectSQL = "SELECT barang.*, jenisbarang.namajenisbarang FROM barang \n" +
"INNER JOIN jenisbarang ON barang.idjenisbarang = jenisbarang.id "
                + "WHERE namabarang like ? OR namajenisbarang like ?" ;
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, keywords);
            preparedStatement.setString(2, keywords);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Barang b = new Barang();
                
                b.setId(rs.getInt("id"));
                b.setNamaBarang(rs.getString("namabarang"));
                b.setHarga(rs.getDouble("harga"));
                
                JenisBarang jb = new JenisBarang();
                jb.setId(rs.getInt("idjenisbarang"));
                jb.setNamajenisbarang(rs.getString("namajenisbarang"));
                
                b.setJenisBarang(jb);
                
                list.add(b);
            }
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void find(){
        
        String selectSQL = "SELECT barang.*, jenisbarang.namajenisbarang FROM barang \n" +
"INNER JOIN jenisbarang ON barang.idjenisbarang = jenisbarang.id "
                + "WHERE barang.id = ?" ;
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, this.id);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                
                setId(rs.getInt("id"));
                setNamaBarang(rs.getString("namabarang"));
                setHarga(rs.getDouble("harga"));
                
                JenisBarang jb = new JenisBarang();
                jb.setId(rs.getInt("idjenisbarang"));
                jb.setNamajenisbarang(rs.getString("namajenisbarang"));
                
                setJenisBarang(jb);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public JenisBarang getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(JenisBarang jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    
    
}
