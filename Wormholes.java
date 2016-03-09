import java.util.*;
import java.lang.Exception;
import edu.princeton.cs.algs4.*;
public class Wormholes {
  ArrayList<Wormhole> wormholes = new ArrayList<Wormhole>();

  public Wormholes() { }

  public void add(Wormhole w) { wormholes.add(w); }

  public boolean exists(EdgeTo e) { 
    return exists(new Wormhole(e.from, e.to));
  }
  public boolean exists(Wormhole w) { 
    return wormholes.contains(w);
  }
}
