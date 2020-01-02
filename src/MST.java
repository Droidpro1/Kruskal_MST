import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MST {
    private ArrayList<Edge> mst = new ArrayList<>();

    public MST(List<Edge> edges, int numVerticies){
        DisjSets ds = new DisjSets(numVerticies);
        PriorityQueue<Edge> pq = new PriorityQueue<>(edges);

        while (mst.size() != numVerticies-1){
            Edge e = pq.remove();
            int uset = ds.find(e.getU());
            int vset = ds.find(e.getV());

            if(uset != vset){
                mst.add(e);
                ds.union(uset,vset);
            }
        }
    }

    public ArrayList<Edge> getMst(){ return mst;}

    public int sumAllDists(){
        int sum = 0;
        for(Edge e : mst){
            sum+=e.getWeight();
        }
        return sum;
    }
}