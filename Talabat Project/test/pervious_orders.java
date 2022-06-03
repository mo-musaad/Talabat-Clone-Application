/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.test;

/**
 *
 * @author mohme
 */
public class pervious_orders extends Meal_orgin {
    int meal_freq;
    String res_name;

    public pervious_orders(int meal_freq, int price, String meal_name, String res_name) {
        super(meal_name,price);
        this.meal_freq = meal_freq;
        this.res_name = res_name;
    }

  
    public int getMeal_freq() {
        return meal_freq;
    }

    public int getPrice() {
        return Meal_price;
    }

  

    public String getMeal_name() {
        return Meal_name;
    }

    public String getRes_name() {
        return res_name;
    }
    
}
