/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventbooking;
import java.util.*;
/**
 *
 * @author sian
 */
public class EventBooking {
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        ArrayList<Event> allEvents;
 
      Storage.startUp();
      new mainMenu().setVisible(true);
    
} 
    
    public static boolean checkStrings(String stringToBeChecked)
    {
            if(stringToBeChecked.isEmpty())
            {  
              String error = "Please enter values for all fields";
              new errorForm(error).setVisible(true);
              return false;
            } else 
            {
               return true;
            }
    }
    
    public static boolean checkInts(String integerString)
    {
        try{
            int enteredInt = Integer.parseInt(integerString);
            return true;
            
        }catch(Exception e)
        {
            new errorForm("Value entered not a number").setVisible(true);
            return false;
            
        }
    }
    
    public static boolean checkEmail(String emailAddress)
    {
        if(emailAddress.isEmpty()  || emailAddress.contains("@") == false)
        {
              String error = "Please enter a valid email";
              new errorForm(error).setVisible(true);
              return false;
        } else { 
            
            return true;
            
        }
        
    }
           
}




