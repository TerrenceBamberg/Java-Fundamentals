package ObjectOrientedDesign2.Vehicles;

import java.text.DecimalFormat;

/**
 * Represents a truck with name year, make, model, value, alt fuel
 * and weight in tons.
 *
 * @author Terrence Bamberg - CPSC 1223 AO2
 *
 **/
public class Truck extends Vehicle {

    protected double tons;
    public static final double TAX_RATE = 0.02;
    public static final double ALTERNATIVE_FUEL_TAX_RATE = 0.01;
    public static final double LARGE_TRUCK_TONS_THRESHOLD = 2.0;
    public static final double LARGE_TRUCK_TAX_RATE = 0.03;

    /**
     * ConsTRUCKtor.
     * @param nameIn owner name
     * @param yearMakeModelIn year, make and model  of truck
     * @param valueIn value of truck
     * @param altFuelIn if hybrid
     * @param tonsIn weight of truck (in tons)
     * @throws NegativeValueException negative values not allowed
     */
    public Truck(String nameIn, String yearMakeModelIn, double valueIn, boolean altFuelIn,
                 double tonsIn) throws NegativeValueException {

        super(nameIn, yearMakeModelIn, valueIn, altFuelIn);

        setTons(tonsIn);

        if (tons < 0 || value < 0) {
            vehicleCount--;
            throw new NegativeValueException();
        }
    }

    /**
     * Gets weight of truck.
     * @return weight in tons
     */
    public double getTons() {
        return tons;
    }

    /**
     * Method sets weight of truck.
     * @param tonsIn weight of truck in tons
     */
    public void setTons(double tonsIn) {
        tons = tonsIn;
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
        if (tons > LARGE_TRUCK_TONS_THRESHOLD) {
            total += value * LARGE_TRUCK_TAX_RATE;
        }
        return total;
    }

    /**
     * String representation of the truck object.
     * @return output string
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
        if (tons > LARGE_TRUCK_TONS_THRESHOLD) {
            output += " Large Truck Tax Rate: " + fmt.format(LARGE_TRUCK_TAX_RATE);
        }
        return output;
    }
}