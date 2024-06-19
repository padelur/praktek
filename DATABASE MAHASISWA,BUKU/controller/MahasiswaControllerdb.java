/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FADHLUR_30052024.controller;
import FADHLUR_30052024.model.Mahasiswa;
import FADHLUR_30052024.view.FormMahasiswa1;
import FADHLUR_30052024.DAO.MahasiswaDb;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class MahasiswaControllerdb {
   FormMahasiswa1 formMahasiswa;
    Mahasiswa mahasiswa;
    MahasiswaDb mahasiswaDb;
    
    public MahasiswaControllerdb(FormMahasiswa1 formMahasiswa){
        this.formMahasiswa = formMahasiswa;
        mahasiswaDb = new MahasiswaDb();
    }

    public void cancel(){
        formMahasiswa.getTxtNOBP().setText("");
        formMahasiswa.getTxtNama().setText("");
        formMahasiswa.getTxtAlamat().setText("");
        formMahasiswa.getTxtTglLahir().setText("");    
        isiJenisKelamin();
    } 
    
    public void isiJenisKelamin(){
        formMahasiswa.getCboJenisKelamin().removeAllItems();
        formMahasiswa.getCboJenisKelamin().addItem("L");
        formMahasiswa.getCboJenisKelamin().addItem("P");
    }
    
    public void insert(){
        try {
            mahasiswa = new Mahasiswa();
            mahasiswa.setNobp(formMahasiswa.getTxtNOBP().getText());
            mahasiswa.setNama(formMahasiswa.getTxtNama().getText());
            mahasiswa.setAlamat(formMahasiswa.getTxtAlamat().getText());
            mahasiswa.setJenisKelamin(formMahasiswa.getCboJenisKelamin().getSelectedItem().toString());
            mahasiswa.setTglLahir(formMahasiswa.getTxtTglLahir().getText());
            mahasiswaDb.insert(mahasiswa);
            JOptionPane.showMessageDialog(formMahasiswa, "Entri Data Ok");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(formMahasiswa, "Error  "+ex.getMessage());
        }
    }
    
    public void viewData(){
        try {
            DefaultTableModel model = (DefaultTableModel)formMahasiswa.getTabelMahasiswa1().getModel();
            model.setNumRows(0);
            List<Mahasiswa> list = mahasiswaDb.getAllmahasiswa();
            for(Mahasiswa mahasiswa : list){
                Object[] data = {
                    mahasiswa.getNobp(),
                    mahasiswa.getNama(),
                    mahasiswa.getAlamat(),
                    mahasiswa.getJenisKelamin(),
                    mahasiswa.getTglLahir()
                };
                model.addRow(data);
            }
        } catch (Exception ex) {
            Logger.getLogger(MahasiswaControllerdb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




    public  void actionClickTabel(){
        try {
            String nobp = formMahasiswa.getTabelMahasiswa1()
                    .getValueAt(formMahasiswa.getTabelMahasiswa1().getSelectedRow(), 0).toString();
            mahasiswa = mahasiswaDb.getMahasiswa(nobp);
            formMahasiswa.getTxtNOBP().setText(mahasiswa.getNobp());
            formMahasiswa.getTxtNama().setText(mahasiswa.getNama());
            formMahasiswa.getTxtAlamat().setText(mahasiswa.getAlamat());
            formMahasiswa.getCboJenisKelamin().setSelectedItem(mahasiswa.getJenisKelamin());
            formMahasiswa.getTxtTglLahir().setText(mahasiswa.getTglLahir());
        } catch (Exception ex) {
            Logger.getLogger(MahasiswaControllerdb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(){
        
        try {
            mahasiswa.setNobp(formMahasiswa.getTxtNOBP().getText());
            mahasiswa.setNama(formMahasiswa.getTxtNama().getText());
            mahasiswa.setAlamat(formMahasiswa.getTxtAlamat().getText());
            mahasiswa.setJenisKelamin(formMahasiswa.getCboJenisKelamin()
                    .getSelectedItem().toString());
            mahasiswa.setTglLahir(formMahasiswa.getTxtTglLahir().getText());
            mahasiswaDb.update(mahasiswa);
            JOptionPane.showMessageDialog(formMahasiswa, "Update Data Ok");
        } catch (Exception ex) {
            Logger.getLogger(MahasiswaControllerdb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(){
        try {
            String nobp = formMahasiswa.getTabelMahasiswa1()
                    .getValueAt(formMahasiswa.getTabelMahasiswa1().getSelectedRow(), 0).toString();
            mahasiswaDb.delete(nobp);
            JOptionPane.showMessageDialog(formMahasiswa, "Delete Data Ok");
        } catch (Exception ex) {
            Logger.getLogger(MahasiswaControllerdb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

    

