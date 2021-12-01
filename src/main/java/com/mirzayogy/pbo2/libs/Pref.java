package com.mirzayogy.pbo2.libs;

import com.mirzayogy.pbo2.model.Pengguna;
import java.util.prefs.Preferences;

public class Pref {
    public void simpan(Pengguna pengguna){
        Preferences preferences = Preferences.userNodeForPackage(Pref.class);
        preferences.putInt("5F_id", pengguna.getId());
        preferences.put("5F_username", pengguna.getUsername());
        preferences.put("5F_nama_lengkap", pengguna.getNamaLengkap());
        preferences.putBoolean("5F_is_admin", pengguna.isIsAdmin());
    }
    
    public Pengguna ambil(){
        Preferences preferences = Preferences.userNodeForPackage(Pref.class);
        
        Pengguna pengguna = new Pengguna();
        
        pengguna.setId(preferences.getInt("5F_id",0));
        pengguna.setUsername(preferences.get("5F_username", ""));
        pengguna.setNamaLengkap(preferences.get("5F_nama_lengkap", ""));
        pengguna.setIsAdmin(preferences.getBoolean("5F_is_admin", false));
        
        return pengguna;
        
    }
    
    public void hapus(){
        Preferences preferences = Preferences.userNodeForPackage(Pref.class);
        preferences.putInt("5F_id", 0);
        preferences.put("5F_username", "");
        preferences.put("5F_nama_lengkap", "");
        preferences.putBoolean("5F_is_admin", false);
    }
}
