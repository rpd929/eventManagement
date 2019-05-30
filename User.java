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
public class User {
    
    String name;
    String email;
    ArrayList<Event> eventHistory = new ArrayList<>();
    ArrayList<Booking> bookingHistory = new ArrayList<>();
    String userID;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.userID = createUserID();
  
    }
    public User(String userID, String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.userID = userID;
  
    }
    
    public String createUserID(){
        
        Random random = new Random();
        int val = random.nextInt();
        String Hex = new String();
        Hex = Integer.toHexString(val);
        return Hex;
    
}
    
    public void addEvent(Event event)
    {
        eventHistory.add(event);
    }
    
 
    
    
    public void bookEvent(int eventIndex)
    {
        Event event = allEvents.getEvent(eventIndex);
        Booking thisBooking = new Booking(event, name, email);
        bookingHistory.add(thisBooking);
        Storage.insertBooking(thisBooking);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    
    
    
    
}
