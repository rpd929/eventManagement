/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventbooking;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author sian
 */
public class changeEvent extends javax.swing.JFrame {

  
    int indexEvent;
    public changeEvent() {
         this.setResizable(false);
        initComponents();
        
    }
    
     public changeEvent(int index) {
           this.setResizable(false);
         this.indexEvent = index;
         //setTime();
         initComponents();
        
    }
    
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        priceField = new javax.swing.JTextField();
        capacityField = new javax.swing.JTextField();
        locationField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        monthComboBox = new javax.swing.JComboBox();
        yearComboBox = new javax.swing.JComboBox();
        dayComboBox = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        minuteComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        timeComboBox = new javax.swing.JComboBox();
        amPmComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionField = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setForeground(new java.awt.Color(0, 71, 187));
        jLabel1.setText("Name");

        jLabel3.setForeground(new java.awt.Color(0, 71, 187));
        jLabel3.setText("Dates");

        jLabel4.setForeground(new java.awt.Color(0, 71, 187));
        jLabel4.setText("Price");

        jLabel5.setForeground(new java.awt.Color(0, 71, 187));
        jLabel5.setText("Capacity");

        jLabel6.setForeground(new java.awt.Color(0, 71, 187));
        jLabel6.setText("Location");

        nameField.setText(allEvents.allEvents.get(indexEvent).getName());
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        priceField.setText(Integer.toString(allEvents.allEvents.get(indexEvent).getPrice()));

        capacityField.setText(Integer.toString(allEvents.allEvents.get(indexEvent).getCapacity()));

        locationField.setText(allEvents.allEvents.get(indexEvent).getLocation());

        jButton1.setForeground(new java.awt.Color(0, 71, 187));
        jButton1.setText("Confirm Changes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        monthComboBox.setForeground(new java.awt.Color(0, 71, 187));
        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"1","2","3","4","5","6","7","8","9","10","11","12"}));
        monthComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthComboBoxActionPerformed(evt);
            }
        });

        yearComboBox.setForeground(new java.awt.Color(0, 71, 187));
        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"2019", "2020"}));
        yearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearComboBoxActionPerformed(evt);
            }
        });

        dayComboBox.setForeground(new java.awt.Color(0, 71, 187));
        dayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}));
        dayComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayComboBoxActionPerformed(evt);
            }
        });

        jButton2.setForeground(new java.awt.Color(0, 71, 187));
        jButton2.setText("Delete Event");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        minuteComboBox.setForeground(new java.awt.Color(0, 71, 187));
        minuteComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "15", "30","45" }));
        minuteComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minuteComboBoxActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(0, 71, 187));
        jLabel7.setText("Time");

        timeComboBox.setForeground(new java.awt.Color(0, 71, 187));
        timeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        timeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeComboBoxActionPerformed(evt);
            }
        });

        amPmComboBox.setForeground(new java.awt.Color(0, 71, 187));
        amPmComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PM", "AM"}));

        descriptionField.setText(allEvents.allEvents.get(indexEvent).description);
        descriptionField.setColumns(20);
        descriptionField.setRows(5);
        jScrollPane1.setViewportView(descriptionField);

        jLabel2.setForeground(new java.awt.Color(0, 71, 187));
        jLabel2.setText("Description");

        jLabel8.setForeground(new java.awt.Color(0, 71, 187));
        jLabel8.setText("Email Address");

        emailField.setText(allEvents.allEvents.get(indexEvent).getEmail());
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel4))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(priceField, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                            .addComponent(capacityField)
                            .addComponent(locationField)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(dayComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(timeComboBox, 0, 73, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(minuteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addComponent(amPmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthComboBox)
                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(timeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minuteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amPmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(capacityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          
         getInformation();    
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void yearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearComboBoxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        allEvents.removeEvent(allEvents.allEvents.get(indexEvent));
        
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void monthComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthComboBoxActionPerformed

    private void dayComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayComboBoxActionPerformed

    private void minuteComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minuteComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minuteComboBoxActionPerformed

    private void timeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeComboBoxActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(changeEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changeEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changeEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changeEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changeEvent().setVisible(true);
            }
        });
    }
    public boolean checkEvent(String name, String location, String price, String capacity)
    {
       
        if(EventBooking.checkInts(price) && EventBooking.checkStrings(name) && EventBooking.checkInts(capacity)
                    && EventBooking.checkStrings(location))
                   
            return true;
    
        else {
        
                return false;
            }
    
    }
    
    public void replaceEvent(String eventName, String location, String priceString, String capacityString)
    {
            allEvents eventList = new allEvents();
            Event oldEvent = eventList.getEvent(indexEvent);
            
            //Converting String variables to integers
            int capacity = Integer.parseInt(capacityString); 
            int price = Integer.parseInt(priceString);
   
            int time;
            int minute;
            int year;
            int month;
            int day;
            String minuteString;
            String amPm; 
            String timeString;
            String dayString;
            String monthString;
            String yearString;
            String description;
            String emailAddress;
            
            /*Assigning each part of the date to variables. NOTE*** Will be a for loop when more than
               one date is added for an event */
            minuteString = minuteComboBox.getSelectedItem().toString();
            timeString = timeComboBox.getSelectedItem().toString();
            amPm = amPmComboBox.getSelectedItem().toString();
            dayString = dayComboBox.getSelectedItem().toString();
            monthString = monthComboBox.getSelectedItem().toString();
            yearString = yearComboBox.getSelectedItem().toString();
            description =descriptionField.getText();
            emailAddress = emailField.getText();
            
            
            if(EventBooking.checkEmail(emailAddress))
            {
                emailAddress = emailAddress;
            } else
            {
                new errorForm("Please enter a valid email Address").setVisible(true);
            }
           
            time = Integer.parseInt(timeString);
            if(amPm.equalsIgnoreCase("PM"))
            {
                time = time + 12;
            }
            minute = Integer.parseInt(minuteString);
            day = Integer.parseInt(dayString);
            month = Integer.parseInt(monthString);
            year = Integer.parseInt(yearString);
            
            
            Calendar singleDate = Calendar.getInstance();
            singleDate.set(year, month-1, day, time, minute);
            
            /*Creating the event with provided values. NOTE** Will need to check these values before 
                creating the event or will throw error */
            
            Event myEvent = new Event(singleDate, price, capacity, location, eventName, description, emailAddress);
            myEvent.eventID = oldEvent.eventID;
            //Adding the event to the list of all events
            eventList.replaceEvent(oldEvent, myEvent);
            this.dispose();
            System.out.println(myEvent.eventID);
            
            
        
    }
    
    
    public void setTime()
    {
       Date eventDate = allEvents.allEvents.get(indexEvent).getDate();
       
       int hours = eventDate.getHours();
       int minutes = eventDate.getMinutes();
       System.out.print(hours + " Hello  " + minutes);
       if(hours > 12)
       {
           hours = hours - 12;
           timeComboBox.setSelectedItem(Integer.toString(hours));
           amPmComboBox.setSelectedItem("PM");
           minuteComboBox.setSelectedItem(Integer.toString(minutes));
           
       }else {
       
            timeComboBox.setSelectedItem(Integer.toString(hours));
            minuteComboBox.setSelectedItem(Integer.toString(minutes));
            amPmComboBox.setSelectedItem("AM");
       }
      
       
       
       
        
        
        
    }
    
    
    public void getInformation()
    {
            String eventName = nameField.getText();          
            String location = locationField.getText();
            String capacityString = capacityField.getText();      
            String priceString = priceField.getText();
            
            
            if(checkEvent(eventName, location, priceString, capacityString))
            {
                replaceEvent(eventName, location, priceString, capacityString);
            }
                   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox amPmComboBox;
    private javax.swing.JTextField capacityField;
    private javax.swing.JComboBox dayComboBox;
    private javax.swing.JTextArea descriptionField;
    private javax.swing.JTextField emailField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField locationField;
    private javax.swing.JComboBox minuteComboBox;
    private javax.swing.JComboBox monthComboBox;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField priceField;
    private javax.swing.JComboBox timeComboBox;
    private javax.swing.JComboBox yearComboBox;
    // End of variables declaration//GEN-END:variables
}
