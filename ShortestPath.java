import edu.princeton.cs.algs4.*;
import java.lang.Exception;
import java.util.*;

/* CONTRACT:
    must compute the distance between two planets least number of wormholes in any shortest path bt two planets
    output the distance from p1 to p2 is x parsecs using y wormholes
 */

public class ShortestPath {
  Graph graph;
  Wormholes wormholes;
  double[][] distTo;
  HashMap<String, Integer> indeces = new HashMap<String, Integer>();

  public int V() { return graph.V(); }

  public ShortestPath(Graph graph, Wormholes holes) {
    this.graph = graph;
    this.wormholes = holes;
    int c = 0;
    for (String p : graph.planets()) {
      indeces.put(p, new Integer(c++));
    }

    distTo = new double[graph.V()][graph.V()];
    for (int j = 0; j < V(); ++j) {
      for (int i = 0; i < V(); ++i) {
        distTo[i][j] = Double.POSITIVE_INFINITY;
      }
    }

    for (String p : graph.planets()) {
      for (EdgeTo e : graph.adjacencyList(p)) {
        distTo[indeces.get(e.from).intValue()][indeces.get(e.to).intValue()] = e.distance;
      }
    }

    for (Wormhole w : holes) {
      distTo[indeces.get(w.from).intValue()][indeces.get(w.to).intValue()] = 0;
    }

    for (int k = 0; k < V(); ++k) {
      for (int j = 0; j < V(); ++j) {
        for (int i = 0; i < V(); ++i) {
          distTo[j][i] = Math.min(distTo[j][i], distTo[j][k] + distTo[k][i]);
        }
      }
    }
  }

  public Wormholes leastNumberOfWormholes() 
  { return new Wormholes(); }

  public double distanceBetween(String p1, String p2) {
    return distTo[indeces.get(p1).intValue()][indeces.get(p2).intValue()];
  }

  public boolean query(String p1, String p2)
  { return false; }
}
