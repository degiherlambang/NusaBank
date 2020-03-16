/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;

import com.nusabank.view.viewAdmin.ViewMenuAdmin;
import com.nusabank.model.database.DBConnection;
import com.nusabank.model.ModelAdmin;
import com.nusabank.model.DAO.InterfaceAdminDAO;
import com.nusabank.model.DAO.AdminDAO;
import com.nusabank.view.viewLogin.ViewLoginAdmin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDI DWI SAPUTRO
 */
public class CLoginAdmin {

    private final ViewLoginAdmin vLoginAdmin;

    //private List<ModelAdmin> listAdmin;

    //private final InterfaceAdminDAO interAdminDAO;

    public CLoginAdmin(ViewLoginAdmin vLoginAdmin) {
        this.vLoginAdmin = vLoginAdmin;
    }
    
    public void doLogin(String username, String password){
        try{
            String sql = "SELECT*FROM admin where username_admin=? AND password_admin=?";
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                    JOptionPane.showMessageDialog(null, "Login Sukses!");
                    ViewMenuAdmin vMenuAdmin = new ViewMenuAdmin();
                    vMenuAdmin.setVisible(true);
               
            } else {
                JOptionPane.showMessageDialog(null, "Login Gagal!"+username+" "+password);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
    }
}
