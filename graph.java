import java.util.*;
class Graph {
 int data;
 boolean vis;
 ArrayList < Graph > Neighbours;
 Graph(int x) {
  data = x;
  this.Neighbours = new ArrayList < Graph > ();
  this.vis = false;

 }
 public void add(Graph node) {
  this.Neighbours.add(node);
 }
}
public class sol {
 static ArrayList < Graph > all = new ArrayList < Graph > ();
 public static void addvertex(int x) {
  for (Graph g: all)
   if (g.data == x) return;
  String t = "s" + Integer.toString(x);
  Graph tem = new Graph(x);
  all.add(tem);
 }
 public static void addedge(int s, int d) {
  Graph so = new Graph(0);
  Graph de = new Graph(0);
  for (Graph te: all) {
   if (te.data == s) so = te;
   if (te.data == d) de = te;
  }
  so.add(de);
 }
 public static void printadjtable() {
  System.out.println("Adjacency table is");
  for (Graph te: all) {
   System.out.print(te.data + "\t" + "->\t");
   for (Graph g: te.Neighbours)
    System.out.print(g.data + " ");
   System.out.println();
  }
 }
 public static void printvertex() {
  System.out.println("vertices are");
  for (Graph g: all) System.out.print(g.data + " ");
  System.out.println();
 }
 public static void pdfs(int x) {
  Graph so = new Graph(0);
  for (Graph te: all)
   if (te.data == x) so = te;
  for (Graph g: all) g.vis = false;
  System.out.println("Dfs is");
  dfs(so);
  System.out.println();
 }
 public static void dfs(Graph s) {
  if (s.vis) return;
  s.vis = true;
  System.out.print(s.data + " ");
  if (s.Neighbours.size() == 0) return;
  for (Graph t: s.Neighbours) dfs(t);
 }
 public static void pbfs(int x) {
  Graph so = new Graph(0);
  for (Graph te: all)
   if (te.data == x) so = te;
  for (Graph g: all) g.vis = false;
  System.out.println("Bfs is");
  bfs(so);
  System.out.println();
 }
 public static void bfs(Graph s) {
  Queue < Graph > q = new LinkedList < Graph > ();
  q.add(s);
  s.vis = true;
  while (!q.isEmpty()) {
   Graph temp = q.remove();
   System.out.print(temp.data + " ");
   if (temp.Neighbours.size() != 0) {
    //for(Graph g:temp.Neighbours){if(!g.vis)System.out.print(g.data+" ");}
    for (Graph g: temp.Neighbours) {
     if (!g.vis) {
      q.add(g);
      g.vis = true;
     }
    }
   }
  }

 }
 public static void main(String[] args) {
  addvertex(1);
  addvertex(2);
  addvertex(3);
  addvertex(6);
  addvertex(5);
  addvertex(9);
  addvertex(10);
  addvertex(11);
  addedge(1, 10);
  addedge(1, 2);
  addedge(1, 3);
  addedge(2, 9);
  addedge(9, 10);
  addedge(5, 1);
  addedge(3, 5);
  addedge(3, 6);
  addedge(6, 11);
  printvertex();
  System.out.println();
  printadjtable();
  System.out.println();
  pdfs(5);
  System.out.println();
  pbfs(5);
 }
}
