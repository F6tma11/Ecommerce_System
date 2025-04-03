/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fatma.fawry.internship.ecommerce;

/**
 *
 * @author A M
 */
public class Product {

    private String name;
    private double price;
    private int quentity;
    private double weight;
    private boolean expire;
    private boolean shipping;

    public Product(String name, double price, int quentity, double weight, boolean expire, boolean shipping) {
        this.name = name;
        this.price = price;
        this.quentity = quentity;
        this.weight = weight;
        this.expire = expire;
        this.shipping = shipping;
    }
    
  public Product(String name, double price, int quentity, double weight, boolean shipping) {
        this.name = name;
        this.price = price;
        this.quentity = quentity;
        this.weight = weight;
        this.shipping = shipping;
    }


    public Product() {
    }
    
    
    public boolean isExpire() {
        return expire;
    }

    public void setExpire(boolean expire) {
        this.expire = expire;
    }

    public boolean isShipping() {
        return shipping;
    }

    public void setShipping(boolean shipping) {
        this.shipping = shipping;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuentity() {
        return quentity;
    }

    public void setQuentity(int quentity) {
        this.quentity = quentity;
    }

    public boolean isFound() {
        if (this.quentity > 0) {
            return true;
        } else {
            System.out.println("Expired");
            return false;
        }
    }

}
