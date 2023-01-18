package ObjectOrientedDesign2.Vehicles;

import java.text.DecimalFormat;

/**
 * Represents a motorcycle with owner name year, make, model, value,
 * alt fuel and engine size.
 **/
public class Motorcycle extends Vehicle {

    protected double engineSize;
    public static final double TAX_RATE = 0.005;
    public static final double ALTERNATIVE_FUEL_TAX_RATE = 0.0025;
    public static final double LARGE_BIKE_CC_THRESHOLD = 499;
    public static final double LARGE_BIKE_TAX_RATE = .015;

    /**
     * Motorcycle constructor.
     * @param nameIn owner name
     * @param yearMakeModelIn year make and model
     * @param valueIn value
     * @param altFuelIn if hybrid
     * @param engineSizeIn engine size of motorcycle
     * @throws NegativeValueException negative values not allowed
     */
    public Motorcycle(String nameIn, String yearMakeModelIn, double valueIn, boolean altFuelIn,
                      double engineSizeIn)
            throws NegativeValueException {

        super(nameIn, yearMakeModelIn, valueIn, altFuelIn);
        setEngineSize(engineSizeIn);

        if (engineSize < 0 || value < 0) {
            vehicleCount--;
            throw new NegativeValueException();
        }
    }
    /**
     * Method to get engine size of motorcycle.
     * @return engineSize
     */
    public double getEngineSize() {
        return engineSize;
    }

    /**
     * Method to set engine size of motorcycle.
     * @param engineSizeIn for size to set
     */
    public void setEngineSize(double engineSizeIn) {
        engineSize = engineSizeIn;
    }

    /**
     * Method to calculate the tax rate based off of engine size.
     * @return the tax to use after calculation of
     * value, alt fuel tax and/or large bike tax rate
     *
     * @author Terrence Bamberg - CPSC 1223 AO2
     *
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
        if (engineSize > LARGE_BIKE_CC_THRESHOLD) {
            total += value * LARGE_BIKE_TAX_RATE;
        }
        return total;
    }

    /**
     * Prints the string of the motorcycle object.
     * @return output of bike string
     */
    public String toString() {
        String output = super.toString();
        DecimalFormat fmt = new DecimalFormat("0.00%");

        if (altFuel) {
            output += "\nwith Tax Rate: " + fmt.format(ALTERNATIVE_FUEL_TAX_RATE);
        }
        else {
            output += "\nwith Tax Rate: " + fmt.format(TAX_RATE);
        }
        if (engineSize > LARGE_BIKE_CC_THRESHOLD) {
            output += " Large Bike Tax Rate: " + fmt.format(LARGE_BIKE_TAX_RATE);
        }
        return output;
    }

}
