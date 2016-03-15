import edu.princeton.cs.algs4.*;
import java.lang.Exception;
import java.util.*;
import java.lang.Math;

public abstract class IndecesBuilder {
  public HashMap<String, Integer> Indeces(Graph g) {
    HashMap<String, Integer> indeces = new HashMap<String, Integer>();
    int c = 0;
    for (String p : g.planets()) {
      indeces.put(p, new Integer(c++));
    }
    return indeces;
  }

  public ArrayList<String> Planets(Graph g) {
    ArrayList<String> p = new ArrayList<String>(g.V());
    HashMap<String, Integer> indeces = Indeces(g);
    for (Map.Entry e : indeces.entrySet()) {
      p.add(((Integer)e.getValue()).intValue(), (String)e.getKey());
    }
    return p;
  }
}
