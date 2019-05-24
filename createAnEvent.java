/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventbooking;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author sian
 */
public class createAnEvent extends javax.swing.JFrame {

    /**
     * Creates new form createAnEvent
     */
    static ArrayList<PromoCode> promoCodes = null;
    static boolean promoCodeStatus = false;
    public createAnEvent() {
          promoCodes = null;
          promoCodeStatus = false;
          this.setResizable(false);
          initComponents();
        if(EventBooking.loginStatus == true)
        {
            emailField.setText(EventBooking.currentUser.email);
        }
      
    }
    
     public createAnEvent(ArrayList<PromoCode> codes) {
           this.setResizable(false);
         
         initComponents();
        if(EventBooking.loginStatus == true)
        {
            emailField.setText(EventBooking.currentUser.email);
        }
      
          promoCodeStatus = true;
          promoCodes = codes;
         
          
          
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        priceField = new javax.swing.JTextField();
        capacityField = new javax.swing.JTextField();
        locationField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        dayComboBox = new javax.swing.JComboBox();
        monthComboBox = new javax.swing.JComboBox();
        yearComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        timeComboBox = new javax.swing.JComboBox();
        amPmComboBox = new javax.swing.JComboBox();
        minuteComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionField = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("UOW Event Booking System");

        jLabel2.setForeground(new java.awt.Color(0, 71, 187));
        jLabel2.setText("Date:");
        jLabel2.setToolTipText("");

        jLabel3.setForeground(new java.awt.Color(0, 71, 187));
        jLabel3.setText("Capacity");
        jLabel3.setToolTipText("");

        jLabel4.setForeground(new java.awt.Color(0, 71, 187));
        jLabel4.setText("Event Name");
        jLabel4.setToolTipText("");

        jLabel5.setForeground(new java.awt.Color(0, 71, 187));
        jLabel5.setText("Price");
        jLabel5.setToolTipText("");

        jLabel6.setForeground(new java.awt.Color(0, 71, 187));
        jLabel6.setText("Location");
        jLabel6.setToolTipText("");

        nameField.setToolTipText("");
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        priceField.setToolTipText("");

        capacityField.setToolTipText("");

        locationField.setToolTipText("");

        jButton1.setForeground(new java.awt.Color(0, 71, 187));
        jButton1.setText("Create Event");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        dayComboBox.setForeground(new java.awt.Color(0, 71, 187));
        dayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}));
        dayComboBox.setToolTipText("");

        monthComboBox.setForeground(new java.awt.Color(0, 71, 187));
        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"1","2","3","4","5","6","7","8","9","10","11","12"}));
        monthComboBox.setToolTipText("");
        monthComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthComboBoxActionPerformed(evt);
            }
        });

        yearComboBox.setForeground(new java.awt.Color(0, 71, 187));
        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"2019", "2020"}));
        yearComboBox.setToolTipText("");
        yearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(0, 71, 187));
        jLabel1.setText("Email Address");
        jLabel1.setToolTipText("");

        emailField.setToolTipText("");
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(0, 71, 187));
        jLabel7.setText("Time");
        jLabel7.setToolTipText("");

        timeComboBox.setForeground(new java.awt.Color(0, 71, 187));
        timeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        timeComboBox.setToolTipText("");

        amPmComboBox.setForeground(new java.awt.Color(0, 71, 187));
        amPmComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PM", "AM"}));
        amPmComboBox.setToolTipText("");

        minuteComboBox.setForeground(new java.awt.Color(0, 71, 187));
        minuteComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "15", "30","45" }));
        minuteComboBox.setToolTipText("");

        jScrollPane1.setToolTipText("");

        descriptionField.setColumns(20);
        descriptionField.setRows(5);
        jScrollPane1.setViewportView(descriptionField);

        jLabel8.setForeground(new java.awt.Color(0, 71, 187));
        jLabel8.setText("Description");
        jLabel8.setToolTipText("");

        jButton2.setForeground(new java.awt.Color(0, 71, 187));
        jButton2.setText("Create Promo Codes");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(0, 71, 187));
        jLabel9.setText("Promotional Codes");
        jLabel9.setToolTipText("");

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 71, 187));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Create an Event");
        jLabel10.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                                .addComponent(emailField)
                                .addComponent(priceField)
                                .addComponent(capacityField)
                                .addComponent(locationField)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(timeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minuteComboBox, 0, 68, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(amPmComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(yearComboBox, 0, 93, Short.MAX_VALUE)))
                                .addComponent(jScrollPane1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(dayComboBox)
                        .addComponent(monthComboBox)
                        .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amPmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minuteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(capacityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jButton2))
                .addGap(14, 14, 14)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void monthComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthComboBoxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       new createPromoCode().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(createAnEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createAnEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createAnEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createAnEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createAnEvent().setVisible(true);
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
    
    public void getInformation()
    {
            String eventName = nameField.getText();          
            String location = locationField.getText();
            String capacityString = capacityField.getText();      
            String priceString = priceField.getText();
            
            String emailAddress = emailField.getText();
            String description = descriptionField.getText();
          
            
            
            if(checkEvent(eventName, location, priceString, capacityString) && EventBooking.checkEmail(emailAddress))
            {
                createNewEvent(eventName, location, priceString, capacityString, emailAddress, description);
                
            }
                   
    }
    
    
    
    public void createNewEvent(String eventName, String location, String priceString, String capacityString, String emailAddress, String description)
    {
            allEvents eventList = new allEvents();
            
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
            
            
            /*Assigning each part of the date to variables. NOTE*** Will be a for loop when more than
               one date is added for an event */
            minuteString = minuteComboBox.getSelectedItem().toString();
            timeString = timeComboBox.getSelectedItem().toString();
            amPm = amPmComboBox.getSelectedItem().toString();
            dayString = dayComboBox.getSelectedItem().toString();
            monthString = monthComboBox.getSelectedItem().toString();
            yearString = yearComboBox.getSelectedItem().toString();
            
            
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
            //Storage.createInsertStatement(myEvent);
            //Adding the event to the list of all events
            eventList.addEvent(myEvent);
            Storage.insertEvent(myEvent);
            myEvent.addPromoCodes(promoCodes);
            this.dispose();
            System.out.println(myEvent.eventID);
            String message = "<html>Thankyou for booking with UOW Event Booking System. <br/> Your eventID is:<b> " + myEvent.eventID + "</b>";
            message = message + "<br/>This can be used to alter or cancel your event in the 'manage event' window of the application.";
            message = message + "<br/>This message has been emailed to: " + emailAddress + " along with any created Promo Codes for future reference. </html>";
           
            //This displays message to the user to confirm booking made. Email is also sent to user.
            JOptionPane.showMessageDialog(null,message);
            sendEmail.send(emailAddress, eventName, message);
            
            if(EventBooking.loginStatus)
            {
                EventBooking.currentUser.addEvent(myEvent);
            }
            if(promoCodeStatus)
            {
                message = message + myEvent.printPromoCodes();
            
                for(int x = 0; x < myEvent.getPromoCodes().size(); x++)
                {
                    Storage.insertPromoCode(myEvent.getPromoCodes().get(x), myEvent);

                }
            }
           
            System.out.println(message);
           
          
           
            
            
        
    }
    
    public static void setCodes(ArrayList<PromoCode> codes)
    {
        promoCodes = codes;
        promoCodeStatus = true;
        
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
