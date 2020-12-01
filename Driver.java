package KJapp;

import java.sql.*;
import java.text.spi.DateFormatSymbolsProvider;
import java.util.ArrayList;


public class Driver {
    private String name;
    private String address;
    private String telephone;
    private String email;
    private String trn;
    private String nis;
    private String driver_license;
    private int id;
    private DriverWork work;

    public Driver(String name, int id, String address, String telephone, String email, String trn, String nis, String license){
        this.name=name;
        this.address=address;
        this.id=id;
        this.email=email;
        this.nis=nis;
        this.trn=trn;
        this.driver_license=license;
        this.telephone=telephone;
    }

    public String getName(){
        return this.name;
    }

    public DriverWork getWork(){
        return this.work;
    }

    public String getAddress(){
        return this.address;
    }

    public String getEmail(){
        return this.email;
    }

    public String getTRN(){
        return this.trn;
    }

    public String getNIS(){
        return this.nis;
    }

    public int getID(){
        return this.id;
    }

    public String getTelephone(){
        return this.telephone;
    }

    public String getDriverLicense(){
        return this.driver_license;
    }

    public void setName(String newname){
        this.name=newname;
    }

    public void setAddress(String naddress){
        this.address=naddress;
    }

    public void setEmail(String nemail){
        this.email=nemail;
    }

    public void setTelephone(String ntelephone){
        this.telephone= ntelephone ;
    }

    public void setDriverLicense(String nlicense){
        this.driver_license= nlicense;
    }


    public String toString(){
        return "Name: "+ getName()+"\n"+"ID: "+getID()+"\n"+"Address: "+getAddress()+"\n"+"Telephone: "+getTelephone()
        +"\n"+"NIS: "+ getNIS()+"\n"+"TRN: "+getTRN()+"\n"+"Email: "+getEmail()+"\n"+"Driver License: "+getDriverLicense();
    }



    public static void AddDriver(Driver employee){
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

            String name=employee.getName();
            String address=employee.getAddress();
            int id=employee.getID();
            String telephone=employee.getTelephone();
            String nis= employee.getNIS();
            String trn= employee.getTRN();
            String license=employee.getDriverLicense();
            String email= employee.getEmail();

            String sql= "INSERT INTO DRIVER VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps= conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, telephone);
            ps.setString(4, email);
            ps.setString(5, trn);
            ps.setString(6, nis);
            ps.setString(7, license);
            ps.setInt(8, id);

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

    public static Driver[] FindDriver(int id){
        final String USER= "root";
        final String PASS="";

        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        final String DB_URL = "jdbc:mysql://localhost/kjtrucking"; 

        Connection conn = null;
        Statement stmt = null;
        Driver undriver;
        Driver[] driverlist= new Driver[2];
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql= "SELECT * FROM DRIVER WHERE id = ?";
            PreparedStatement preps= conn.prepareStatement(sql);
            preps.setInt(1, id);
            ResultSet rs= preps.executeQuery();
           
            while(rs.next()){
                String uname=rs.getString(1);
                String uaddress= rs.getString(2);
                String utelephone= rs.getString(3);
                String uemail= rs.getString(4);
                String utrn= rs.getString(5);
                String unis= rs.getString(6);
                String ulicense= rs.getString(7);
                int uid= rs.getInt(8);
                undriver=new Driver(uname,uid,uaddress,utelephone,uemail,utrn,unis,ulicense);
                driverlist[0]=undriver;
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
        return driverlist;
    }

    public static Driver[] UpdateDriver(int id,String name, String telephone, String address, String license, String email){
        final String USER= "root";
        final String PASS="";

        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        final String DB_URL = "jdbc:mysql://localhost/kjtrucking"; 

        Connection conn = null;
        Statement stmt = null;
   
        Driver driver;
        Driver[] driverlist= new Driver[1];
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql2 = "Update DRIVER Set driver_name=?, driver_address=?, telephone=?, email=?, driver_license=? Where id=?";
            PreparedStatement prep= conn.prepareStatement(sql2);
            prep.setString(1, name);
            prep.setString(2, address);
            prep.setString(3, telephone);
            prep.setString(4, email);
            prep.setString(5, license);
            prep.setInt(6, id);

            prep.executeUpdate();

            String sql3= "SELECT * FROM DRIVER WHERE id = ?";
            PreparedStatement pr= conn.prepareStatement(sql3);
            pr.setInt(1, id);
            ResultSet rs1= pr.executeQuery();
            while(rs1.next()){
                String dname=rs1.getString(1);
                String daddress= rs1.getString(2);
                String dtelephone= rs1.getString(3);
                String demail= rs1.getString(4);
                String dtrn= rs1.getString(5);
                String dnis= rs1.getString(6);
                String dlicense= rs1.getString(7);
                int did= rs1.getInt(8);
                driver=new Driver(dname,did,daddress,dtelephone,demail,dtrn,dnis,dlicense);
                driverlist[0]= driver;
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
        return driverlist;
    }

    public static int DeleteDriver(int id){
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

            String sql= "DELETE FROM DRIVER WHERE id = ?";
            PreparedStatement pr= conn.prepareStatement(sql);
            pr.setInt(1, id);

            status= pr.executeUpdate();

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

    public static void DriverWork(DriverWork driver1){
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

            String sql= "INSERT INTO DRIVERWORK VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps= conn.prepareStatement(sql);
            
            ps.setString(1, driver1.getDriverName());
            ps.setString(2, driver1.getCompany());
            ps.setString(3, driver1.getDestName());
            ps.setString(4, driver1.getLoadName());
            ps.setDouble(5, driver1.getWeight());
            ps.setString(6, driver1.getSide1Name());
            ps.setString(7, driver1.getSide2Name());
            ps.setInt(8, driver1.getTruckID());
            ps.setInt(9, driver1.getID());
            ps.setString(10, driver1.getDate());
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
    
    public static ArrayList<DriverWork> ReportEntries(){
        final String USER= "root";
        final String PASS="";

        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        final String DB_URL = "jdbc:mysql://localhost/kjtrucking"; 

        Connection conn = null;
        Statement stmt = null;
        ArrayList <DriverWork> drivers=new ArrayList<>();
        DriverWork driver;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql= "SELECT * FROM DRIVERWORK";
            PreparedStatement ps= conn.prepareStatement(sql);

            ResultSet results=ps.executeQuery();
    
            while(results.next()){
                String dname=results.getString(1);
                String company= results.getString(2);
                String destname= results.getString(3);
                String load= results.getString(4);
                double wght= results.getDouble(5);
                String side1= results.getString(6);
                String side2= results.getString(7);
                int truck_id= results.getInt(8);
                int did= results.getInt(9);
                String date=results.getString(10);
                driver=new DriverWork(dname,did,company,destname,load,wght,side1,side2,truck_id,date);
                drivers.add(driver);
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
        }//end try
        return drivers;
    }

    public static ArrayList<String> ReportFrequency(){
        final String USER= "root";
        final String PASS="";

        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        final String DB_URL = "jdbc:mysql://localhost/kjtrucking"; 

        Connection conn = null;
        Statement stmt = null;
        ArrayList <String> frequent=new ArrayList<>();
        
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql= "SELECT company, COUNT(*) AS Frequency FROM DRIVERWORK GROUP BY company ORDER BY COUNT(*) DESC LIMIT 1;";
            PreparedStatement ps= conn.prepareStatement(sql);

            ResultSet results=ps.executeQuery();
    
            while(results.next()){
                String freq_company=results.getString(1);
                String freq=results.getString(2);
                frequent.add(freq_company);
                frequent.add(freq);
            }

            String sql1= "SELECT driver_name, COUNT(*) AS Frequency FROM DRIVERWORK GROUP BY driver_name ORDER BY COUNT(*) ASC LIMIT 1;";
            PreparedStatement ps1= conn.prepareStatement(sql1);

            ResultSet result=ps1.executeQuery();
    
            while(result.next()){
                String least_company=result.getString(1);
                String freq1=result.getString(2);
                frequent.add(least_company);
                frequent.add(freq1);
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
        }//end try
        return frequent;
    }


   
    public static void main (String [] args) throws SQLException {
        DriverWork(new DriverWork("Bill Foster",2,"Delons","Frestor","Bananas",12.34,"Dakrte Dadfvs","DASWEF",321,"12/24/2020"));
        ArrayList<String> lst=ReportFrequency();
        for (String i: lst){
            System.out.println(i);
        }

        
    }
}