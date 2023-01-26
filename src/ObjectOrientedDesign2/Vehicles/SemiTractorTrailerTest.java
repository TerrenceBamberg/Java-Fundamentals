package ObjectOrientedDesign2.Vehicles;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SemiTractorTrailerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAxles() throws NegativeValueException {
        SemiTractorTrailer semi1 = new SemiTractorTrailer("Williams, Grant",
                "2012 Mack LR", 123000, false, 5.0, 3);
        assertEquals(3, semi1.getAxles(), "Error in getAxles: ");
    }

    @Test
    void setAxles() throws NegativeValueException {
        SemiTractorTrailer semi1 = new SemiTractorTrailer("Williams, Grant",
                "2012 Mack LR", 123000, false, 5.0, 3);
        semi1.setAxles(6);
        assertEquals(6, semi1.getAxles(), "Error in setAxles: ");
    }

    @Test
    void useTax() throws NegativeValueException {
        SemiTractorTrailer semi1 = new SemiTractorTrailer("Johnson, Travis",
                "2012 Mack LR", 142000, false, 5.0, 3);
        assertEquals(9230.00, semi1.useTax(), 0.00001, "Error in useTax: ");
    }

    @Test
    void useTaxAltFuel() throws NegativeValueException {
        SemiTractorTrailer semi2 = new SemiTractorTrailer("Williams, Grant",
                "2019 Mack LR Electric", 123000, true, 4.5, 3);
        assertEquals(6765, semi2.useTax(), "Error in useTaxAltFuel: ");
    }

    @Test
    void testToString() throws NegativeValueException {
        SemiTractorTrailer semi1 = new SemiTractorTrailer("Johnson, Travis",
                "2012 Mack LR", 142000, false, 5.0, 3);
        assertEquals("""
                        Johnson, Travis: SemiTractorTrailer 2012 Mack LR
                        Value: $142,000.00 Use Tax: $9,230.00
                        with Tax Rate: 2.00% Large Truck Tax Rate: 3.00% Axle Tax Rate: 1.50%""",
                semi1.toString(), "Error in toString: ");
    }

    @Test
    void testToStringAltFuel() throws NegativeValueException {
        SemiTractorTrailer semi2 = new SemiTractorTrailer("Williams, Grant",
                "2019 Mack LR Electric", 123000, true, 4.5, 3);
        assertEquals("""
                        Williams, Grant: SemiTractorTrailer 2019 Mack LR Electric (Alternative Fuel)
                        Value: $123,000.00 Use Tax: $6,765.00
                        with Tax Rate: 1.00% Large Truck Tax Rate: 3.00% Axle Tax Rate: 1.50%""",
                semi2.toString(), "Error in toStringAltFuel: ");
    }
}