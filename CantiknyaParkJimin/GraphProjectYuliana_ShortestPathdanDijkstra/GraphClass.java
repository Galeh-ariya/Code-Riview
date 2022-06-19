package GraphProjectYuliana_ShortestPathdanDijkstra;

import java.util.Iterator;
import java.util.PriorityQueue;

public class GraphClass {
    int vCount;
    PriorityQueue<EdgeClass>[] adj;

    public int getvCount() {
        return vCount;
    }
    public GraphClass (int vCount) {
        this.vCount = vCount;
        //Inisialisasi adj
        adj = new PriorityQueue[vCount];
        for (int i = 0; i < vCount; i++) {
            adj[i] = new PriorityQueue<EdgeClass>();
        }
    }
    public void addEdge (int i, int j, double weight) {
        adj[i].add(new EdgeClass(i, j, weight));
    }
    public void addEdge (EdgeClass e) {
        adj[e.getStarPoint()].add(e);
    }
    public void removeEdge (int i, int j) {
        Iterator<EdgeClass> it = adj[i].iterator();
        EdgeClass other = new EdgeClass(i, j, 1);
        while (it.hasNext()) {
            if (it.next().equals(other)) {
                it.remove();
                return;
            }
        }
    }
    public boolean hasEdge (EdgeClass e) {
        return adj[e.getStarPoint()].contains(e);
    }
    public PriorityQueue<EdgeClass> neighbours(int vertex) {
        return adj[vertex];
    }
    public void printGraph() {
        for (int i = 0; i < vCount; i++) {
            PriorityQueue<EdgeClass> edges = neighbours(i);
            Iterator<EdgeClass> it = edges.iterator();
            System.out.print(i + ": ");
            for (int j = 0; j < edges.size(); j++) {
                System.out.print(it.next() + " ");
            }
            System.out.println();
        }
    }
}
