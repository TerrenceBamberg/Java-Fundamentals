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

    @org.junit.jupiter.api.Test
    void getLabel() {
        Spherocylinder obj = new Spherocylinder("Example Test", 5, 10);
        assertEquals("Example Test", obj.getLabel());
    }

    @org.junit.jupiter.api.Test
    void setLabel() {
        Spherocylinder obj = new Spherocylinder("Example Test", 5, 10);
        assertTrue(obj.setLabel("New Label Test"));
        assertFalse(obj.setLabel(null));
        assertFalse(obj.setLabel(""));
    }

    @org.junit.jupiter.api.Test
    void getRadius() {
        Spherocylinder obj = new Spherocylinder("Example Test", 5, 10);
        assertEquals(5, obj.getRadius(), 0.001);
    }

    @org.junit.jupiter.api.Test
    void setRadius() {
        Spherocylinder obj = new Spherocylinder("Example Test", 5, 10);
        assertTrue(obj.setRadius(0));
        assertTrue(obj.setRadius(2300));
        assertFalse(obj.setRadius(-2));
    }

    @org.junit.jupiter.api.Test
    void getCylinderHeight() {
        Spherocylinder obj = new Spherocylinder("Example Test", 5, 10);
        assertEquals(10, obj.getCylinderHeight(), 0.001);
    }

    @org.junit.jupiter.api.Test
    void setCylinderHeight() {
        Spherocylinder obj = new Spherocylinder("Example Test", 5, 10);
        assertTrue(obj.setCylinderHeight(0));
        assertTrue(obj.setCylinderHeight(1000));
        assertFalse(obj.setCylinderHeight(-320));
    }

    @org.junit.jupiter.api.Test
    void circumference() {
        Spherocylinder obj = new Spherocylinder("Example Test", 5, 10);
        Spherocylinder obj2 = new Spherocylinder("Example Test2", -5, 10);
        Spherocylinder obj3 = new Spherocylinder("Example Test3", -5, -10);
        assertEquals(31.415, obj.circumference(), 0.001);
        assertEquals(0, obj2.circumference(), 0.001);
        assertEquals(0, obj3.circumference(), 0.001);
    }

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

    @org.junit.jupiter.api.Test
    void getCount() {
        assertEquals(22, Spherocylinder.getCount());
    }

    @org.junit.jupiter.api.Test
    void resetCount() {
        Spherocylinder.resetCount();
        assertEquals(0,
            Spherocylinder.getCount());
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        Spherocylinder obj1 = new Spherocylinder("Example Test", 5, 10);
        Spherocylinder obj2 = new Spherocylinder("Example Test2", 1, 4);
        Spherocylinder obj3 = new Spherocylinder("Example Test", 5, 10);
        assertNotEquals(obj1,obj2);
        assertEquals(obj1,obj3);
    }

    @org.junit.jupiter.api.Test
    void testHashCode() {
        Spherocylinder obj1 = new Spherocylinder("Example Test", 5, 10);
        Spherocylinder obj2 = new Spherocylinder("Example Test2", 1, 4);
        assertEquals(0, obj1.hashCode());
        assertEquals(0, obj2.hashCode());
    }

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
