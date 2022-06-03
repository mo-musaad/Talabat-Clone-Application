
package gui.test;

public class Meals extends Meal_orgin {
 
   private String Meal_Type1,Meal_Type2,Meal_Time,img_path;
 
   
   public Meals(String Meal_Name,String Meal_Type1,String Meal_Type2,String Meal_Time,int Meal_Price,String img_path){
       super(Meal_Name,Meal_Price);
       this.Meal_Time=Meal_Time;
       this.Meal_Type1=Meal_Type1;
       this.Meal_Type2=Meal_Type2;
       this.img_path=img_path;
   }

    public String getImg_path() {
        return img_path;
    }

    public String getMeal_name() {
        return Meal_name;
    }

    public String getMeal_Type1() {
        return Meal_Type1;
    }

    public String getMeal_Type2() {
        return Meal_Type2;
    }

    public String getMeal_Time() {
        return Meal_Time;
    }

    public int getPrice() {
        return Meal_price;
    }
    
}
