************************************************
Program Information and How to Use
************************************************

The following program computes the shortest path from a source to all other nodes of a graph using
Dijkstra's Algorithm with Binary Heaps.

The graph will be constructed given required text files for the input which will depict nodes and vertices.
Input text files:
    1000.txt
    25000.txt

These text files however will be converted to a new format in order for the algorithm to read and compute the shortest path
Converted format:
    startVertex,endVertex,edgeWight

To execute, in the Main class, create a file object for each text file.
Then use the convert method to convert the file by specifying the input file name AND the output file name
I have already specified the name of the output file for the 1000.txt as 1000converted.txt. The 1000converted will be
made in the project folder during the converting process.

Use the OUTPUT file name as the input to compute the shortest path.
Shortest path will use the getPath method from the file class. The output file will be the argument for this method.

************************************************
Program Structure
************************************************

Classes:
    Main - For user execution
    Graph - To construct the graph with given vertices and edges
    Vertex  - To create vertex objects for the graph
    Edge - To create edge objects for the graph
    DijkstraAlgorithm - To compute the shortest path
    BinaryHeap - Act as the queue and data structure to hold the vertex and information during the Dijkstra computation
    File - To create file objects for each input text file in order to convert and process the text information into a graph

Data Structures:
    Lists - To store list of edges and vertices
    Hash Maps - To store information about each vertex (key value pair)