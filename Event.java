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
public class Event {
    
   public int eventID;
   private ArrayList<Date> dates;
   private int price;
   private String[] promoCodes;
   private int capacity;
   private String location;
   private String name;
   private int numberOfSessions;
   private ArrayList<Integer> bookingIDs;
  

    public Event( ArrayList<Date> dates, int price, int capacity, String location, String name, int numberOfSessions) {
        this.dates = dates;
        this.price = price;
        this.capacity = capacity;
        this.location = location;
        this.name = name;
        this.numberOfSessions = numberOfSessions;
       
    }

    public int getEventID() {
        return eventID;
    }

    public Date getDate(int sessionNumber) {
        if(sessionNumber < dates.size())
        {
            Date session = dates.get(sessionNumber);
             return session;
            
        }
        else 
            return null;
        
    }

    public int getPrice() {
        return price;
    }

    public String[] getPromoCodes() {
        return promoCodes;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSessions() {
        return numberOfSessions;
    }
    
    
    public void makeBooking(Integer bookingID){
        
        bookingIDs.add(bookingID);
        
    }
    
    public ArrayList<Integer> getBookings() {
        
        return bookingIDs;
    
    
}
    
    
   
    
    
}
