/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

/**
 *
 * @author Said
 */
public class Product {
     private int id;
    private String name;
    private int jumlah;
    private float price;
    private byte[] picture;
    
    public Product(int pid, String pname, float pprice,int jumlah, byte[] pimg)
    {
        this.id = pid;
        this.name = pname;
        this.price = pprice;
        this.picture = pimg;
        this.jumlah = jumlah;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public float getPrice()
    {
        return price;
    }
    
    public int getJumlah()
    {
        return jumlah;
    }
    
    public byte[] getImage()
    {
        return picture;
    }
    
}
