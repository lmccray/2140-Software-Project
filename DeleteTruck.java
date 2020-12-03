package KJapp;

import java.sql.*;
public class DeleteTruck {

public void DelTruck(Integer truckID){


    //public static void main(String[] args) {
        try {
            // create the mysql database connection
            final String USER = "root";
            final String PASS = "";

            final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
            final String DB_URL = "jdbc:mysql://localhost/kjtrucking";

            Connection conn = null;
            Statement stmt = null;

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            // create the mysql delete statement.

            String query = "delete from Trucks where id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, truckID);

      // execute the preparedstatement
      preparedStmt.execute();
      
      conn.close();
    }
    catch (Exception e)
    {
      System.err.println("ERROR! ");
      System.err.println(e.getMessage());
    }

  }
}
//}
    
