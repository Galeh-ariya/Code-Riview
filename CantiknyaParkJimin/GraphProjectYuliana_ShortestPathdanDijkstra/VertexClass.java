package GraphProjectYuliana_ShortestPathdanDijkstra;

public class VertexClass {
    int id;
    double distance;
    VertexClass parent;

    public VertexClass(int i) {
        distance = Double.MAX_VALUE; //Tak Terbatas
        parent = null;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    public VertexClass getParent() {
        return parent;
    }
    public void setParent(VertexClass parent) {
        this.parent = parent;
    }
    public int compareTo(Object o) {
        VertexClass other = (VertexClass) o;
        return Double.compare(this.distance, other.distance);
    }
}
