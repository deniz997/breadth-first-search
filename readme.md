# Breadth-First Search Algorithm (BFS)

This algorithm gets a graph as an adjacency matrix input and discovers all reachable nodes by using BFS.

**Inputs**

* Dimensions of the adjacency matrix
* Values of the adjacency matrix
* Start node for the search

In a regular BFS, when a node has multiple neighbors, next node can be any of these neighbors. However, for the
consistency between answers, here the node with the smallest number is selected.

**Sample Input**

5\
1 0 0 1 0\
0 0 0 0 1\
0 0 1 0 0\
1 1 1 1 0\
0 0 1 0 0\
3

5 means that the input matrix has a size of 5x5.
Then, the following 25 values are read.
3 denotes the starting point of BFS.

**Sample Output**

3 0 1 2 4