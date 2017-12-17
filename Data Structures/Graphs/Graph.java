import java.util.LinkedList;

public class Graph {

  private int V;
  private LinkedList<Integer> adjList[];
  private int matrix[][];

  public Graph(int v, boolean adjacencyList) {
    this.V = v;
    if (adjacencyList) {
      adjList = (LinkedList<Integer>[])new LinkedList<?>[v];
      for (int i = 0; i < v; i++) {
        adjList[i] = new LinkedList<Integer>();
      }
    }
    else {
      matrix = new int[v][v];
    }
  }

  private void addListEdge(int u, int v) {
    adjList[u].add(v);
  }

  private void removeListEdge(int u, int v) {
    adjList[u].remove(v);
  }

  private void addMatrixEdge(int u, int v) {
    matrix[u][v] = 1;
  }

  private void removeMatrixEdge(int u, int v) {
    matrix[u][v] = 0;
  }

  private void printList() {
    for (int i = 0; i < V; i++) {
      System.out.print(i + ": ");
      for (int j = 0; j < adjList[i].size(); j++) {
        System.out.print(adjList[i].get(j) + " ");
      }
      System.out.println();
    }
  }

  private void printMatrix() {
    for (int i = 0; i < V; i++) {
      System.out.print(i + ": ");
      for (int j = 0; j < V; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {

    Graph g = new Graph(4, true); // true to make an adjList

    // Add to adjList
    g.addListEdge(0, 1);
    g.addListEdge(0, 2);
    g.addListEdge(1, 2);
    g.addListEdge(2, 0);
    g.addListEdge(2, 3);
    g.addListEdge(3, 3);
    g.printList();

    System.out.println("-----------------------");

    g = new Graph(4, false);

    // add to add to matrix
    g.addMatrixEdge(0, 1);
    g.addMatrixEdge(0, 2);
    g.addMatrixEdge(1, 2);
    g.addMatrixEdge(2, 0);
    g.addMatrixEdge(2, 3);
    g.addMatrixEdge(3, 3);
    g.printMatrix();


  }

}
