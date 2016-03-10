  import java.util.*;
  import java.lang.Exception;
  import edu.princeton.cs.algs4.*;

  public class EdgeTo implements Comparable<EdgeTo> {
    public final String from;
    public final String to;
    public final double distance;
    public EdgeTo(String from, String to, double distance) {
      this.from = from; 
      this.to = to; 
      this.distance = distance; 
    }

    public boolean equals(Object o) {
    if (o instanceof EdgeTo) {
      if (((EdgeTo)o).to == this.to && ((EdgeTo)o).from == this.from) {
        return true;
      }
    }
    return false;
  }
  public int compareTo(EdgeTo e) {
    if (e.distance > this.distance) return 1;
    if (e.distance < this.distance) return -1;
    return 0;
  }
}
