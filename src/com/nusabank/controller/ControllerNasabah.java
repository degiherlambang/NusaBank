/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;

import com.nusabank.model.ModelNasabah;
import com.nusabank.model.DAO.NasabahDAO;
import com.nusabank.model.DAO.InterfaceNasabahDAO;
import com.nusabank.model.DAO.InterfaceRekeningDAO;
import com.nusabank.model.DAO.RekeningDAO;
import com.nusabank.model.ModelRekening;
import com.nusabank.model.table.TableModelNasabah;
import com.nusabank.view.viewAdmin.ViewRegisNasabah;
import com.nusabank.view.viewNasabah.*;
import java.sql.Date;
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
public class ControllerNasabah {

    private final ViewRegisNasabah vRegNasabah;

    private List<ModelNasabah> listNasabah;
    private List<ModelRekening> listRekening;

    private final InterfaceNasabahDAO interfaceNasabah;
    private final InterfaceRekeningDAO interfaceRekening;
    
    public ControllerNasabah(JFrame frame) {
        this.vRegNasabah = (ViewRegisNasabah) frame;
        interfaceNasabah = new NasabahDAO();
        listNasabah = interfaceNasabah.getAll();
        interfaceRekening = new RekeningDAO();
        listRekening = interfaceRekening.getAll();
    }

    public void reset() {
        /* reset form transaksi banking
        vTrxBank.getCmbJenisTransaksi().setSelectedIndex(0);
        vTrxBank.getTfNoRekTujuan().setText("");
        vTrxBank.getTfKodeBank().setText("");
        vTrxBank.getTfNominal().setText("");
        vTrxBank.getTfKeterangan().setText("");
        vTrxBank.getTableTrxBank().clearSelection();

        // reset form transaksi ppob
        vTrxPPOB.getCmbJenisTransaksi().setSelectedIndex(0);
        vTrxPPOB.getTfNoTarget().setText("");
        vTrxPPOB.getTfNominal().setText("");
        vTrxPPOB.getTfKeterangan().setText("");
        vTrxPPOB.getTableTrxPPOB().clearSelection();
        */
        // reset form regis nasabah
        vRegNasabah.getTxtNama().setText("");
        vRegNasabah.getTxtAlamat().setText("");
        vRegNasabah.getTxtAlamatKantor().setText("");
        vRegNasabah.getTxtLahir().setDateFormatString(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-mm-yyyy")));
        vRegNasabah.getTxtNIK().setText("");
        vRegNasabah.getTxtNamaIbu().setText("");
        vRegNasabah.getTxtNoHP().setText("");
        vRegNasabah.getTxtNoPIN().setText("");
        vRegNasabah.getTxtNoRekening().setText("");
        vRegNasabah.getTxtPassword().setText("");
        vRegNasabah.getTxtPekerjaan().setText("");
        vRegNasabah.getTxtRePassword().setText("");
        vRegNasabah.getTxtSaldo().setText("");
        vRegNasabah.getTxtUsername().setText("");
        vRegNasabah.getCmbJenisKelamin().setSelectedIndex(0);
        vRegNasabah.getCmbStatus().setSelectedIndex(0);
        vRegNasabah.getLbFoto().setText("file...");
        vRegNasabah.getLbNamaNasabah().setText("");
        
        
        // reset form edit data diri
        // TO-DO soon
        // reset form ganti PIN
        // TO-DO soon    
    }

    public void bindingTable() {

    }

    public void getDataField() {

    }

    public void insert() {

        ModelNasabah nasabah = new ModelNasabah();
        ModelRekening rekening = new ModelRekening();

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
        nasabah.setTglLahir((java.sql.Date) vRegNasabah.getTxtLahir().getDate());
        
        rekening.setNoPin(Integer.parseInt(String.valueOf(vRegNasabah.getTxtNoPIN().getPassword())));
        rekening.setNoRekening(Integer.parseInt(vRegNasabah.getTxtNoRekening().getText()));
        rekening.setSaldo(Integer.parseInt(vRegNasabah.getTxtSaldo().getText()));
        
        interfaceRekening.insert(rekening);
        interfaceNasabah.insert(nasabah);
    }

    public void update() {

    }

    public void delete() {

    }

    public void searchData() {

    }

    public void bindingSearch() {

    }

    public String generateNoRek(String nmNasabah, String dob, String dj) {
        String norekResult = "1234567890";

        String a = nmNasabah;
        String b = dob;
        String c = dj;
        int hash1 = a.hashCode();
        int hash2 = b.hashCode();
        int hash3 = c.hashCode();
        String pt1 = String.valueOf(hash1).substring(1, 5);
        String pt2 = String.valueOf(hash2).substring(1, 5);
        String pt3 = String.valueOf(hash3).substring(1, 5);
        String cont = pt1 + pt2 + pt3;
        System.out.println(hash1);
        System.out.println(hash2);
        System.out.println(hash3);
        System.out.println(pt1);
        System.out.println(pt2);
        System.out.println(pt3);
        System.out.println(cont);
        norekResult = cont;
        
        return norekResult;
    }
}
