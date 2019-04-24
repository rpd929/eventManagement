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
   public String eventString;
   private Calendar date;
   private int price;
   private String[] promoCodes;
   private int capacity;
   private String location;
   private String name;
   private ArrayList<Booking> allBookings;
   private ArrayList<String> allBookingIDs;
  

    public Event(Calendar date, int price, int capacity, String location, String name) {
        this.date = date;
        this.price = price;
        this.capacity = capacity;
        this.location = location;
        this.name = name;
        this.eventID = createEventID();
        this.allBookings = new ArrayList<Booking>();
        this.allBookingIDs = new ArrayList<String>();
        this.eventString = this.name;
        eventString = eventString + " " + this.location;
        eventString = eventString + " $" + Integer.toString(this.price);
        
       
    }

    public String getEventID() {
        return eventID;
    }

    public Calendar getDate() {
        
        return date;
        
    }

    public int getPrice() {
        return price;
    }

    public String[] getPromoCodes() {
        return promoCodes;
    }
    
    public String getEventString() {
        return eventString;
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
    
    public void setBookings(ArrayList<Booking> allBookings, ArrayList<String> allBookingIDs)
    {
        this.allBookings = allBookings;
        this.allBookingIDs = allBookingIDs;
    }
    
    public boolean findBooking(String bookingID)
    {
        if(allBookingIDs.contains(bookingID))
        {
            return true;
            
        } else 
        {
            return false;
        }
    }

    
    
    
    public void makeBooking(Booking newBooking){
        
        allBookingIDs.add(newBooking.bookingID);
        allBookings.add(newBooking);
        
    }
    
    public ArrayList<Booking> getBookings() {
        
        return allBookings;
    
}
  public ArrayList<String> getBookingIDs() {
        
        return allBookingIDs;
    
}   
    public void editBookings(Booking oldBooking, Booking newBooking)
    {
        allBookingIDs.set(allBookingIDs.indexOf(oldBooking.bookingID), newBooking.bookingID);
        allBookings.set(allBookings.indexOf(oldBooking), newBooking);
    }
    
    public Booking getSingleBooking(String bookingID)
    {
        int indexOfBooking = allBookingIDs.indexOf(bookingID);
        Booking newBooking = allBookings.get(indexOfBooking);
        return newBooking;
        
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
        System.out.println("Event Date: " + this.date.getTime());
        System.out.println("Event Location: " + this.getLocation());
        
        System.out.println("EVENT ID " + this.eventID);
    }
    
    
    
   
    
    
}
