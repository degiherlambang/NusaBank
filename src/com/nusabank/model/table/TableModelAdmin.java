/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.model.table;

import com.nusabank.model.ModelAdmin;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ANDI DWI SAPUTRO
 */
public class TableModelAdmin extends AbstractTableModel{
    
    private static final long serialVersionUID = 1L;
    
    List<ModelAdmin> list;
    
    public TableModelAdmin(List<ModelAdmin> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
}

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return list.get(rowIndex).getId();
            case 1 : return list.get(rowIndex).getNama();
            case 2 : return list.get(rowIndex).getUsername();
            case 3 : return list.get(rowIndex).getPhoto();
            case 4 : return list.get(rowIndex).getJenisKelamin();
            case 5 : return list.get(rowIndex).getNoHp();
                default:return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 : return "ID";
            case 1 : return "NAMA";
            case 2 : return "USERNAME";
            case 3 : return "PHOTO";
            case 4 : return "JENIS KELAMIN";
            case 5 : return "NO.HP";
                default:return null;
        }
    }
}
