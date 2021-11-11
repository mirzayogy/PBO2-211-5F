package com.mirzayogy.pbo2;

import com.mirzayogy.pbo2.model.JenisBarang;
import com.mirzayogy.pbo2.model.Pengguna;
import com.mirzayogy.pbo2.view.LoginFrame;
import com.mirzayogy.pbo2.view.MainPublic;
import com.mirzayogy.pbo2.view.admin.JenisBarangViewFrame;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
//        LoginFrame loginFrame = new LoginFrame();
//        loginFrame.setVisible(true);

        JenisBarang jenisBarang = new JenisBarang();
        
//        jenisBarang.setNamajenisbarang("Modul 5F");
//        if(jenisBarang.create()){
//            System.out.println("Simpan Berhasil");
//        } else {
//            System.out.println("Gagal Simpan");
//        }


//        jenisBarang.setId(16);
//        jenisBarang.setNamajenisbarang("Modul 5F baru");
//        if(jenisBarang.update()){
//            System.out.println("Ubah Data Berhasil");
//        } else {
//            System.out.println("Gagal Ubah Data");
//        }

//        jenisBarang.setId(8);
//        if(jenisBarang.delete()){
//            System.out.println("Hapus Data Berhasil");
//        } else {
//            System.out.println("Gagal Hapus Data");
//        }
        
//        jenisBarang.setId(3);
//        if(jenisBarang.find()){
//            System.out.println(jenisBarang.getNamajenisbarang());
//        } else {
//            System.out.println("Data tidak ditemukan");
//        }

//        ArrayList<JenisBarang> list = jenisBarang.read();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getNamajenisbarang());
//        }

//       

        JenisBarangViewFrame jenisBarangViewFrame = new JenisBarangViewFrame();
        jenisBarangViewFrame.setVisible(true);
    }
}
