/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;

import com.nusabank.helper.Function;
import com.nusabank.helper.Validation;
import com.nusabank.model.ModelNasabah;
import com.nusabank.model.DAO.NasabahDAO;
import com.nusabank.model.DAO.InterfaceNasabahDAO;
import com.nusabank.model.table.TableModelNasabah;
import com.nusabank.view.viewAdmin.ViewRegisNasabah;
import com.nusabank.view.viewNasabah.*;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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

    private Function func;
    private Validation validator;
    private final ViewRegisNasabah vRegNasabah;
    private String allMsgValidation;

    private boolean isAllValid;
    private boolean isInsert = true;
    private Boolean[] isEachFieldsValid;

    private int minPasswordLength = 6;
    private int maxPasswordLength = 12;

    private Color errorColor = new Color(225, 102, 102);
    
    private List<ModelNasabah> listNasabah;

    private final InterfaceNasabahDAO interfaceNasabah;
    
    public CRegisNasabah(JFrame frame) {
        this.vRegNasabah = (ViewRegisNasabah) frame;
        interfaceNasabah = new NasabahDAO();
        func = new Function();
        listNasabah = interfaceNasabah.getAll();
    }

    public String getAllMsgValidation(){
        return allMsgValidation;
    }
    
    public void reset() {
        vRegNasabah.getTxtNama().setText("");
        vRegNasabah.getTxtAlamat().setText("");
        vRegNasabah.getTxtAlamatKantor().setText("");
        vRegNasabah.getTxtNIK().setText("");
        vRegNasabah.getTxtNamaIbu().setText("");
        vRegNasabah.getTxtNoHP().setText("");
        vRegNasabah.getTxtNoPIN().setText("123456");
        vRegNasabah.getTxtPassword().setText("");
        vRegNasabah.getTxtPekerjaan().setText("");
        vRegNasabah.getTxtPendapatan().setText("0");
        vRegNasabah.getTxtRePassword().setText("");
        vRegNasabah.getTxtSaldo().setText("");
        vRegNasabah.getTxtUsername().setText("");
        vRegNasabah.getCmbJenisKelamin().setSelectedIndex(0);
        vRegNasabah.getCmbStatus().setSelectedIndex(0);
        vRegNasabah.getLbFoto().setText("file...");
        vRegNasabah.getLbNamaNasabah().setText("");   
        vRegNasabah.getTxtIdRekening().setText("0");
        vRegNasabah.getTxtNoRekening().setText("");
        vRegNasabah.getTxtEmail().setText("");
        
        // reset the error condition
        vRegNasabah.getTxtNama().setBackground(Color.WHITE);
        vRegNasabah.getTxtAlamat().setBackground(Color.WHITE);
        vRegNasabah.getTxtAlamatKantor().setBackground(Color.WHITE);
        vRegNasabah.getTxtLahir().setBackground(Color.WHITE);
        vRegNasabah.getTxtNIK().setBackground(Color.WHITE);
        vRegNasabah.getTxtNamaIbu().setBackground(Color.WHITE);
        vRegNasabah.getTxtNoHP().setBackground(Color.WHITE);
        vRegNasabah.getTxtNoPIN().setBackground(Color.WHITE);
        vRegNasabah.getTxtPassword().setBackground(Color.WHITE);
        vRegNasabah.getTxtPekerjaan().setBackground(Color.WHITE);
        vRegNasabah.getTxtPendapatan().setBackground(Color.WHITE);
        vRegNasabah.getTxtRePassword().setBackground(Color.WHITE);
        vRegNasabah.getTxtSaldo().setBackground(Color.WHITE);
        vRegNasabah.getTxtUsername().setBackground(Color.WHITE);
        vRegNasabah.getCmbJenisKelamin().setBackground(Color.WHITE);
        vRegNasabah.getCmbStatus().setBackground(Color.WHITE);
        vRegNasabah.getLbFoto().setBackground(Color.WHITE);
        vRegNasabah.getTxtEmail().setBackground(Color.WHITE);
    }

    public void insert() {

        ModelNasabah nasabah = new ModelNasabah();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date tglPembuatan = new java.util.Date();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tglLahir = sdf.format(vRegNasabah.getTxtLahir().getDate());
        
        nasabah.setNama(vRegNasabah.getTxtNama().getText());
        nasabah.setUsername(vRegNasabah.getTxtUsername().getText());
        nasabah.setPassword(String.valueOf(vRegNasabah.getTxtPassword().getPassword()));
        nasabah.setJenisKelamin(vRegNasabah.getCmbJenisKelamin().getSelectedItem().toString());
        nasabah.setNik(vRegNasabah.getTxtNIK().getText());
        nasabah.setNoHp(vRegNasabah.getTxtNoHP().getText());
        nasabah.setStatus(vRegNasabah.getCmbStatus().getSelectedItem().toString());
        nasabah.setPekerjaan(vRegNasabah.getTxtPekerjaan().getText());
        nasabah.setPendapatan(Integer.parseInt(vRegNasabah.getTxtPendapatan().getText()));
        nasabah.setNamaIbu(vRegNasabah.getTxtNamaIbu().getText());
        nasabah.setPhoto(vRegNasabah.getLbFoto().getText());
        nasabah.setAlamatKantor(vRegNasabah.getTxtAlamatKantor().getText());
        nasabah.setAlamatRumah(vRegNasabah.getTxtAlamat().getText());
        nasabah.setTglLahir(tglLahir);
        nasabah.setTglPembuatan(dateFormat.format(tglPembuatan));
        nasabah.setIdRekening(Integer.parseInt(vRegNasabah.getTxtIdRekening().getText()));
        nasabah.setEmail(vRegNasabah.getTxtEmail().getText());
        nasabah.setIdAdmin(Integer.parseInt(vRegNasabah.getLbNoIdAdmin().getText()));
        
        String newFileName = func.uploadPhotoNasabah(vRegNasabah, nasabah);
        nasabah.setPhoto(newFileName);
        
        interfaceNasabah.insert(nasabah);
        vRegNasabah.getLbNamaNasabah().setText(nasabah.getNama());
        JOptionPane.showMessageDialog(null,"Data berhasil di input");
    }

    public boolean validateForm() {
        validator = Validation.buildPasswordRule(false, false, true, 6, 12);
        ModelNasabah nasabah = new ModelNasabah();

        isEachFieldsValid = new Boolean[15];

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tglLahir = sdf.format(this.vRegNasabah.getTxtLahir().getDate());
        
        int pendapatan = Integer.parseInt(vRegNasabah.getTxtPendapatan().getText());
        //String formattedPendapatan = "0";
        if (pendapatan==0 || String.valueOf(pendapatan).isEmpty() || String.valueOf(pendapatan).equals("")) {
            pendapatan = 0;
        } 

        nasabah.setNama(vRegNasabah.getTxtNama().getText());
        nasabah.setNik(vRegNasabah.getTxtNIK().getText());
        nasabah.setTglLahir(tglLahir);
        nasabah.setAlamatRumah(vRegNasabah.getTxtAlamat().getText());
        nasabah.setJenisKelamin(vRegNasabah.getCmbJenisKelamin().getSelectedItem().toString());
        nasabah.setPekerjaan(vRegNasabah.getTxtPekerjaan().getText());
        nasabah.setAlamatKantor(vRegNasabah.getTxtAlamatKantor().getText());
        nasabah.setPendapatan(pendapatan);
        nasabah.setNoHp(vRegNasabah.getTxtNoHP().getText());
        nasabah.setStatus(vRegNasabah.getCmbStatus().getSelectedItem().toString());
        nasabah.setNamaIbu(vRegNasabah.getTxtNamaIbu().getText());
        nasabah.setUsername(vRegNasabah.getTxtUsername().getText());
        nasabah.setPassword(String.valueOf(vRegNasabah.getTxtPassword().getPassword()));
        nasabah.setIdRekening(Integer.parseInt(vRegNasabah.getTxtIdRekening().getText()));
        nasabah.setEmail(vRegNasabah.getTxtEmail().getText());
        

        StringBuilder messageBuilder = new StringBuilder();
        java.util.Date todayDate = new java.util.Date();

        if ((nasabah.getNama().isEmpty())
                && (String.valueOf(nasabah.getNik()).equals(""))
                && (nasabah.getUsername().isEmpty())
                && (nasabah.getPassword().isEmpty())
                && (vRegNasabah.getTxtRePassword().equals(""))
                && (nasabah.getEmail().isEmpty())
                && (nasabah.getJenisKelamin().isEmpty()
                    || nasabah.getJenisKelamin().equals("- Choose -"))
                && (nasabah.getNoHp().isEmpty())
                && (nasabah.getTglLahir().isEmpty()
                    || (vRegNasabah.getTxtLahir().getDate().compareTo(todayDate) < 0))
                && (nasabah.getAlamatRumah().isEmpty())
                && (nasabah.getAlamatKantor().isEmpty())
                && (nasabah.getStatus().isEmpty()
                    ||nasabah.getStatus().equals("- Choose -"))
                && (nasabah.getNamaIbu().isEmpty())
                && (nasabah.getPekerjaan().isEmpty())
                && (String.valueOf(nasabah.getPendapatan()).equals("")||String.valueOf(nasabah.getPendapatan()).isEmpty())
                && (String.valueOf(nasabah.getIdRekening()).equals("")||String.valueOf(nasabah.getIdRekening()).isEmpty())    
                ) {

            JOptionPane.showMessageDialog(vRegNasabah,
                    "Please don't leave fields blank!",
                    "Warning",
                    JOptionPane.ERROR_MESSAGE
            );

            isAllValid = false;

        } else if (isAllValid == false) {

            if (!validator.isValidName(nasabah.getNama())) {

                messageBuilder.append("\n > Incorrect Name input, "
                        + "please use alphanumeric characters and avoid symbols!");

                vRegNasabah.getTxtNama().setBackground(errorColor);
                isEachFieldsValid[0] = false;

            } else {

                isEachFieldsValid[0] = true;

            }

            if (!validator.isValidNIK(nasabah.getNik())) {

                messageBuilder.append("\n > Incorrect NIK input, "
                        + "only numeric input accepted !");

                vRegNasabah.getTxtNIK().setBackground(errorColor);
                isEachFieldsValid[1] = false;

            } else {

                isEachFieldsValid[1] = true;

            }

            if (!validator.isValidUsername(nasabah.getUsername())) {

                messageBuilder.append("\n > Incorrect Username input, "
                        + "please use alphanumeric characters and avoid symbols!");

                vRegNasabah.getTxtUsername().setBackground(errorColor);
                isEachFieldsValid[2] = false;

            } else {

                isEachFieldsValid[2] = true;

            }

            if (!validator.isValidEmail(nasabah.getEmail())) {

                messageBuilder.append("\n > Incorrect Email input, "
                        + "the format should be like name@mailhost.com !");

                vRegNasabah.getTxtEmail().setBackground(errorColor);
                isEachFieldsValid[3] = false;
            
            } else {
            
                isEachFieldsValid[3] = true;
            
            }

            if (!validator.isValidPassword(nasabah.getPassword().toString())) {

                messageBuilder.append("\n > Incorrect Password input !"
                        + "\n\t->Password should be alphanumeric"
                        + "\n\t->Password should have at least 1 number"
                        + "\n\t->Password should have minimum "
                        + minPasswordLength + " characters"
                        + "\n\t->and maximum of " + maxPasswordLength + " characters"
                        + "\n\t->No Capital letters"
                        + "\n\t->and doesn't include whitespaces "
                        + "\n\tor special characters !");

                vRegNasabah.getTxtPassword().setBackground(errorColor);
                isEachFieldsValid[4] = false;
            
            } else {
            
                isEachFieldsValid[4] = true;
            
            }

            if (!validator.isValidPhoneNumber(nasabah.getNoHp())) {

                messageBuilder.append("\n Incorrect Phone Number input !"
                        + "\n\t-> The phone number format should be like this:"
                        + "\n\t-> +62 82123456789"
                        + "\n\t-> Contains numerical digit only"
                        + "\n\t-> With maximum length: 14 digits");

                vRegNasabah.getTxtNoHP().setBackground(errorColor);
                isEachFieldsValid[5] = false;
            
            } else {
            
                isEachFieldsValid[5] = true;
            
            }

            if (!validator.isValidDate(nasabah.getTglLahir())) {

                messageBuilder.append("\n Incorrect Date Format input !"
                        + "\n\t-> Date of birth format should be like this: "
                        + "\n\t-> e.g: 1970-01-31"
                        + "\n\t-> format: yyyy-mm-dd.");

                vRegNasabah.getTxtLahir().setBackground(errorColor);
                isEachFieldsValid[6] = false;
            
            } else {
            
                isEachFieldsValid[6] = true;
            
            }

            if (nasabah.getAlamatRumah().isEmpty()) {

                messageBuilder.append("\n Home Address field can't be blank!");

                vRegNasabah.getTxtAlamat().setBackground(errorColor);
                isEachFieldsValid[7] = false;
            
            } else {
            
                isEachFieldsValid[7] = true;
            
            }

            if (nasabah.getJenisKelamin().isEmpty()
                    || nasabah.getJenisKelamin().equals("- Choose -")) {

                messageBuilder.append("\n Please select your gender !");

                vRegNasabah.getCmbJenisKelamin().setBackground(errorColor);
                isEachFieldsValid[8] = false;
            
            } else {
            
                isEachFieldsValid[8] = true;
            
            }
            
            if (nasabah.getStatus().isEmpty()
                    || nasabah.getStatus().equals("- Choose -")) {

                messageBuilder.append("\n Please select your current relationship status !");

                vRegNasabah.getCmbStatus().setBackground(errorColor);
                isEachFieldsValid[9] = false;
            
            } else {
            
                isEachFieldsValid[9] = true;
            
            }
            
            if (!String.valueOf(vRegNasabah.getTxtPassword().getPassword())
                    .equals(String.valueOf(vRegNasabah.getTxtRePassword().getPassword()))
               ) 
            {
                messageBuilder.append("\n Your re-typed password isn't match!");
                vRegNasabah.getTxtRePassword().setBackground(errorColor);
                vRegNasabah.getTxtPassword().setBackground(errorColor);
                isEachFieldsValid[10] = false;
            } else {
                isEachFieldsValid[10] = true;
            }
            
            this.allMsgValidation = messageBuilder.toString();
            vRegNasabah.getTxtAreaValidation().setText(messageBuilder.toString());
            
            
            if (
                    isEachFieldsValid[0] == true
                    && isEachFieldsValid[1] == true
                    && isEachFieldsValid[2] == true
                    && isEachFieldsValid[3] == true
                    && isEachFieldsValid[4] == true
                    && isEachFieldsValid[5] == true
                    && isEachFieldsValid[6] == true
                    && isEachFieldsValid[7] == true
                    && isEachFieldsValid[8] == true
                    && isEachFieldsValid[9] == true
                    && isEachFieldsValid[10] == true
                )
            {
            
                isAllValid = true;
            
            } else {
            
                isAllValid = false;
            
            }

        }
        
        if (isAllValid == true) {
            
            //this.insert();
            //this.reset();
            return isAllValid;
            
        } else {
            
            //JOptionPane.showMessageDialog(vRegNasabah, "There's something wrong");
            return isAllValid;
            
        }
    }
}
