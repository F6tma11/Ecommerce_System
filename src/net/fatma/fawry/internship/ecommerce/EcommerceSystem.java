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
public class EcommerceSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Customer fatmah = new Customer("Fatmah", "fatmah@gmail.com", "sadat city", "01015006073", 2500);
        Customer ahmed = new Customer("Ahmed", "ahmed@gmail.com", "sadat city", "0112006073", 3000);
        Customer walid = new Customer("Walid", "walid@gmail.com", "sadat city", "01013006073", 100);

        Product cheese = new Product("cheese", 20, 10, 250, false, true);
        Product egg = new Product("egg packet", 150, 50, 250, false, true);
        Product milk = new Product("milk", 35.50, 100, 1000, false, true);
        Product tv = new Product("TV", 7000, 20, 2000, true);
        Product biscuits = new Product("Biscuits", 10, 50, 10, false, true);
        Product appleJuice = new Product("Apple Juice", 15, 2, 10, true, true);
        Product cards = new Product("Mobile scratch cards", 15, 2, 1, false);

        Cart fatmahCart = new Cart(fatmah);
        Cart ahmedCart = new Cart(ahmed);
        Cart walidCart = new Cart(walid);
        fatmahCart.add(cards, 2);
        fatmahCart.add(appleJuice, 2);
        fatmahCart.add(tv, 2);
        fatmahCart.add(biscuits, 50);
        if (!fatmahCart.getProducts().isEmpty()) {
            checkout(fatmah, fatmahCart);
        } else {
            System.out.println("Cart is empty");
        }

    }

    public static void productWeight(Cart cart) {
        
        for (ProductCart proWeight : cart.getProducts()) {
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
            System.out.println("Your balance in unsufficient");
        }
    }

}
