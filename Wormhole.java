import java.util.*;
import java.lang.Exception;
import edu.princeton.cs.algs4.*;

public class Wormhole {
  public final String from;
  public final String to;
  public Wormhole(String from, String to) 
  { this.from = from; this.to = to; }

  public boolean equals(Object o) {
    if (o instanceof Wormhole) {
      if (((Wormhole)o).from == this.from && ((Wormhole)o).to == this.to) {
        return true;
      }
    }
    return false;
  }
}
