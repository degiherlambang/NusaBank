/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.model.DAO;

import com.nusabank.model.ModelAdmin;
import com.nusabank.model.ModelNasabah;
import com.nusabank.view.viewAdmin.ViewManageAdmin;
import com.nusabank.view.viewAdmin.ViewMenuAdmin;
import com.nusabank.view.viewAdmin.ViewRegisNasabah;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.JFrame;

/**
 *
 * @author ANDI DWI SAPUTRO
 */
public class Function {
    
   public String uploadPhotoNasabah(ViewRegisNasabah vRegNasabah, ModelNasabah nasabah) {
    File newPath = null;
        String newFileName = "";
        try {
            String fileType = "";
            String oldFileName = vRegNasabah.getFileName();
            if (oldFileName.endsWith(".png")){
                fileType=".png";
            } else if (oldFileName.endsWith(".jpg")){
                fileType=".jpg";
            } else if (oldFileName.endsWith(".jpeg")){
                fileType=".jpeg";
            }
            
            String prefix = nasabah.getUsername();
            String mid = "_NusaBank_";
            String sufix = String.valueOf(nasabah.getTglPembuatan())
                    .replace(" ", "_")
                    .replace(":", "-");
            String destPath = "res/nasabah_photos/";
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
            
            File srcPhoto = new File(vRegNasabah.getLbFoto().getText());

            newPath = new File(copyNewFile);
            Files.copy(srcPhoto.toPath(), newPath.toPath(), StandardCopyOption.REPLACE_EXISTING);
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        return newFileName;
   } 
   
   public String uploadPhotoAdmin(ViewManageAdmin vma, ModelAdmin admin){
        File newPath = null;
        String newFileName = "";
        String oldFileName = vma.getFileName();
        // check if admin has photo or not, if not > set to default avatar from res
        if (!vma.getTfPhotoAdminPath().getText().isEmpty()) {
            try {
                String fileType = "";

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
        } else {
            newFileName = "";
        }
        
        return newFileName;
   }
}
