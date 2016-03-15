import java.util.*;
import java.lang.Exception;
import edu.princeton.cs.algs4.*;
public class Wormholes implements Iterable<Wormhole> {
  ArrayList<Wormhole> wormholes = new ArrayList<Wormhole>();

  public Wormholes() { }

  public void add(Wormhole w) { wormholes.add(w); }

  public boolean exists(EdgeTo e) { 
    return exists(new Wormhole(e.from, e.to));
  }

  public Iterator<Wormhole> iterator() {
    return wormholes.iterator();
  }

  public boolean exists(Wormhole w) { 
    for (Wormhole o : wormholes) {
      if ((w.from == o.from) && (w.to == o.to)) {return true;}
    }
    return false;
  }
}
