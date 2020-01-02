public class Edge implements Comparable<Edge> {
    private int u;
    private int v;
    private int weight;

    public Edge(int v1, int v2, int w){
        u = v1;
        v = v2;
        weight = w;
    }

    public int getU(){ return u;}
    public int getV(){ return v;}
    public int getWeight(){ return weight;}

    @Override
    public int compareTo(Edge e) {
        return this.weight-e.getWeight();
    }
}