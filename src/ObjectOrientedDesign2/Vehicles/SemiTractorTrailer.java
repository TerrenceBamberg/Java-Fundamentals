package ObjectOrientedDesign2.Vehicles;

import java.text.DecimalFormat;

/**
 * Represents a semi-tractor trailer truck with name year, make, model, value,
 * alt fuel, weight in tons and axles.
 *
 * @author Terrence Bamberg - CPSC 1223 AO2
 *
 **/
public class SemiTractorTrailer extends Truck {

    protected int axles;
    public static final double PER_AXLE_TAX_RATE = 0.005;

    /**
     * SemiTractorTrailer constructor.
     * @param nameIn owner name
     * @param yearMakeModelIn year, make and model
     * @param valueIn value
     * @param altFuelIn if hybrid
     * @param tonsIn weight in tons
     * @param axlesIn number of axles
     * @throws NegativeValueException negative values not allowed
     */
    public SemiTractorTrailer(String nameIn, String yearMakeModelIn, double valueIn,
                              boolean altFuelIn, double tonsIn, int axlesIn)
            throws NegativeValueException {

        super(nameIn, yearMakeModelIn, valueIn, altFuelIn, tonsIn);

        setAxles(axlesIn);

        if (axles < 0 || value < 0 || tons < 0) {
            vehicleCount--;
            throw new NegativeValueException();
        }
    }

    /**
     * Gets number of axles for trailer.
     * @return number of axles
     */
    public int getAxles() {
        return axles;
    }

    /**
     * Sets number of axles for trailer.
     * @param axlesIn number of axles
     */
    public void setAxles(int axlesIn) {
        axles = axlesIn;
    }

    /**
     * Calculates tax based on the number of axles.
     * @return tax to be calculated
     */
    @Override
    public double useTax() {
        return super.useTax() + value * PER_AXLE_TAX_RATE * axles;
    }

    /**
     * String representation of the semi-tractor trailer object.
     * @return output of semi-trailer string
     */
    public String toString() {
        String output = super.toString();
        DecimalFormat fmt = new DecimalFormat("0.0%");

        output += " Axle Tax Rate: " + fmt.format(axles * PER_AXLE_TAX_RATE);
        return output;
    }
}
