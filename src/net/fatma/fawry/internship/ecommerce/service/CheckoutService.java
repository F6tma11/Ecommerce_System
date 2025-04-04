/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fatma.fawry.internship.ecommerce.service;

import net.fatma.fawry.internship.ecommerce.entity.Cart;
import net.fatma.fawry.internship.ecommerce.entity.Customer;
import net.fatma.fawry.internship.ecommerce.entity.ProductCart;

/**
 *
 * @author A M
 */
public class CheckoutService {
     public static void productWeight(Cart cart) {
        
        for (ProductCart proWeight : cart.getProducts()) {
            if (proWeight.getProduct().isShipping()){
                 System.out.print(proWeight.getQuentity() + "X  ");
            System.out.print(proWeight.getProduct().getName() + "\t");
            double weightByKilo = proWeight.getProduct().getWeight() * proWeight.getQuentity() / 1000;
            if (weightByKilo >= 1) {
                System.out.println(weightByKilo + "kg");
          
            } else {
                System.out.println((int) proWeight.getProduct().getWeight() * proWeight.getQuentity() + "g");
               
            }
            }
           
        }
   
    }

    public static double productPrice(Cart cart) {
        double subTotalPrice = 0;
        for (ProductCart proPrice : cart.getProducts()) {
            System.out.print(proPrice.getQuentity() + "X  ");
            System.out.print(proPrice.getProduct().getName() + "\t");
            System.out.println((int) proPrice.getProduct().getPrice() * proPrice.getQuentity() + "$");
            subTotalPrice += proPrice.getProduct().getPrice() * proPrice.getQuentity();
        }
        return subTotalPrice;
    }

    public static void checkout(Customer cust, Cart cart) {
        System.out.println("\n-----------------------------------------------------");
        System.out.println("**Shipment Notic**");
        productWeight(cart);
       
        System.out.println("\n**Checkout Recipt**");
        double subTotal = productPrice(cart);
        double shipping = 30;
        double total = shipping + subTotal;
        System.out.println("\n------------------------------------------");
        if (cust.getBalance() >= total) {
            System.out.println("SubTotal   " + subTotal);
            System.out.println("Shipping   " + shipping);
            System.out.println("Total Price   " + total);
            System.out.println(" Your current price is " + cust.getBalance());
            cust.setBalance(cust.getBalance() - total);
            System.out.println("YOU paied " + total + " Your current price is " + cust.getBalance());
        } else {
            throw new IllegalArgumentException("Your balance in unsufficient");
           
        }
    }
}
