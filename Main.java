package FinalDikjstra;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        File file1 = new File();
       // File file2 = new File();

        // Note: Be sure to change the source vertex if needed in the File class
        file1.convert("1000.txt", "1000converted.txt");
        //file2.convert("25000.txt", "25000converted.txt");

        /*
            Note: Algorithm starts as soon as "Sum for" statement prints
         */
        System.out.print("Sum for 1000.txt: ");
        file1.getPath("1000converted.txt");
       // System.out.println();
       // System.out.print("Sum for 25000.txt: ");
       // file2.getPath("25000converted.txt");
    }


}