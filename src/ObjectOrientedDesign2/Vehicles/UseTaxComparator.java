package ObjectOrientedDesign2.Vehicles;

import java.util.Comparator;
/**
 * Implements the comparator interface for defining vehicle object comparison by use tax amount.
 *
 * @author Terrence Bamberg - CPSC 1223 AO2
 *
 */
public class UseTaxComparator implements Comparator<Vehicle> {

    /**
     * @param v1 vehicle 1.
     * @param v2 vehicle 2.
     * @return 1 if v1>v2, -1 if v1<v2, 0 if equal.
     */
    public int compare(Vehicle v1, Vehicle v2) {
        if (v1.useTax() > v2.useTax()) {
            return 1;
        }
        else if (v1.useTax() < v2.useTax()) {
            return -1;
        }
        return 0;
    }
}