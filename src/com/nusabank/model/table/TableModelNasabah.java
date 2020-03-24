/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.model.table;

import com.nusabank.model.ModelNasabah;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ANDI DWI SAPUTRO
 */
public class TableModelNasabah extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    
    List<ModelNasabah> list;
    
    public TableModelNasabah(List<ModelNasabah> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
}

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return list.get(rowIndex).getId();
            case 1 : return list.get(rowIndex).getNama();
            case 2 : return list.get(rowIndex).getNik();
            case 3 : return list.get(rowIndex).getEmail();
            case 4 : return list.get(rowIndex).getAlamatRumah();
            case 5 : return list.get(rowIndex).getJenisKelamin();
            case 6 : return list.get(rowIndex).getNoHp();
            case 7 : return list.get(rowIndex).getIdRekening();
                default:return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 : return "ID";
            case 1 : return "NAMA";
            case 2 : return "NIK";
            case 3 : return "E-MAIL";
            case 4 : return "ALAMAT";
            case 5 : return "JENIS KELAMIN";
            case 6 : return "NO.HP";
            case 7 : return "NO.REK";
                default:return null;
        }
    }
}
