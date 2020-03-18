/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;
import com.nusabank.model.ModelTransaksiBank;
import com.nusabank.model.DAO.TransaksiBankDAO;
import com.nusabank.model.DAO.InterfaceTrxBankDAO;
import com.nusabank.model.table.TableModelTransaksiBank;
import com.nusabank.view.viewNasabah.*;
import com.nusabank.view.viewNasabah.ViewTrxBank;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class CTransaksiBank {
    private final ViewTrxBank cTrxBank;
    
    private List<ModelTransaksiBank> listTrxBank;

    private final  InterfaceTrxBankDAO interfaceTrxBank;
    
    public CTransaksiBank(JFrame frame) {
        this.cTrxBank = (ViewTrxBank) frame;
        interfaceTrxBank = new TransaksiBankDAO();
        listTrxBank = interfaceTrxBank.getAll();
    }
    
    public void insert() {

        ModelTransaksiBank trxBank = new ModelTransaksiBank();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        java.util.Date tglPembuatan = new java.util.Date();
        
        trxBank.setJenisTransaksi((cTrxBank.getCmbJenisTransaksi().getSelectedItem().toString()));
        trxBank.setNominal(Integer.parseInt(cTrxBank.getTfNominal().getText()));
        trxBank.setTglTransaksi(dateFormat.format(tglPembuatan));
        trxBank.setKodeBank(Integer.parseInt(cTrxBank.getTfKodeBank().getText()));
        trxBank.setRekTujuan(Integer.parseInt(cTrxBank.getTfNoRekTujuan().getText()));
        trxBank.setBiayaAdmin(1000);
        trxBank.setKetTransaksi(cTrxBank.getTfKeterangan().getText());
        
        interfaceTrxBank.insert(trxBank);
       
    }
    
    public void reset() {
        cTrxBank.getCmbJenisTransaksi().setSelectedItem(0);
        cTrxBank.getTfNominal().setText("");
        cTrxBank.getTfKodeBank().setText("");
        cTrxBank.getTfNoRekTujuan().setText("");
        cTrxBank.getTfKeterangan().setText("");
          
    }
}
