/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;

import com.nusabank.helper.Function;
import com.nusabank.helper.Validation;
import com.nusabank.model.DAO.InterfaceRekeningDAO;
import com.nusabank.model.DAO.RekeningDAO;
import com.nusabank.model.ModelRekening;
import com.nusabank.model.table.TableModelNasabah;
import com.nusabank.view.viewAdmin.ViewRegisNasabah;
import com.nusabank.view.viewNasabah.*;
import java.awt.Color;
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
public class CRegisRekening {

    private Function func;
    private Validation validator;

    private boolean isAllValid;
    private boolean isInsert = true;
    private Boolean[] isEachFieldsValid;

    private final ViewRegisNasabah vRegNasabah;

    private List<ModelRekening> listRekening;

    private Color errorColor = new Color(225, 102, 102);

    private final InterfaceRekeningDAO interfaceRekening;

    public CRegisRekening(JFrame frame) {
        this.vRegNasabah = (ViewRegisNasabah) frame;
        interfaceRekening = new RekeningDAO();
        func = new Function();
        listRekening = interfaceRekening.getAll();
    }

    public void reset() {
        vRegNasabah.getTxtNoRekening().setText("");
        vRegNasabah.getLbNamaNasabah().setText("");
        vRegNasabah.getTxtIdRekening().setText("");
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

    public void validateForm() {
        validator = new Validation();
        ModelRekening rekening = new ModelRekening();

        isEachFieldsValid = new Boolean[5];

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tglLahir = sdf.format(this.vRegNasabah.getTxtLahir().getDate());

        // rekening.setIdRekening(Integer.parseInt(vRegNasabah.getTxtIdRekening().getText()));
        rekening.setJenisRekening(vRegNasabah.getCmbJenisRekening().getSelectedItem().toString());
        rekening.setNoPin(Integer.parseInt(String.valueOf(vRegNasabah.getTxtNoPIN().getPassword())));
        rekening.setNoRekening(vRegNasabah.getTxtNoRekening().getText());
        //  rekening.setSaldo(Integer.parseInt(vRegNasabah.getTxtSaldo().getText()));

        StringBuilder messageBuilder = new StringBuilder();
        java.util.Date todayDate = new java.util.Date();

        if ((rekening.getJenisRekening().equals("- Choose -"))
                && (String.valueOf(rekening.getNoPin()).equals(null))
                && (rekening.getNoRekening().isEmpty())
                && (String.valueOf(rekening.getSaldo()).equals(null))) {

            JOptionPane.showMessageDialog(vRegNasabah,
                    "Please don't leave fields blank!",
                    "Warning",
                    JOptionPane.ERROR_MESSAGE
            );

            isAllValid = false;

        } else if (isAllValid == false) {

            if (!validator.isValidPIN(String.valueOf(rekening.getNoPin()))) {

                messageBuilder.append("\n > Incorrect PIN input, "
                        + "please use 6 digit of numbers only!");

                vRegNasabah.getTxtNoPIN().setBackground(errorColor);
                isEachFieldsValid[0] = false;

            } else {

                isEachFieldsValid[0] = true;

                if (!validator.isValidName(vRegNasabah.getTxtNama().getText())) {

                    messageBuilder.append("\n > Incorrect Name input, "
                            + "please use alphanumeric characters and avoid symbols!");

                    vRegNasabah.getTxtNama().setBackground(errorColor);
                    isEachFieldsValid[1] = false;

                } else {

                    isEachFieldsValid[1] = true;

                }

                if (!validator.isValidDate(vRegNasabah.getTxtLahir().getDateFormatString())) {

                    messageBuilder.append("\n Incorrect Date Format input !"
                            + "\n\t-> Date of birth format should be like this: "
                            + "\n\t-> e.g: 1970-01-31"
                            + "format: yyyy-mm-dd.");

                    vRegNasabah.getTxtLahir().setBackground(errorColor);
                    isEachFieldsValid[2] = false;

                } else {

                    isEachFieldsValid[2] = true;
                }

                if (String.valueOf(rekening.getIdRekening()) == ""
                        || String.valueOf(rekening.getIdRekening()) == null) {

                    messageBuilder.append("\n Please fill the required fields correctly!");
                    vRegNasabah.getCmbJenisKelamin().setBackground(errorColor);
                    isEachFieldsValid[3] = false;
                } else {

                    isEachFieldsValid[3] = true;
                }

                if (String.valueOf(rekening.getSaldo()) == ""
                        || String.valueOf(rekening.getSaldo()) == null) {

                    messageBuilder.append("\n Saldo/Balance field cannot be blank!"
                            + "\n put 0 if you don't want to submit customer first deposit!");

                    vRegNasabah.getCmbJenisKelamin().setBackground(errorColor);
                    isEachFieldsValid[3] = false;
                } else {

                    isEachFieldsValid[3] = true;

                }

                vRegNasabah.getTxtAreaValidation().setText(messageBuilder.toString());

                if (isEachFieldsValid[0] == true
                        && isEachFieldsValid[1] == true
                        && isEachFieldsValid[2] == true) {

                    isAllValid = true;

                } else {

                    isAllValid = false;

                }

            }

            if (isAllValid == true) {

                String noRekening = func.generateNoRek(
                        vRegNasabah.getTxtNama().getText().replace(" ", ""),
                        vRegNasabah.getTxtLahir().getDateFormatString(),
                        vRegNasabah.getLbTodayDate().getText()
                );
                vRegNasabah.getTxtNoRekening().setText(noRekening);
                this.insert();
                this.reset();

            } else {

                JOptionPane.showMessageDialog(vRegNasabah, "There's something wrong");

            }

        }

    }
}
