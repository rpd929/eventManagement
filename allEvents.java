package eventbooking;
import eventbooking.Event;
import java.util.ArrayList;
import javax.swing.JOptionPane;

class allEvents {
     
    public static ArrayList<Event> allEvents = new ArrayList<>();
    public static ArrayList<String> allEventIDs = new ArrayList<>();
    public static ArrayList<String> allEventStrings = new ArrayList<>();
    
    
    public int getSize()
    {
        return allEvents.size();
    }
    
    public static void addEvent(Event currentEvent)
    {
        String eventString = createEventString(currentEvent);
        allEvents.add(currentEvent);
        allEventIDs.add(currentEvent.eventID);
        allEventStrings.add(eventString);

    }
    
    public static String createEventString(Event currentEvent)
    {
        String eventString = "";
        eventString = currentEvent.getName();
        eventString = eventString + " " + currentEvent.getLocation();
        eventString = eventString + " $" + Integer.toString(currentEvent.getPrice());
        return eventString;
        
    }
    
    public static Event getEvent(int eventIndex)
    {
        Event retrievedEvent = allEvents.get(eventIndex);
        return retrievedEvent;
        
    }
    
   
     public static int findEvent(String eventID)
    {
        if(allEventIDs.contains(eventID))
        {
            System.out.println("Event Found!");
            int indexOfEvent = allEventIDs.indexOf(eventID);
            return indexOfEvent;
           
        } else {
            
            System.out.println("No Event Found!");
            return -1;
        }
        
        
    }
     
     public void replaceEvent(Event oldEvent, Event newEvent)
     {
        int index = allEventIDs.indexOf(oldEvent.eventID);
        
         allEventIDs.set(index, newEvent.eventID);
         allEvents.set(index, newEvent);
         allEventStrings.set(index, createEventString(newEvent));
         newEvent.setBookings(oldEvent.getBookings(), oldEvent.getBookingIDs());
         Storage.updateEvent(newEvent);
         
     }
     
     public static void removeEvent(Event eventToBeRemoved)
     {
         allEventIDs.remove(eventToBeRemoved.eventID);
         allEvents.remove(eventToBeRemoved);
         allEventStrings.remove(eventToBeRemoved.toString());
         Storage.deleteEvent(eventToBeRemoved);
         
         JOptionPane.showMessageDialog(null,"Event Deleted");
         

         
        
     }
     
    
             
             
    
   
    
   
}