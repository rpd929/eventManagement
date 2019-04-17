package eventbooking;
import eventbooking.Event;
import java.util.ArrayList;

class allEvents {
     
    public static ArrayList<Event> allEvents = new ArrayList<>();
    public static ArrayList<String> allEventIDs = new ArrayList<>();
    
    
    public int getSize()
    {
        return allEvents.size();
    }
    
    public void addEvent(Event currentEvent)
    {
        allEvents.add(currentEvent);
        allEventIDs.add(currentEvent.eventID);

    }
    
    public Event getEvent(int eventIndex)
    {
        Event retrievedEvent = allEvents.get(eventIndex);
        return retrievedEvent;
        
    }
     public int findEvent(String eventID)
    {
        if(allEventIDs.contains(eventID))
        {
            System.out.print("Event Found!");
            int indexOfEvent = allEventIDs.indexOf(eventID);
            return indexOfEvent;
           
        } else {
            
            System.out.println("No Event Found!");
            return -1;
        }
        
        
    }
    
   
    
   
}