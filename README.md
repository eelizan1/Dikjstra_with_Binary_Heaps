# Dikjstra_with_Binary_Heaps
Finding the shortest path with large data using Dikjstra's Algorithm and Binary Heaps making it a run time of O(ElogV)

The program reads data from file (see samples below) and output a single number = sum of lengths of the shortest paths from node 0 to each node. 
INPUT FORMAT: The first line of each file below contains the number of vertices and the number of edges in the graph (in the format "n=XXXX m=XXXXX"). The rest of the file is organized as follows: 
each vertex i appears on a line by itself, followed by a line for each neighbor j>i of i (containing j and the length of edge (i,j)). 

Each list of neighbors is ended by an empty line. Vertices i which do not have neighbors with an index greater than i are not represented. 
NOTE: Vertices are indexed from 0 to n-1. 
NOTE: each edge is mentioned only once with its smaller number endpoint 
SAMPLE INPUT: 
1. first input 
2. second input 
the length of the shortest path tree should be 10721073 and 625349 respectively. 
Program gives output in 3-10 seconds for the first input and less than 1 second for the second.


