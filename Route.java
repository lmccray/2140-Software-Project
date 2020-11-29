package pdf;

public class Route {
    Truck truck;
    private String destination_name;
    private double fuel_cost;
    private double driver_wage;
    private double side_wage;
    private double delivery_price;
    private int length_billing;

    public Route(String destname, double fuel, double driverwage, double sidewage, double deliveryprice, int billlength,Truck truck){
        this.destination_name=destname;
        this.fuel_cost=fuel;
        this.driver_wage=driverwage;
        this.side_wage=sidewage;
        this.delivery_price=deliveryprice;
        this.length_billing=billlength;
        this.truck=truck;
    }

    public String getDestName(){
        return this.destination_name;
    }

    public double getFuelCost(){
        return this.fuel_cost;
    }

    public int getBillingCycle(){
        return this.length_billing;
    }

    public double getDriverWage(){
        return this.driver_wage;
    }

    public double getSideWage(){
        return this.side_wage;
    }

    public double getDeliveryPrice(){
        return this.delivery_price;
    }

    public void setFuelCost(double newfuel){
        this.fuel_cost= newfuel;
    }

    public void setDriverWage(double newdriverwage){
        this.driver_wage=newdriverwage;
    }

    public void setSideWage(double newsidewge){
        this.side_wage=newsidewge;
    }

    public void setPriceofDelivery(double newpriceofdelivery){
        this.delivery_price=newpriceofdelivery;
    }

    public void setBillingCycle(int billing){
        this.length_billing=billing;
    }

    public String toString(){
        return "Route Destination:"+ getDestName()+ "\n"+ "Fuel Cost:$"+ getFuelCost()+ "\n" +"Driver's Wage:$"+ getDriverWage()
        +"\n"+"Side-Men Wage:$" + getSideWage()+ "\n"+ "Price of Delivery:$" + getDeliveryPrice() +"\n"+ "Billing Cycle Length:"+ getBillingCycle();
    }

}
