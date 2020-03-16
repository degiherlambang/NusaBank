/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;

import com.nusabank.model.ModelNasabah;
import com.nusabank.model.DAO.NasabahDAO;
import com.nusabank.model.DAO.InterfaceNasabahDAO;
import com.nusabank.model.table.TableModelNasabah;
import com.nusabank.view.viewAdmin.ViewRegisNasabah;
import com.nusabank.view.viewNasabah.*;
import java.sql.Date;
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
 * @author ANDI DWI SAPUTRO
 */
public class CRegisNasabah {

    private final ViewRegisNasabah vRegNasabah;

    private List<ModelNasabah> listNasabah;

    private final InterfaceNasabahDAO interfaceNasabah;
    
    public CRegisNasabah(JFrame frame) {
        this.vRegNasabah = (ViewRegisNasabah) frame;
        interfaceNasabah = new NasabahDAO();
        listNasabah = interfaceNasabah.getAll();
    }

    public void reset() {
        vRegNasabah.getTxtNama().setText("");
        vRegNasabah.getTxtAlamat().setText("");
        vRegNasabah.getTxtAlamatKantor().setText("");
        vRegNasabah.getTxtLahir().setDateFormatString(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-mm-yyyy")));
        vRegNasabah.getTxtNIK().setText("");
        vRegNasabah.getTxtNamaIbu().setText("");
        vRegNasabah.getTxtNoHP().setText("");
        vRegNasabah.getTxtNoPIN().setText("");
        //vRegNasabah.getTxtNoRekening().setText("");
        vRegNasabah.getTxtPassword().setText("");
        vRegNasabah.getTxtPekerjaan().setText("");
        vRegNasabah.getTxtRePassword().setText("");
        vRegNasabah.getTxtSaldo().setText("");
        vRegNasabah.getTxtUsername().setText("");
        vRegNasabah.getCmbJenisKelamin().setSelectedIndex(0);
        vRegNasabah.getCmbStatus().setSelectedIndex(0);
        vRegNasabah.getLbFoto().setText("file...");
        vRegNasabah.getLbNamaNasabah().setText("");   
    }

    public void insert() {

        ModelNasabah nasabah = new ModelNasabah();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        java.util.Date tglPembuatan = new java.util.Date();
        
        nasabah.setNama(vRegNasabah.getTxtNama().getText());
        nasabah.setUsername(vRegNasabah.getTxtUsername().getText());
        nasabah.setPassword(String.valueOf(vRegNasabah.getTxtPassword().getPassword()));
        nasabah.setJenisKelamin(vRegNasabah.getCmbJenisKelamin().getSelectedItem().toString());
        nasabah.setNik(Integer.parseInt(vRegNasabah.getTxtNIK().getText()));
        nasabah.setNoHp(vRegNasabah.getTxtNoHP().getText());
        nasabah.setStatus(vRegNasabah.getCmbStatus().getSelectedItem().toString());
        nasabah.setPekerjaan(vRegNasabah.getTxtPekerjaan().getText());
        nasabah.setPendapatan(Integer.parseInt(vRegNasabah.getTxtPendapatan().getText()));
        nasabah.setNamaIbu(vRegNasabah.getTxtNamaIbu().getText());
        nasabah.setPhoto(vRegNasabah.getLbFoto().getText());
        nasabah.setAlamatKantor(vRegNasabah.getTxtAlamatKantor().getText());
        nasabah.setAlamatRumah(vRegNasabah.getTxtAlamat().getText());
        nasabah.setTglLahir((new java.sql.Date(vRegNasabah.getTxtLahir().getDate().getTime()).toString()));
        nasabah.setTglPembuatan(dateFormat.format(tglPembuatan));
        nasabah.setIdRekening(Integer.parseInt(vRegNasabah.getTxtIdRekening().getText()));
        
        interfaceNasabah.insert(nasabah);
        JOptionPane.showMessageDialog(null,"Data berhasil di input");
    }

}
