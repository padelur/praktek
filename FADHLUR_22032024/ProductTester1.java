/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package FADHLUR_22032024;

/**
 *
 * @author ACER
 */
public class ProductTester1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //6 object product1
        //2 object mengacu pada default constructor
        product1 p1 = new product1();
        product1 p2 = new product1();
        //4 object mengacu pada constructor dengan parameter
        
        product1 p3 = new product1(1,"Rinso 1.8 kg",10,48500.00);
        product1 p4 = new product1(2,"Molto Cair 100 ml",25,15500.00);
        product1 p5 = new product1(3,"Pepsodent",250,7500.00);
        product1 p6 = new product1(4,"Lifebuoy 150 ml",35,20000.00); 
        
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);
    }
    
}
