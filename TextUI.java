package KJapp;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;



public class TextUI {
    private Scanner scan;

    public TextUI(){
        this.scan= new Scanner(System.in);
    }
 
    public boolean login(){
        boolean value;
        System.out.println("\n-----------KJ TRUCKING-------------\n");
        System.out.println("\n--------------LOGIN----------------\n");
        System.out.print("ID number: ");
        int id=scan.nextInt();
        scan.nextLine();

        System.out.print("Password: ");
        String password=scan.next();
        value= DataValidation.passwordCheck(id, password);
        return value;
    }

    public int loginAdmin(){
        System.out.println("\n-----------KJ TRUCKING-------------\n");
        System.out.println("\n--------------LOGIN----------------\n");
        System.out.print("ID number: ");
        int id=scan.nextInt();
        scan.nextLine();

        System.out.print("Password: ");
        String password=scan.next();
        int value=DataValidation.AdminpasswordCheck(id, password);
        return value;
    }


    public void go(){
        boolean v=login();
        if (v){
            Menu();
        }
        else{
            System.out.println("Access Denied!");
            System.exit(0);
        }
    }
    
    public static void clrs() {
        try {
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        else {
            System.out.print("\033\143");
        }
    } catch (IOException | InterruptedException ex) {}
    }


    public void Menu(){
        String choice="";
     
        while(!choice.equals("5"))
        {
            clrs();
            System.out.println("\n-------------KJ TRUCKING------------\n\n");
            System.out.println("1. User Management");
            System.out.println("2. Driver Management"); 
            System.out.println("4. Report Management");
            /*System.out.println("d. Register a Death");
            System.out.println("e. Register a Marriage");
            System.out.println("f. Generate a Mailing Label");
            System.out.println("g. Search");*/
            System.out.println("5. Exit Application");

            System.out.println("Enter choice:\n");
            choice=scan.next();

            switch(choice)
            {
                case "1":
                    clrs();
                    UserManagement();
                    break;
                
                case "2":
                     DriverManagement();
                    break;
                /*
                case "c":
                   updateCitizen();
                   break;
                
                case "d":
                    registerDeath();
                    break;
                
                case "e":
                    registerMarriage();
                    break;
                
                case "f":
                    generateMailing();
                    break;
                
                case "g":
                    searchMenu();
                    break;*/
                
                case "5":
                    System.out.println("Exiting..");
                    System.exit(0);
            }

        }
    }

    public void UserManagement(){
        String choice="";
     
        int value=loginAdmin();

        if (value==0){
            System.out.println("Access Denied!");
            Menu();
        }
        else{
            while(!choice.equals("5")){
                System.out.println("\n-------------USER MANAGEMENT------------\n");
                System.out.println("1. Add User");
                System.out.println("2. Update User");
                System.out.println("3. Delete User");
                System.out.println("4. Add Admin");
                System.out.println("5. Exit to Menu");
                System.out.println("Enter choice:");
                choice=scan.next();

                switch(choice)
                {
                case "1":
                    AddUser();
                    
                    break;
              
                case "2":
                    UpdateUser();
                    break;
                
                case "3":
                   DeleteUser();
                   break;
                
                case "4":
                    AddAdmin();
                    break;
                
                case "5":
                    System.out.println("Exiting to Menu...");
                    break;

                }
            }
        }
    }

    public void AddUser(){
        scan.nextLine();
        System.out.println("------------------ADD USER--------------\n");
        System.out.print("Enter the First Name of the new user:");
        String fname=scan.nextLine();

        System.out.print("\nEnter the Last Name of the new user:");
        String lname=scan.nextLine();

        System.out.print("\nEnter the Date of birth of the new user (xx/xx/xxxx): ");
        String dob=scan.nextLine();

        System.out.print("\nEnter the Email of the new user: ");
        String email=scan.nextLine();

        System.out.print("\nEnter the Telephone Number of the new user ((xxx)xxx-xxxx): ");
        String telephone=scan.nextLine();

        System.out.print("\nEnter the ID number of the new user: ");
        int id=scan.nextInt();

        scan.nextLine();
        System.out.print("\nNew User's password: ");
        String password=scan.nextLine();

        User user1=new User(fname,lname,email,dob,telephone,id,password);
        User.AddUser(user1);

        System.out.println("\nUser successfully added to the system!");    
    }

    public void UpdateUser(){
        scan.nextLine();
        System.out.println("------------------UPDATE USER--------------\n");
        System.out.print("Enter the ID number of the User you wish to edit:");
        int id=scan.nextInt();

        scan.nextLine();
        System.out.print("\nEnter the new Last Name of the user if applicable else enter the same last name:");
        String lname=scan.nextLine();

        System.out.print("\nEnter the new Email of the user if applicable else enter the same email: ");
        String email=scan.nextLine();

        System.out.print("\nEnter the new Telephone Number of if applicable else enter the same number: ");
        String telephone=scan.nextLine();

        System.out.print("\nEnter new User's password: ");
        String password=scan.nextLine();

        User.UpdateUser(id, lname, email, telephone, password);

        System.out.println("\nUser successfully updated!");    
    }

    public void DeleteUser(){
        scan.nextLine();
        System.out.println("------------------DELETE USER--------------\n");
        System.out.print("Enter the ID number of the User you wish to delete:");
        int id=scan.nextInt();

        scan.nextLine();
        System.out.print("Are you sure y/n:");
        String input=scan.nextLine();

        if (input.equals("y")){
            int status=User.DeleteUser(id);
            if (status==0){
                System.out.println("\nUser ID entered does not exist!");
            }else{
                System.out.println("\nUser successfully deleted!");    
            } 
        }
        else{
            System.out.println("\nReturning to the Menu..");
        }    
    }
    
    public void AddAdmin(){
        scan.nextLine();
        System.out.println("------------------ADD ADMIN--------------\n");
        System.out.print("\nEnter the Email of the user: ");
        String email=scan.nextLine();

        System.out.print("\nEnter the ID number of the user: ");
        int id=scan.nextInt();

        scan.nextLine();
        System.out.print("\nUser's password: ");
        String password=scan.nextLine();

        User.AddAdmin(id, email, password);
        System.out.println("\nNew Admin successfully added to the system!");    
    }

    public void DriverManagement(){
        String choice="";
     
        boolean value=login();

        if (value==false){
            System.out.println("Access Denied!");
            Menu();
        }
        else{
            while(!choice.equals("5")){
                System.out.println("\n-------------DRIVER MANAGEMENT------------\n");
                System.out.println("1. Add Driver");
                System.out.println("2. Update Driver");
                System.out.println("3. Delete Driver");
                System.out.println("4. Input Driver's Work Log");
                System.out.println("5. Exit to Menu");
                System.out.println("Enter choice:");
                choice=scan.next();

                switch(choice)
                {
                case "1":
                    AddDriver();
                    
                    break;
              
                case "2":
                    UpdateDriver();
                    break;
                
                case "3":
                   DeleteDriver();
                   break;
                
                case "4":
                    DriverWork();
                    break;
                
                case "5":
                    System.out.println("Exiting to Menu...");
                    break;

                }
            }
        }
    }

    public void AddDriver(){
        scan.nextLine();
        System.out.println("------------------ADD DRIVER--------------\n");

        System.out.print("Enter the Name of the new Driver:");
        String name=scan.nextLine();

        System.out.print("\nEnter the Address of the new Driver:");
        String address=scan.nextLine();

        System.out.print("\nEnter the Email of the new Driver: ");
        String email=scan.nextLine();

        System.out.print("\nEnter the Telephone Number of the new Driver ((xxx)xxx-xxxx): ");
        String telephone=scan.nextLine();

        System.out.print("\nEnter the ID number of the new Driver: ");
        int id=scan.nextInt();

        scan.nextLine();
        System.out.print("\nEnter the TRN of the new Driver (xxx-xxx-xxx): ");
        String trn=scan.nextLine();

        System.out.print("\nEnter the NIS of the new Driver: ");
        String nis=scan.nextLine();

        System.out.print("\nEnter the Driver's License of the new Driver: ");
        String dlicense=scan.nextLine();

        Driver driver1=new Driver(name,id,address,telephone,email,trn,nis,dlicense);
        Driver.AddDriver(driver1);

        System.out.println("\nDriver successfully added to the system!");    
    }


    public void UpdateDriver(){
        scan.nextLine();
        System.out.println("------------------UPDATE DRIVER--------------\n");

        System.out.print("Enter the ID number of the User you wish to edit:");
        int id=scan.nextInt();

        Driver [] drive= Driver.FindDriver(id);

        if (drive[0]!=null){
            System.out.println("\n\n--------------------DRIVER'S INFORMATION-----------------\n");
            Driver dr=drive[0];
            System.out.print(dr.toString());

            scan.nextLine();
            System.out.print("\n\nEnter the updated Name of the Driver if applicable else enter the same name:");
            String name=scan.nextLine();

            System.out.print("\nEnter the new Address of the new Driver if applicable else enter the same address:");
            String address=scan.nextLine();

            System.out.print("\nEnter the updated Email of the new Driver if applicable else enter the same email: ");
            String email=scan.nextLine();

            System.out.print("\nEnter the upadated Telephone Number of the new Driver ((xxx)xxx-xxxx) if applicable else enter the same number: ");
            String telephone=scan.nextLine();

            System.out.print("\nEnter the updated Driver's License of the new Driver: ");
            String dlicense=scan.nextLine();

            Driver [] driver1=Driver.UpdateDriver(id,name,telephone,address,dlicense,email);
            
            System.out.println("\n\n--------------------UPDATED DRIVER'S INFORMATION-----------------\n");
            Driver dr1=driver1[0];
            System.out.print(dr1.toString());


            System.out.println("\n\nDriver successfully updated!");    
        }
        else{
            System.out.println("ID entered for Driver does not exist!");
        }
    }
    
    public void DeleteDriver(){
        scan.nextLine();
        System.out.println("------------------DELETE DRIVER--------------\n");
        System.out.print("Enter the ID number of the Driver you wish to delete:");
        int id=scan.nextInt();

        scan.nextLine();
        System.out.print("\nAre you sure y/n:");
        String input=scan.nextLine();

        if (input.equals("y")){
            int status=Driver.DeleteDriver(id);
            if (status==0){
                System.out.println("\nDriver ID entered does not exist!");
            }else{
                System.out.println("\nDriver successfully deleted!");    
            }   
        }
        else{
            System.out.println("\nReturning to the Menu..");
        }  
    }
    
    public void DriverWork(){
        int value=loginAdmin();

        if (value==0){
            System.out.println("Access Denied!");
        }
        else{
            scan.nextLine();
            System.out.println("------------------INPUT DRIVER'S WORK LOG--------------\n");
            
            DateFormat df = new SimpleDateFormat("dd/MM/yy");
            Date dateobj = new Date();
            String date= df.format(dateobj);
            
            System.out.print("Enter the Name of the Driver:");
            String name=scan.nextLine();
    
            System.out.print("\nEnter the ID of the new Driver:");
            int id= scan.nextInt();

            scan.nextLine();
            System.out.print("\nEnter the Destination of the delivery: ");
            String destname=scan.nextLine();

            System.out.print("\nEnter the Company the delivery was made for: ");
            String company=scan.nextLine();
    
            System.out.print("\nEnter the Goods Delivered: ");
            String load=scan.nextLine();
    
            System.out.print("\nEnter the weight of the goods (kg): ");
            double weight=scan.nextDouble();
    
            scan.nextLine();
            System.out.print("\nEnter the name of the Side Man 1 used for the delivery: ");
            String side1=scan.nextLine();
    
            System.out.print("\nEnter the name of the Side Man 2 used for the delivery:: ");
            String side2=scan.nextLine();
    
            System.out.print("\nEnter the ID of the truck used for the delivery: ");
            int truckid=scan.nextInt();

            DriverWork work= new DriverWork(name,id,company,destname,load,weight,side1,side2,truckid,date);
            Driver.DriverWork(work);

            System.out.println("\n----------Driver's Log Successfully Logged---------\n");
            System.out.println(work.toString());
        }
    }
    
    

public static void main(String [] args){
    TextUI ui=new TextUI();
    ui.go();
}
}