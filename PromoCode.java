/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventbooking;

import java.util.Random;

/**
 *
 * @author sian
 */
public class PromoCode {
    
    String codeID;
    double percentageDiscount;
    boolean validStatus = true;

    public PromoCode(double percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
        codeID = createPromoCode();
       
        
    }
    public PromoCode(String codeID, double percentageDiscount) {
        
        this.percentageDiscount = percentageDiscount;
        this.codeID = codeID;
       
        
    }
    
    
    
    public String createPromoCode()
    {
        Random random = new Random();
        int val = random.nextInt();
        String Hex = new String();
        Hex = Integer.toHexString(val);
        return Hex; 
      
    }
    
    public void useCode()
    {
        this.validStatus = false;
    }
    
    
}
