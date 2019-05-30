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
import java.util.*;


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
            Event event = null;
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
                Storage.loadPromoCodes(newEvent);
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
    
    public static void insertUser(User user, String pw)
    {
        String userInsert = "INSERT INTO USERS(userID, name, email, password) values (?,?,?,?)";
        
        try(Connection conn = getConnection())
        {
            PreparedStatement pstmt = conn.prepareStatement(userInsert);
            pstmt.setString(1, user.userID);
            pstmt.setString(2, user.name);
            pstmt.setString(3, user.email);

            pstmt.setString(4, pw);
            pstmt.executeUpdate();
            checkUser(user.email, pw);
            System.out.println("User Created");
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
  
    }
    
    public static void updateUser(String name, String email){
        String sql = "UPDATE USERS SET name = ?,"
                + "email = ?"
                + "WHERE userID =?";
                
               
        try (Connection conn = getConnection())     
        {
            // set the corresponding param
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, EventBooking.currentUser.userID);
       
            pstmt.executeUpdate();
            System.out.println("User altered");
            
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }
    
    public static boolean checkUser(String email, String password)
    {
        String sql = "Select * FROM USERS WHERE email = ? AND password = ?";
        ResultSet rs;
        
         
        try(Connection conn = getConnection())
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if(rs.next())
            {
                String userID = rs.getString(1);
                String name = rs.getString(2);

                String userEmail = rs.getString(3);
                String pw = rs.getString(4);
                
                User loggedInUser = new User(userID, name, userEmail, pw);
                EventBooking.currentUser = loggedInUser;
                EventBooking.loginStatus = true;
                System.out.println("User Found. Login Successful");
                return true;
            } else {return false;}
            
           
            
        }catch(Exception e)
        {
            
        }
        
        return false;
        
    }
    
    
    public static ArrayList<String> viewEventHistory(User user)
    {
            ArrayList<String> userEvents = new ArrayList<>();
            String sql = "SELECT eventID, eventName, eventDateTime, location, price, capacity, description, email From Event where event.email =?;";
           
            try (Connection conn = getConnection())
            {   PreparedStatement stmt  = conn.prepareStatement(sql);
                stmt.setString(1, user.email);
                ResultSet rs = stmt.executeQuery();
                

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
                    System.out.println("Test:" + newEvent.getEventString());
                    userEvents.add(newEvent.getEventString());
                   
            }             
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
            return userEvents;
        
    }
    
     public static void loadEventHistory()
    {
            ArrayList<String> userEvents = new ArrayList<>();
            String sql = "SELECT eventID, eventName, eventDateTime, location, price, capacity, description, email From Event where event.email =?;";
           
            try (Connection conn = getConnection())
            {   PreparedStatement stmt  = conn.prepareStatement(sql);
                stmt.setString(1, EventBooking.currentUser.email);
                ResultSet rs = stmt.executeQuery();
                

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
                    
                    EventBooking.currentUser.eventHistory.add(newEvent);
                   
            }             
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
  
    }
     
      public static void loadBookingHistory()
    {
            ArrayList<String> userBookings = new ArrayList<>();
            String sql = "SELECT * From BOOKING where email =?;";
           
            try (Connection conn = getConnection())
            {   PreparedStatement stmt  = conn.prepareStatement(sql);
                stmt.setString(1, EventBooking.currentUser.email);
                ResultSet rs = stmt.executeQuery();
                

                // loop through the result set
                while (rs.next()) 
                {
                    String bookingID = rs.getString(1);
                    String eventID = rs.getString(2);
                    String name = rs.getString(3);
                    String email = rs.getString(4);
                    Event event = null;
                    event =  allEvents.getEvent(allEvents.findEvent(eventID));
                    
                    Booking booking = new Booking(event, bookingID, name, email);
                    EventBooking.currentUser.bookingHistory.add(booking);
               
                   
            }             
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
  
    }
      
       public static void insertPromoCode(PromoCode code, Event event)
    {
        String userInsert = "INSERT INTO PROMOCODES(eventID, codeID, discountPercent, validStatus) values (?,?,?,?)";
        
        try(Connection conn = getConnection())
        {
            PreparedStatement pstmt = conn.prepareStatement(userInsert);
            pstmt.setString(1, event.eventID);
            pstmt.setString(2, code.codeID);
            pstmt.setDouble(3, code.percentageDiscount);
            if(code.validStatus)
            {
                pstmt.setInt(4, 1);
            } else {
                pstmt.setInt(4, 0);
            }
           
            pstmt.executeUpdate();
           
            System.out.println("PromoCode Inserted");
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
  
    }
       
       public static void loadPromoCodes(Event event)
       {
            ArrayList<PromoCode> codes = new ArrayList<>();
            String sql = "SELECT * From PROMOCODES where eventID =? AND validStatus = 1;";
           
            try (Connection conn = getConnection())
            {   PreparedStatement stmt  = conn.prepareStatement(sql);
                stmt.setString(1, event.eventID);
                ResultSet rs = stmt.executeQuery();
                

                // loop through the result set
                while (rs.next()) 
                {
                    String codeID = rs.getString(2);
                    double discountAmount = rs.getDouble(3);
                    PromoCode code = new PromoCode(codeID, discountAmount);
                    codes.add(code);
                    System.out.println("Loaded: " + code.percentageDiscount);
             
                }      
                
                event.addPromoCodes(codes);
                
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       }
      public static void updatePromocode(String code){
        String sql = "UPDATE PROMOCODES SET validstatus = 0 "
                + "Where codeID = ?";
               
                
               
        try (Connection conn = getConnection())     
        {
            // set the corresponding param
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, code);
            
       
            pstmt.executeUpdate();
            System.out.println("Promotional Code used!");
            
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }
     
     
    
    
    

}