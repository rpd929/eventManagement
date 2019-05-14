package eventbooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author sian
 */
public class Storage {
    
    
    
    public static Connection getConnection()
    {
         // SQLite connection string
        String url = "jdbc:sqlite:test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;


    }
    
    public static void loadEvents()
    {
        String sql = "SELECT eventID, eventName, eventDateTime, location, price, capacity, description, email From Event;";
            Event event;
            try (Connection conn = getConnection();
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) 
            {
                String eventID =rs.getString(1);
                String eventName = rs.getString(2);
                Date   eventDate = rs.getDate(3);
             
                DateAndCalendar convert = new DateAndCalendar();
                Calendar c = convert.dateToCalendar(eventDate);
                String location =  rs.getString(4);
                
                int price =  rs.getInt(5);
                int capacity = rs.getInt(6);

                String description =  rs.getString(7);
                String email = rs.getString(8);
                Event newEvent = new Event(eventID, c, price, capacity, location, eventName, description, email);
                allEvents.addEvent(newEvent); 
                System.out.println("Event Loaded: " + newEvent.eventID);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        
    }
    
    public static void insertBooking(Booking booking)
    {

        String sql = "INSERT INTO BOOKING(bookingID, eventID, name, email) VALUES(?,?,?,?)";
 
             try (Connection conn = getConnection())
             {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, booking.bookingID);
                pstmt.setString(2, booking.getEventID());
                pstmt.setString(3, booking.getName());
                pstmt.setString(4, booking.getEmail());

                pstmt.executeUpdate();
                
                System.out.println("Booking Inserted!");
            } catch (SQLException e) {
                
                System.out.println(e.getMessage());
        }
    }
    
    public static void loadBookings()
    {
        String sql = "SELECT bookingID, eventID, name, email FROM BOOKING;";
                Booking booking;
        try(Connection conn = getConnection())
        {
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
            
            // loop through the result set
            while (rs.next()) {
                String bookingID = rs.getString("bookingID");
                String eventID = rs.getString("eventID");
                String name = rs.getString("name");
                String email = rs.getString("email");
                
                int eventIndex = allEvents.findEvent(eventID);
                if(eventIndex != -1)
                {   Event event = allEvents.getEvent(eventIndex);

                    booking = new Booking(event, bookingID, name, email);
                
                
                    System.out.println("Booking Loaded: " + "\n EventID: " + event.eventID + "\n BookingID: " + bookingID);
                }else {
                    
                    System.out.println("Cannot find event for given booking. BookingID: " + bookingID);
                    
                }
                              
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public static void deleteBooking(String bookingID)
    {
         String sql = "Delete from Booking where bookingID = ?";
 
        try (Connection conn = getConnection())
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bookingID);
            pstmt.executeUpdate();
            
            System.out.println(sql);

        } catch(Exception e)
        {
            System.out.println(e.getMessage());
        }


    }
    
    public static void updateBooking(Booking booking)
    {

        String sql = "UPDATE BOOKING SET name = ? , "
                    + "email = ? "
                    +  "WHERE bookingID = ?";

        try (Connection conn = getConnection())
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, booking.getName());
            pstmt.setString(2, booking.getEmail());
            pstmt.setString(3, booking.getBookingID());

            pstmt.executeUpdate();
            
        } catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
 
    
    
           
        
    
    
    
    
    
      
        
   
     
    public static void insertEvent(Event event) 
    {
        String sql = "INSERT INTO EVENT(eventID, eventName, eventDateTime, location, price, capacity, description, email) VALUES(?,?,?,?,?,?,?,?)";
 
        try (Connection conn = getConnection())
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, event.getEventID());
            pstmt.setString(2, event.getName());
            
            java.sql.Date sDate = new java.sql.Date(event.getDate().getTime());
            pstmt.setDate(3, sDate);
             
            pstmt.setString(4, event.getLocation());
            pstmt.setDouble(5, event.getPrice());
            pstmt.setInt(6, event.getCapacity());
            pstmt.setString(7, event.getDescription());
            pstmt.setString(8, event.getEmail());
            pstmt.executeUpdate();
            System.out.println("Insert Complete!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public static void deleteEvent(Event event)
    {

        String sql = "Delete from Event where eventID = ?";
 
        try (Connection conn = getConnection())
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, event.eventID);
            pstmt.executeUpdate();
            
            for(int count = 0; count < event.getBookingIDs().size(); count++)
            {
                String bookingID = event.getBookingIDs().get(count);
                deleteBooking(bookingID);
            }
            System.out.println(sql);

        } catch(Exception e)
        {
            System.out.println("Error" + e.getMessage());
        }

    }
    
    public static void updateEvent(Event event)
    {
         String sql = "UPDATE EVENT SET eventName = ? , "
                + "eventDateTime = ? , "
                + "location = ? , "
                + "price = ? , "
                + "capacity = ? , "
                + "description = ? , "
                + "email = ?"
                + "WHERE eventID =?";
                
               
        try (Connection conn = getConnection())
            
        {
            // set the corresponding param
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(8, event.getEventID());
            pstmt.setString(1, event.getName());
            
            java.sql.Date sDate = new java.sql.Date(event.getDate().getTime());
            pstmt.setDate(2, sDate);
             
            pstmt.setString(3, event.getLocation());
            pstmt.setDouble(4, event.getPrice());
            pstmt.setInt(5, event.getCapacity());
            pstmt.setString(6, event.getDescription());
            pstmt.setString(7, event.getEmail());
           
            
            // update 
            pstmt.executeUpdate();
            System.out.println("Update Complete!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

}