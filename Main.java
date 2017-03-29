package FinalDikjstra;

import java.io.IOException;

/*
 * Created by eeliz_000 on 3/28/2017.
 * Main to execute the program
 *
 * How to Use:
 *      Create file object sand specify the input file AND output file
 *      Output file will be the name of the converted file you want
 *      Then get the shortest path of the CONVERTED text file
 *
 * Process of execution:
 *      Create file objects for each text file
 *      Convert given text files to a formatted text file so the program can process them
 *      Output shortest path
 */
public class Main {

    public static void main(String[] args) throws IOException {
        // Create File objects to process the text files
        /*
            file1 : 1000.txt
            file2 : 25000.txt
         */
        File file1 = new File();
       // File file2 = new File();

        // Note: Be sure to change the source vertex if needed in the File class
        file1.convert("1000.txt", "1000converted.txt");
        //file2.convert("25000.txt", "25000converted.txt");

        /*
            Note: Algorithm starts as soon as "Sum for" statement prints
            OUTPUT: Sum for 1000.txt: 625349
         */
        System.out.print("Sum for 1000.txt: ");
        file1.getPath("1000converted.txt");
       // System.out.println();
       // System.out.print("Sum for 25000.txt: ");
       // file2.getPath("25000converted.txt");
    }
}