import java.util.LinkedList;

public class BFS {
  private int V;
  private LinkedList<Integer> adjList[];
  private int matrix[][];

  public BFS(int v) {
    this.V = v;

    adjList = (LinkedList<Integer>[])new LinkedList<?>[v];
    for (int i = 0; i < v; i++) {
      adjList[i] = new LinkedList<Integer>();
    }

  }

  private void bfs(int v) {

    LinkedList<Integer> queue = new LinkedList<Integer>();
    boolean visited[] = new boolean[this.V];

    queue.add(v);
    visited[v] = true;

    while (queue.size() != 0) {

      int current_node = queue.poll();

      System.out.println(current_node + " ");
      // iterate through current_nodes adjList and add
      // it's connected nodes to the queue and print them
      // if they haven't already been visited

      for (int i = 0; i < adjList[current_node].size(); i++) {
        int adjacentNode = adjList[current_node].get(i);

        if (visited[adjacentNode] == false) {
          queue.add(adjacentNode);
          visited[adjacentNode] = true;
        }
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

    BFS g = new BFS(4); // create a graph with 4 vertices

    // Add to adjList
    g.addListEdge(0, 1);
    g.addListEdge(0, 2);
    g.addListEdge(1, 2);
    g.addListEdge(2, 0);
    g.addListEdge(2, 3);
    g.addListEdge(3, 3);
    g.printList();

    System.out.println("-----------------");

    g.bfs(2);


  }
}
