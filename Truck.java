package pdf;

public class Truck {
    private int truck_id;
    private String make;
    private String model;
    private String license_num;
    private String fitness_expdate;
    private String registration_expdate;
    private String insurance_expdate;

    public Truck(int truckid, String make, String model, String license, String fitnessdate, String regdate, String insurdate){
        this.truck_id=truckid;
        this.make=make;
        this.model=model;
        this.license_num=license;
        this.fitness_expdate=fitnessdate;
        this.registration_expdate=regdate;
        this.insurance_expdate=insurdate;
    }

    public int getTruckID()
    {
        return this.truck_id;
    }

    public String getMake(){
        return this.make;
    }

    public String getModel(){
        return this.model;
    }

    public String getLicense(){
        return this.license_num;
    }

    public String getFitnessExpDate(){
        return this.fitness_expdate;
    }

    public String getRegistrationExpDate(){
        return this.registration_expdate;
    }

    public String getInsuranceExpDate(){
        return this.insurance_expdate;
    }

    public void setFitnessDate(String newfitnessdate){
        this.fitness_expdate=newfitnessdate;
    }

    public void setRegistrationDate(String newregdate){
        this.registration_expdate=newregdate;
    }

    public void setInsuranceDate(String newinsdate){
        this.insurance_expdate=newinsdate;
    }

    public String toString(){
        return "Truck ID:"+ getTruckID() +"\n"+ "Make:" +getMake() +"\n"+ "Model:" +getModel() + "\n"+"License Plate Number:"+ getLicense()
        + "\n"+"Fitness Expires:" +getFitnessExpDate()+ "\n"+ "Registration Expires:" + getRegistrationExpDate() +"\n" +"Insurance Expires:" +getInsuranceExpDate();
    }     


public static void main(String [] args) {
    Truck truck1= new Truck(12,"Toyota","Voxy", "1432P","12/3/2020","12/13/2020","14/3/2020");
    System.out.println(truck1.toString());
    
}
}