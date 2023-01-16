package ObjectOrientedDesign.Spherocylinder;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class SpherocylinderListTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    /** Test for getName. **/
    @Test public void getNameTest() {
        Spherocylinder s1 = new Spherocylinder("Ex1", 2, 3);
        Spherocylinder s2 = new Spherocylinder("Ex2", 3, 6);
        Spherocylinder s3 = new Spherocylinder("Ex3", 6, 10);
        ArrayList<Spherocylinder> sObjArray = new ArrayList<>();
        sObjArray.add(s1);
        sObjArray.add(s2);
        sObjArray.add(s3);
        SpherocylinderList sL = new SpherocylinderList("List1", sObjArray, 3);
        assertEquals("List1", sL.getName());
    }

    /** Test for numberOfSpherocylinders. **/
    @Test public void numberOfSpherocylindersTest() {
        Spherocylinder s1 = new Spherocylinder("Ex1", 2, 3);
        Spherocylinder s2 = new Spherocylinder("Ex2", 3, 6);
        Spherocylinder s3 = new Spherocylinder("Ex3", 6, 10);
        ArrayList<Spherocylinder> sObjArray = new ArrayList<>();
        sObjArray.add(s1);
        sObjArray.add(s2);
        sObjArray.add(s3);
        SpherocylinderList sL = new SpherocylinderList("List1", sObjArray, 3);
        assertEquals(3, sL.numberOfSpherocylinders());
    }

    /** Test for totalSurfaceArea. **/
    @Test public void totalSurfaceAreaTest() {
        Spherocylinder s1 = new Spherocylinder("Ex1", 1, 1);
        Spherocylinder s2 = new Spherocylinder("Ex2", 1, 1);
        Spherocylinder s3 = new Spherocylinder("Ex3", 1, 1);
        ArrayList<Spherocylinder> sObjArray = new ArrayList<>();
        sObjArray.add(s1);
        sObjArray.add(s2);
        sObjArray.add(s3);
        SpherocylinderList sL = new SpherocylinderList("List1", sObjArray, 3);
        assertEquals(56.5488, sL.totalSurfaceArea(), 0.001);
    }

    /** Test for totalVolume. **/
    @Test public void totalVolumeTest() {
        Spherocylinder s1 = new Spherocylinder("Ex1", 1, 1);
        Spherocylinder s2 = new Spherocylinder("Ex2", 1, 1);
        Spherocylinder s3 = new Spherocylinder("Ex3", 1, 1);
        ArrayList<Spherocylinder> sObjArray = new ArrayList<>();
        sObjArray.add(s1);
        sObjArray.add(s2);
        sObjArray.add(s3);
        SpherocylinderList sL = new SpherocylinderList("List1", sObjArray, 3);
        assertEquals(21.9911, sL.totalVolume(), 0.001);
    }

    /** Test for averageSurfaceArea. **/
    @Test public void averageSurfaceAreaTest() {
        Spherocylinder s1 = new Spherocylinder("Ex1", 1, 1);
        Spherocylinder s2 = new Spherocylinder("Ex2", 1, 1);
        Spherocylinder s3 = new Spherocylinder("Ex3", 1, 1);
        ArrayList<Spherocylinder> sObjArray = new ArrayList<>();
        sObjArray.add(s1);
        sObjArray.add(s2);
        sObjArray.add(s3);
        SpherocylinderList sL = new SpherocylinderList("List1", sObjArray, 3);
        assertEquals(18.8496, sL.averageSurfaceArea(), 0.001);
    }

    /** Test for averageSurfaceArea with 0. **/
    @Test public void averageSurfaceAreaTest2() {
        Spherocylinder s1 = new Spherocylinder("Ex1", 1, 1);
        Spherocylinder s2 = new Spherocylinder("Ex2", 1, 1);
        Spherocylinder s3 = new Spherocylinder("Ex3", 1, 1);
        ArrayList<Spherocylinder> sObjArray = new ArrayList<>();
        sObjArray.add(s1);
        sObjArray.add(s2);
        sObjArray.add(s3);
        SpherocylinderList sL = new SpherocylinderList("List1", sObjArray, 0);
        assertEquals(0, sL.averageSurfaceArea(), 0.001);
    }

    /** Test for averageSurfaceArea with -1. **/
    @Test public void averageSurfaceAreaTest3() {
        Spherocylinder s1 = new Spherocylinder("Ex1", 1, 1);
        Spherocylinder s2 = new Spherocylinder("Ex2", 1, 1);
        Spherocylinder s3 = new Spherocylinder("Ex3", 1, 1);
        ArrayList<Spherocylinder> sObjArray = new ArrayList<>();
        sObjArray.add(s1);
        sObjArray.add(s2);
        sObjArray.add(s3);
        SpherocylinderList sL = new SpherocylinderList("List1", sObjArray, -1);
        assertEquals(0, sL.averageSurfaceArea(), 0.001);
    }


    /** Test for averageVolume. **/
    @Test public void averageVolumeTest() {
        Spherocylinder s1 = new Spherocylinder("Ex1", 1, 1);
        Spherocylinder s2 = new Spherocylinder("Ex2", 1, 1);
        Spherocylinder s3 = new Spherocylinder("Ex3", 1, 1);
        ArrayList<Spherocylinder> sObjArray = new ArrayList<>();
        sObjArray.add(s1);
        sObjArray.add(s2);
        sObjArray.add(s3);
        SpherocylinderList sL = new SpherocylinderList("List1", sObjArray, 3);
        assertEquals(7.3304, sL.averageVolume(), 0.001);
    }

    /** Test for averageVolume with 0. **/
    @Test public void averageVolumeTest2() {
        Spherocylinder s1 = new Spherocylinder("Ex1", 1, 1);
        Spherocylinder s2 = new Spherocylinder("Ex2", 1, 1);
        Spherocylinder s3 = new Spherocylinder("Ex3", 1, 1);
        ArrayList<Spherocylinder> sObjArray = new ArrayList<>();
        sObjArray.add(s1);
        sObjArray.add(s2);
        sObjArray.add(s3);
        SpherocylinderList sL = new SpherocylinderList("List1", sObjArray, 0);
        assertEquals(0, sL.averageVolume(), 0.001);
    }

    /** Test for averageSurfaceArea with -1. **/
    @Test public void averageVolumeTest3() {
        Spherocylinder s1 = new Spherocylinder("Ex1", 1, 1);
        Spherocylinder s2 = new Spherocylinder("Ex2", 1, 1);
        Spherocylinder s3 = new Spherocylinder("Ex3", 1, 1);
        ArrayList<Spherocylinder> sObjArray = new ArrayList<>();
        sObjArray.add(s1);
        sObjArray.add(s2);
        sObjArray.add(s3);
        SpherocylinderList sL = new SpherocylinderList("List1", sObjArray, -1);
        assertEquals(0, sL.averageSurfaceArea(), 0.001);
    }

    /** Test for toString. **/
    @Test public void toStringTest() {
        Spherocylinder s1 = new Spherocylinder("Ex1", 1, 1);
        Spherocylinder s2 = new Spherocylinder("Ex2", 1, 1);
        Spherocylinder s3 = new Spherocylinder("Ex3", 1, 1);
        ArrayList<Spherocylinder> sObjArray = new ArrayList<>();
        sObjArray.add(s1);
        sObjArray.add(s2);
        sObjArray.add(s3);
        SpherocylinderList sL = new SpherocylinderList("List1", sObjArray, 3);
        assertEquals( """
                ----- Summary for List1 -----
                Number of Spherocylinders: 3
                Total Surface Area: 56.549
                Total Volume: 21.991
                Average Surface Area: 18.85
                Average Volume: 7.33""", sL.toString());
    }

    /** Test for getList. **/
    @Test public void getListTest() {
        Spherocylinder s1 = new Spherocylinder("Ex1", 1, 1);
        Spherocylinder s2 = new Spherocylinder("Ex2", 1, 1);
        Spherocylinder s3 = new Spherocylinder("Ex3", 1, 1);
        ArrayList<Spherocylinder> sObjArray = new ArrayList<>();
        sObjArray.add(s1);
        sObjArray.add(s2);
        sObjArray.add(s3);
        SpherocylinderList sL = new SpherocylinderList("List1", sObjArray, 3);
        assertEquals(sObjArray,sL.getList());
    }
    /** Test for addSpherocylinder. **/
    @Test public void addSpherocylinderTest() {
        Spherocylinder s1 = new Spherocylinder("Ex1", 1, 1);
        Spherocylinder s2 = new Spherocylinder("Ex2", 1, 1);
        Spherocylinder s3 = new Spherocylinder("Ex3", 1, 1);
        ArrayList<Spherocylinder> sObjArray = new ArrayList<>(10);
        sObjArray.add(s1);
        sObjArray.add(s2);
        sObjArray.add(s3);
        SpherocylinderList sL = new SpherocylinderList("List1", sObjArray, 3);
        sL.addSpherocylinder("Ex4", 1, 1);
        assertEquals( 4, sL.numberOfSpherocylinders());
    }

    /** Test for findSpherocylinder found. **/
    @Test public void findSpherocylinderTest() {
        Spherocylinder s1 = new Spherocylinder("Ex1", 1, 1);
        Spherocylinder s2 = new Spherocylinder("Ex2", 1, 1);
        Spherocylinder s3 = new Spherocylinder("Ex3", 1, 1);
        ArrayList<Spherocylinder> sObjArray = new ArrayList<>();
        sObjArray.add(s1);
        sObjArray.add(s2);
        sObjArray.add(s3);
        SpherocylinderList sL = new SpherocylinderList("List1", sObjArray, 3);
        assertEquals(s2, sL.findSpherocylinder("EX2"));
    }

    /** Test for findSpherocylinder not found. **/
    @Test public void findSpherocylinderTest2() {
        Spherocylinder s1 = new Spherocylinder("Ex1", 1, 1);
        Spherocylinder s2 = new Spherocylinder("Ex2", 1, 1);
        Spherocylinder s3 = new Spherocylinder("Ex3", 1, 1);
        ArrayList<Spherocylinder> sObjArray = new ArrayList<>();
        sObjArray.add(s1);
        sObjArray.add(s2);
        sObjArray.add(s3);
        SpherocylinderList sL = new SpherocylinderList("List1", sObjArray, 3);
        assertNull(sL.findSpherocylinder("E2"));
    }

    /** Test for deleteSpherocylinder found. **/
    @Test public void deleteSpherocylinderTest() {
        Spherocylinder s1 = new Spherocylinder("Ex1", 1, 1);
        Spherocylinder s2 = new Spherocylinder("Ex2", 1, 1);
        Spherocylinder s3 = new Spherocylinder("Ex3", 1, 1);
        ArrayList<Spherocylinder> sObjArray = new ArrayList<>();
        sObjArray.add(s1);
        sObjArray.add(s2);
        sObjArray.add(s3);
        SpherocylinderList sL = new SpherocylinderList("List1", sObjArray, 3);
        assertEquals(s2, sL.deleteSpherocylinder("EX2"));
    }

    /** Test for deleteSpherocylinder not found. **/
    @Test public void deleteSpherocylinderTest2() {
        Spherocylinder s1 = new Spherocylinder("Ex1", 1, 1);
        Spherocylinder s2 = new Spherocylinder("Ex2", 1, 1);
        Spherocylinder s3 = new Spherocylinder("Ex3", 1, 1);
        ArrayList<Spherocylinder> sObjArray = new ArrayList<>();
        sObjArray.add(s1);
        sObjArray.add(s2);
        sObjArray.add(s3);
        SpherocylinderList sL = new SpherocylinderList("List1", sObjArray, 3);
        assertNull(sL.deleteSpherocylinder("E4"));
    }

    /** Test for editSpherocylinder found. **/
    @Test public void editSpherocylinderTest() {
        Spherocylinder s1 = new Spherocylinder("Ex1", 1, 1);
        Spherocylinder s2 = new Spherocylinder("Ex2", 1, 1);
        Spherocylinder s3 = new Spherocylinder("Ex3", 1, 1);
        ArrayList<Spherocylinder> sObjArray = new ArrayList<>();
        sObjArray.add(s1);
        sObjArray.add(s2);
        sObjArray.add(s3);
        SpherocylinderList sL = new SpherocylinderList("List1", sObjArray, 3);
        boolean found = sL.editSpherocylinder("Ex1", 2, 4);
        assertTrue(found);
    }

    /** Test for editSpherocylinder not found. **/
    @Test public void editSpherocylinderTest2() {
        Spherocylinder s1 = new Spherocylinder("Ex1", 1, 1);
        Spherocylinder s2 = new Spherocylinder("Ex2", 1, 1);
        Spherocylinder s3 = new Spherocylinder("Ex3", 1, 1);
        ArrayList<Spherocylinder> sObjArray = new ArrayList<>();
        sObjArray.add(s1);
        sObjArray.add(s2);
        sObjArray.add(s3);
        SpherocylinderList sL = new SpherocylinderList("List1", sObjArray, 3);
        boolean found = sL.editSpherocylinder("Ex4,", 2, 4);
        assertFalse(found);
    }

    /** Test for findSpherocylinderWithLargestVolume. **/
    @Test public void findSpherocylinderWithLargestVolumeTest() {
        Spherocylinder s1 = new Spherocylinder("Ex1", 10, 33);
        Spherocylinder s2 = new Spherocylinder("Ex2", 21, 6);
        Spherocylinder s3 = new Spherocylinder("Ex3", 43, 14);
        ArrayList<Spherocylinder> sObjArray = new ArrayList<>();
        sObjArray.add(s1);
        sObjArray.add(s2);
        sObjArray.add(s3);
        SpherocylinderList sL = new SpherocylinderList("List1", sObjArray, 3);
        assertEquals(s3, sL.findSpherocylinderWithLargestVolume());

        ArrayList<Spherocylinder> sObjArray2 = new ArrayList<>();
        SpherocylinderList sL2 = new SpherocylinderList("List1", sObjArray2, 0);
        assertNull(sL2.findSpherocylinderWithLargestVolume());
    }
}