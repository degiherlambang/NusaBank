/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.model.DAO;

import com.nusabank.model.database.DBConnection;
import com.nusabank.model.ModelRekening;
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
public class RekeningDAO implements InterfaceRekeningDAO {
    
    List<ModelRekening> modelRekening;
    
    @Override
    public void insert(ModelRekening rekening) {
        try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement("INSERT INTO rekening "
                    + "(id_rekening, no_rekening, saldo, jenis_rekening, no_pin)"
                    + "VALUES "
                    + "(null, ?, ?, ?, ?)");
            statement.setInt(1, rekening.getNoRekening());
            statement.setInt(2, rekening.getSaldo());
            statement.setString(3, rekening.getJenisRekening());
            statement.setInt(4, rekening.getNoPin());
            
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
            Logger.getLogger(RekeningDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ModelRekening rekening) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ModelRekening> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ModelRekening> search(String category, String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ModelRekening> getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
