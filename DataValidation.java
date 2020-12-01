package KJapp;

import java.sql.*;

public class DataValidation{
    
    public static boolean passwordCheck(int id, String password){
        final String USER= "root";
        final String PASS="";

        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        final String DB_URL = "jdbc:mysql://localhost/kjtrucking"; 

        Connection conn = null;
        Statement stmt = null;
        User user = null;
    
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "SELECT * FROM PASSWORD WHERE id = ? and password = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();
 
            if (result.next()) {
                int did =result.getInt(1);
                String fname= result.getString(2);
                String lname=result.getString(3);
                String dob= result.getString(4);
                String email= result.getString(5);
                String telnum= result.getString(6);
                String passwords= result.getString(7);
                user= new User(fname, lname, email, dob, telnum, did, passwords);   
            }
    
            
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
            
        }
        if (user==null){
            return false;
        }
        else{
            return true;
        }
    }

    public static int AdminpasswordCheck(int id, String password){
        final String USER= "root";
        final String PASS="";

        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        final String DB_URL = "jdbc:mysql://localhost/kjtrucking"; 

        Connection conn = null;
        Statement stmt = null;
        String verify=null;
    
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "SELECT * FROM ADMIN WHERE id = ? and password = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, password);

            ResultSet rs=statement.executeQuery();

            while(rs.next()){
                verify= rs.getString(1);
            }
 
            
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
            
        }
      if (verify==null){
          return 0;
      }
      else{
          return 1;
      }
    }
    
  
}
