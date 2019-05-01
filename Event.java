/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventbooking;
import java.time.Instant;
import java.time.temporal.TemporalField;
import java.util.*;
import javax.swing.JOptionPane;


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
   public String description;
   private String emailAddress;
  

    public Event(Calendar date, int price, int capacity, String location, String name, String description, String email) {
        this.date = date;
        this.price = price;
        this.capacity = capacity;
        this.location = location;
        this.name = name;
        this.eventID = createEventID();
        this.allBookings = new ArrayList<Booking>();
        this.allBookingIDs = new ArrayList<String>();
        this.eventString = this.name;
        eventString = eventString + " at " + this.location;
        eventString = eventString + " on " + this.getDate().getDay();
        eventString = eventString + "/" + (this.getDate().getMonth() + 1);
        eventString = eventString + "/" + (this.getDate().getYear() +1900) + " at ";
        eventString = eventString + this.getDate().getHours() + ":" + this.getDate().getMinutes();
        this.description = description;
        this.emailAddress = email;
   
    }
    
    public String toString(){
        
        return eventString;
    }
    
    public String seeMore()
    {
        String seeMoreString;
        seeMoreString = "<html><b> Event Name: </b> " + name + ". <br/><br/>";
        seeMoreString = seeMoreString + "<b>Date: </b>" + getReadableDate()+ ".<br/><br/>";
        seeMoreString = seeMoreString + "<b>Price: $</b>" + price + ". <br/><br/>";
        seeMoreString = seeMoreString + "<b>Location: </b>" + location + ". <br/><br/>";
        seeMoreString = seeMoreString + "<b>Description: </b>" + description + "</html>";
        return seeMoreString;
        
    }

    public String getEventID() {
        return eventID;
    }
    
    public String getReadableDate(){
        
        String dateString;
        dateString = Integer.toString(date.getTime().getDate()) + "/";
        dateString = dateString + Integer.toString(date.getTime().getMonth()+1) + "/";
        dateString = dateString + Integer.toString(date.getTime().getYear() + 1900) + " ";
        if(date.getTime().getHours() > 12)
        {
            dateString = dateString + Integer.toString(date.getTime().getHours() - 12) + ":";
            dateString = dateString + Integer.toString(date.getTime().getMinutes()) + "PM";
            
        } else {
            
            dateString = dateString + Integer.toString(date.getTime().getHours()) + ":";
            dateString = dateString + Integer.toString(date.getTime().getMinutes()) + "AM";
            
        }
        return dateString;
        
        
    }

    public Date getDate() {
        
        Date readableDate;
        readableDate =  date.getTime();
       
    
        return readableDate;
        
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
    
    public String getEmail()
    {
        return emailAddress;
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
    public void editBookings(Booking newBooking)
    {
        allBookingIDs.set(allBookingIDs.indexOf(newBooking.bookingID), newBooking.bookingID);
        allBookings.set(allBookings.indexOf(newBooking), newBooking);
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
    
    public void cancelBooking(Booking booking)
    {
        this.allBookingIDs.remove(booking.bookingID);
        this.allBookings.remove(booking);
        JOptionPane.showMessageDialog(null,"Booking Deleted");

        
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
