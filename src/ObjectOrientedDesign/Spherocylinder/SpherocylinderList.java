package ObjectOrientedDesign.Spherocylinder;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Represents a spherocylinder list with a name, and an array of
 * spherocylinder array objects.
 * Keeps track of the number of Spherocylinder objects in the array.
 *
 * Project 3: Spherocylinder with JUnit Tests – Part 3
 * @author Terrence Bamberg - CPSC 1223 AO2
 * @version 11/10/2019
 */
public class SpherocylinderList {

    private final String sListName;
    private final ArrayList<Spherocylinder> sList;
    private int numberOfSpherocylinders;

    /**
     * Constructor takes in name of list, an array of
     * spherocylinder array objects and number of spherocylinders.
     * @param sListNameIn for name of the list
     * @param sListIn for array of spherocylinders
     * @param numberOfSpherocylindersIn for number of spherocylinders in array
     */
    public SpherocylinderList(String sListNameIn, ArrayList<Spherocylinder>  sListIn,
                              int numberOfSpherocylindersIn) {

        sListName = sListNameIn;
        sList = sListIn;
        numberOfSpherocylinders = numberOfSpherocylindersIn;
    }

    /**
     * Instance method to get name of the list.
     * @return name of the list
     */
    public String getName() {
        return sListName;
    }

    /**
     * Instance method to return the number of spherocylinders in the array.
     * @return the number of Spherocylinder
     */
    public int numberOfSpherocylinders() {

        return numberOfSpherocylinders;
    }

    /**
     * Instance method to caluculate total surface area of all spherocylinders
     * in the array.
     * @return total surface area result
     */
    public double totalSurfaceArea() {
        double total = 0;

        for(Spherocylinder sObj : sList) {
            total += sObj.surfaceArea();
        }
        return total;
    }

    /**
     * Instance method to calculate the total volume of all spherocylinders
     * in array.
     * @return total volume result
     */
    public double totalVolume() {
        double total = 0;

        for(Spherocylinder sObj : sList) {
            total += sObj.volume();
        }
        return total;
    }

    /**
     * Instance method to calculate the average surface area.
     * @return average surface area result
     */
    public double averageSurfaceArea() {
        double totalSA = 0;
        double averageSA;

        for(Spherocylinder sObj : sList) {
            totalSA += sObj.surfaceArea();
        }
        if(numberOfSpherocylinders > 0) {
            averageSA = totalSA / numberOfSpherocylinders;
            return averageSA;
        }
        return 0;
    }

    /**
     * Instance method to calculate average volume.
     * @return average volume result
     */
    public double averageVolume() {
        double totalVol = 0;
        double averageVol;

        for(Spherocylinder sObj :  sList) {
            totalVol += sObj.volume();
        }
        if(numberOfSpherocylinders > 0) {
            averageVol = totalVol / numberOfSpherocylinders;
            return averageVol;
        }
        return 0;
    }

    /**
     * Instance method to print summary of array.
     * @return string result
     */
    @Override
    public String toString() {
        DecimalFormat fmt = new DecimalFormat("#,##0.0##");
        return "----- Summary for " + getName() + " -----"
                + "\nNumber of Spherocylinders: " + numberOfSpherocylinders()
                + "\nTotal Surface Area: " + fmt.format(totalSurfaceArea())
                + "\nTotal Volume: " + fmt.format(totalVolume())
                + "\nAverage Surface Area: " + fmt.format(averageSurfaceArea())
                + "\nAverage Volume: " + fmt.format(averageVolume());
    }

    /**
     * Instance method to return the array list of spherocylinder objects.
     * @return array list of spherocylinders
     */
    public ArrayList<Spherocylinder> getList() {
        return sList;
    }

    /**
     * Instance method to add a spherocylinder to the array.
     * @param labelIn name of spherocylinder object
     * @param radiusIn radius of spherocylinder object
     * @param cylinderHeightIn cylinder height of spherocylinder object
     */
    public void addSpherocylinder(String labelIn, double radiusIn, double cylinderHeightIn) {
        Spherocylinder sObj = new Spherocylinder(labelIn, radiusIn, cylinderHeightIn);
        sList.add(sObj);
        numberOfSpherocylinders++;
    }

    /**
     * Instance method to find a spherocylinder by name in the list.
     * @param labelIn object to find
     * @return the found spherocylinder. Returns null if not found
     */
    public Spherocylinder findSpherocylinder(String labelIn) {
        Spherocylinder found = null;
        for(Spherocylinder sObj : sList) {
            if (labelIn.equalsIgnoreCase(sObj.getLabel())) {
                found = sObj;
            }
        }
        return found;
    }

    /**
     * Instance method to delete a spherocylinder from the list if found.
     * @param labelIn object to find
     * @return the found spherocylinder to be deleted. Returns null if not found
     */
    public Spherocylinder deleteSpherocylinder(String labelIn) {
        Spherocylinder found = null;
        for(Spherocylinder sObj : sList) {
            if (labelIn.equalsIgnoreCase(sObj.getLabel())) {
                found = sObj;
                sList.remove(sObj);
                numberOfSpherocylinders--;
            }
        }
        return found;
    }

    /**
     * Instance method to edit a spherocylinder in the list if found.
     * @param labelIn spherocylinder object to find
     * @param radiusIn to update radius
     * @param cylinderHeightIn to update cylinder height
     * @return false
     */
    public boolean editSpherocylinder(String labelIn, double radiusIn, double cylinderHeightIn) {
        boolean edited = false;
        for(Spherocylinder sObj : sList) {
            if (labelIn.equalsIgnoreCase(sObj.getLabel())) {
                sObj.setRadius(radiusIn);
                sObj.setCylinderHeight(cylinderHeightIn);
                edited = true;
            }
        }
        return edited;
    }

    /**
     * Instance method to find the spherocylinder with the largest volume in
     * list.
     * @return largest spherocylinder
     */
    public Spherocylinder findSpherocylinderWithLargestVolume() {
        double largestVol = 0;
        Spherocylinder largest = null;
        for(Spherocylinder sObj : sList) {
            if (largestVol < sObj.volume()) {
                largest = sObj;
                largestVol = sObj.volume();
            }
        }
        return largest;
    }

}
