/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventbooking;


import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;



public class Booking {
 
    public String bookingID;
    private Calendar date;
    private Event eventBooked;   
    private String bookerName;
    private String emailAddress;
    private static allEvents eventList;
    private static double discountPrice = -1;

    public Booking(Event eventBooked, String bookerName, String email, double discountPrice) {
     
       
        this.bookingID = createBookingID();
        this.eventBooked = eventBooked; 
        this.bookerName = bookerName;
        this.emailAddress = email;
        bookEvent(eventBooked);
        this.discountPrice = discountPrice;
       
        
        //int eventIndex = eventList.findEvent(eventBooked.eventID); 
    }
     public Booking(Event eventBooked, String bookerName, String email) {
     
       
        this.bookingID = createBookingID();
        this.eventBooked = eventBooked; 
        this.bookerName = bookerName;
        this.emailAddress = email;
        bookEvent(eventBooked);
        
       
        
        //int eventIndex = eventList.findEvent(eventBooked.eventID); 
    }
    public Booking(Event eventBooked,  String bookingID, String bookerName, String email) {
     
       
        this.bookingID = bookingID;
        this.eventBooked = eventBooked; 
        this.bookerName = bookerName;
        this.emailAddress = email;
        bookEvent(eventBooked);
        
        //int eventIndex = eventList.findEvent(eventBooked.eventID);
     
    }
 public Booking(Event eventBooked,  String bookingID, String bookerName, String email, double discountPrice) {
     
       
        this.bookingID = bookingID;
        this.eventBooked = eventBooked; 
        this.bookerName = bookerName;
        this.emailAddress = email;
        bookEvent(eventBooked);
        this.discountPrice = discountPrice;
        
        //int eventIndex = eventList.findEvent(eventBooked.eventID);
     
    }    
    public final void bookEvent(Event event)
    {
        event.makeBooking(this);
    }
    
    public String viewBooking()
    {
        
        String bookingString = "<html><b>BookingID: </b> " + this.bookingID + " <b> Event: </b>  " + eventBooked.eventString + "</html>";
       return bookingString;
    }
    
    public String createBookingID()
    {
        Random random = new Random();
        int val = random.nextInt();
        String Hex = new String();
        Hex = Integer.toHexString(val);
        return Hex; 
        
    }
    
    public String getEventID()
    {
        return eventBooked.eventID;
    }
    
    public String getBookingID()
    {
        return bookingID;
    }
     public String getEmail()
    {
        return this.emailAddress;
    }
    
    public String getName()
    {
        return bookerName;
    }
    
    public void changeBooking(String name, String email)
    {
        
        this.bookerName = name;
        this.emailAddress = email;
        this.eventBooked.editBookings(this);
        
      
        String msg;
        String sub; 
        sub = "Booking Change: " + this.bookingID; 
        msg = "Booking Change for BookingID: " + this.bookingID;
        
        msg = msg + "\n" + "Event: " + this.eventBooked.getEventString();
        msg = msg + "\n" + "Name: " + name + " Email: " + email;
        JOptionPane.showMessageDialog(null,msg);
        sendEmail.send(email, sub, msg);
        Storage.updateBooking(this);
      
       
    }
    
   
    
   
    
    
}

