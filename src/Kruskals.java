import java.io.*;
import java.util.*;

public class Kruskals {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("data.csv");
        Scanner sc = new Scanner(input);
        sc.useDelimiter(",");

        ArrayList<String> nameMap = new ArrayList<>();
        ArrayList<Edge> edges = new ArrayList<>();
        int map = 0;
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            String[] lineArr = line.split(",");
            String v1 = lineArr[0];
            if(!nameMap.contains(v1)){
                nameMap.add(v1);
                map++;
            }
            for(int i = 1; i<lineArr.length; i+=2){
                String v2 = lineArr[i];
                if(!nameMap.contains(v2)){
                    nameMap.add(v2);
                    map++;
                }
                edges.add(new Edge(nameMap.indexOf(v1),nameMap.indexOf(v2),Integer.parseInt(lineArr[i+1])));
            }
        }
        MST g = new MST(edges, map);
        for( Edge e : g.getMst()){
            System.out.print(nameMap.get(e.getU()));
            System.out.print(" <--"+e.getWeight()+"--> ");
            System.out.println(nameMap.get(e.getV()));
        }

        System.out.println("The total distance is " + g.sumAllDists());
    }
}