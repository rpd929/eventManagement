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

    public Booking(Event eventBooked, String bookerName, String email) {
     
       
        this.bookingID = createBookingID();
        this.eventBooked = eventBooked; 
        this.bookerName = bookerName;
        this.emailAddress = email;
        eventBooked.makeBooking(this);
        
        //int eventIndex = eventList.findEvent(eventBooked.eventID);
       
        System.out.println(bookingID);
        
        
        
      
  
            
    }
    public Booking(Event eventBooked, String bookerName, String email, String bookingID) {
     
       
        this.bookingID = bookingID;
        this.eventBooked = eventBooked; 
        this.bookerName = bookerName;
        this.emailAddress = email;
        eventBooked.makeBooking(this);
        
        //int eventIndex = eventList.findEvent(eventBooked.eventID);
       
        System.out.println(bookingID);
        
        
        
      
  
            
    }
    
    public void printBookingInformation()
    {
        
        System.out.println("BookingID: " + this.bookingID);
        System.out.println("Event Name: " + this.eventBooked.getName());
        System.out.println("Booked by: " + this.bookerName);
        System.out.println("----------------------------");
    }
    
    public String createBookingID()
    {
        Random random = new Random();
        int val = random.nextInt();
        String Hex = new String();
        Hex = Integer.toHexString(val);
        return Hex; 
        
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
      
       
    }
    
   
    
   
    
    
}

