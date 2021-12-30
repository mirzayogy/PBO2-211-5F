package com.mirzayogy.pbo2.model;

import com.mirzayogy.pbo2.db.Database;
import java.sql.Connection;
import java.util.ArrayList;

public class PenjualanDetail {
    private int id;
    private Penjualan penjualan;
    private Barang barang;
    private double hargaJual;
    private int jumlah;
    
    private Database database;
    private Connection connection;
    
    public boolean create(){
        return false;
    }

    public boolean update(){
        return false;
    }
    
    public boolean delete(){
        return false;
    }
    
    public ArrayList<PenjualanDetail> read(){
        return null;
    }
    
    public ArrayList<PenjualanDetail> search(String keywords){
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Penjualan getPenjualan() {
        return penjualan;
    }

    public void setPenjualan(Penjualan penjualan) {
        this.penjualan = penjualan;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public double getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(double hargaJual) {
        this.hargaJual = hargaJual;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
    
}
