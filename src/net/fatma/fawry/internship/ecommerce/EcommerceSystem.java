/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fatma.fawry.internship.ecommerce;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import net.fatma.fawry.internship.ecommerce.entity.Customer;
import net.fatma.fawry.internship.ecommerce.entity.ProductCart;
import net.fatma.fawry.internship.ecommerce.entity.Cart;
import net.fatma.fawry.internship.ecommerce.entity.Product;
import net.fatma.fawry.internship.ecommerce.entity.Shippable;
import net.fatma.fawry.internship.ecommerce.service.CheckoutService;
import net.fatma.fawry.internship.ecommerce.service.ShippingService;

/**
 *
 * @author A M
 */
public class EcommerceSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Customer fatmah = new Customer("Fatmah", "fatmah@gmail.com", "sadat city", "01015006073", 2500);
        Customer ahmed = new Customer("Ahmed", "ahmed@gmail.com", "sadat city", "0112006073", 3000);
        Customer walid = new Customer("Walid", "walid@gmail.com", "sadat city", "01013006073", 100);
        
        ArrayList<Product>productList=new ArrayList<>();
        Product cheese = new Product("cheese", 20, 10, 250, new GregorianCalendar(2025, Calendar.JULY, 1).getTime(), true);
        Product egg = new Product("egg packet", 150, 50, 250, new GregorianCalendar(2025, Calendar.NOVEMBER, 1).getTime(), true);
        Product milk = new Product("milk", 35.50, 100, 1000, new GregorianCalendar(2025, Calendar.APRIL, 7).getTime(), true);
        Product tv = new Product("TV", 7000, 20, 2000, true);
        Product mobile = new Product("Mobile", 4000, 20, 500, true);
        Product biscuits = new Product("Biscuits", 10, 50, 10, new GregorianCalendar(2025, Calendar.DECEMBER, 1).getTime(), true);
        Product appleJuice = new Product("Apple Juice", 15, 2, 10, new GregorianCalendar(2025, Calendar.MARCH, 1).getTime(), true);
        Product cards = new Product("Mobile scratch cards", 15, 2, 1, false);
        productList.add(tv);
        productList.add(cheese);
        productList.add(egg);
        productList.add(milk);
        productList.add(biscuits);
        productList.add(appleJuice);
        productList.add(cards);
        productList.add(mobile);
        
        ArrayList<Shippable>shipItems=new ArrayList<>();
        for (Product item : productList) {
            if (item.isShipping()) {
                shipItems.add(item);
            }
        }
        
        ShippingService.shipItems(shipItems);
        Cart fatmahCart = new Cart(fatmah);
        Cart ahmedCart = new Cart(ahmed);
        Cart walidCart = new Cart(walid);
        
        fatmahCart.add(cards, 2);
        fatmahCart.add(appleJuice, 2);
//        fatmahCart.add(tv, 1);
        fatmahCart.add(biscuits, 50);
        if (!fatmahCart.getProducts().isEmpty()) {
            CheckoutService.checkout(fatmah, fatmahCart);
        } else {
           throw new IllegalArgumentException("Cart is empty");
        }

    }

}
