import java.util.Scanner;

public class BellmanFord{
    public static final int MAX = Integer.MAX_VALUE;
    
    public static void bellmanFordEvaluation(int source, int N, int edges[][]){
        int dist[] = new int[N];
        for(int it = 0; it < N; ++it) dist[it] = MAX;
        dist[source] = 0;
        
        int u,v,wt;
        
        //N-1 times
        for(int it = 1; it < N; ++it){
            for(int e = 0; e < edges.length; ++e){
                u = edges[e][0];
                v = edges[e][1];
                wt = edges[e][2];
                if( dist[u] + wt < dist[v] ) 
                    dist[v] = dist[u] + wt;
            }
        }
        
        //Nth time
        for(int e = 0;e < edges.length; ++e){
            u = edges[e][0];
            v = edges[e][1];
            wt = edges[e][2];
            if( dist[u] + wt < dist[v] ){
                System.out.println("Negative cycle exists in the graph!!");
                return;
            }
        }
        
        for(int node = 0; node < N; ++node){
            System.out.println("Distance from "+source+" to "+node+" : "+dist[node]);
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter no. of vertices : ");
        int N = sc.nextInt();
        
        System.out.print("Enter no. of edges : ");
        int E = sc.nextInt();
        
        int edges[][] = new int[E][3];
        for(int i=0;i<E;++i){
            System.out.print("Edge-"+(i+1)+" : ");
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }
        
        System.out.print("Enter source node : ");
        int source = sc.nextInt();
        
        bellmanFordEvaluation(source, N, edges);
    }
}
