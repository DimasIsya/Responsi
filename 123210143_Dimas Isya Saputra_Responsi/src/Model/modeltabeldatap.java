/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class modeltabeldatap extends AbstractTableModel{

    
    List<datap> dp;
    public modeltabeldatap(List<datap>dp){
    this.dp = dp;
    }
    
    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }
    
   @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "JUDUL";
            case 2:
                return "GENRE";
            case 3:
                return "PENULIS";
            case 4:
                return "PENERBIT";
            case 5:
                return "LOKASI";
            case 6:
                return "STOCK";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return dp.get(rowIndex).getId();
            case 1:
                return dp.get(rowIndex).getJudul();
            case 2:
                return dp.get(rowIndex).getGenre();
            case 3:
                return dp.get(rowIndex).getPenulis();
            case 4:
                return dp.get(rowIndex).getPenerbit();
            case 5:
                return dp.get(rowIndex).getLokasi();
            case 6:
                return dp.get(rowIndex).getStock();
            default:
                return null;
        }
    }
}
