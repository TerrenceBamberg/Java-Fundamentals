package ObjectOrientedDesign2.Vehicles;

import java.io.FileNotFoundException;

/**
 * Driver class. Creates an instance of UseTaxList, and reads in
 * a file from command line. Calls the readVehicleFile method in the
 * UseTaxList class to read in the data file. Prints the summary,
 * vehicle list by owner, vehicle list by use tax, and the list of
 * excluded records.
 *
 * @author Terrence Bamberg - CPSC 1223 AO2
 * @version 11/29/2019
 */
public class VehiclesPart3 {

    /**
     * Prompts user to enter file name and then prints.
     * @param args - command line arguments.
     */
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("*** File name not provided"
                    + " by command line argument.");
            System.out.print("Program ending.");
            return;
        }

        try {
            UseTaxList list = new UseTaxList();
            list.readVehicleFile(args[0]);

            System.out.println(list.summary() + "\n");
            System.out.println(list.listByOwner() + "\n");
            System.out.println(list.listByUseTax() + "\n");
            System.out.println(list.excludedRecordsList() + "\n");
        }
        catch (FileNotFoundException e) {
            System.out.println("*** File not found.");
            System.out.print("Program ending.");
        }


    }
}
