/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.view.viewNasabah;


import com.nusabank.model.database.DBConnection;
import com.nusabank.controller.CButton;
import com.nusabank.controller.CLogoutNasabah;
import com.nusabank.view.MainLogin;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ViewMenuNasabah extends javax.swing.JFrame {

    private CButton cb;
    private final CLogoutNasabah cLogout;
    /**
     * Creates new form MenuNasabah
     */
    public ViewMenuNasabah() {
        initComponents();
        todayDateInit();
        setLocationRelativeTo(null);
        cb = new CButton(this);
        cLogout = new CLogoutNasabah(this);
    }

    public void todayDateInit() {
        lbTanggal.setText(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
    
    public JLabel getLabelIdNasabah() {
        return lbIdNasabah;
    }
    
    public JLabel getLogoPT() {
        return lbLogoPT;
    }
    
    public JLabel getLabelUsername(){
        return lbUsername;
    }
    
    public JLabel getLabelNamaWelcome() {
        return lbNamaWelcome;
    }
    
    public JLabel getLabelAvatar() {
        return labelAvatar;
    }
    
    public JLabel getLabelNIK() {
        return lbNIK;
    }
    
    public JLabel getLabelDOB() {
        return lbDOB;
    }
    
    public JLabel getLabelGender() {
        return lbGender;
    }
    
    public JLabel getLbJenisRek() {
        return lbJenisRek;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        lbNamaWelcome = new javax.swing.JLabel();
        lbLogoPT = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnMenu1 = new javax.swing.JPanel();
        btnAccountInfo = new javax.swing.JButton();
        btnMenu4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        btnMenu3 = new javax.swing.JPanel();
        btnTrxPpob = new javax.swing.JButton();
        btnMenu6 = new javax.swing.JPanel();
        btnAbout = new javax.swing.JButton();
        btnMenu2 = new javax.swing.JPanel();
        btnTrxBank = new javax.swing.JButton();
        btnMenu5 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbUsername = new javax.swing.JLabel();
        lbNIK = new javax.swing.JLabel();
        lbDOB = new javax.swing.JLabel();
        lbGender = new javax.swing.JLabel();
        lbJenisRek = new javax.swing.JLabel();
        lbIdNasabah = new javax.swing.JLabel();
        lbTanggal = new javax.swing.JLabel();
        labelAvatar = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nusa Bank v1.0 -  Customer/Nasabah Dashboard");
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setText("SELAMAT DATANG,");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        lbNamaWelcome.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbNamaWelcome.setText("Nama");
        getContentPane().add(lbNamaWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 130, -1));

        lbLogoPT.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        lbLogoPT.setText("Nusa Bank");
        getContentPane().add(lbLogoPT, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 10, 240, 100));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        btnAccountInfo.setText("ACCOUNT INFO");
        btnAccountInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnMenu1Layout = new javax.swing.GroupLayout(btnMenu1);
        btnMenu1.setLayout(btnMenu1Layout);
        btnMenu1Layout.setHorizontalGroup(
            btnMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAccountInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
        );
        btnMenu1Layout.setVerticalGroup(
            btnMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAccountInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
        );

        jButton4.setText("CREDIT CARD");
        jButton4.setEnabled(false);

        javax.swing.GroupLayout btnMenu4Layout = new javax.swing.GroupLayout(btnMenu4);
        btnMenu4.setLayout(btnMenu4Layout);
        btnMenu4Layout.setHorizontalGroup(
            btnMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
        );
        btnMenu4Layout.setVerticalGroup(
            btnMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
        );

        btnTrxPpob.setText("PPOB");
        btnTrxPpob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrxPpobActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnMenu3Layout = new javax.swing.GroupLayout(btnMenu3);
        btnMenu3.setLayout(btnMenu3Layout);
        btnMenu3Layout.setHorizontalGroup(
            btnMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTrxPpob, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
        );
        btnMenu3Layout.setVerticalGroup(
            btnMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTrxPpob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnAbout.setText("ABOUT");
        btnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnMenu6Layout = new javax.swing.GroupLayout(btnMenu6);
        btnMenu6.setLayout(btnMenu6Layout);
        btnMenu6Layout.setHorizontalGroup(
            btnMenu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAbout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnMenu6Layout.setVerticalGroup(
            btnMenu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAbout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnTrxBank.setText("TRANSFER");
        btnTrxBank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrxBankActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnMenu2Layout = new javax.swing.GroupLayout(btnMenu2);
        btnMenu2.setLayout(btnMenu2Layout);
        btnMenu2Layout.setHorizontalGroup(
            btnMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTrxBank, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
        );
        btnMenu2Layout.setVerticalGroup(
            btnMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTrxBank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jButton5.setText("DEPOSITO");
        jButton5.setEnabled(false);

        javax.swing.GroupLayout btnMenu5Layout = new javax.swing.GroupLayout(btnMenu5);
        btnMenu5.setLayout(btnMenu5Layout);
        btnMenu5Layout.setHorizontalGroup(
            btnMenu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnMenu5Layout.setVerticalGroup(
            btnMenu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMenu5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMenu6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMenu4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenu5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenu6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 610, 340));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jLabel5.setText("User Info:");

        lbUsername.setText("Username");

        lbNIK.setText("NIK");

        lbDOB.setText("DOB");

        lbGender.setText("Gender");

        lbJenisRek.setText("Jenis_Rek");

        lbIdNasabah.setText("ID");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNIK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbGender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbJenisRek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbIdNasabah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel5)
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(13, 13, 13)
                .addComponent(lbIdNasabah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbUsername)
                .addGap(18, 18, 18)
                .addComponent(lbNIK)
                .addGap(16, 16, 16)
                .addComponent(lbDOB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbGender)
                .addGap(18, 18, 18)
                .addComponent(lbJenisRek)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 130, 300));

        lbTanggal.setText("tanggalSekarang");
        getContentPane().add(lbTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 110, 20));

        labelAvatar.setText("FOTO");
        getContentPane().add(labelAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, 128, 128));

        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAccountInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountInfoActionPerformed
       cb.goAccountInfo();
    }//GEN-LAST:event_btnAccountInfoActionPerformed

    private void btnTrxBankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrxBankActionPerformed
        cb.goTrxBank();
    }//GEN-LAST:event_btnTrxBankActionPerformed

    private void btnTrxPpobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrxPpobActionPerformed
        cb.goTrxPpob();
    }//GEN-LAST:event_btnTrxPpobActionPerformed

    private void btnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAboutActionPerformed
        JOptionPane.showMessageDialog(null, 
                "v.1.0 - Developed by NusaSoft"
                        + "\n 1. Andi"
                        + "\n 2. Degi"
                        + "\n 3. Jamal"
                        + "\n Visit our repository: https://github.com/andiads/NusaBank",
                "About Us",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAboutActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
            cLogout.doLogOut();
    }//GEN-LAST:event_btnLogoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewMenuNasabah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMenuNasabah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMenuNasabah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMenuNasabah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMenuNasabah().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbout;
    private javax.swing.JButton btnAccountInfo;
    private javax.swing.JButton btnLogout;
    private javax.swing.JPanel btnMenu1;
    private javax.swing.JPanel btnMenu2;
    private javax.swing.JPanel btnMenu3;
    private javax.swing.JPanel btnMenu4;
    private javax.swing.JPanel btnMenu5;
    private javax.swing.JPanel btnMenu6;
    private javax.swing.JButton btnTrxBank;
    private javax.swing.JButton btnTrxPpob;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel labelAvatar;
    private javax.swing.JLabel lbDOB;
    private javax.swing.JLabel lbGender;
    public static javax.swing.JLabel lbIdNasabah;
    private javax.swing.JLabel lbJenisRek;
    private javax.swing.JLabel lbLogoPT;
    private javax.swing.JLabel lbNIK;
    public static javax.swing.JLabel lbNamaWelcome;
    private javax.swing.JLabel lbTanggal;
    public static javax.swing.JLabel lbUsername;
    // End of variables declaration//GEN-END:variables
}
