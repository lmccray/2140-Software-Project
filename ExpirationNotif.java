package KJapp;



import java.sql.*;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;  

public class ExpirationNotif {
    public class GettingCurrentDate {
        //getting current date and time using Date class
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        String currentdate = (df.format(dateobj));
    }
         

 public static void main(String [] args){  
  
  String to= User.getEmailAddress();  
  final String user= User.getEmailAddress(); 
  final String password=User.getPassword(); 
   
  //gets the session object     
  Properties properties = System.getProperties();  
  properties.setProperty("mail.smtp.host", "mail.javatpoint.com");  
  properties.put("mail.smtp.auth", "true");  
  
  Session session = Session.getDefaultInstance(properties,  
   new javax.mail.Authenticator() {  
   protected PasswordAuthentication getPasswordAuthentication() {  
   return new PasswordAuthentication(user,password);  
   }  
  });  
     
  // composes message     
  try{  
    MimeMessage message = new MimeMessage(session);  
    message.setFrom(new InternetAddress(user));  
    message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
    message.setSubject("Expiration Alert");  
      
    // creates MimeBodyPart object and sets the message text   

    BodyPart messageBodyPart1 = new MimeBodyPart();  
    messageBodyPart1.setText("Your Fitness will Expire in 10 Days");  
      
    // creates new MimeBodyPart object and set DataHandler object to this object      
    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
  
    String filename = "ExpirationNotif.java";//change accordingly  
    DataSource source = new FileDataSource(filename);  
    messageBodyPart2.setDataHandler(new DataHandler(source));  
    messageBodyPart2.setFileName(filename);  
     
     
    // creates Multipart object and adds MimeBodyPart objects to this object      
    Multipart multipart = new MimeMultipart();  
    multipart.addBodyPart(messageBodyPart1);  
    multipart.addBodyPart(messageBodyPart2);  
  
    // sets the multiplart object to the message object  
    message.setContent(multipart );  
     
    // sends the message  
    Transport.send(message);  
   
   System.out.println("message sent....");  
   }catch (MessagingException ex) {ex.printStackTrace();}  
 }  
}  
