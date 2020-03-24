/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;
import com.nusabank.model.DAO.NasabahDAO;
import com.nusabank.helper.Function;
import com.nusabank.helper.Validation;
import com.nusabank.model.DAO.InterfaceNasabahDAO;
import com.nusabank.model.DAO.InterfaceNasabahDAO;
import com.nusabank.model.ModelNasabah;
import com.nusabank.model.DAO.NasabahDAO;
import com.nusabank.model.ModelNasabah;
import com.nusabank.model.table.TableModelNasabah;
import com.nusabank.view.viewAdmin.ViewManageNasabah;
import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class CManageNasabah {
    private Function func;
    private Validation validator;
    private ViewManageNasabah vManageNasabah;
    
    private boolean isAllValid;
    private boolean isInsert = true;
    private Boolean[] isEachFieldsValid;

    private int minPasswordLength = 6;
    private int maxPasswordLength = 12;

    private Color errorColor = new Color(225, 102, 102);
    
    private List<ModelNasabah> listNasabah;
    private InterfaceNasabahDAO interfaceNasabah;
    
    public CManageNasabah(ViewManageNasabah vManageNasabah) {
        this.vManageNasabah =  (ViewManageNasabah) vManageNasabah;
        interfaceNasabah = new NasabahDAO();
        func = new Function();
        listNasabah = interfaceNasabah.getAll(); 
    }

     public void reset() {
        vManageNasabah.getTfName().setText("");
        vManageNasabah.getTfIDNasabah().setText("");
        vManageNasabah.getTfNIK().setText("");
        vManageNasabah.getTfAdressWork().setText("");
        vManageNasabah.getTaAdress().setText("");
        vManageNasabah.getTfNoHP().setText("");
        vManageNasabah.getTfEmail().setText("");
        vManageNasabah.getTfPassword().setText("");
        vManageNasabah.getTfUsername().setText("");
        vManageNasabah.getTfWork().setText("");
        vManageNasabah.getTfPhoto().setText("");
        vManageNasabah.getTfMotherName().setText("");
        vManageNasabah.getTfIncome().setText("0");
        vManageNasabah.getTfAccountID().setText("0");
        vManageNasabah.getCbGender().setSelectedIndex(0);
        vManageNasabah.getCbStatus().setSelectedIndex(0);
        vManageNasabah.getLbDateMake().setText("");
        
        // reset after validation 
        vManageNasabah.getTfName().setBackground(Color.WHITE);
        vManageNasabah.getTfNIK().setBackground(Color.WHITE);
        vManageNasabah.getTfAdressWork().setBackground(Color.WHITE);
        vManageNasabah.getTaAdress().setBackground(Color.WHITE);
        vManageNasabah.getTfNoHP().setBackground(Color.WHITE);
        vManageNasabah.getTfEmail().setBackground(Color.WHITE);
        vManageNasabah.getTfPassword().setBackground(Color.WHITE);
        vManageNasabah.getTfUsername().setBackground(Color.WHITE);;
        vManageNasabah.getTfWork().setBackground(Color.WHITE);
        vManageNasabah.getTfPhoto().setBackground(Color.WHITE);
        vManageNasabah.getTfMotherName().setBackground(Color.WHITE);
        vManageNasabah.getTfIncome().setBackground(Color.WHITE);
        vManageNasabah.getTfAccountID().setBackground(Color.WHITE);
        vManageNasabah.getCbGender().setBackground(Color.WHITE);
        vManageNasabah.getCbStatus().setBackground(Color.WHITE);
    }
    
    public void bindingTable(){
        listNasabah = interfaceNasabah.getAll();
        vManageNasabah.getTableNasabah().setModel(new TableModelNasabah(listNasabah));
    }
    
    public void getDataField(){
         int row = vManageNasabah.getTableNasabah().getSelectedRow();
        
        if (row != -1){
            try {
            java.util.Date tglLahir = new SimpleDateFormat("yyyy-MM-dd").parse(listNasabah.get(row).getTglLahir());
            vManageNasabah.getTfIDNasabah().setText(String.valueOf(listNasabah.get(row).getId()));
            vManageNasabah.getTfName().setText(listNasabah.get(row).getNama());
            vManageNasabah.getTfNik().setText(String.valueOf(listNasabah.get(row).getNik()));
            vManageNasabah.getDcTglLahir().setDate(tglLahir);
            vManageNasabah.getTfEmail().setText(listNasabah.get(row).getEmail());
            vManageNasabah.getTaAdress().setText(listNasabah.get(row).getAlamatRumah());
            vManageNasabah.getTfPhoto().setText(listNasabah.get(row).getPhoto());
            vManageNasabah.getCmbGender().setSelectedItem(listNasabah.get(row).getJenisKelamin());
            vManageNasabah.getTfPekerjaan().setText(listNasabah.get(row).getPekerjaan());
            vManageNasabah.getTfAdressWork().setText(listNasabah.get(row).getAlamatKantor());
            vManageNasabah.getTfIncome().setText(String.valueOf(listNasabah.get(row).getPendapatan()));
            vManageNasabah.getTfNoHP().setText(listNasabah.get(row).getNoHp());
            vManageNasabah.getCmbStatus().setSelectedItem(listNasabah.get(row).getStatus());
            vManageNasabah.getTfMotherName().setText(listNasabah.get(row).getNamaIbu());
            vManageNasabah.getUsername().setText(listNasabah.get(row).getUsername());
            vManageNasabah.getTfPassword().setText(listNasabah.get(row).getPassword());
            vManageNasabah.getLbDateMake().setText(listNasabah.get(row).getTglPembuatan());
            vManageNasabah.getTfIDRekening().setText(String.valueOf(listNasabah.get(row).getIdRekening()));
            } catch(ParseException e){
                e.printStackTrace();
            }
        }
    }
    
    public void update(){
        ModelNasabah nasabah = new ModelNasabah();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tglLahir = sdf.format(vManageNasabah.getDcTglLahir().getDate());
        
        nasabah.setId(Integer.parseInt(vManageNasabah.getTfIDNasabah().getText()));
        nasabah.setNama(vManageNasabah.getTfName().getText());
        nasabah.setNik(vManageNasabah.getTfNik().getText());
        nasabah.setTglLahir(tglLahir);
        nasabah.setAlamatRumah(vManageNasabah.getTaAdress().getText());
        nasabah.setJenisKelamin(vManageNasabah.getCmbGender().getSelectedItem().toString());
        nasabah.setPekerjaan(vManageNasabah.getTfPekerjaan().getText());
        nasabah.setAlamatKantor(vManageNasabah.getTfAdressWork().getText());
        nasabah.setPendapatan(Integer.parseInt(vManageNasabah.getTfIncome().getText()));
        nasabah.setNoHp(vManageNasabah.getTfNoHP().getText());
        nasabah.setStatus(vManageNasabah.getCmbStatus().getSelectedItem().toString());
        nasabah.setNamaIbu(vManageNasabah.getTfMotherName().getText());
        nasabah.setUsername(vManageNasabah.getUsername().getText());
        nasabah.setPassword(vManageNasabah.getTfPassword().getText());
        nasabah.setIdRekening(Integer.parseInt(vManageNasabah.getTfIDRekening().getText()));
        nasabah.setEmail(vManageNasabah.getTfEmail().getText());
        
        String newFileName = func.updatePhotoNasabah(vManageNasabah, nasabah);
        nasabah.setPhoto(newFileName);
               
        interfaceNasabah.update(nasabah);
        JOptionPane.showMessageDialog(vManageNasabah, "update success !");
    }
    
    public void delete(){
    if (vManageNasabah.getTfIDNasabah().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(vManageNasabah, "No data deleted....? ",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int row = Integer.parseInt(vManageNasabah.getTfIDNasabah().getText());
        
        interfaceNasabah.delete(row);
        JOptionPane.showMessageDialog(null, "Succesfully deleted !");
    }
    
    public void getData() {
        String cat = vManageNasabah.getCmbCategory().getSelectedItem().toString();
        String keyword = vManageNasabah.getTfSearch().getText();
        String tableField = null;

        if (cat.equals("ID")) {
            tableField = "id_nasabah";
        } else if (cat.equals("NAME")) {
            tableField = "nama";
        } else if (cat.equals("NIK")) {
            tableField = "nik";
        } else if (cat.equals("USERNAME")) {
            tableField = "username_nasabah";
        } else if (cat.equals("GENDER")) {
            tableField = "jenis_kelamin";
        } else if (cat.equals("EMAIL")) {
            tableField = "email";
        } else if (cat.equals("PHONE_NO")) {
            tableField = "no_hp";
        } else if (cat.equals("ADDRESS")) {
            tableField = "alamat";
        } else if (cat.equals("DOB")) {
            tableField = "tgl_lahir";
        } else if (cat.equals("JOB")) {
            tableField = "pekerjaan";
        } else if (cat.equals("STATUS")) {
            tableField = "status";
        } else if (cat.equals("BANK ACCOUNT ID")) {
            tableField = "id_rekening";
        }

        interfaceNasabah.search(tableField, keyword);
        bindingSearch(tableField, keyword);

    }
    
    public void bindingSearch(String cat, String keyword) {
        listNasabah = interfaceNasabah.search(cat, keyword);
        vManageNasabah.getTableNasabah().setModel(new TableModelNasabah(listNasabah));
    }
    
    public void validateForm() {
        validator = Validation.buildPasswordRule(false, false, true, 6, 12);
        ModelNasabah nasabah = new ModelNasabah();

        isEachFieldsValid = new Boolean[15];

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tglLahir = sdf.format(this.vManageNasabah.getDcTglLahir().getDate());

        nasabah.setNama(vManageNasabah.getTfName().getText());
        nasabah.setNik(vManageNasabah.getTfNik().getText());
        nasabah.setTglLahir(tglLahir);
        nasabah.setAlamatRumah(vManageNasabah.getTaAdress().getText());
        nasabah.setJenisKelamin(vManageNasabah.getCmbGender().getSelectedItem().toString());
        nasabah.setPekerjaan(vManageNasabah.getTfPekerjaan().getText());
        nasabah.setAlamatKantor(vManageNasabah.getTfAdressWork().getText());
        nasabah.setPendapatan(Integer.parseInt(vManageNasabah.getTfIncome().getText()));
        nasabah.setNoHp(vManageNasabah.getTfNoHP().getText());
        nasabah.setStatus(vManageNasabah.getCmbStatus().getSelectedItem().toString());
        nasabah.setNamaIbu(vManageNasabah.getTfMotherName().getText());
        nasabah.setUsername(vManageNasabah.getUsername().getText());
        nasabah.setPassword(vManageNasabah.getTfPassword().getText());
        nasabah.setIdRekening(Integer.parseInt(vManageNasabah.getTfIDRekening().getText()));
        nasabah.setEmail(vManageNasabah.getTfEmail().getText());
        

        StringBuilder messageBuilder = new StringBuilder();
        java.util.Date todayDate = new java.util.Date();

        if ((nasabah.getNama().isEmpty())
                && (String.valueOf(nasabah.getNik()).isEmpty())
                && (nasabah.getUsername().isEmpty())
                && (nasabah.getPassword().isEmpty())
                && (nasabah.getEmail().isEmpty())
                && (nasabah.getJenisKelamin().isEmpty()
                    || nasabah.getJenisKelamin().equals("- Choose -"))
                && (nasabah.getNoHp().isEmpty())
                && (nasabah.getTglLahir().isEmpty()
                    || (vManageNasabah.getDcTglLahir().getDate().compareTo(todayDate) < 0))
                && (nasabah.getAlamatRumah().isEmpty())
                && (nasabah.getAlamatKantor().isEmpty())
                && (nasabah.getStatus().isEmpty())
                && (nasabah.getNamaIbu().isEmpty())
                && (nasabah.getPekerjaan().isEmpty())
                && (String.valueOf(nasabah.getPendapatan()).isEmpty()||nasabah.getPendapatan()==0)
                && (String.valueOf(nasabah.getIdRekening()).isEmpty()||nasabah.getIdRekening()==0)    
                ) {

            JOptionPane.showMessageDialog(vManageNasabah,
                    "Please don't leave fields blank!",
                    "Warning",
                    JOptionPane.ERROR_MESSAGE
            );

            isAllValid = false;

        } else if (isAllValid == false) {

            if (!validator.isValidName(nasabah.getNama())) {

                messageBuilder.append("\n > Incorrect Name input, "
                        + "please use alphanumeric characters and avoid symbols!");

                vManageNasabah.getTfName().setBackground(errorColor);
                isEachFieldsValid[0] = false;

            } else {

                isEachFieldsValid[0] = true;

            }

            if (!validator.isValidNIK(String.valueOf(nasabah.getNik()))) {

                messageBuilder.append("\n > Incorrect NIK input, "
                        + "only numeric input accepted !");

                vManageNasabah.getTfNIK().setBackground(errorColor);
                isEachFieldsValid[1] = false;

            } else {

                isEachFieldsValid[1] = true;

            }

            if (!validator.isValidUsername(nasabah.getUsername())) {

                messageBuilder.append("\n > Incorrect Username input, "
                        + "please use alphanumeric characters and avoid symbols!");

                vManageNasabah.getTfUsername().setBackground(errorColor);
                isEachFieldsValid[2] = false;

            } else {

                isEachFieldsValid[2] = true;

            }

            if (!validator.isValidEmail(nasabah.getEmail())) {

                messageBuilder.append("\n > Incorrect Email input, "
                        + "the format should be like name@mailhost.com !");

                vManageNasabah.getTfEmail().setBackground(errorColor);
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

                vManageNasabah.getTfPassword().setBackground(errorColor);
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

                vManageNasabah.getTfNoHP().setBackground(errorColor);
                isEachFieldsValid[5] = false;
            
            } else {
            
                isEachFieldsValid[5] = true;
            
            }

            if (!validator.isValidDate(nasabah.getTglLahir())) {

                messageBuilder.append("\n Incorrect Date Format input !"
                        + "\n\t-> Date of birth format should be like this: "
                        + "\n\t-> e.g: 1970-01-31"
                        + "format: yyyy-mm-dd.");

                vManageNasabah.getDcTglLahir().setBackground(errorColor);
                isEachFieldsValid[6] = false;
            
            } else {
            
                isEachFieldsValid[6] = true;
            
            }

            if (nasabah.getAlamatRumah().isEmpty()) {

                messageBuilder.append("\n Home Address field can't be blank!");

                vManageNasabah.getTaAdress().setBackground(errorColor);
                isEachFieldsValid[7] = false;
            
            } else {
            
                isEachFieldsValid[7] = true;
            
            }

            if (nasabah.getJenisKelamin().isEmpty()
                    || nasabah.getJenisKelamin().equals("- Choose -")) {

                messageBuilder.append("\n Please select your gender !");

                vManageNasabah.getCmbGender().setBackground(errorColor);
                isEachFieldsValid[8] = false;
            
            } else {
            
                isEachFieldsValid[8] = true;
            
            }

            vManageNasabah.getTxtAreaValidation().setText(messageBuilder.toString());

            if (isEachFieldsValid[0] == true
                    && isEachFieldsValid[1] == true
                    && isEachFieldsValid[2] == true
                    && isEachFieldsValid[3] == true
                    && isEachFieldsValid[4] == true
                    && isEachFieldsValid[5] == true
                    && isEachFieldsValid[6] == true
                    && isEachFieldsValid[7] == true
                    && isEachFieldsValid[8] == true) {
            
                isAllValid = true;
            
            } else {
            
                isAllValid = false;
            
            }

        }
        
        if (isAllValid == true) {
            

                this.update();
                this.reset();
            
        } else {
            
            JOptionPane.showMessageDialog(vManageNasabah, "There's something wrong");
        
        }

    }
}
