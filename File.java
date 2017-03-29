package FinalDikjstra;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

/*
 * Created by eeliz_000 on 3/28/2017.
 *
 *  Class file is used to process original text files into another format
 *  New format will allow the text file to be processed by the algorithm
 */
public class File {
    private static Graph<Integer> graph = new Graph<>(false);

    /*
        convert will accept files and convert them to a new format
        used by the Main class
     */
    public static void convert(String origialfile, String outputFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(origialfile));
        //String builder for creating format
        StringBuilder sb = new StringBuilder();
        //Read line by line from text file
        String line = br.readLine();
        String ver = null;
        while (line != null) {
            //split each and every line by spaces
            String[] strLine = line.toString().split(" ");
            // if line has edge
            if (strLine.length == 1 && !strLine[0].equals("")) {
                ver = strLine[0];
            }
            //if line has vertex
            else if (ver != null && strLine.length != 1) {
                String temp = ",";
                for (String str : strLine) {
                    //Condition to ignore white spaces
                    if (!str.equals("")) {
                        temp = temp + str + ",";
                    }
                }
                sb.append(ver + temp.substring(0, temp.length() - 1));
                sb.append(System.lineSeparator());
            }
            line = br.readLine();
        }
        String newContent = sb.toString();

        //Write the new content to file
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(outputFile);
            bw = new BufferedWriter(fw);
            bw.write(newContent);
        } catch (IOException e) {
        }finally{
            bw.close();
            fw.close();
        }
    }

    /*
        getPath is to process the newly converted text file
        Used by the main class
     */
    public static void getPath(String file) {
        Scanner scanner = null;
        int path = 0;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(file)));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {

                String input = scanner.nextLine();
                String[] data = input.split(",");
                int startVertex = Integer.parseInt(data[0]);
                int endVertex = Integer.parseInt(data[1]);
                int weight = Integer.parseInt(data[2]);


                //System.out.println(startVertex + ": " + endVertex + ": " + weight);
                graph.addEdge(startVertex, endVertex, weight);

                // call the DijkstraAlogorithm to process the text files for shortes path
                DijkstraAlgorithm algorithm = new DijkstraAlgorithm();
                // specify the source vertex as 0
                Vertex<Integer> sourceVertex = graph.getVertex(0);
                // map to hold the shortest distance from source
                Map<Vertex<Integer>, Integer> distance = algorithm.shortestPath(graph, sourceVertex);
                // adds the sum from the map to compute shortest path
                int sum = 0;
                for (int f : distance.values()) {
                    sum += f;
                }
                // store shortest path sum in path
                path = sum;
            }

            System.out.println(path);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

    }
}
