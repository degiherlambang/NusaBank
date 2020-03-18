/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;

import com.nusabank.model.ModelAdmin;
import com.nusabank.model.DAO.AdminDAO;
import com.nusabank.model.DAO.InterfaceAdminDAO;
import com.nusabank.model.table.TableModelAdmin;
import com.nusabank.view.viewAdmin.ViewManageAdmin;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDI DWI SAPUTRO
 */
public class CManageAdmin {
    
    private final ViewManageAdmin vma;
    
    private List<ModelAdmin> listAdmin;
    private final InterfaceAdminDAO aDao;
    
    public CManageAdmin(ViewManageAdmin vma) {
        this.vma =  vma;
        aDao = new AdminDAO();
        listAdmin = aDao.getAll();
    }
    
    public void reset(){
        vma.getTfIdAdmin().setText("");
        vma.getTfNamaAdmin().setText("");
        vma.getTfNikAdmin().setText("");
        vma.getTfAlamatAdmin().setText("");
        vma.getTfNoHpAdmin().setText("");
        vma.getTfPasswordAdmin().setText("");
        vma.getTfUsernameAdmin().setText("");
        vma.getTfPhotoAdminPath().setText("");
        vma.getTfEmailAdmin().setText("");
        vma.getCmbJenisKelamin().setSelectedIndex(0);
    }
    
    public void insert(){
        ModelAdmin admin = new ModelAdmin();
        admin.setNama(vma.getTfNamaAdmin().getText());
        admin.setNIK(vma.getTfNikAdmin().getText());
        admin.setUsername(vma.getTfUsernameAdmin().getText());
        admin.setJenisKelamin(vma.getCmbJenisKelamin().getSelectedItem().toString());
        admin.setPassword(String.valueOf(vma.getTfPasswordAdmin().getPassword()));
        admin.setEmail(vma.getTfEmailAdmin().getText());
        admin.setAlamat(vma.getTfAlamatAdmin().getText());
        admin.setTglLahir(vma.getDcTglLahir().getDate().toString());
        admin.setNoHp(vma.getTfNoHpAdmin().getText());
        
        File newPath = null;
        String newFileName = "";
        try {
            String fileType = "";
            String oldFileName = vma.getFileName();
            if (oldFileName.endsWith(".png")){
                fileType=".png";
            } else if (oldFileName.endsWith(".jpg")){
                fileType=".jpg";
            } else if (oldFileName.endsWith(".jpeg")){
                fileType=".jpeg";
            }
            
            String prefix = admin.getUsername();
            String mid = "_NusaBank_";
            String sufix = String.valueOf(admin.getTglLahir())
                    .replace(" ", "_")
                    .replace(":", "-");
            String destPath = "res/admin_photos/";
            newFileName = 
                    destPath.concat(
                        prefix.concat(
                            mid.concat(
                                sufix.concat(fileType)
                            )
                        )
                    );
            String copyNewFile = 
                    System.getProperty("user.dir")
                            .concat("/src/com/nusabank/")
                            .concat(newFileName);
            System.out.println(newFileName);
            
            File srcPhoto = new File(vma.getTfPhotoAdminPath().getText());

            newPath = new File(copyNewFile);
            Files.copy(srcPhoto.toPath(), newPath.toPath(), StandardCopyOption.REPLACE_EXISTING);
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        admin.setPhoto(newFileName);
        
        aDao.insert(admin);
        JOptionPane.showMessageDialog(null, "New admin added !");
    }
    
    public void update(){
        ModelAdmin admin = new ModelAdmin();
        admin.setNama(vma.getTfNamaAdmin().getText());
        admin.setNIK(vma.getTfNikAdmin().getText());
        admin.setUsername(vma.getTfUsernameAdmin().getText());
        admin.setJenisKelamin(vma.getCmbJenisKelamin().getSelectedItem().toString());
        admin.setPassword(String.valueOf(vma.getTfPasswordAdmin().getPassword()));
        admin.setEmail(vma.getTfEmailAdmin().getText());
        admin.setAlamat(vma.getTfAlamatAdmin().getText());
        admin.setTglLahir(vma.getDcTglLahir().getDate().toString());
        admin.setNoHp(vma.getTfNoHpAdmin().getText());
        
        File newPath = null;
        String newFileName = "";
        try {
            String fileType = "";
            String oldFileName = vma.getFileName();
            if (oldFileName.endsWith(".png")){
                fileType=".png";
            } else if (oldFileName.endsWith(".jpg")){
                fileType=".jpg";
            } else if (oldFileName.endsWith(".jpeg")){
                fileType=".jpeg";
            }
            
            String prefix = admin.getUsername();
            String mid = "_NusaBank_";
            String sufix = String.valueOf(admin.getTglLahir())
                    .replace(" ", "_")
                    .replace(":", "-");
            String destPath = "res/admin_photos/";
            newFileName = 
                    destPath.concat(
                        prefix.concat(
                            mid.concat(
                                sufix.concat(fileType)
                            )
                        )
                    );
            String copyNewFile = 
                    System.getProperty("user.dir")
                            .concat("/src/com/nusabank/")
                            .concat(newFileName);
            System.out.println(newFileName);
            
            File srcPhoto = new File(vma.getTfPhotoAdminPath().getText());

            newPath = new File(copyNewFile);
            Files.copy(srcPhoto.toPath(), newPath.toPath(), StandardCopyOption.REPLACE_EXISTING);
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        admin.setPhoto(newFileName);
        
        aDao.update(admin);
        JOptionPane.showMessageDialog(null, "update success !");
    }
    
    public void delete(){
    if (vma.getTfIdAdmin().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(vma, "No data deleted....? ",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int row = Integer.parseInt(vma.getTfIdAdmin().getText());
        
        aDao.delete(row);
        JOptionPane.showMessageDialog(null, "Succesfully deleted !");
    }
    
    public void bindingTable(){
        listAdmin = aDao.getAll();
        vma.getTableAdmin().setModel(new TableModelAdmin(listAdmin));
    }
    
    public void getData(){

        String cat = vma.getCmbCategory().getSelectedItem().toString();
        String keyword = null;
        
        if (cat.equals("ID")){
            keyword = vma.getTfIdAdmin().getText();
        } else if (cat.equals("NAMA")) {
            keyword = vma.getTfNamaAdmin().getText();
        } else if (cat.equals("NIK")) {
            keyword = vma.getTfNikAdmin().getText();
        } else if (cat.equals("USERNAME")) {
            keyword = vma.getTfUsernameAdmin().getText();
        } else if (cat.equals("GENDER")) {
            keyword = vma.getCmbJenisKelamin().getSelectedItem().toString();
        } else if (cat.equals("EMAIL")) {
            keyword = vma.getTfEmailAdmin().getText();
        } else if (cat.equals("PHONE_NO")) {
            keyword = vma.getTfNoHpAdmin().getText();
        } else if (cat.equals("ADDRESS")) {
            keyword = vma.getTfAlamatAdmin().getText();
        }
       //String nama = panel.getTxtNama().getText();
        
       aDao.search(cat, keyword);
       bindingSearch(cat, keyword);
        //implementMahasiswa.getMahasiswa(nama);
        //isiTabelCari(nama);
    }
    
    public void getDataField(){
         int row = vma.getTableAdmin().getSelectedRow();
        
        if (row != -1){
            try {
            java.util.Date tglLahir = new SimpleDateFormat("yyyy-MM-dd").parse(listAdmin.get(row).getTglLahir());
            vma.getTfIdAdmin().setText(String.valueOf(listAdmin.get(row).getId()));
            vma.getTfNamaAdmin().setText(listAdmin.get(row).getNama());
            vma.getTfNikAdmin().setText(listAdmin.get(row).getNIK());
            vma.getTfUsernameAdmin().setText(listAdmin.get(row).getUsername());
            vma.getTfPasswordAdmin().setText(listAdmin.get(row).getPassword());
            vma.getDcTglLahir().setDate(tglLahir);
            vma.getTfPhotoAdminPath().setText(listAdmin.get(row).getPhoto());
            vma.getCmbJenisKelamin().setSelectedItem(listAdmin.get(row).getJenisKelamin());
            vma.getTfNoHpAdmin().setText(listAdmin.get(row).getNoHp());
            vma.getTfEmailAdmin().setText(listAdmin.get(row).getEmail());
            vma.getTfAlamatAdmin().setText(listAdmin.get(row).getAlamat());
            } catch(ParseException e){
                e.printStackTrace();
            }
        }
    }
    
    public void bindingSearch(String cat, String keyword){
        listAdmin = aDao.search(cat, keyword);
        vma.getTableAdmin().setModel(new TableModelAdmin(listAdmin));
    }

}
