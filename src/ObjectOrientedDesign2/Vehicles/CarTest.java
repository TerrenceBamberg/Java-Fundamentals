package ObjectOrientedDesign2.Vehicles;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class CarTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }
    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void compareTo() throws NegativeValueException {
        Car car1 = new Car("Smith, Jack", "2017 Honda Accord",
                111000, false);
        Car car2 = new Car("Smith, Jack", "2017 Honda Accord",
                111000, false);
        assertEquals(0, car1.compareTo(car2));
    }

    @Test
    void getOwner() throws NegativeValueException {
        Car car1 = new Car("Smith, Jack", "2015 Mercedes-Benz Coupe",
                110000, true);
        assertEquals("Smith, Jack", car1.getOwner(), "Error in getOwner: ");
    }

    @Test
    void setOwner() throws NegativeValueException {
        Car car1 = new Car("Smith, Jack", "2015 Mercedes-Benz Coupe",
                110000, true);
        car1.setOwner("Patterson, Johnny");
        assertEquals( "Patterson, Johnny", car1.getOwner(), "Error in setOwner: ");
    }

    @Test
    void getYearMakeModel() throws NegativeValueException {
        Car car1 = new Car("Smith, Jack", "2015 Mercedes-Benz Coupe",
                110000, true);
        assertEquals(
                "2015 Mercedes-Benz Coupe", car1.getYearMakeModel(),
                "Error in getYearMakeModel: ");
    }

    @Test
    void setYearMakeModel() throws NegativeValueException {
        Car car1 = new Car("Smith, Jack", "2015 Mercedes-Benz Coupe",
                110000, true);
        car1.setYearMakeModel("2017 BMW M6");
        assertEquals("2017 BMW M6", car1.getYearMakeModel(), "Error in setYearMakeModel: ");
    }

    @Test
    void getValue() throws NegativeValueException {
        Car car1 = new Car("Smith, Jack", "2015 Mercedes-Benz Coupe",
                110000, true);
        assertEquals(110000,
                car1.getValue(), 0.00001, "Error in getValue: ");
    }

    @Test
    void setValue() throws NegativeValueException {
        Car car1 = new Car("Smith, Jack", "2015 Mercedes-Benz Coupe",
                110000, true);
        car1.setValue(115999);
        assertEquals(115999,
                car1.getValue(), 0.00001, "Error in setValue: ");
    }

    @Test
    void getAltFuel() throws NegativeValueException {
        Car car1 = new Car("Smith, Jack", "2015 Mercedes-Benz Coupe",
                110000, true);
        assertTrue(car1.getAltFuel(), "Error in getAltFuel: ");
    }

    @Test
    void setAltFuel() throws NegativeValueException {
        Car car1 = new Car("Smith, Jack", "2015 Mercedes-Benz Coupe",
                110000, false);
        car1.setAltFuel(true);
        assertTrue(car1.getAltFuel(), "Error in setAltFuel: ");
    }

    @Test
    void getVehicleCount() {
        assertEquals(5, Vehicle.getVehicleCount(), "Error in getVehicleCount: ");
    }

    @Test
    void resetVehicleCount() {
        Vehicle.resetVehicleCount();
        assertEquals(0, Vehicle.getVehicleCount(), "Error in resetVehicleCount: ");
    }

    @Test
    void testEquals() throws NegativeValueException {
        Car car1 = new Car("Smith, John", "2017 Honda Accord",
                111000, false);
        Car car2 = new Car("Smith, John", "2017 Honda Accord",
                111000, false);
        Car car3 = new Car("Lee, Jason", "2015 Mercedes-Benz Coupe",
                68999, true);
        Motorcycle bike1 = new Motorcycle("Brando, Marlon",
                "1964 Harley-Davidson Sportster", 14000, false, 750);
        assertEquals(car1, car2, "Error in testEquals (equals): ");
        assertNotEquals(car1, car3, "Error in testEquals (not equals): ");
        assertNotEquals(car1, bike1, "Error in testEquals (not a car): ");
    }

    @Test
    void testHashCode() throws NegativeValueException {
        Car car1 = new Car("Smith, John", "2017 Honda Accord",
                111000, false);
        Car car2 = new Car("Smith, John", "2017 Honda Accord",
                111000, false);
        assertEquals(car1.hashCode(), car2.hashCode(), "Error in testHashCode: ");
    }

    @Test
    void useTax() throws NegativeValueException {
        Car car4 = new Car("Smith, Jack", "2015 Mercedes-Benz Coupe",
                45000, false);
        assertEquals(450.00, car4.useTax(), 0.0001, "Error in useTax: ");
    }

    @Test
    void useTaxAltFuel() throws NegativeValueException {
        Car car4 = new Car("Smith, Jack", "2015 Mercedes-Benz Coupe",
            45000, true);
        assertEquals( 225.00, car4.useTax(), 0.0001, "Error in useTaxAltFuel: ");
    }

    @Test
    void useTaxThreshold() throws NegativeValueException {
        Car car4 = new Car("Smith, Jack", "2019 Rolls Royce Phantom",
                320000, false);
        assertEquals( 9600.00, car4.useTax(), 0.0001, "Error in useTaxThreshold: ");
    }

    @Test
    void toStringTest() throws NegativeValueException {
        Car car1 = new Car("Davis, Brian", "2018 Ford Fusion",
                45000, true);
        assertEquals("""
                Davis, Brian: Car 2018 Ford Fusion (Alternative Fuel)
                Value: $45,000.00 Use Tax: $225.00
                with Tax Rate: 0.5%""", car1.toString(), "Error in toStringTest: ");
    }

    @Test
    void toStringLuxury() throws NegativeValueException {
        Car car1 = new Car("Smith, Jack", "2015 Mercedes-Benz Coupe",
                110000, false);
        assertEquals("""
                Smith, Jack: Car 2015 Mercedes-Benz Coupe
                Value: $110,000.00 Use Tax: $3,300.00
                with Tax Rate: 1.0% Luxury Tax Rate: 2.0%""", car1.toString(),
                "Error in toStringLuxury: ");
    }

    @Test
    void toStringAltFuel() throws NegativeValueException {
        Car car1 = new Car("Davis, Brian", "2018 Ford Fusion",
                45000, true);
        assertEquals("""
                Davis, Brian: Car 2018 Ford Fusion (Alternative Fuel)
                Value: $45,000.00 Use Tax: $225.00
                with Tax Rate: 0.5%""", car1.toString(), "Error in toStringAltFuel: ");
    }

    @Test
    void toStringAltFuelLuxury() throws NegativeValueException {
        Car car1 = new Car("Smith, Jack", "2015 Mercedes-Benz Coupe",
                110000, true);
        assertEquals("""
                Smith, Jack: Car 2015 Mercedes-Benz Coupe (Alternative Fuel)
                Value: $110,000.00 Use Tax: $2,750.00
                with Tax Rate: 0.5% Luxury Tax Rate: 2.0%""", car1.toString(),
                "Error in toStringAltFuelLuxury: ");
    }
}