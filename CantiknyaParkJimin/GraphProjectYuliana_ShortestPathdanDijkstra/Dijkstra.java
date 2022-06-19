package GraphProjectYuliana_ShortestPathdanDijkstra;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Dijkstra {
    public static void main(String[] args) {
        GraphClass g = new GraphClass(8);

        System.out.println("====GRAPH====");
        //Add Edges
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(1, 8, 10);
        g.addEdge(2, 3, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(4, 5, 9);
        g.addEdge(5, 1, 15);
        g.addEdge(6, 5, 14);
        g.addEdge(7, 6, 5);
        g.addEdge(7, 8, 9);
        g.addEdge(8, 5, 8);

        //Print Graph
        g.printGraph();

        //Djikstra Shortest Path Algoritma
        System.out.println("Dijkstra Shortest Path : ");
        Dijkstra(g, 0);
    }
    public static void Dijkstra(GraphClass g, int starVertex) {
        //Menyimpan jarak(distance) setelah hapus vertex dari Queue
        double[] distances = new double[g.getvCount()];
        //Menyimpan parent id setelah hapus vertex dari Queue
        int[] parents = new int[g.getvCount()];
        for (int i = 0; i < g.getvCount(); i++) {
            parents[i] = -1;
        }
        //Set Up Vertex Queue
        PriorityQueue<VertexClass> Q = new PriorityQueue<VertexClass>();
        for (int i = 0; i < g.getvCount(); i++) {
            if (i != starVertex) {
                Q.add(new VertexClass(i));
            }
        }
        //Add starVertex
        VertexClass node = new VertexClass(starVertex);
        node.setDistance(0);
        Q.add(node);

        //Loop
        while (!Q.isEmpty()) {
            //Mendapatkan Vertex dengan Shortest distance
            VertexClass u = Q.remove();
            distances[u.getId()] = u.getDistance();
            //Iterate
            Iterator<EdgeClass> it = g.neighbours(u.getId()).iterator();
            while (it.hasNext()) {
                EdgeClass e = it.next();
                Iterator<VertexClass> it2 = Q.iterator();
                VertexClass v = null;
                while (it2.hasNext()) {
                    v = it2.next();
                }
                //Check jika vertex siap
                if (e.getEndPoint() != v.getId()) {
                    continue;
                }
                //Check jarak (distance)
                if (v.getDistance() > u.getDistance() + e.getWeight()) {
                    v.setDistance(u.getDistance() + e.getWeight());
                    v.setParent(u);
                }
                //Cetak
                System.out.println("====VERTEX====");
                for (int i = 0; i < g.getvCount(); i++) {
                    System.out.println(i + "\t" + distances[i] + "\t\t" + parents[i]);
                }
            }
        }
    }
}