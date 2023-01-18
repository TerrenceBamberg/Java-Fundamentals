package ObjectOrientedDesign2.Vehicles;

import java.text.DecimalFormat;
/**
 * Superclass for vehicles that includes owner name, year make and model, 
 * value and alternative fuel. Keeps track of the number of vehicles.
 *
 * @author Terrence Bamberg - CPSC 1223 AO2
 * @version 11/29/2019
 */


public abstract class Vehicle implements Comparable<Vehicle> {

    protected String name;
    protected String yearMakeModel;
    protected double value;
    protected boolean altFuel;
    protected static int vehicleCount = 0;

    /**
     * Constructor for a vehicle setting owner name, year make model, value
     * and alternative fuel. Increases the count of vehicles.
     * @param nameIn owner name
     * @param yearMakeModelIn year make and model of vehicle
     * @param valueIn value of vehicle
     * @param altFuelIn if hybrid
     */
    public Vehicle(String nameIn, String yearMakeModelIn, double valueIn, boolean altFuelIn) {
        setName(nameIn);
        setYearMakeModel(yearMakeModelIn);
        setValue(valueIn);
        setAltFuel(altFuelIn);
        vehicleCount++;
    }

    /**
     * Takes a Vehicle as a parameter and returns an int indicating the results
     * of comparing Vehicle objects based on their respective owners.
     * @param v1 for vehicle to compare
     * @return value based on vehicle owners
     */
    public int compareTo(Vehicle v1) {
        if (this.getOwner().equals(v1.getOwner())) {
            return 0;
        }
        else if (this.getOwner().compareTo(v1.getOwner()) > 0) {
            return 1;
        }
        else {
            return -1;
        }
    }

    /**
     * Method to get set name of vehicle.
     * @param nameIn sets vehicle name
     */
    private void setName(String nameIn) {
        name = nameIn;
    }

    /**
     * Method to get the vehicle owner's name.
     * @return name for owner of vehicle
     */
    public String getOwner() {
        return name;
    }

    /**
     * Method to set the vehicle owner's name.
     * @param nameIn sets owner name
     */
    public void setOwner(String nameIn) {
        name = nameIn;
    }

    /**
     * Method to get the vehicle owner's name.
     * @return yearMakeModel of vehicle
     */
    public String getYearMakeModel() {
        return yearMakeModel;
    }

    /**
     * Method to set the vehicle owner's name.
     * @param yearMakeModelIn sets vehicle info
     */
    public void setYearMakeModel(String yearMakeModelIn) {
        yearMakeModel = yearMakeModelIn;
    }

    /**
     * Method to get the vehicle's value.
     * @return value of vehicle
     */
    public double getValue() {
        return value;
    }

    /**
     * Method to set the vehicle's value.
     * @param valueIn sets value of vehicle
     */
    public void setValue(double valueIn) {
        value = valueIn;
    }

    /**
     * Method to get alternative fuel available for vehicle.
     * @return altFuel if car is hybrid
     */
    public boolean getAltFuel() {
        return altFuel;
    }

    /**
     * Method to set alternative fuel available for vehicle.
     * @param altFuelIn sets true or false
     */
    public void setAltFuel(boolean altFuelIn) {
        altFuel = altFuelIn;
    }

    /**
     * Method to get the number of vehicles.
     * @return vehicleCount
     */
    public static int getVehicleCount() {
        return vehicleCount;
    }

    /**
     * Method to reset the number of vehicles.
     */
    public static void resetVehicleCount() {
        vehicleCount = 0;
    }

    /**
     * Abstract method for total amount of vehicles use tax.
     * @return nothing...it's abstract
     */
    public abstract double useTax();

    /**
     * String representation of vehicle object. 2 variations are printed
     * depending on altFuel status.
     *
     * @return output string
     */
    @Override
    public String toString() {
        DecimalFormat fmt = new DecimalFormat("$##,###.00");
        String output = "";
        if (this.getAltFuel()) {
            output += this.getOwner() + ": " + this.getClass().getSimpleName()
                    + " " + this.getYearMakeModel() + " (Alternative Fuel)"
                    + "\nValue: " + fmt.format(this.getValue())
                    + " Use Tax: " + fmt.format(this.useTax());
        }
        else {

            output += this.getOwner() + ": " + this.getClass().getSimpleName()
                    + " " + this.getYearMakeModel()
                    + "\nValue: " + fmt.format(this.getValue())
                    + " Use Tax: " + fmt.format(this.useTax());
        }
        return output;
    }

    /**
     * @param obj the other object
     * @return false if not a vehicle and returns the object if it is
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vehicle vObj)) {
            return false;
        }
        else {
            return (name + yearMakeModel + value)
                    .equals(vObj.name + vObj.yearMakeModel + vObj.value);
        }
    }

    /** @return 0 */
    @Override
    public int hashCode() {
        return 0;
    }

}