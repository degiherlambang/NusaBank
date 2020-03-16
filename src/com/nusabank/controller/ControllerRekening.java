/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;

import com.nusabank.model.DAO.InterfaceRekeningDAO;
import com.nusabank.model.DAO.RekeningDAO;
import com.nusabank.model.ModelRekening;
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
public class ControllerRekening {
 
    private final ViewRegisNasabah vRegNasabah;

    private List<ModelRekening> listRekening;

    private final InterfaceRekeningDAO interfaceRekening;
    
    public ControllerRekening(JFrame frame) {
        this.vRegNasabah = (ViewRegisNasabah) frame;
        interfaceRekening = new RekeningDAO();
        listRekening = interfaceRekening.getAll();
    }
    
    public void bindingTable() {

    }

    public void getDataField() {

    }
    
    public void getData(int id) {
        listRekening = interfaceRekening.getById(id);
        vRegNasabah.getTxtIdRekening()
                .setText(String.valueOf(
                        listRekening.get(0)
                        .getIdRekening()
                ));
    }
    
    public void insert() {

        ModelRekening rekening = new ModelRekening();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        java.util.Date tglPembuatan = new java.util.Date();
        
        rekening.setNoPin(Integer.parseInt(String.valueOf(vRegNasabah.getTxtNoPIN().getPassword())));
        rekening.setNoRekening(vRegNasabah.getTxtNoRekening().getText());
        rekening.setSaldo(Integer.parseInt(vRegNasabah.getTxtSaldo().getText()));
        rekening.setJenisRekening(vRegNasabah.getCmbJenisRekening().getSelectedItem().toString());
        
        interfaceRekening.insert(rekening);
        vRegNasabah.getTxtIdRekening().setText(interfaceRekening.getLastId());
        
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

