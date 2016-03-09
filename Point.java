import java.util.*;
import java.lang.Exception;
import edu.princeton.cs.algs4.*;

public class Point { 
  public double x; double y; double z;
  public Point(double x, double y, double z) 
  { this.x = x; this.y = y; this.z = z; }
  public double distanceTo(Point p) {
    return euclideanDistance(this, p);
  }
  public static double euclideanDistance( Point p1, Point p2 ) {
    return Math.sqrt(
      Math.pow(p1.x - p2.x, 2) +
      Math.pow(p1.y - p2.y, 2) +
      Math.pow(p1.z - p2.z, 2)
    );
}
}

