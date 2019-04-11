/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventbooking;


import java.util.Date;



public class Booking {
 
    public double bookingID;
    private Date date;
    private Event eventBooked;
    private int sessionNumber;
    private String bookerName;

    public Booking(Event eventBooked, int sessionNumber, String bookerName) {
     
        double newID = Math.random() * 100;
        
        this.bookingID = Math.round(newID);
        this.eventBooked = eventBooked;
        this.date = eventBooked.getDate(sessionNumber); 
        this.bookerName = bookerName;
        this.sessionNumber = sessionNumber;
      
        
            
    }
    
    public void printBookingInformation()
    {
        System.out.println("Booking...");
        System.out.println("Event Name: " + this.eventBooked.getName());
        System.out.println("Booked by: " + this.bookerName);
        System.out.println("For session number: " + this.sessionNumber + " of a total of: " + eventBooked.getNumberOfSessions() + " Sessions");
        System.out.println("With Booking ID: " + bookingID); 
        System.out.println("----------------------------");
    }
    
    
    
}

