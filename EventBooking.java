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
    public static void main(String[] args) {
        
      
        // Creating a new Event
        ArrayList<Date> expectDates = new ArrayList<>();   
        int price = 100;
        int capacity = 500;
        int numberOfSessions = 3;
        
        String name = new String();
        name = "Computer Science Graduation";
        
        String location; 
        location = "Uni Hall";
        
       
        Event ball = new Event(expectDates, price, capacity, location, name, numberOfSessions);
        
        //Creating 50 random bookings for the new event
        for(int totalBookings = 0; totalBookings < 50; totalBookings++)
        {      
            
            String chosenName = "";
            int sessionNumber = 0;
            
            
            
            chosenName = getRandomName();
            sessionNumber = getRandomSessionNumber();
      
          
            Booking myBooking = new Booking(ball, sessionNumber, chosenName);
            myBooking.printBookingInformation();
             
     
    }
        
        
      
    
}
    //Generates a random session number between 0 and 3
    public static int getRandomSessionNumber()
    {
          double randomDouble = Math.random();
          int sessionNumber = 0;
          
          if(randomDouble < 0.3)
            {
                sessionNumber = 1;
                return sessionNumber;
                
            } else if(randomDouble < 0.6)
            {
                sessionNumber = 2;
                 return sessionNumber;
                
                
            } else
            {
                sessionNumber = 3;
                 return sessionNumber;
                
            }
          
    }
    
    //Generates a random name out of someone in the group
    public static String getRandomName()
    {
            String name1  = "Rory";
            String name2  = "Jarrad";
            String name3  = "Molin";
            String name4  = "Mohid";
            String name5  = "Zhijin";
            
            String chosenName = "";
            
            ArrayList<String> allNames = new ArrayList<String>();
            allNames.add(name1);
            allNames.add(name2);
            allNames.add(name3);
            allNames.add(name4);
            allNames.add(name5);
           
            double randomDouble = Math.random();
            
           
            int sessionNumber = 0;
            
             if(randomDouble < 0.20)
            {
                chosenName = allNames.get(0);
                 return chosenName;
                
                
            } else if(randomDouble < 0.40)
            {
                 chosenName = allNames.get(1);
                  return chosenName;
                
            } else if (randomDouble < 0.60)
            {
                 chosenName = allNames.get(2);
                  return chosenName;
                 
            } else if (randomDouble < 0.80)
            {
                 chosenName = allNames.get(3);
                  return chosenName;
            } else
            {
                 chosenName = allNames.get(4);
                 return chosenName;
            }
    } 
}

