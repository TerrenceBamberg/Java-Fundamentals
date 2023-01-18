package ObjectOrientedDesign2.Vehicles;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getTons() throws NegativeValueException {
        Truck truck1 = new Truck("Jones, Jerry", "2015 Chevy Silverado", 40000.00, true, 3);
        assertEquals(3, truck1.getTons(), 0.00001, "Error in getTons: ");
    }

    @Test
    void setTons() throws NegativeValueException {
        Truck truck1 = new Truck("Jones, Jerry", "2015 Chevy Silverado", 40000.00, true, 3);
        truck1.setTons(4);
        assertEquals(4, truck1.getTons(), 0.00001, "Error in getTons: ");
    }

    @Test
    void useTax() throws NegativeValueException {
        Truck truck1 = new Truck("Jones, Jerry", "2015 Chevy Silverado", 40000.00, false, 1);
        assertEquals(800.00, truck1.useTax(), 0.00001, "Error in useTax: ");
    }

    @Test
    void useTaxAltFuel() throws NegativeValueException {
        Truck truck2 = new Truck("Mender, Blake", "2015 Ford Ranger", 27000.00, true, 1);
        assertEquals(270.0, truck2.useTax(), 0.00001, "Error in useTax: ");
    }

    @Test
    void useTaxThreshold() throws NegativeValueException {
        Truck truck3 = new Truck("Mender, Blake", "2018 Ford Raptor", 82000.00, false, 1);
        assertEquals(1640.0, truck3.useTax(), 0.00001, "Error in useTax: ");
    }

    @Test
    void useTaxThresholdAltFuel() throws NegativeValueException {
        Truck truck4 = new Truck("Pront, Chris", "2019 Rivian R1T", 78000.00, true, 1);
        assertEquals(780.0, truck4.useTax(), 0.00001, "Error in useTax: ");
    }

    @Test
    void testToString() throws NegativeValueException {
        Truck truck6 = new Truck("Mender, Blake", "2010 Ford F150", 30000.00, false, 1);
        assertEquals("""
            Mender, Blake: Truck 2010 Ford F150
            Value: $30,000.00 Use Tax: $600.00
            with Tax Rate: 2.00%""", truck6.toString());
    }

    @Test
    void testToStringLargeTruck() throws NegativeValueException {
        Truck truck5 = new Truck("Freeman, Joseph", "2014 F350", 90000.00, false, 2.5);
        assertEquals("""
                Freeman, Joseph: Truck 2014 F350
                Value: $90,000.00 Use Tax: $4,500.00
                with Tax Rate: 2.00% Large Truck Tax Rate: 3.00%""", truck5.toString());
    }

    @Test
    void testToStringAltFuel() throws NegativeValueException {
        Truck truck1 = new Truck("Jones, Jerry", "2019 Rivian R1T", 78000.00, true, 1);
        assertEquals("""
                Jones, Jerry: Truck 2019 Rivian R1T (Alternative Fuel)
                Value: $78,000.00 Use Tax: $780.00
                with Tax Rate: 1.00%""", truck1.toString());
    }

    @Test
    void testToStringLargeTruckAltFuel() throws NegativeValueException {
        Truck truck6 = new Truck("Reed, Logan", "2012 F250e", 92000.00, true, 2.2);
        assertEquals("""
                Reed, Logan: Truck 2012 F250e (Alternative Fuel)
                Value: $92,000.00 Use Tax: $3,680.00
                with Tax Rate: 1.00% Large Truck Tax Rate: 3.00%""", truck6.toString());
    }
}