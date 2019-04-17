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
    
   public String eventID;
   private ArrayList<Calendar> dates;
   private int price;
   private String[] promoCodes;
   private int capacity;
   private String location;
   private String name;
   private int numberOfSessions;
   private ArrayList<String> bookingIDs;
  

    public Event( ArrayList<Calendar> dates, int price, int capacity, String location, String name, int numberOfSessions) {
        this.dates = dates;
        this.price = price;
        this.capacity = capacity;
        this.location = location;
        this.name = name;
        this.numberOfSessions = numberOfSessions;
        this.eventID = createEventID();
        this.bookingIDs = new ArrayList<String>();
       
    }

    public String getEventID() {
        return eventID;
    }

    public Calendar getDate(int sessionNumber) {
        if(sessionNumber < dates.size())
        {
             Calendar session = dates.get(sessionNumber);
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
    
    
    public void makeBooking(String bookingID){
        
        bookingIDs.add(bookingID);
        
    }
    
    public ArrayList<String> getBookings() {
        
        return bookingIDs;
    
}
    public String createEventID()
    {
        Random random = new Random();
        int val = random.nextInt();
        String Hex = new String();
        Hex = Integer.toHexString(val);
        return Hex; 
           
        
    }
    
    
    public void printEvent()
    {
        System.out.println("Event Name: " + this.getName());
        System.out.println("Event Price: " + this.getPrice());
        System.out.println("Event Capacity: " + this.getCapacity());
        System.out.println("Event Date: " + this.getDate(0).getTime());
        System.out.println("Event Location: " + this.getLocation());
        
        System.out.println("EVENT ID " + this.eventID);
    }
    
    
    
   
    
    
}
