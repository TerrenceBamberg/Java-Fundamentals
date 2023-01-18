package ObjectOrientedDesign2.Vehicles;

import java.text.DecimalFormat;

/**
 * Represents a car with name year, make, model, value and alt fuel.
 *
 * @author Terrence Bamberg - CPSC 1223 AO2
 *
 **/
public class Car extends Vehicle {

    public static final double TAX_RATE = 0.01; // constant tax rate.
    public static final double ALTERNATIVE_FUEL_TAX_RATE = 0.005; //constant alt fuel tax rate.
    public static final double LUXURY_THRESHOLD = 50000; // constant for car to be considered luxury.
    public static final double LUXURY_TAX_RATE = 0.02; //constant for luxury tax rate.

    /**
     * Car constructor.
     * @param nameIn owner name
     * @param yearMakeModelIn year make and model of car
     * @param valueIn value of the car
     * @param altFuelIn if hybrid
     * @throws NegativeValueException negative values not allowed
     */
    public Car(String nameIn, String yearMakeModelIn, double valueIn, boolean altFuelIn)
            throws NegativeValueException {

        super(nameIn, yearMakeModelIn, valueIn, altFuelIn);

        if (value < 0) {
            vehicleCount--;
            throw new NegativeValueException();
        }
    }

    /**
     * Overrides useTax to calculate taxes based on vehicle info.
     * @return total tax to be collected
     */
    @Override
    public double useTax() {
        double total;
        if (altFuel) {
            total = value * ALTERNATIVE_FUEL_TAX_RATE;
        }
        else {
            total = value * TAX_RATE;
        }
        if (value > LUXURY_THRESHOLD) {
            total += value * LUXURY_TAX_RATE;
        }
        return total;
    }

    /**
     * String representation of the car object.
     * @return output string
     */
    @Override
    public String toString() {
        String output = super.toString();
        DecimalFormat fmt = new DecimalFormat("0.0%");
        if (altFuel) {
            output += "\nwith Tax Rate: " + fmt.format(ALTERNATIVE_FUEL_TAX_RATE);
        }
        else {
            output += "\nwith Tax Rate: " + fmt.format(TAX_RATE);
        }
        if (value > LUXURY_THRESHOLD) {
            output += " Luxury Tax Rate: " + fmt.format(LUXURY_TAX_RATE);
        }
        return output;
    }
}