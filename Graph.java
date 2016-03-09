import java.util.*;
import java.lang.Exception;
import edu.princeton.cs.algs4.*;

public class Graph {
  HashMap<String, ArrayList<EdgeTo>> graph;

  public Graph(HashMap<String, Point> coords) { 
    // build graph
    // for every planet in coordinates
    // calculate the euclidean distance between all other planets
    // and add that distance to the graph
    graph = new HashMap<String, ArrayList<EdgeTo>>();

    for (Map.Entry<String, Point> planet : coords.entrySet()) {
        ArrayList<EdgeTo> adj_list = new ArrayList<EdgeTo>();
        Point p1 = planet.getValue();

      for (Map.Entry<String, Point> edge : coords.entrySet()) {
        Point p2 = edge.getValue();
        double distance = p1.distanceTo(p2);
        adj_list.add(new EdgeTo(planet.getKey(), edge.getKey(), distance));
      }
      graph.put(planet.getKey(), adj_list);
    }
  }

  public ArrayList<EdgeTo> adjacencyList(String vertex) {
    return graph.get(vertex);
  }

  public Set<String> planets() {
    return graph.keySet();
  }

  public void addEdge(String v1, String v2, double distance) {
    graph.get(v1).add(new EdgeTo(v1, v2, distance));
    graph.get(v2).add(new EdgeTo(v2, v1, distance));
  }
}
