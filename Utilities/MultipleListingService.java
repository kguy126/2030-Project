package Utilities;

import Model.Land;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MultipleListingService {
    public static void createMlsRecord(Land property) throws IOException {
        try {
            FileWriter mls = new FileWriter("data/mls.txt",true); //
            mls.write(property.getMlsEntry() + "\n");
            mls.close(); // close file when done writing to it
        } catch (IOException err) {
            System.out.println("Error occurred while writing to mls.txt");
            err.printStackTrace(); // useful for finding problems in case of error
        }
    }


}
