package eventbooking;
import eventbooking.Event;
import java.util.ArrayList;

class allEvents {
     
    public static ArrayList<Event> allEvents = new ArrayList<>();
    public static ArrayList<String> allEventIDs = new ArrayList<>();
    public static ArrayList<String> allEventStrings = new ArrayList<>();
    
    
    public int getSize()
    {
        return allEvents.size();
    }
    
    public void addEvent(Event currentEvent)
    {
        String eventString = createEventString(currentEvent);
        allEvents.add(currentEvent);
        allEventIDs.add(currentEvent.eventID);
        allEventStrings.add(eventString);

    }
    
    public String createEventString(Event currentEvent)
    {
        String eventString = "";
        eventString = currentEvent.getName();
        eventString = eventString + " " + currentEvent.getLocation();
        eventString = eventString + " $" + Integer.toString(currentEvent.getPrice());
        return eventString;
        
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
     
     public void replaceEvent(Event changedEvent)
     {
        int index = allEventIDs.indexOf(changedEvent.eventID);
        
         allEventIDs.set(index, changedEvent.eventID);
         allEvents.set(index, changedEvent);
         allEventStrings.set(index, createEventString(changedEvent));
     }
             
             
    
   
    
   
}