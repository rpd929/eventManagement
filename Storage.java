/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventbooking;

import java.sql.Connection;
import java.sql.DriverManager;
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
    
    
    public static void startUp() throws Exception 
    { 
       
            String query = "Select count(*) from Event";
            
            try
            {  
                 ResultSet res = executeQueryWithReturn(query);
                 int results = res.getInt(1);
                 if(results >= 0)
                {
                    loadValues();
                
                } 
            } catch(Exception e){
                
                Storage.createEventDB();
            }
           
            
        }
           
        
    
    
    
    public static void createEventDB() throws Exception
    {
       
            String eventQuery = "CREATE TABLE EVENT(eventID VARCHAR(8) NOT NULL, eventName VARCHAR(30) NOT NULL, eventDateTime DATE NOT NULL, location VARCHAR(30) NOT NULL, price NUMBER NOT NULL, capacity NUMBER NOT NULL, description VARCHAR(100)NOT NULL, email VARCHAR(50) NOT NULL, CONSTRAINT Event_pkey PRIMARY KEY ( eventID) )";
            executeQuery(eventQuery);
            
            String bookingQuery;
            bookingQuery = "CREATE TABLE BOOKING( bookingID VARCHAR(6) NOT NULL, eventID VARCHAR(6) NOT NULL, name VARCHAR(30) Not NULL, email VARCHAR(50) NOT NULL, CONSTRAINT Booking_pkey PRIMARY KEY (bookingID), CONSTRAINT booking_fkey1 FOREIGN KEY (eventID) REFERENCES EVENT(eventID))";
            executeQuery(bookingQuery);
            
            System.out.println("DB Created");
  
        
    }
    
        public static void loadValues() throws Exception
    {
        System.out.println("Load Values...");
        loadEvents();
        loadBookings();
        
    }
        
     public static void loadEvents() throws Exception   
     { 
         String loadEvents; 
         loadEvents = "Select * from EVENT;";
         ResultSet rs = executeQueryWithReturn(loadEvents);
         Calendar c = null; 
         DateAndCalendar convert = new DateAndCalendar();
         
         
         
            
            while (rs.next()) {
                String eventID =rs.getString(1);
                String eventName = rs.getString(2);
                Date   eventDate = rs.getDate(3);
             
               
                c = convert.dateToCalendar(eventDate);
                
                String location =  rs.getString(4);
                String description =  rs.getString(7);
                String email = rs.getString(8);
                int price =  rs.getInt(5);
                int capacity = rs.getInt(6);
                
                Event newEvent = new Event(eventID, c, price, capacity, location, eventName, description, email);
                allEvents.addEvent(newEvent); 
                System.out.println(newEvent.eventID);
                         
            }
            
        } 
     
     
     public static void loadBookings() throws Exception   
     { 
         String loadEvents; 
         loadEvents = "Select * from BOOKING;";
         ResultSet rs = executeQueryWithReturn(loadEvents);
         
         
     }
     
     public static void insertEvent(Event evnt)
    {
       
            String insertStatementString = createInsertStatement(evnt);
            executeQuery(insertStatementString);
            
      
    }
     
      public static String createInsertStatement(Event evnt)
    {
        String insertString;
        String eventString;
        String dateString;
        
        eventString = "INSERT INTO EVENT VALUES(";
        eventString = eventString + "'" +evnt.getEventID() + "'" + "," + "'" + evnt.getName() + "'" + "," + evnt.getDate().getTime();
        eventString = eventString + "," +  "'" + evnt.getLocation() + "'" + "," + evnt.getPrice() + "," + evnt.getCapacity();
        eventString = eventString + "," +  "'" + evnt.description + "'" + ',' +  "'" + evnt.getEmail() + "'";
        eventString = eventString + ");";
        return eventString;
    }
      
      public static String createEventDeleteStatement(Event evnt)
      {
          String deleteString;
          
          deleteString = "Delete from EVENT where eventID ='";
          deleteString = deleteString + evnt.eventID + "';";
          System.out.println(deleteString);
          return deleteString;
          
      }
       
      public static void dropDB()
      {
          String drop = "Drop Table EVENT;";
          executeQuery(drop);
          String bookingDrop = "Drop table BOOKING;";
          executeQuery(bookingDrop);
          
      }
      
      public static void executeQuery(String query)
    {
        Connection c = null;
        
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement insertStatement = c.createStatement();
            
            insertStatement.executeUpdate(query);
            
            
          } catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e.toString());
            
        }
        
    }
      
      public static ResultSet executeQueryWithReturn(String query)
    {
        Connection c = null;
        
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement insertStatement = c.createStatement();
            ResultSet results;
            results = insertStatement.executeQuery(query);
            return results;
            
            
          } catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e.toString());
            return null;
            
        }
        
    }
      
      public static void removeEvent(Event event) 
      {
           String deleteQuery = Storage.createEventDeleteStatement(event);
           Storage.executeQuery(deleteQuery);
          
         
      }
      
      
      
       
    
}
