import java.util.LinkedList;

public class DFS {
  private int V;
  private LinkedList<Integer> adjList[];
  private int matrix[][];

  public DFS(int v) {
    this.V = v;

    adjList = (LinkedList<Integer>[])new LinkedList<?>[v];
    for (int i = 0; i < v; i++) {
      adjList[i] = new LinkedList<Integer>();
    }

  }

  private void dfs(int v) {

    boolean visited[] = new boolean[this.V];
    visited[v] = true;

    dfsUtil(v, visited);

  }

  private void dfsUtil(int v, boolean visited[]) {

    System.out.println(v + " ");

    for (int i = 0; i < adjList[v].size(); i++) {
      int adjacentNode = adjList[v].get(i);

      if (visited[adjacentNode] == false) {
        visited[adjacentNode] = true;
        dfsUtil(adjacentNode, visited);
      }
    }
  }

  private void addListEdge(int u, int v) {
    adjList[u].add(v);
  }

  private void removeListEdge(int u, int v) {
    adjList[u].remove(v);
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

  public static void main(String[] args) {

    DFS g = new DFS(4); // create a graph with 4 vertices

    // Add to adjList
    g.addListEdge(0, 1);
    g.addListEdge(0, 2);
    g.addListEdge(1, 2);
    g.addListEdge(2, 0);
    g.addListEdge(2, 3);
    g.addListEdge(3, 3);
    g.printList();

    System.out.println("-----------------");

    g.dfs(2);


  }
}
