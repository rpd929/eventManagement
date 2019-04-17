/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventbooking;


import java.util.Calendar;
import java.util.Date;
import java.util.Random;



public class Booking {
 
    public String bookingID;
    private Calendar date;
    private Event eventBooked;
    private int sessionNumber;
    private String bookerName;

    public Booking(Event eventBooked, int sessionNumber, String bookerName) {
     
       
        this.bookingID = createBookingID();
        this.eventBooked = eventBooked;
        this.date = eventBooked.getDate(sessionNumber); 
        this.bookerName = bookerName;
        this.sessionNumber = sessionNumber;
      
  
            
    }
    
    public void printBookingInformation()
    {
        
        System.out.println("BookingID: " + this.bookingID);
        System.out.println("Event Name: " + this.eventBooked.getName());
        System.out.println("Booked by: " + this.bookerName);
        System.out.println("For session number: " + this.sessionNumber + " of a total of: " + eventBooked.getNumberOfSessions() + " Sessions");          
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
    
    public void makeBooking(String bookingID, Event currentEvent)
    {
       currentEvent.makeBooking(bookingID);
    }
    
    
}

