package ObjectOrientedDesign2.Vehicles;

/**
 * Defines an exception for negative values.
 */
public class NegativeValueException extends Exception {

    public NegativeValueException() {
        super("Numeric values must be non-negative");
    }
}
