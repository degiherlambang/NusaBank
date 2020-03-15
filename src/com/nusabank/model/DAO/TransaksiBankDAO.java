/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.model.DAO;

import com.nusabank.model.database.DBConnection;
import com.nusabank.model.ModelTransaksiBank;
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
public class TransaksiBankDAO implements InterfaceTrxBankDAO {

    @Override
    public void insert(ModelTransaksiBank mtb) {
        try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement("INSERT INTO transaksi_bank "
                    + "(id_transaksi, jenis_transaksi, nominal, tgl_transaksi, kode_bank, rek_tujuan,"
                    + "biaya_admin, ket_transaksi)"
                    + "VALUES "
                    + "(null, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, mtb.getJenisTransaksi());
            statement.setInt(2, mtb.getNominal());
            statement.setDate(3, mtb.getTglTransaksi());
            statement.setInt(4, mtb.getKodeBank());
            statement.setInt(5, mtb.getRekTujuan());
            statement.setInt(6, mtb.getBiayaAdmin());
            statement.setString(7, mtb.getKetTransaksi());
            statement.executeUpdate();
            statement.close();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
            Logger.getLogger(RekeningDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ModelTransaksiBank mtb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ModelTransaksiBank> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ModelTransaksiBank> search(String category, String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ModelTransaksiBank> getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
