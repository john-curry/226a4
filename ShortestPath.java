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

  public ShortestPath(Graph graph, Wormholes holes) {
    this.graph = graph;
    this.wormholes = holes;
  }

  public Wormholes leastNumberOfWormholes() 
  { return new Wormholes(); }

  public double distanceBetween(String p1, String p2) {
    if (p1 == p2) { return 0; } // just for fun

    // shortest distance from p1 to all other planets
    HashMap<String, Double> minDistances = new HashMap<String, Double>();

    // whether or not we have visited the planet yet
    HashMap<String, Boolean> marked = new HashMap<String, Boolean>();

    for (String s : graph.planets()) {
      // set all distances to max distance
      minDistances.put(s, Double.POSITIVE_INFINITY);
      // we have not visited any planets yet
      marked.put(s, new Boolean(false));
    }

    // sorted list of edges that we have yet to visit
    PriorityQueue<EdgeTo> toVisit = new PriorityQueue<EdgeTo>();

    // add all adjacent edges 
    for (EdgeTo edge : graph.adjacencyList(p1)) {
      toVisit.add(edge);
    }

    minDistances.put(p1, new Double(0));
    marked.put(p1, new Boolean(true));

    EdgeTo e = toVisit.poll();
    // start traversal
    do {
      double distance_so_far = minDistances.get(e.from); // update distance travelled
      
      marked.put(e.to, new Boolean(true)); // mark this node

      if (e.to == p2) { return distance_so_far + e.distance; } // check if we are done

      if (wormholes.exists(e)) { // if there is a wormhole then distance travelled to next planet is 0
        minDistances.put(e.to, new Double(distance_so_far));
      } else {
        if (distance_so_far + e.distance < minDistances.get(e.to).doubleValue()) { // if we have found a better path
          minDistances.put(e.to, new Double(e.distance + distance_so_far)); // update distance to the next node
        }
      }

      for (EdgeTo edge : graph.adjacencyList(e.to)) {
        if (!marked.get(edge.to).booleanValue()) toVisit.add(edge); // only visit edges we have not been to yet
      }

      e = toVisit.poll(); // check next shortest edge
    } while (e != null);

    return -99;
  }

  public boolean query(String p1, String p2)
  { return false; }
}
