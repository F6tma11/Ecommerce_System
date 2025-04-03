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
public class ProductCart {
    Product product;
    private int quentity;

    public ProductCart(Product product, int quentity) {
        this.product = product;
        this.quentity = quentity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuentity() {
        return quentity;
    }

    public void setQuentity(int quentity) {
        this.quentity = quentity;
    }
    
}
