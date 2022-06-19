package GraphProjectYuliana_ShortestPathdanDijkstra;

//3130021006_YULIANA_S1 SISTEM INFORMASI

public class EdgeClass {
    int starPoint;
    int endPoint;
    double weight;

    public EdgeClass (int starPoint, int endPoint, double weight) {
        this.starPoint = starPoint;
        this.endPoint = endPoint;
        this.weight = weight;
    }
    public int getStarPoint() {
        return starPoint;
    }
    public int getEndPoint() {
        return endPoint;
    }
    public double getWeight() {
        return weight;
    }
    public boolean equals (EdgeClass other) {
        if (this.starPoint == other.starPoint) {
            if (this.endPoint == other.endPoint) {
                return true;
            }
        }
        return false;
    }
    public int compareTo (Object o) {
        EdgeClass other = (EdgeClass) o;
        return Double.compare(this.weight, other.weight);
    }
    public String toString() {
        return starPoint + "-" + endPoint + " (" + weight + ") ";
    }
}
