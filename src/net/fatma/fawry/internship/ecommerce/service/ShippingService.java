/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fatma.fawry.internship.ecommerce.service;

import java.util.ArrayList;
import net.fatma.fawry.internship.ecommerce.entity.Shippable;

/**
 *
 * @author A M
 */
public class ShippingService {
     public static void shipItems(ArrayList<Shippable> items) {
        System.out.println("Shipping the following items:");
        for (Shippable item : items) {
            System.out.println("- " + item.getName() + " (" + item.getWeight() + " kg)");
        }
    }
}
