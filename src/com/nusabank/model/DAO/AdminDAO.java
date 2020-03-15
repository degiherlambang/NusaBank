/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.model.DAO;

import com.nusabank.model.database.DBConnection;
import com.nusabank.model.ModelAdmin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author ANDI DWI SAPUTRO
 */
public class AdminDAO implements InterfaceAdminDAO {

    List<ModelAdmin> modelAdmin;
    @Override
    public void insert(ModelAdmin admin) {
        try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement("INSERT INTO admin "
                    + "(id_admin, nama_admin, username_admin, password_admin, photo, jenis_kelamin, no_hp)"
                    + "VALUES "
                    + "(null, ?, ?, ?, ?, ?, ?, ?");
            statement.setString(1, admin.getNama());
            statement.setString(2, admin.getUsername());
            statement.setString(3, admin.getPassword());
            statement.setString(4, admin.getPhoto());
            statement.setString(6, admin.getJenisKelamin());
            statement.setString(7, admin.getNoHp());
            
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ModelAdmin admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ModelAdmin> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ModelAdmin> search(String category, String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ModelAdmin> getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
