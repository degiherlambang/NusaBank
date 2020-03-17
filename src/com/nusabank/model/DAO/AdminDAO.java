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

    List<ModelAdmin> listAdmin;
    @Override
    public void insert(ModelAdmin admin) {
        try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement("INSERT INTO admin "
                    + "(id_admin, nama_admin, nik,username_admin, password_admin, tgl_lahir, photo, jenis_kelamin, no_hp)"
                    + "VALUES "
                    + "(null, ?, ?, ?, ?, ?, ?, ?, ?");
            statement.setString(1, admin.getNama());
            statement.setString(2, admin.getNIK());
            statement.setString(2, admin.getUsername());
            statement.setString(3, admin.getPassword());
            statement.setString(4, admin.getTglLahir());
            statement.setString(5, admin.getPhoto());
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
    try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(""
                    + "UPDATE admin SET "
                    + "nama_admin=?, nik=?, username_admin=?, password_admin=?,"
                    + "tgl_lahir=?, photo=?, jenis_kelamin=?, no_hp=?"
                    + "  WHERE id_admin=?");
            
            statement.setString(1, admin.getNama());
            statement.setString(2, admin.getNIK());
            statement.setString(3, admin.getUsername());
            statement.setString(4, admin.getPassword());
            statement.setString(5, admin.getTglLahir());
            statement.setString(6, admin.getPhoto());
            statement.setString(7, admin.getJenisKelamin());
            statement.setString(8, admin.getNoHp());
            statement.setInt(9, admin.getId());
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
    try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(""
                    + "DELETE FROM admin WHERE id_admin=?");
            
            statement.setInt(1, id);
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public List<ModelAdmin> getAll() {
    listAdmin = new ArrayList<ModelAdmin>();
        
        try {
            
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM admin");
            
            while (result.next()) { 
                ModelAdmin admin = new ModelAdmin();
                admin.setId(result.getInt("id_admin"));
                admin.setNama(result.getString("nama_admin"));
                admin.setNIK(result.getString("nik"));
                admin.setUsername(result.getString("username_admin"));
                admin.setPassword(result.getString("password_admin"));
                admin.setTglLahir(result.getString("tgl_lahir"));
                admin.setPhoto(result.getString("photo"));
                admin.setJenisKelamin(result.getString("jenis_kelamin"));
                admin.setNoHp(result.getString("no_hp"));
                listAdmin.add(admin);
            }
            
            
            statement.close();
            result.close();
            return listAdmin;
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<ModelAdmin> search(String category, String search) {
    listAdmin = new ArrayList<ModelAdmin>();
        
        try {
            String query = "SELECT * FROM admin WHERE "+category+" LIKE '%"+search+"%'";
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while (result.next()) { 
                ModelAdmin admin = new ModelAdmin();
                admin.setId(result.getInt("id_admin"));
                admin.setNama(result.getString("nama_admin"));
                admin.setNIK(result.getString("nik"));
                admin.setUsername(result.getString("username_admin"));
                admin.setPassword(result.getString("password_admin"));
                admin.setTglLahir(result.getString("tgl_lahir"));
                admin.setPhoto(result.getString("photo"));
                admin.setJenisKelamin(result.getString("jenis_kelamin"));
                admin.setNoHp(result.getString("no_hp"));
                listAdmin.add(admin);
            }
            
            
            statement.close();
            result.close();
            return listAdmin;
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<ModelAdmin> getById(int id) {
    listAdmin = new ArrayList<ModelAdmin>();
        
        try {
            String query = "SELECT * FROM admin WHERE id_admin='"+id+"'";
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while (result.next()) { 
                ModelAdmin admin = new ModelAdmin();
                admin.setId(result.getInt("id_admin"));
                admin.setNama(result.getString("nama_admin"));
                admin.setNIK(result.getString("nik"));
                admin.setUsername(result.getString("username_admin"));
                admin.setPassword(result.getString("password_admin"));
                admin.setTglLahir(result.getString("tgl_lahir"));;
                admin.setPhoto(result.getString("photo"));
                admin.setJenisKelamin(result.getString("jenis_kelamin"));
                admin.setNoHp(result.getString("no_hp"));
                listAdmin.add(admin);
            }
            
            
            statement.close();
            result.close();
            return listAdmin;
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
