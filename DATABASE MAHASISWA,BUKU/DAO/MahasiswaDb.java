/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FADHLUR_30052024.DAO;
import FADHLUR_30052024.model.Mahasiswa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class MahasiswaDb {
    
    public void insert(Mahasiswa mahasiswa) throws Exception{
        DBHelper db = new DBHelper();
        String query ="insert into formmahasiswa1 values(?,?,?,?,?)";
        PreparedStatement ps = db.getKoneksi().prepareStatement(query);
        ps.setString(1,mahasiswa.getNobp());
        ps.setString(2,mahasiswa.getNama());
        ps.setString(3,mahasiswa.getAlamat());
        ps.setString(4,mahasiswa.getJenisKelamin());
        ps.setString(5,mahasiswa.getTglLahir());
        ps.executeUpdate();
        
        
    }
    public void update(Mahasiswa mahasiswa) throws Exception{
        DBHelper db = new DBHelper();
        String query ="update mahasiswa set nama=?,alamat=?"
                +"jeniskelamin=?,tanggallahir=?,where nobp=?";
        PreparedStatement ps = db.getKoneksi().prepareStatement(query);
        ps.setString(1,mahasiswa.getNobp());
        ps.setString(2,mahasiswa.getNama());
        ps.setString(3,mahasiswa.getAlamat());
        ps.setString(4,mahasiswa.getJenisKelamin());
        ps.setString(5,mahasiswa.getTglLahir());
        ps.executeUpdate();
    }
    public void delete(String nobp) throws Exception
    {
        DBHelper db = new DBHelper ();
        String query = "delete from formmahasiswa1 where nobp=?";
        PreparedStatement ps = db.getKoneksi().prepareStatement(query);
        ps.setString(1, nobp);
        ps.executeUpdate();
    }
     public Mahasiswa getMahasiswa(String nobp) throws Exception {
        DBHelper db = new DBHelper();
        String query = "SELECT * FROM formmahasiswa1 WHERE nobp=?";
        try (PreparedStatement ps = db.getKoneksi().prepareStatement(query)) {
            ps.setString(1, nobp);
            ResultSet rs = ps.executeQuery();
            Mahasiswa mahasiswa = null;
            if (rs.next()) {
                mahasiswa = new Mahasiswa();
                mahasiswa.setNobp(rs.getString("1"));
                mahasiswa.setNama(rs.getString("2"));
                mahasiswa.setAlamat(rs.getString("3"));
                mahasiswa.setJenisKelamin(rs.getString("4"));
                mahasiswa.setTglLahir(rs.getString("5"));
            }
            return mahasiswa;
        }
     }
        public List<Mahasiswa> getAllmahasiswa()  throws Exception{
        DBHelper db = new DBHelper();
        String query = "select * from formmahasiswa1";
        PreparedStatement ps = db.getKoneksi().prepareStatement(query);
        List<Mahasiswa> list = new ArrayList();
        Mahasiswa mahasiswa = null;
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            mahasiswa = new Mahasiswa();
            mahasiswa.setNobp(rs.getString(1));
            mahasiswa.setNama(rs.getString(2));
            mahasiswa.setAlamat(rs.getString(3));
            mahasiswa.setJenisKelamin(rs.getString(4));
            mahasiswa.setTglLahir(rs.getString(5));
            list.add(mahasiswa);
        }
        return list;
    }
    }

