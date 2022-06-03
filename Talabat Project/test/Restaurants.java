package gui.test;


import java.awt.Image;
import java.util.Vector;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mahmoud
 */
public class Restaurants {
   
    private String res_name, workHours_b, workHours_e,address,img;
    private int phone;

    public Restaurants(String res_name, String workHours_b, String workHours_e, String address,String img, int phone) {
        this.res_name = res_name;
        this.workHours_b = workHours_b;
        this.workHours_e = workHours_e;
        this.address = address;
        this.phone = phone;
        this.img=img;
    }

    public String getRes_name() {
        return res_name;
    }

    public String getWorkHours_b() {
        return workHours_b;
    }

    public String getWorkHours_e() {
        return workHours_e;
    }

    public String getAddress() {
        return address;
    }

    public String getImg() {
        return img;
    }

    public int getPhone() {
        return phone;
    }
    
    
   
}
