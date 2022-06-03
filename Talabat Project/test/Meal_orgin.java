/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.test;


public abstract class Meal_orgin {
    
    protected int Meal_price;
    protected String Meal_name;
    
    public Meal_orgin(String Meal_name, int Meal_price) {
        this.Meal_name=Meal_name;
        this.Meal_price=Meal_price;
                
    }
    
    protected abstract int getPrice();
    protected abstract String getMeal_name();
    
}
