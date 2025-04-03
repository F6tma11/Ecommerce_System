/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fatma.fawry.internship.ecommerce;

import java.util.ArrayList;

/**
 *
 * @author A M
 */
public class Cart {

    private Customer customer;
    private ArrayList<ProductCart> products;
    private double totalPrice;

    Cart(Customer customer) {
        this.customer = customer;
        totalPrice = 0.0;
        products = new ArrayList<>();

    }

    public boolean add(Product product, int quantity) {
        if (product.isFound() && quantity <= product.getQuentity()&&product.isShipping()&&!product.isExpire()) {
            products.add(new ProductCart(product, quantity));
            totalPrice += product.getPrice();
            return true;
        } else if (!product.isShipping()) {
            System.out.println("This "+product.getName()+" product does not applicable to shipping");
            return false;
        } else if (product.isExpire()) {
            System.out.println("This"+product.getName()+" product is expired");
            return false;
        } else if(quantity>product.getQuentity()) {
            System.out.println("This quentity not available ,we have "+product.getQuentity()+" item");
            return false;
        }
        return false;

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<ProductCart> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductCart> products) {
        this.products = products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isFound(Product product) {
        for (ProductCart item : products) {
            if (product.getName().equals(item.getProduct().getName())) {
                return true;
            }
        }
        return false;
    }

    public void remove(Product product) {
        if (this.isFound(product)) {
            this.products.remove(product);
            totalPrice -= product.getPrice();
            System.out.println("Product removed succesfully.");
        } else {
            System.out.println("This product not found on your cart.");
        }
    }
}
