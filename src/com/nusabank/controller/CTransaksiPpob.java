/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;
import com.nusabank.model.ModelTransaksiPPOB;
import com.nusabank.model.DAO.TransaksiPpobDAO;
import com.nusabank.model.DAO.InterfaceTrxPpobDAO;
import com.nusabank.model.table.TableModelTransaksiPPOB;
import com.nusabank.view.viewNasabah.*;
import com.nusabank.view.viewNasabah.ViewTrxPPOB;
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
public class CTransaksiPpob {
    private final ViewTrxPPOB cTrxPpob;
    
    private List<ModelTransaksiPPOB> listTrxPpob;

    private final  InterfaceTrxPpobDAO interfaceTrxPpob;
    
    public CTransaksiPpob(JFrame frame) {
        this.cTrxPpob = (ViewTrxPPOB) frame;
        interfaceTrxPpob = new TransaksiPpobDAO();
        listTrxPpob = interfaceTrxPpob.getAll();
    }
    
    
    public void insert() {

        ModelTransaksiPPOB trxPpob = new ModelTransaksiPPOB();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        java.util.Date tglPembuatan = new java.util.Date();
        
        trxPpob.setJenisTransaksi((cTrxPpob.getCmbJenisTransaksi().getSelectedItem().toString()));
        trxPpob.setNominal(Integer.parseInt(cTrxPpob.getTfNominal().getText()));
        trxPpob.setTglTransaksi(dateFormat.format(tglPembuatan));
        trxPpob.setNoTarget(Integer.parseInt(cTrxPpob.getTfNoTarget().getText()));
        trxPpob.setKetTransaksi(cTrxPpob.getTfKeterangan().getText());
        
        interfaceTrxPpob.insert(trxPpob);
    }
    public void reset() {
        cTrxPpob.getCmbJenisTransaksi().setSelectedItem(0);
        cTrxPpob.getTfNominal().setText("");
        cTrxPpob.getTfNoTarget().setText("");
        cTrxPpob.getTfKeterangan().setText("");
          
    }
    public void bindingTable(){
        listTrxPpob = interfaceTrxPpob.getAll();
        cTrxPpob.getTableTrxPPOB().setModel(new TableModelTransaksiPPOB(listTrxPpob));
    }

}
