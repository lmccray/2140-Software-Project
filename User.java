package KJapp;

import java.sql.*;

public class User {
    private String first_name;
    private String last_name;
    private String email;
    private String dob;
    private String tel_num;
    private int id_num;
    private String password;
    
    public User(String fname, String lname, String email, String dob, String telnum, int id, String password){
        this.first_name=fname;
        this.last_name=lname;
        this.email=email;
        this.dob=dob;
        this.id_num=id;
        this.tel_num=telnum;
        this.password=password;
    }

    public String getFirstName(){
        return this.first_name;
    }

    public String getLastName(){
        return this.last_name;
    }

    public String getTelephone(){
        return this.tel_num;
    }
    public String getEmailAddress(){
        return this.email;
    }

    public String getDOB(){
        return this.dob;
    }
    public int getID(){
        return this.id_num;
    }

    public String getPassword(){
        return this.password;
    }

    public void setEmail(String newemail){
        this.email= newemail;
    }

    public void setLastName(String newlstname){
        this.last_name= newlstname;
    }

    public void setFirstName(String newfname){
        this.first_name=newfname;
    }

    public void setPassword(String newpass){
        this.password=newpass;
    }

    public void setDOB(String newdob){
        this.dob=newdob;
    }

    public void setTelephoneNumber(String newtel){
        this.tel_num=newtel;
    }

    public static void AddUser(User user1){
        final String USER= "root";
        final String PASS="";

        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        final String DB_URL = "jdbc:mysql://localhost/kjtrucking"; 

        Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String fname=user1.getFirstName();
            String lname=user1.getLastName();
            int id=user1.getID();
            String telephone=user1.getTelephone();
            String dob= user1.getDOB();
            String email= user1.getEmailAddress();
            String password=user1.getPassword();

            String sql= "INSERT INTO PASSWORD VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps= conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setString(4, dob);
            ps.setString(5, email);
            ps.setString(6, telephone);
            ps.setString(7, password);
            ps.executeUpdate();
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

    public static void AddAdmin(int id, String email, String password){
        final String USER= "root";
        final String PASS="";

        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        final String DB_URL = "jdbc:mysql://localhost/kjtrucking"; 

        Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();


            String sql= "INSERT INTO ADMIN VALUES (?,?,?)";
            PreparedStatement ps= conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.executeUpdate();
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

    public static void UpdateUser(int id, String lname, String email, String telephone, String password){
        final String USER= "root";
        final String PASS="";

        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        final String DB_URL = "jdbc:mysql://localhost/kjtrucking"; 

        Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
         
            
            String sql2 = "Update PASSWORD Set last_name=?, email=?, telephone=?, password=? Where id=?";
            PreparedStatement prep= conn.prepareStatement(sql2);
            prep.setString(1, lname);
            prep.setString(2, email);
            prep.setString(3, telephone);
            prep.setString(4, password);
            prep.executeUpdate();

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


    public static int DeleteUser(int id){
        final String USER= "root";
        final String PASS="";

        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        final String DB_URL = "jdbc:mysql://localhost/kjtrucking"; 

        Connection conn = null;
        Statement stmt = null;

        int status=0;

        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql= "DELETE FROM PASSWORD WHERE id = ?";
            PreparedStatement pr= conn.prepareStatement(sql);
            pr.setInt(1, id);

            status=pr.executeUpdate();
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
        return status;
    }
}

