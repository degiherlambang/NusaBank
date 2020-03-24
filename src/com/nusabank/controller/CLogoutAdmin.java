/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;

import com.nusabank.view.MainLogin;
import com.nusabank.view.viewAdmin.ViewMenuAdmin;

/**
 *
 * @author Jamalludin
 */
public class CLogoutAdmin {
    
    private final ViewMenuAdmin vMenuAdmin;
    
    public CLogoutAdmin(ViewMenuAdmin vMenuAdmin){
        this.vMenuAdmin = vMenuAdmin;
    }
    
    public void doLogOut() {
        this.vMenuAdmin.dispose();
        new MainLogin().setVisible(true);
    }
}
