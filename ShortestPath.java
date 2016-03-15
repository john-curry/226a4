import edu.princeton.cs.algs4.*;
import java.lang.Exception;
import java.util.*;
import java.lang.Math;

/* CONTRACT:
    must compute the distance between two planets least number of wormholes in any shortest path bt two planets
    output the distance from p1 to p2 is x parsecs using y wormholes
 */

public class ShortestPath extends IndecesBuilder {
  Graph graph;
  Wormholes wormholes;
  double[][] distTo;
  int[][] wormTo;
  HashMap<String, Integer> indeces;

  public int V() { return graph.V(); }

  public ShortestPath(Graph graph, Wormholes holes) {
    this.graph = graph;
    this.wormholes = holes;

    indeces = this.Indeces(graph);

    wormTo = new int[graph.V()][graph.V()];
    distTo = new double[graph.V()][graph.V()];
    for (int j = 0; j < V(); ++j) {
      for (int i = 0; i < V(); ++i) {
        distTo[i][j] = Double.POSITIVE_INFINITY;
        wormTo[i][j] = 0;
      }
    }

    for (String p : graph.planets()) {
      for (EdgeTo e : graph.adjacencyList(p)) {
        distTo[indeces.get(e.from).intValue()][indeces.get(e.to).intValue()] = e.distance;
      }
    }

    for (Wormhole w : holes) {
      distTo[indeces.get(w.from).intValue()][indeces.get(w.to).intValue()] = 0;
      wormTo[indeces.get(w.from).intValue()][indeces.get(w.to).intValue()] = 1;
    }

    for (int k = 0; k < V(); ++k) {
      for (int j = 0; j < V(); ++j) {
        for (int i = 0; i < V(); ++i) {
          if (distTo[j][i] > distTo[j][k] + distTo[k][i]) {
            wormTo[j][i] = wormTo[j][k] + wormTo[k][i];
          } 

          distTo[j][i] = Math.min(distTo[j][i], distTo[j][k] + distTo[k][i]);

        }
      }
    }
  }

  public int wormholesBetween(String p1, String p2) {
    return wormTo[indeces.get(p1).intValue()][indeces.get(p2).intValue()];
  }

  public double distanceBetween(String p1, String p2) {
    return distTo[indeces.get(p1).intValue()][indeces.get(p2).intValue()];
  }

  public boolean query(String p1, String p2)
  { return false; }
}
