import edu.princeton.cs.algs4.*;
import java.lang.Exception;
import java.util.*;
public class Worm {

  // planets and their position in space
  HashMap<String, Point> Coordinates;
  ShortestPath sp;

  public Worm( In in ) { 
    Coordinates = new HashMap<String, Point>();
    int num_planets = in.readInt();
    for (int i = 0; i < num_planets; i++) {
      String planet = in.readString();
      double x = in.readDouble();
      double y = in.readDouble();
      double z = in.readDouble();
      Coordinates.put(planet, new Point(x, y, z));
    }

    Graph graph = new Graph(Coordinates);
    Wormholes wormholes = new Wormholes();

    int num_wormholes = in.readInt();
    for (int i = 0; i < num_wormholes; i++) {
      String from = in.readString();
      String to   = in.readString();
      wormholes.add(new Wormhole(from, to));
    }

    sp = new ShortestPath(graph, wormholes);
  }


  public double dist( String origP, String destP ) {
    return sp.distanceBetween(origP, destP);
  }
     
  public int   worms( String origP, String destP ) { 
    return sp.wormholesBetween(origP, destP);
  }

  public String query( String origP, String destP ) {
    return "The distance from " + origP + " and " + destP + " is " + sp.distanceBetween(origP, destP) + " parsecs using " + worms(origP, destP) + " wormholes.";
  }
 
  public static void main(String[] args) {
     // You can test your program with something like this.
     System.out.println(args[0]);
     In in = new In( args[0] );

     int T = in.readInt(); // number of cases
     for (int t=1; t<=T; t++) {
        System.out.println("Case " + t + ":") ;
        Worm w = new Worm( in );
        int Q = in.readInt() ; // number of items in list
        for (int i=0; i<Q; i++) {
           String p1s = in.readString() ;
           String p2s = in.readString() ;
           System.out.println( w.query( p1s, p2s ) ) ;
        }
     }
  }
}

