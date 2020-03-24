/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;

import com.nusabank.view.MainLogin;
import com.nusabank.view.viewNasabah.ViewMenuNasabah;
/**
 *
 * @author Jamalludin
 */
public class CLogoutNasabah {
    private final ViewMenuNasabah vMenuNasabah;
    
    public CLogoutNasabah(ViewMenuNasabah vMenuNasabah) {
        this.vMenuNasabah = vMenuNasabah;
    }
    
    public void doLogOut() {
         this.vMenuNasabah.dispose();
         new MainLogin().setVisible(true);
     }
}
