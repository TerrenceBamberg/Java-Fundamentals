package ObjectOrientedDesign2.Vehicles;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MotorcycleTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getEngineSize() throws NegativeValueException {
        Motorcycle bike1 = new Motorcycle("Brando, Marlon",
                "1964 Harley-Davidson Duo-Glide", 14000, false, 750);
        assertEquals(750, bike1.getEngineSize(), 0.00001, "Error in getEngineSize: ");
    }

    @Test
    void setEngineSize() throws NegativeValueException {
        Motorcycle bike2 = new Motorcycle("Grants, Payton",
                "2018 BMW C400 GT", 8245, false, 0);
        bike2.setEngineSize(350);
        assertEquals(350, bike2.getEngineSize(), 0.00001, "Error in setEngineSize: ");
    }

    @Test
    void useTax() throws NegativeValueException {
        Motorcycle bike1 = new Motorcycle("Brando, Marlon",
                "1964 Harley-Davidson Sportster", 14000, false, 231);
        assertEquals(70, bike1.useTax(), 0.00001, "Error in useTax: ");
    }

    @Test
    void useTaxAltFuel() throws NegativeValueException {
        Motorcycle bike3 = new Motorcycle("Remes, Joel",
                "2013 Honda PCX", 3790, true, 160);
        assertEquals(9.475, bike3.useTax(), 0.00001, "Error in useTax: ");
    }

    @Test
    void useTaxThreshold() throws NegativeValueException {
        Motorcycle bike4 = new Motorcycle("Hendrix, Perry",
                "2017 Indian Challenger Dark Horse", 35000, false, 1768);
        assertEquals(700, bike4.useTax(), 0.00001, "Error in useTax: ");
    }

    @Test
    void testToString() throws NegativeValueException {
        Motorcycle bike2 = new Motorcycle("Grants, Payton",
                "2018 BMW C400 GT", 8245, false, 350);
        assertEquals("""
                Grants, Payton: Motorcycle 2018 BMW C400 GT
                Value: $8,245.00 Use Tax: $41.23
                with Tax Rate: 0.50%""", bike2.toString());
    }

    @Test
    void testToStringLargeBike() throws NegativeValueException {
        Motorcycle bike1 = new Motorcycle("Brando, Marlon",
                "1964 Harley-Davidson Duo-Glide", 14000, false, 750);
        assertEquals("""
                Brando, Marlon: Motorcycle 1964 Harley-Davidson Duo-Glide
                Value: $14,000.00 Use Tax: $280.00
                with Tax Rate: 0.50% Large Bike Tax Rate: 1.50%""", bike1.toString());
    }

    @Test
    void testToStringLargeBikeAltFuel() throws NegativeValueException {
        Motorcycle bike5 = new Motorcycle("Price, Jason",
                "2016 Yamaha Bolt R", 10000, true, 942);
        assertEquals("""
                Price, Jason: Motorcycle 2016 Yamaha Bolt R (Alternative Fuel)
                Value: $10,000.00 Use Tax: $175.00
                with Tax Rate: 0.25% Large Bike Tax Rate: 1.50%""", bike5.toString());
    }

    @Test
    void testToStringAltFuel() throws NegativeValueException {
        Motorcycle bike3 = new Motorcycle("Remes, Joel",
                "2013 Honda PCX", 3790, true, 160);
        assertEquals("""
                Remes, Joel: Motorcycle 2013 Honda PCX (Alternative Fuel)
                Value: $3,790.00 Use Tax: $9.47
                with Tax Rate: 0.25%""", bike3.toString());
    }
}