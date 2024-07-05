/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package FADHLUR_03282024;

/**
 *
 * @author ACER
 */
public class StudentRecordExample {

    public static void main(String[] args) 
    {
       StudentRecord student1 = new StudentRecord();
       student1.setName("Ali");
       student1.setAddress("Padang");
       student1.setAge(20);
       student1.setmathGrade(70);
       student1.setEnglishGrade(80);
       student1.setScienceGrade(70);
       
       System.out.println("Nama               :"+student1.getName());
       System.out.println("Alamat             :"+student1.getAddress());
       System.out.println("Umur               :"+student1.getAge());
       System.out.println("Matematika         :"+student1.getmathGrade());
       System.out.println("B. Inggris         :"+student1.getEnglishGrade());
       System.out.println("Ilmu Pengetahuan   :"+student1.getScienceGrade());
       System.out.println("Rata-Rata          :"+student1.getAverage());
       
       System.out.println();
       
       StudentRecord annarecord = new StudentRecord("Anna");
       StudentRecord alirecord = new StudentRecord("Ali","Padang");
       StudentRecord denirecord = new StudentRecord(80,70,60);
       
      System.out.println("Anna Record");
      annarecord.print(annarecord.getName());
      System.out.println();
      System.out.println("Ali Record");
      alirecord.print(alirecord.getName());
      System.out.println();
      System.out.println("Deni Record");
      denirecord.print(denirecord.getEnglishGrade(), denirecord.getmathGrade(), denirecord.getScienceGrade());
      
      System.out.println();
       System.out.println("Jumlah Siswa       :"+StudentRecord.getStudentCount());
    }
    
}
