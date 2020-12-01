package KJapp;

import java.sql.*;

public class KJDatabase {

    public static void Connect(){
        final String USER= "root";
        final String PASS="";

        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        final String DB_URL = "jdbc:mysql://localhost"; 

        Connection conn = null;
        Connection conn1 = null;
        Statement stmt = null;
        Statement stmt1 = null;
       
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "CREATE DATABASE KJTrucking";
            stmt.executeUpdate(sql);

            final String DB1_URL = "jdbc:mysql://localhost/kjtrucking";
            conn1 = DriverManager.getConnection(DB1_URL, USER, PASS);
            stmt1 = conn1.createStatement();

            String sql1 = "CREATE TABLE PASSWORD " +
                   "(id INTEGER not NULL, " +
                   " first_name VARCHAR(255), " + 
                   " last_name VARCHAR(255), " + 
                   " dob VARCHAR(20), " +
                   " email VARCHAR(255), " +
                   " telephone VARCHAR(255), "+
                   " password VARCHAR(20), "+
                   " PRIMARY KEY ( id ))"; 
            
            String sql2 = "CREATE TABLE TRUCK " +
                   "(truck_id INTEGER not NULL, " +
                   " make VARCHAR(255), " + 
                   " model VARCHAR(255), " + 
                   " license_num VARCHAR(20), " +
                   " fitness_expdate VARCHAR(255), " +
                   " registration_expdate VARCHAR(255), "+
                   " insurance_expdate VARCHAR(255), "+
                   " PRIMARY KEY ( truck_id ))"; 
            
            String sql3 = "CREATE TABLE ROUTES" +
                   "(company_name VARCHAR(255), " +
                   " destination_name VARCHAR(255), " + 
                   " fuel_cost DOUBLE not NULL, " + 
                   " driver_wage DOUBLE not NULL, " +
                   " side_wage DOUBLE not NULL, " +
                   " delivery_price DOUBLE not NULL, "+
                   " PRIMARY KEY ( company_name ))"; 
            
            String sql4 = "CREATE TABLE CALROUTES" +
                   "(company_name VARCHAR(255), " +
                   " destination_name VARCHAR(255), " + 
                   " truck_id INTEGER not NULL, "+
                   " date VARCHAR(255), " +
                   " calculate_profit DOUBLE not NULL, "+
                   " PRIMARY KEY ( truck_id ))"; 
            
            String sql5 = "CREATE TABLE COMPANY" +
                   "(company_name VARCHAR(255), " +
                   " company_address VARCHAR(255), " + 
                   " telephone VARCHAR(255), "+
                   " email VARCHAR(255), " +
                   " id INTEGER not NULL AUTO_INCREMENT, "+
                   " PRIMARY KEY ( id ))"; 
            
            String sql6 = "CREATE TABLE DRIVER" +
                   "(driver_name VARCHAR(255), " +
                   " driver_address VARCHAR(255), " + 
                   " telephone VARCHAR(255), "+
                   " email VARCHAR(255), " +
                   " trn VARCHAR(12), " +
                   " nis VARCHAR(12), "+
                   " driver_license VARCHAR(255)," +
                   " id INTEGER not NULL,"+
                   " PRIMARY KEY ( id ))"; 

            String sql7 = "CREATE TABLE DRIVERWORK" +
                   "(driver_name VARCHAR(255), " +
                   " company VARCHAR(255),"+
                   " destination_name VARCHAR(255), " + 
                   " load_name VARCHAR(255), " + 
                   " weight DOUBLE not NULL, " +
                   " side_man1 VARCHAR(255), " +
                   " side_man2 VARCHAR(255), " +
                   " truck_id INTEGER not NULL, "+
                   " id INTEGER not NULL,"+
                   " date VARCHAR(20),"+
                   " PRIMARY KEY ( id ))"; 
           
            String sql8 = "CREATE TABLE ADMIN " +
                   "(id INTEGER not NULL, " +
                   " email VARCHAR(255), " +
                   " password VARCHAR(20), "+
                   " PRIMARY KEY ( id ))"; 
    
            stmt1.executeUpdate(sql1);
            stmt1.executeUpdate(sql2);
            stmt1.executeUpdate(sql3);
            stmt1.executeUpdate(sql4);
            stmt1.executeUpdate(sql5);
            stmt1.executeUpdate(sql6);
            stmt1.executeUpdate(sql7);
            stmt1.executeUpdate(sql8);

    

            String sql9= "INSERT INTO PASSWORD VALUES ('1','Kemoy','Smith','12/1/1995','kemoy.smith@gmail.com','(876)234-1246','kemoy1life')";
          
            String sql10= "INSERT INTO ADMIN VALUES ('1','kemoy.smith@gmail.com','kemoy1life')";
           
            stmt1.executeUpdate(sql9);
            stmt1.executeUpdate(sql10);

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

    }

    public static void main(String [] args){
        Connect();
    }
}