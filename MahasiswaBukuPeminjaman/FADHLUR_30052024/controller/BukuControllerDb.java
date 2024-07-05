/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FADHLUR_30052024.controller;

import FADHLUR_30052024.DAO.BukuDb;
import FADHLUR_30052024.model.Buku;
import FADHLUR_30052024.view.FormBuku;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class BukuControllerDb {
    
     FormBuku formbuku;
    Buku buku;
    BukuDb bukuDb;
    int index;
    
    public BukuControllerDb(FormBuku formbuku){
        this.formbuku = formbuku;
        bukuDb = new BukuDb();
    }

    
    
    public void cancel(){
        formbuku.getTxtKode().setText("");
        formbuku.getTxtJudul().setText("");
        formbuku.getTxtPengarang().setText("");
        formbuku.getTxtTahun().setText("");                      
    } 
    
    public void insert() throws Exception{
        buku = new Buku();
        buku.setKodeBuku(formbuku.getTxtKode().getText());
        buku.setJudulBuku(formbuku.getTxtJudul().getText());
        buku.setPengarang(formbuku.getTxtPengarang().getText());
        buku.setTahunTerbit(formbuku.getTxtTahun().getText());
        bukuDb.insert(buku);
        JOptionPane.showMessageDialog(formbuku, "Entri Data Ok");
    }
    
    public void viewData() throws Exception{
        DefaultTableModel model = (DefaultTableModel)formbuku.getTblBuku().getModel();
        model.setNumRows(0);
        List<Buku> list = bukuDb.getAllBuku();
        for(Buku buku : list){
            Object[] data = {
                buku.getKodeBuku(),
                buku.getJudulBuku(),
                buku.getPengarang(),
                buku.getTahunTerbit()                    
            };
            model.addRow(data);
        }         
    }
    
    public  void actionClickTabel() throws Exception{
        String kode= formbuku.getTblBuku().getValueAt(formbuku.getTblBuku().getSelectedRow(),0).toString();        
        buku= bukuDb.getBuku(kode);
        formbuku.getTxtKode().setText(buku.getKodeBuku());
        formbuku.getTxtJudul().setText(buku.getJudulBuku());
        formbuku.getTxtPengarang().setText(buku.getPengarang());
        formbuku.getTxtTahun().setText(buku.getTahunTerbit());    
    }
    
    public void update() throws Exception{
       buku.setKodeBuku(formbuku.getTxtKode().getText());
       buku.setJudulBuku(formbuku.getTxtJudul().getText());
       buku.setPengarang(formbuku.getTxtPengarang().getText());
       buku.setTahunTerbit(formbuku.getTxtTahun().getText());
       bukuDb.update(buku);
       JOptionPane.showMessageDialog(formbuku, "Update Data Ok");
    }
    
    public void delete() throws Exception{
        String kodebuku = formbuku.getTblBuku().getValueAt(formbuku.getTblBuku().getSelectedRow(),0).toString();
        bukuDb.delete(kodebuku);
        JOptionPane.showMessageDialog(formbuku, "Delete Data Ok");
                   
    } 
}
    

