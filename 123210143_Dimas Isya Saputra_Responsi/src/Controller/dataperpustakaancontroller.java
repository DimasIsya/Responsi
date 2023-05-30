/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.List;
import DAOdatap.datapDAO;
import DAOImplement.datapimplement;
import Model.datap;
import Model.modeltabeldatap;
import View.MainView;
import model.*;

public class dataperpustakaancontroller {
    MainView frame;
    datapimplement impldatap;
    List<datap> dp;
    
    public dataperpustakaancontroller(MainView frame){
        this.frame = frame;
        impldatap = new datapDAO();
        dp = impldatap.getAll();
    }
    public void isitabel(){
        dp = impldatap.getAll();
        modeltabeldatap mp = new modeltabeldatap(dp);
        frame.getTabelDatap().setModel(mp);
    }
    
    public void insert(){
        datap dp = new datap();
        dp.setJudul(frame.getJTxtjudul().getText());
        dp.setGenre(frame.getJTxtgenre().getText());
        dp.setPenulis(frame.getJTxtpenulis().getText());
        dp.setPenerbit(frame.getJTxtpenerbit().getText());
        dp.setLokasi(frame.getJTxtlokasi().getText());
        impldatap.insert(dp);
        
    }
    
    public void update(){
        datap dp = new datap();
        dp.setJudul(frame.getJTxtjudul().getText());
        dp.setGenre(frame.getJTxtgenre().getText());
        dp.setPenulis(frame.getJTxtpenulis().getText());
        dp.setPenerbit(frame.getJTxtpenerbit().getText());
        dp.setLokasi(frame.getJTxtlokasi().getText());
        impldatap.update(dp);
    }
    
    public void delete(){
        int id = Integer.parseInt(frame.getJTxtid().getText());
        impldatap.delete(id);
    }

    public void tampil() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
