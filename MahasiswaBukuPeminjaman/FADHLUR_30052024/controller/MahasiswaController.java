/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FADHLUR_30052024.controller;

import FADHLUR_30052024.model.Mahasiswa;
import FADHLUR_30052024.view.FormMahasiswaArray;
import FADHLUR_30052024.model.MahasiswaDao;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class MahasiswaController 
{
    FADHLUR_30052024.view.FormMahasiswaArray formMahasiswa;
    FADHLUR_30052024.model.Mahasiswa mahasiswa;
    FADHLUR_30052024.model.MahasiswaDao mahasiswaDao;
    int index;
    
    public MahasiswaController(FADHLUR_30052024.view.FormMahasiswaArray formMahasiswa)
    {
        this.formMahasiswa = formMahasiswa;
        mahasiswaDao = new FADHLUR_30052024.model.MahasiswaDao();
    }
    
    public void cancel()
    {
        formMahasiswa.getTxtNOBP().setText("");
        formMahasiswa.getTxtNama().setText("");
        formMahasiswa.getTxtAlamat().setText("");
        formMahasiswa.getTxtTglLahir().setText("");
        isiJenisKelamin();
    }
    
    public void isiJenisKelamin()
    {
        formMahasiswa.getCboJenisKelamin().removeAllItems();
        formMahasiswa.getCboJenisKelamin().addItem("L");
        formMahasiswa.getCboJenisKelamin().addItem("P");
    }
    
    public void insert()
    {
        mahasiswa = new FADHLUR_30052024.model.Mahasiswa();
        mahasiswa.setNobp(formMahasiswa.getTxtNOBP().getText());
        mahasiswa.setNama(formMahasiswa.getTxtNama().getText());
        mahasiswa.setAlamat(formMahasiswa.getTxtAlamat().getText());
        mahasiswa.setJenisKelamin(formMahasiswa.getCboJenisKelamin().getSelectedItem().toString());
        mahasiswa.setTglLahir(formMahasiswa.getTxtTglLahir().getText());
        mahasiswaDao.insert(mahasiswa);
        JOptionPane.showMessageDialog(formMahasiswa, "Entry Data Ok");
    }
    public void getMahasiswa(){
        int index = formMahasiswa.getTabelMahasiswa().getSelectedRow();
        mahasiswa = mahasiswaDao.getMahasiswa(index);
        if(mahasiswa != null){
            formMahasiswa.getTxtNOBP().setText(mahasiswa.getNobp());
            formMahasiswa.getTxtNama().setText(mahasiswa.getNama());
            formMahasiswa.getTxtAlamat().setText(mahasiswa.getAlamat());
            formMahasiswa.getCboJenisKelamin().setSelectedItem(mahasiswa.getJenisKelamin());
            formMahasiswa.getTxtTglLahir().setText(mahasiswa.getTglLahir());
        }
    }
    
    public void viewData()
    {
        DefaultTableModel model = (DefaultTableModel)formMahasiswa.getTabelMahasiswa().getModel();
        model.setNumRows(0);
        List<FADHLUR_30052024.model.Mahasiswa> list = mahasiswaDao.getAllMahasiswa();
        for(FADHLUR_30052024.model.Mahasiswa mahasiswa :list)
        {
             Object[] data = 
            {
                mahasiswa.getNobp(),
                mahasiswa.getNama(),
                mahasiswa.getAlamat(),
                mahasiswa.getJenisKelamin(),
                mahasiswa.getTglLahir()
            };
            model.addRow(data);
        }
    }
    
    public void update()
    {
        mahasiswa.setNobp(formMahasiswa.getTxtNOBP().getText());
        mahasiswa.setNama(formMahasiswa.getTxtNama().getText());
        mahasiswa.setAlamat(formMahasiswa.getTxtAlamat().getText());
        mahasiswa.setJenisKelamin(formMahasiswa.getCboJenisKelamin().getSelectedItem().toString());
        mahasiswa.setTglLahir(formMahasiswa.getTxtTglLahir().getText());
        JOptionPane.showMessageDialog(formMahasiswa, "Update Data OK");
    }
    
    public void delete()
        {
            mahasiswaDao.delete(index);
            JOptionPane.showMessageDialog(formMahasiswa, "Delete Data Ok");
        }
}
