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

  public int compareTo(EdgeTo e) {
    if (e.distance > this.distance) return 1;
    if (e.distance < this.distance) return -1;
    return 0;
  }
}
