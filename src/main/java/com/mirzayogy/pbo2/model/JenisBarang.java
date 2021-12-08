package com.mirzayogy.pbo2.model;

import com.mirzayogy.pbo2.db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JenisBarang {
    private int id;
    private String namajenisbarang;
    
    private Database database;
    private Connection connection;
    
    @Override
    public String toString(){
        return namajenisbarang;
    }
    
    public boolean create(){
        
        String insertSQL = "INSERT INTO jenisbarang VALUES (NULL, ?)";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, this.namajenisbarang);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean update(){
        String updateSQL = "UPDATE jenisbarang SET namajenisbarang = ? WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, this.namajenisbarang);
            preparedStatement.setInt(2, this.id);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(){
        String deleteSQL = "DELETE FROM jenisbarang WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, this.id);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<JenisBarang> read(){
        
        ArrayList<JenisBarang> list = new ArrayList<>();
        
        String selectSQL = "SELECT * FROM jenisbarang" ;
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                JenisBarang jb = new JenisBarang();
                jb.setId(rs.getInt("id"));
                jb.setNamajenisbarang(rs.getString("namajenisbarang"));
                
                list.add(jb);
            }
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public boolean find(){
        String findSQL = "SELECT * FROM jenisbarang WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(findSQL);
            preparedStatement.setInt(1, this.id);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                this.setNamajenisbarang(rs.getString("namajenisbarang"));
                return true;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<JenisBarang> search(String keyword){
        ArrayList<JenisBarang> list = new ArrayList<>();
        
        String searchSQL = "SELECT * FROM jenisbarang WHERE namajenisbarang like ?" ;
        
        keyword = "%" + keyword + "%";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(searchSQL);
            preparedStatement.setString(1, keyword);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                JenisBarang jb = new JenisBarang();
                jb.setId(rs.getInt("id"));
                jb.setNamajenisbarang(rs.getString("namajenisbarang"));
                
                list.add(jb);
            }
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamajenisbarang() {
        return namajenisbarang;
    }

    public void setNamajenisbarang(String namajenisbarang) {
        this.namajenisbarang = namajenisbarang;
    }
}
