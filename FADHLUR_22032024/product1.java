/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FADHLUR_22032024;

/**
 *
 * @author ACER
 */
public class product1 
{
    //private instance variable
    private int itemnumber;
    private String name;
    private int quantitystock;
    private double price;
    
    //default constructor untuk inisialisasi nilai awal
    //string=null, int=0, double=0.0
    public product1()
    {}
    //constructor dengan parameter
    public product1(int number, String name, int qty, double price)
    {
        this.itemnumber = number;
        this.name = name;
        this.quantitystock = qty;
        this.price = price;
    }
    
    //method accessor(getter) untuk item number
    public int getitemnumber()
    {
        return itemnumber;
    }
    //method mutation(setter) untuk itemnumber - update nilai
    public void setitemnumber(int number)
    {
        this.itemnumber = number;
    }
    
    //getter dan setter untuk variabel name
    public String getname()
    {
        return name;
    }
    public void setname(String name)
    {
        this.name = name;
    }
    
     //getter dan setter untuk variabel quantitystock
    public int getquantitystock()
    {
        return quantitystock;
    }
    public void setquantitystock(int qty)
    {
        this.quantitystock = qty;
    }
    
     //getter dan setter untuk variabel price
    public double getprice()
    {
        return price;
    }
    public void setprice(double price)
    {
        this.price = price;
    }
    
    @Override
    public String toString()
    {
        return "\nKode produk : "+this.itemnumber+
               "\nNama Produk : "+this.name+
               "\nJumlah Produk : "+this.quantitystock+
               "\n Harga Produk : "+this.price;
    }
}
