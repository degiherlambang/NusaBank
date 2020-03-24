/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;

import com.nusabank.helper.Function;
import com.nusabank.model.ModelNasabah;
import com.nusabank.model.ModelRekening;
import com.nusabank.model.DAO.NasabahDAO;
import com.nusabank.model.DAO.RekeningDAO;
import com.nusabank.model.DAO.InterfaceNasabahDAO;
import com.nusabank.model.DAO.InterfaceRekeningDAO;
import com.nusabank.model.database.DBConnection;
import com.nusabank.view.viewNasabah.ViewMenuNasabah;
import com.nusabank.view.viewNasabah.ViewAccountInfo;
import com.nusabank.view.viewNasabah.ViewForgotPIN;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDI DWI SAPUTRO
 */
public class CForgotPIN {
    
    private final ViewForgotPIN vForgotPin;
    private Function func;
    
    private ViewMenuNasabah vmn;
    private ViewAccountInfo vai;
    
    private List<ModelNasabah> listNasabah;
    private List<ModelRekening> listRekening;
    
    private final int idRekening;
    private final String idNasabah;
    
    private String noRek;
    private int noPIN;
    
    
    private final NasabahDAO interfaceNasabah;
    private final RekeningDAO interfaceRekening;
    
    public CForgotPIN(ViewForgotPIN vFP, String idNasabah){
        this.vForgotPin = vFP;
        func = new Function();
        this.interfaceNasabah = new NasabahDAO();
        this.interfaceRekening = new RekeningDAO();
        this.idNasabah = idNasabah;
        this.idRekening = interfaceNasabah.getIdRekening(idNasabah);
        noRek = interfaceRekening.getNoRek(idRekening);
        noPIN = interfaceRekening.getNoPIN(idRekening);
    }
    
    public void showPIN() {
        ModelNasabah nasabah = new ModelNasabah();
        ModelRekening rekening = new ModelRekening();
        
        listNasabah = interfaceNasabah.getById(Integer.parseInt(idNasabah));
        listRekening = interfaceRekening.getById(this.idRekening);
 
        
        nasabah.setUsername(vForgotPin.getTxtUsername().getText());
        nasabah.setPassword(String.valueOf(vForgotPin.getTxtPassword().getPassword()));
        nasabah.setNamaIbu(vForgotPin.getTxtMotherName().getText());
        rekening.setNoRekening(vForgotPin.getTxtNoRekening().getText());
        
        rekening.setIdRekening(listNasabah.get(0).getIdRekening());
        
        if (listNasabah.get(1).getUsername().equals(nasabah.getUsername())
            && listNasabah.get(1).getPassword().equals(nasabah.getPassword())
            && listNasabah.get(1).getNamaIbu().equals(nasabah.getNamaIbu())
            && listRekening.get(1).getNoRekening().equals(rekening.getNoRekening())
            && vForgotPin.getTxtCaptchaField().getText().equalsIgnoreCase(vForgotPin.getLbCaptcha().getText()))
        {
            
            JOptionPane.showMessageDialog(vForgotPin, "Your PIN is: "+this.noPIN
                    + "\nPlease don't share your PIN to others "
                    + "and keep it secret only for you!",
                    "Forgot PIN",
                    JOptionPane.INFORMATION_MESSAGE
            );
            
        } else {
            JOptionPane.showMessageDialog(vForgotPin, "Wrong input or data mismatch with the database", "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }
}
