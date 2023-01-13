package ObjectOrientedDesign.Spherocylinder;

import java.text.DecimalFormat;

/**
 * Represents a spherocylinder with a label, radius, and cylinder height.
 * @author Terrence Bamberg - CPSC 1223 AO2
 * @version 10/23/2019
 */

public class Spherocylinder {
    private String label = "";
    private double radius = 0;
    private double cylinderHeight = 0;
    private static int count = 0;

    /**
     * Constructor sets label, radius and cylinder of spherocylinder object.
     * @param labelIn for spherocylinder label attribute
     * @param radiusIn for radius attribute
     * @param cylinderHeightIn for cylinder height attribute
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
     * Instance method to set label of spherocylinder.
     * @param labelIn for label
     * @return true if label was set
     */
    public Boolean setLabel(String labelIn) {
        boolean isSet = false;
        if (labelIn != null) {
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
     * @param radiusIn for radius
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
     * @param cylinderHeightIn for cylinder height
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
     * Instance method to calculate circumference of spherocylinder.
     * @return circmf
     */
    public double circumference() {
        return 2 * Math.PI * radius;

    }

    /**
     * Instance method to calculate surface area of spherocylinder.
     * @return surfArea
     */
    public double surfaceArea() {
        return 2 * Math.PI * radius * (2 * radius + cylinderHeight);
    }

    /**
     * Instance method to calculate volume of spherocylinder.
     * @return vol
     */
    public double volume() {
        return Math.PI * Math.pow(radius, 2) * ((4.0 / 3) * radius + cylinderHeight);
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
     * Instance method to see if two spherocylinder objects have the same values.
     * @param sObj for a spherocylinder object
     * @return false if not a spherocylinder or values are not the same and true if matching values
     */
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