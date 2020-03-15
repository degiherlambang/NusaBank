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
import com.nusabank.view.viewNasabah.ViewMenuNasabah;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDI DWI SAPUTRO
 */
public class ControllerNasabah {
    private final ViewMenuNasabah vMenuNasabah;
    private List<ModelNasabah> listNasabah;
    private final InterfaceNasabahDAO interfaceNasabah;
    
    public ControllerNasabah() {
        this.vMenuNasabah = new ViewMenuNasabah();
        interfaceNasabah = new NasabahDAO();
        listNasabah = interfaceNasabah.getAll();
    }
    
    
}
