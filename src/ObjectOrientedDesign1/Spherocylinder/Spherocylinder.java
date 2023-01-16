package ObjectOrientedDesign1.Spherocylinder;

import java.text.DecimalFormat;

/**
 * Represents a spherocylinder with a label, radius, and cylinder height.
 * Provides methods for calculating the circumference, surface area, and volume.
 *
 * @author Terrence Bamberg - CPSC 1223 AO2
 * @version 10/23/2019
 */

public class Spherocylinder implements Comparable<Spherocylinder> {
    private String label = "";
    private double radius = 0;
    private double cylinderHeight = 0;
    private static int count = 0;

    /**
     * Constructor sets label, radius and cylinder of spherocylinder object.
     * @param labelIn spherocylinder label attribute
     * @param radiusIn radius attribute
     * @param cylinderHeightIn cylinder height attribute
     */
    public Spherocylinder(String labelIn, double radiusIn,double cylinderHeightIn) {
        setLabel(labelIn);
        setRadius(radiusIn);
        setCylinderHeight(cylinderHeightIn);
        count++;
    }

    /**
     * Instance method to get label of spherocylinder.
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Instance method to set label of spherocylinder if not null and not empty.
     * @param labelIn spherocylinder label
     * @return true if label was set
     */
    public Boolean setLabel(String labelIn) {
        boolean isSet = false;
        if (labelIn != null && !labelIn.equals("")) {
            label = labelIn.trim();
            isSet = true;
        }
        return isSet;
    }

    /**
     * Instance method to get radius of spherocylinder.
     * @return radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Instance method to set radius of spherocylinder if non-negative.
     * @param radiusIn spherocylinder radius
     * @return true if radius was set
     */
    public boolean setRadius(double radiusIn) {
        boolean isSet = false;
        if (radiusIn >= 0) {
            radius = radiusIn;
            isSet = true;
        }
        return isSet;
    }

    /**
     * Instance method to get cylinder height of spherocylinder.
     * @return cylinderHeight
     */
    public double getCylinderHeight() {
        return cylinderHeight;
    }

    /**
     * Instance method to set cylinder height of spherocylinder if non-negative.
     * @param cylinderHeightIn spherocylinder height
     * @return true if cylinder height was set
     */
    public boolean setCylinderHeight(double cylinderHeightIn) {
        boolean isSet = false;
        if (cylinderHeightIn >= 0) {
            cylinderHeight = cylinderHeightIn;
            isSet = true;
        }
        return isSet;
    }

    /**
     * Instance method to calculate circumference of a spherocylinder.
     * @return circmf
     */
    public double circumference() {
        return 2 * Math.PI * radius;

    }

    /**
     * Instance method to calculate surface area of a spherocylinder.
     * @return surfArea
     */
    public double surfaceArea() {
       return cylinderHeight != 0 ? 2 * Math.PI * radius * (2 * radius + cylinderHeight) : 0;
    }

    /**
     * Instance method to calculate volume of a spherocylinder.
     * @return vol
     */
    public double volume() {
        return cylinderHeight != 0 ? Math.PI * Math.pow(radius, 2)
                * ((4.0 / 3) * radius + cylinderHeight) : 0;
    }

    /**
     * Static method to get the number of sphyrocylinder objects created.
     * @return count
     */
    public static int getCount() {
        return count;
    }

    /**
     * Static method to reset the number of sphyrocylinder objects created.
     */
    public static void resetCount() {
        count = 0;
    }

    /**
     * Overriding equals method to compare spherocylinder objects.
     * @param sObj spherocylinder object to compare
     * @return false if not a spherocylinder or values are not the same and true if matching values
     */
    @Override
    public boolean equals(Object sObj) {
        if (!(sObj instanceof Spherocylinder)) {
            return false;
        }
        else {
            Spherocylinder sp = (Spherocylinder) sObj;
            return (label.equalsIgnoreCase(sp.getLabel())
                    && Math.abs(radius - sp.getRadius()) < .000001
                    && Math.abs(cylinderHeight - sp.getCylinderHeight()) < .000001);
        }
    }

    /**
     * Overriding hashcode method for hashing to establish object equivalence.
     * @return hashcode value of 0
     */
    @Override
    public int hashCode() {
        return 0;
    }

    /**
     * Overriding compareTo method for comparing spherocylinder objects based on volume.
     * @param obj spherocylinder object to compare
     * @return int (-) if smaller volume1 < volume 2, (+) if volume1 > volume2
     */
    @Override
    public int compareTo(Spherocylinder obj) {
        if (this.volume() < obj.volume()) {
            return -1;
        }
        else if (this.volume() > obj.volume()) {
            return 1;
        }
        else {
            return 0;
        }
    }

    /**
     * Instance method to represent spherocylinder object as a string.
     * @return output
     */
    public String toString() {

        DecimalFormat fmt = new DecimalFormat("#,##0.0##");
        return "Spherocylinder \"" + label + "\" with radius "
                + radius + " and cylinder height " + fmt.format(cylinderHeight)
                + " has:\n\tcircumference = " + fmt.format(circumference()) + " units"
                + "\n\tsurface area = " + fmt.format(surfaceArea()) + " square units"
                + "\n\tvolume = " + fmt.format(volume()) + " cubic units";
    }
}