package ObjectOrientedDesign2.Vehicles;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

/**
 * The UseTaxList class provides methods for reading in data and
 * generating reports (summary and list), adding a Vehicle, and
 * sorting the vehicles by owner and by use tax amount.
 *
 * @author Terrence Bamberg - CPSC 1223 AO2
 *
 */
public class UseTaxList {

    private String taxDistrict;
    private ArrayList<Vehicle> vehicleList;
    private ArrayList<String> excludedRecords;

    /**
     * Constructor initializes variables.
     */
    public UseTaxList() {
        taxDistrict = "not yet assigned";
        vehicleList = new ArrayList<>();
        excludedRecords = new ArrayList<>();
    }

    /**
     * Reads in a vehicle file as string. Determines the category of the
     * vehicle based on a character in the data file.
     * @param fileNameIn name of the input file
     * @throws FileNotFoundException if not file found
     */
    public void readVehicleFile(String fileNameIn) throws FileNotFoundException {
        File inputFile = new File(fileNameIn);
        Scanner fileScan = new Scanner(inputFile);
        taxDistrict = fileScan.nextLine();

        while (fileScan.hasNext()) {
            String vehicle = fileScan.nextLine().trim();
            try {
                Scanner lineIn = new Scanner(vehicle).useDelimiter(";");
                char vehicleType = lineIn.next().trim().toUpperCase().charAt(0);
                String owner = lineIn.next().trim();
                String yearMakeModel = lineIn.next().trim();
                double value = Double.parseDouble(lineIn.next().trim());
                String sAltFuel = lineIn.next().trim().toLowerCase();
                boolean altFuel = sAltFuel.equals("true");

                switch (vehicleType) {
                    case 'C' -> {
                        Car c = new Car(owner, yearMakeModel, value, altFuel);
                        addVehicle(c);
                    }
                    case 'T' -> {
                        double tons = Double.parseDouble(lineIn.next().trim());
                        Truck t = new Truck(owner, yearMakeModel, value, altFuel,
                                tons);
                        addVehicle(t);
                    }
                    case 'S' -> {
                        double tons2 = Double.parseDouble(lineIn.next().trim());
                        int axle = Integer.parseInt(lineIn.next().trim());
                        SemiTractorTrailer s = new SemiTractorTrailer(owner,
                                yearMakeModel, value, altFuel, tons2, axle);
                        addVehicle(s);
                    }
                    case 'M' -> {
                        double engineSize = Double.parseDouble(lineIn.next().trim());
                        Motorcycle m = new Motorcycle(owner, yearMakeModel, value,
                                altFuel, engineSize);
                        addVehicle(m);
                    }
                    default -> addExcludedRecord("Invalid Vehicle Category in:\n " + vehicle);
                }
            }
            catch (NegativeValueException | NoSuchElementException | NumberFormatException e) {
                addExcludedRecord(e.getClass().getSimpleName() + " in:\n" + vehicle);
            }
        }
    }
    /**
     * String representation of the tax district name.
     * @return Name of tax district
     */
    public String getTaxDistrict() {
        return taxDistrict;
    }

    /**
     * Sets the tax district.
     * @param taxDistrictIn tax district name
     */
    public void setTaxDistrict(String taxDistrictIn) {
        taxDistrict = taxDistrictIn;
    }

    /**
     * Return the vehicle list.
     * @return vehicle list
     */
    public ArrayList<Vehicle> getVehicleList() {
        return vehicleList;
    }

    /**
     * Returns the excluded records list.
     * @return excluded records
     */
    public ArrayList<String> getExcludedRecords() {
        return excludedRecords;
    }

    /**
     * Adds a vehicle to vehicle list
     * @param vehicleIn vehicle to be added
     */
    public void addVehicle(Vehicle vehicleIn) {
        vehicleList.add(vehicleIn);
    }

    /**
     * Adds record to the excluded records list
     * @param recordIn excluded vehicle record
     */
    public void addExcludedRecord(String recordIn) {
        excludedRecords.add(recordIn);
    }

    /**
     * String representation each vehicle in vehicleList.
     * @return output
     */
    public String toString() {
        String output = "";
        for (Vehicle v : vehicleList) {
            output += "\n" + v + "\n";
        }
        return output;
    }

    /**
     * Calculates total useTax for all vehicles in vehicleList.
     * @return total use tax
     */
    public double calculateTotalUseTax() {
        double total = 0;
        for (Vehicle v : vehicleList) {
            total += v.useTax();
        }
        return total;
    }

    /**
     * Calculates total value for all vehicles in vehicleList.
     * @return total value
     */
    public double calculateTotalValue() {
        double total = 0;
        for (Vehicle v : vehicleList) {
            total += v.getValue();
        }
        return total;
    }

    /**
     * String representation of summary information for the tax district.
     * Includes tax district name, total number of vehicles, total value for
     * all vehicles and total use tax for all vehicles.
     * @return output
     */
    public String summary() {
        DecimalFormat fmt = new DecimalFormat("$###,###.00");
        return  "------------------------------"
                + "\nSummary for " + taxDistrict
                + "\n------------------------------"
                + "\nNumber of Vehicles: " + vehicleList.size()
                + "\nTotal Value: " + fmt.format(calculateTotalValue())
                + "\nTotal Use Tax: " + fmt.format(calculateTotalUseTax()) + "\n";
    }

    /**
     * String representation of all vehicle listed by owner natural ordering.
     * Includes owner and all vehicle information.
     * @return output
     */
    public String listByOwner() {
        String output = """
                ------------------------------
                Vehicles by Owner
                ------------------------------""";

        for (Vehicle v : vehicleList) {
            output += "\n" + v + "\n";
        }
        return output;
    }

    /**
     * String representation of all vehicle listed by use tax natural ordering.
     * Includes owner and all vehicle information.
     * @return output
     */
    public String listByUseTax() {
        vehicleList.sort(new UseTaxComparator());
        String output = """
                ------------------------------
                Vehicles by Use Tax
                ------------------------------""";
        for (Vehicle v : vehicleList) {
            output += "\n" + v + "\n";
        }
        return output;
    }

    /**
     * String representation of all excluded vehicles from vehicle array.
     * Includes owner and all vehicle information.
     * @return output
     */
    public String excludedRecordsList() {
        String output = """
                ------------------------------
                Excluded Records
                ------------------------------""";
        for (String v : excludedRecords) {
            output += "\n" + v + "\n";
        }
        return output;
    }
}

