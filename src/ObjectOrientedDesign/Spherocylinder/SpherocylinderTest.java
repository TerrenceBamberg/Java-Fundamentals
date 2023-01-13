package ObjectOrientedDesign.Spherocylinder;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Spherocylinder test class.
 * @author Terrence Bamberg - CPSC 1223 AO2
 * @version 10/26/2019
 */

class SpherocylinderTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    /** Get label test **/
    @org.junit.jupiter.api.Test
    void getLabel() {
        Spherocylinder obj = new Spherocylinder("Example Test", 5, 10);
        assertEquals("Example Test", obj.getLabel());
    }

    /** Set label test **/
    @org.junit.jupiter.api.Test
    void setLabel() {
        Spherocylinder obj = new Spherocylinder("Example Test", 5, 10);

        // conditional test: valid
        String label = "Example Test2";
        boolean set = obj.setLabel(label);
        assertTrue(set);

        // conditional test: null
        label = null;
        set = obj.setLabel(label);
        assertFalse(set);

        // conditional test: empty string
        label = "";
        set = obj.setLabel(label);
        assertFalse(set);

        // method tests
        assertTrue(obj.setLabel("New Label Test"));
        assertFalse(obj.setLabel(null));
        assertFalse(obj.setLabel(""));
    }

    /** Get radius test **/
    @org.junit.jupiter.api.Test
    void getRadius() {
        Spherocylinder obj = new Spherocylinder("Example Test", 5, 10);
        assertEquals(5, obj.getRadius(), 0.001);
    }

    /** Set radius test **/
    @org.junit.jupiter.api.Test
    void setRadius() {
        Spherocylinder obj = new Spherocylinder("Example Test", 5, 10);

        // conditional test: > 0
        double radius = 22;
        boolean set = obj.setRadius(radius);
        assertTrue(set);

        // conditional test: == 0
        radius = 0;
        set = obj.setRadius(radius);
        assertTrue(set);

        // conditional test: < 0
        radius = -30;
        set = obj.setRadius(radius);
        assertFalse(set);

        // method tests
        assertTrue(obj.setRadius(0));
        assertTrue(obj.setRadius(2300));
        assertFalse(obj.setRadius(-2));
    }

    /** Get cylinder height test **/
    @org.junit.jupiter.api.Test
    void getCylinderHeight() {
        Spherocylinder obj = new Spherocylinder("Example Test", 5, 10);
        assertEquals(10, obj.getCylinderHeight(), 0.001);
    }

    /** Set cylinder height test **/
    @org.junit.jupiter.api.Test
    void setCylinderHeight() {
        Spherocylinder obj = new Spherocylinder("Example Test", 5, 10);
        assertTrue(obj.setCylinderHeight(0));
        assertTrue(obj.setCylinderHeight(1000));
        assertFalse(obj.setCylinderHeight(-320));
    }

    /** Circumference calculation test **/
    @org.junit.jupiter.api.Test
    void circumference() {
        Spherocylinder obj = new Spherocylinder("Example Test", 5, 10);
        Spherocylinder obj2 = new Spherocylinder("Example Test2", -5, 10);
        Spherocylinder obj3 = new Spherocylinder("Example Test3", -5, -10);
        assertEquals(31.415, obj.circumference(), 0.001);
        assertEquals(0, obj2.circumference(), 0.001);
        assertEquals(0, obj3.circumference(), 0.001);
    }

    /** Surface area calculation test **/
    @org.junit.jupiter.api.Test
    void surfaceArea() {
        Spherocylinder obj = new Spherocylinder("Example Test", 5, 10);
        Spherocylinder obj2 = new Spherocylinder("Example Test2", -5, 10);
        Spherocylinder obj3 = new Spherocylinder("Example Test3", 5, -10);
        Spherocylinder obj4 = new Spherocylinder("Example Test4", -5, -10);
        assertEquals(628.319, obj.surfaceArea(), .001);
        assertEquals(0, obj2.surfaceArea(), 0.001);
        assertEquals(0, obj3.surfaceArea(), 0.001);
        assertEquals(0, obj4.surfaceArea(), 0.001);
    }

    /** Volume calculation test **/
    @org.junit.jupiter.api.Test
    void volume() {
        Spherocylinder obj = new Spherocylinder("Example Test", 5, 10);
        Spherocylinder obj2 = new Spherocylinder("Example Test2", -5, 10);
        Spherocylinder obj3 = new Spherocylinder("Example Test3", 5, -10);
        Spherocylinder obj4 = new Spherocylinder("Example Test4", -5, -10);
        assertEquals(1308.997, obj.volume(), .001);
        assertEquals(0, obj2.volume(), 0.001);
        assertEquals(0, obj3.volume(), 0.001);
        assertEquals(0, obj4.volume(), 0.001);
    }

    /** Spherocylinder count test **/
    @org.junit.jupiter.api.Test
    void getCount() {
        assertEquals(22, Spherocylinder.getCount());
    }

    /** Reset spherocylinder count test **/
    @org.junit.jupiter.api.Test
    void resetCount() {
        Spherocylinder.resetCount();
        assertEquals(0,
            Spherocylinder.getCount());
    }

    /** Object equality test **/
    @org.junit.jupiter.api.Test
    void testEquals() {
        Spherocylinder obj1 = new Spherocylinder("Example Test", 5, 10);
        Spherocylinder obj2 = new Spherocylinder("Example Test2", 1, 4);
        Spherocylinder obj3 = new Spherocylinder("Example Test", 5, 10);
        assertNotEquals(obj1,obj2);
        assertEquals(obj1,obj3);
    }

    /** Hashcode value test **/
    @org.junit.jupiter.api.Test
    void testHashCode() {
        Spherocylinder obj1 = new Spherocylinder("Example Test", 5, 10);
        Spherocylinder obj2 = new Spherocylinder("Example Test2", 1, 4);
        assertEquals(0, obj1.hashCode());
        assertEquals(0, obj2.hashCode());
    }

    /** Compare to test **/
    @org.junit.jupiter.api.Test
    void testCompareTo() {
        Spherocylinder obj = new Spherocylinder("Example Test", 5, 10);
        Spherocylinder obj2 = new Spherocylinder("Example Test2", -5, 10);
        Spherocylinder obj3 = new Spherocylinder("Example Test3", 5, -10);
        Spherocylinder obj4 = new Spherocylinder("Example Test4", 5, 10);
        assertTrue(obj.compareTo(obj2) > 0);
        assertTrue(obj3.compareTo(obj) < 0);
        assertEquals(0, obj.compareTo(obj4));
    }

    /** toString test **/
    @org.junit.jupiter.api.Test
    void testToString() {
        Spherocylinder obj = new Spherocylinder("Example Test", 5, 10);
        assertEquals("""
            Spherocylinder "Example Test" with radius 5.0 and cylinder height 10.0 has:
            \tcircumference = 31.416 units
            \tsurface area = 628.319 square units
            \tvolume = 1,308.997 cubic units""", obj.toString());
    }
}
