package KJapp; 

import java.sql.*;

public class AddTruck{

    static String truck_ID;
    static String truck_Make;
    static String truck_Model;
    static String truck_Lisc;
    static String fitness_Exp;
    static String registration_Exp;
    static String insure_Exp;

    public static void AddTruckInfo(final User user1) {
        final String USER = "root";
        final String PASS = "";

        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost/kjtrucking";

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            final String sql = "INSERT INTO PASSWORD VALUES (?,?,?,?,?,?,?)";
            final PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, truck_ID);
            ps.setString(2, truck_Make);
            ps.setString(3, truck_Model);
            ps.setString(4, truck_Lisc);
            ps.setString(5, fitness_Exp);
            ps.setString(6, registration_Exp);
            ps.setString(7, insure_Exp);
            ps.executeUpdate();

        } catch (final SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (final Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // final block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (final SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (final SQLException se) {
                se.printStackTrace();
            } // end final try
        } // end try

    }

    public AddTruck(String truckID, String make, String model, String liscence, String fitnessexpires, String regexpires, String insuranceexpires) {
        
        AddTruck.truck_ID = truckID;
        AddTruck.truck_Make = make;
        AddTruck.truck_Model = model;
        AddTruck.truck_Lisc = liscence;
        AddTruck.fitness_Exp = fitnessexpires;
        AddTruck.registration_Exp = regexpires;
        AddTruck.insure_Exp = insuranceexpires; 

    }

    public String getTruckID(){
        return AddTruck.truck_ID;
    }

    public String getTruckMake(){
        return AddTruck.truck_Make;
    }

    public String getTruckModel(){
        return AddTruck.truck_Model;
    }
    public String getTruckLiscence(){
        return AddTruck.truck_Lisc;
    }

    public String getTruckFitness(){
        return AddTruck.fitness_Exp;
    }
    public String getTruckRegistration() {
        return AddTruck.registration_Exp;
    }

    public String getTruckInsurance(){
        return AddTruck.insure_Exp;
    }

    public void setTruckID(String newTruckID){
        AddTruck.truck_ID= newTruckID;
    }

    public void setTruckMake(String newTruckMake){
        AddTruck.truck_Make = newTruckMake;
    }

    public void setTruckModel(String newTruckModel){
        AddTruck.truck_Model= newTruckModel;
    }

    public void setTruckLiscence(String newTruckLiscence){
        AddTruck.truck_Lisc= newTruckLiscence;
    }

    public void setTruckFitness(String newTruckFitness){
        AddTruck.fitness_Exp = newTruckFitness;
    }

    public void setTruckRegistration(String newTruckReg){
        AddTruck.registration_Exp= newTruckReg;
    }

    public void setTruckInsurance(String newTruckIns){
        AddTruck.insure_Exp= newTruckIns;
    }

}