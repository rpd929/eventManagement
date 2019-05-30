/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventbooking;
import static eventbooking.bookEvent.selectedEvent;
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
   private ArrayList<PromoCode> promoCodes = new ArrayList<>();
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
       eventString = eventString + "Location: " + this.location;
        eventString = eventString + "\nDate & Time: " + this.getDate().getDate();
        eventString = eventString + "/" + (this.getDate().getMonth() + 1);
        eventString = eventString + "/" + (this.getDate().getYear() +1900) + " at ";
        
        if(this.getDate().getHours() > 12)
        {
            eventString = eventString + (this.getDate().getHours() - 12);
              if(this.getDate().getMinutes() == 0)
                {
                    eventString = eventString + ":" + this.getDate().getMinutes();
                    eventString = eventString + "0 PM";
                   
                }
        } else if(this.getDate().getMinutes() == 0)
        {
            eventString = eventString + this.getDate().getHours() + ":" + this.getDate().getMinutes();
            eventString = eventString + "0";
        } else {
             eventString = eventString + this.getDate().getHours() + ":" + this.getDate().getMinutes();
        }
       
        
        this.description = description;
        this.emailAddress = email;
   
    }
    
    
    
    public Event(String eventID, Calendar date, int price, int capacity, String location, String name, String description, String email) {
        this.date = date;
        this.price = price;
        this.capacity = capacity;
        this.location = location;
        this.name = name;
        this.eventID = eventID;
        this.allBookings = new ArrayList<Booking>();
        this.allBookingIDs = new ArrayList<String>();
        this.eventString = this.name;
        eventString = eventString + "Location: " + this.location;
        eventString = eventString + "Date & Time" + this.getDate().getDate();
        eventString = eventString + "/" + (this.getDate().getMonth() + 1);
        eventString = eventString + "/" + (this.getDate().getYear() +1900) + " at ";
        
        if(this.getDate().getHours() > 12)
        {
            eventString = eventString + (this.getDate().getHours() - 12);
              if(this.getDate().getMinutes() == 0)
                {
                    eventString = eventString + ":" + this.getDate().getMinutes();
                    eventString = eventString + "0 PM";
                   
                }
        } else if(this.getDate().getMinutes() == 0)
        {
            eventString = eventString + this.getDate().getHours() + ":" + this.getDate().getMinutes();
            eventString = eventString + "0";
        } else {
             eventString = eventString + this.getDate().getHours() + ":" + this.getDate().getMinutes();
        }
       
        
      
        
       
        this.description = description;
        this.emailAddress = email;
   
    }
    
    
     public void checkBooking(String name, String email)
    {
        if(EventBooking.checkStrings(name) && EventBooking.checkEmail(email));
        {
             Booking newBooking = new Booking(this, name, email);
             String message = "Hi " + name + ",";
             message = message + "Thanks for booking the event: " + getName();
             message = message + " at " + getLocation() + " " + getDate();
             message = message + "\nYour booking number is: " + newBooking.bookingID + ". ";
             message = message + "\nTo cancel or alter your booking, locate your booking in the 'manage booking' view of the applciation.";
             message = message + "\nAn email with this information has also been sent to the supplied address.";
             
             sendEmail.send(email, selectedEvent.getName(), message);
             JOptionPane.showMessageDialog(null,message);
             Storage.insertBooking(newBooking);
             
      
        }
    }
   
     public void addPromoCodes(ArrayList<PromoCode> codes)
     {
       
             promoCodes = codes;
           
     }
    
    
    
    public String toString(){
        
        return eventString;
    }
    
    public String seeMore()
    {
        String seeMoreString;
        seeMoreString = "<html><h2 align=center>" + name + "</h2> ";
        seeMoreString = seeMoreString + "<b>Date: </b>" + getReadableDate()+ ".<br/>";
        seeMoreString = seeMoreString + "<b>Price: $</b>" + price + ". <br/>";
        seeMoreString = seeMoreString + "<b>Location: </b>" + location + ". <br/>";
        seeMoreString = seeMoreString + "<b>Description: </b>" + description;
        return seeMoreString;
        
    }

    public String getEventID() {
        return eventID;
    }
    
    public boolean checkCapacity(int numberOfBookings)
    {
        int numberOfAvailableBookings = capacity - allBookings.size();
        if(numberOfBookings < numberOfAvailableBookings)
        {
            
            return true;
        } else{
            new errorForm("Event Sold out! Try booking less tickets.").setVisible(true);
            return false;
        }
    }
    
    public String getReadableDate(){
        
        String dateString;
        dateString = Integer.toString(date.getTime().getDate()) + "/";
        dateString = dateString + Integer.toString(date.getTime().getMonth() + 1) + "/";
        dateString = dateString + Integer.toString(date.getTime().getYear() + 1900) + " ";
        
        if(date.getTime().getHours() > 12)
        {
            dateString = dateString + Integer.toString(date.getTime().getHours() - 12) + ":";
           
            
            if(date.getTime().getMinutes() == 0)
            {
               dateString = dateString + Integer.toString(date.getTime().getMinutes()) + "0 PM";

            } else {
               dateString = dateString + Integer.toString(date.getTime().getMinutes()) + "PM";

            }
            
        } else {
            
            dateString = dateString + Integer.toString(date.getTime().getHours()) + ":";
            if(date.getTime().getMinutes() == 0)
            {
               dateString = dateString + Integer.toString(date.getTime().getMinutes()) + "0 AM";

            } else {
            dateString = dateString + Integer.toString(date.getTime().getMinutes()) + "AM";
            }
            
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

    public ArrayList<PromoCode> getPromoCodes() {
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
    
    public String getDescription(){
        return description;
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

    
    
    public double getDiscountAmount(String code)
    {
        for(int x = 0; x < promoCodes.size(); x++)
        {
            String checkCode = promoCodes.get(x).codeID;
            if(code.equals(checkCode))
            {
                
                if(promoCodes.get(x).validStatus)
                {
                    System.out.println("Returning value");
                    return promoCodes.get(x).percentageDiscount;
                    
                } else {
                  new  errorForm("Code already used!").setVisible(true);
                }
                
            }
            
        }
        
       
        return -1;
        
    }
     public double usePromoCode(String code)
    {
        for(int x = 0; x< promoCodes.size(); x++)
        {
            PromoCode checkCode = null;
            checkCode = promoCodes.get(x);
            if(checkCode.codeID.equals(code))
            {
               
                return x;
            }
        }
        
        return -1;
        
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
        if (indexOfBooking == -1)
        {
            return null;
        }else{
                 Booking newBooking = allBookings.get(indexOfBooking);
        
                 return newBooking;
        }
        
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
        Storage.deleteBooking(booking.bookingID);
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
    
    
    public String printPromoCodes()
    {
        String codes = "\n\n\nPromotional Code Discount%: ";
        codes = codes +  (promoCodes.get(0).percentageDiscount * 100.00);
        codes = codes + "\n Promotional Codes: ";
        for(int x = 0; x < promoCodes.size(); x++)
        {
            codes = codes + "\n" + promoCodes.get(x).codeID;
        }
        return codes;
    }
    
    
    
   
    
    
}
