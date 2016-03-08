import edu.princeton.cs.algs4.*;
import java.lang.Exception;
import java.util.*;
public class worm {

   // PUT YOUR CLASS VARIABLE HERE

   public worm( In in ) { 
      // Create a new problem instance.
   }

   public double dist( String origP, String destP ) {
      // return the distance from origP to destP
      throw new RuntimeException("Not yet implemented");
   }
      
   public int   worms( String origP, String destP ) { 
      // least number of wormholes in any shortest path from origP to destP
      throw new RuntimeException("Not yet implemented");
   }
 
   public String query( String origP, String destP ) {
      // Output the "The distance from ... wormholes." string.
      throw new RuntimeException("Not yet implemented");
   }
  
   public static void main(String[] args) {
      // You can test your program with something like this.
      In in = new In( args[0] );
      int T = in.readInt(); // number of cases
      for (int t=1; t<=T; t++) {
         System.out.println("Case " + t + ":") ;
         worm w = new worm( in );
         int Q = in.readInt() ; // number of items in list
         for (int i=0; i<Q; i++) {
            String p1s = in.readString() ;
            String p2s = in.readString() ;
            System.out.println( w.query( p1s, p2s ) ) ;
         }
      }
   }
}

