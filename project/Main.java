import javax.swing.plaf.synth.SynthStyle;
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.*;
import java.util.*;
import java.sql.*;
// Press Shift twice to open the Search Everywhere dialog and type show whitespaces,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static int INF=Integer.MAX_VALUE;
    static ArrayList<Edge> USAnetwork[];
    static ArrayList<Edge> Cost239[];
    static ArrayList<Edge> NSFnetwork[];
    static ArrayList<Edge> Opticalnetwork[];
    //Hash Map to Map edges of graph
    static  HashMap<String,Integer> USAnetwork_edge=new HashMap<>();
    static  HashMap<String,Integer> Cost239_edge=new HashMap<>();
    static  HashMap<String,Integer> NSFnetwork_edge=new HashMap<>();
    static  HashMap<String,Integer> Opticalnetwork_edge=new HashMap<>();

    //node degree of each node
    static int Cost239_nodaldeg[] ={-1,4,4,5,5,5,5,5,6,5,4,4};
    static int NSFnetwork_nodaldeg[] = {-1,3,3,3,3,3,4,3,3,4,3,3,3,3,3};
    static int Opticalnetwork_nodaldeg[] = {3,3,4,3,5,3,3,3,4,3,4,4,3,3};
    static int USnetwork_nodaldeg[] = {2,3,4,3,3,5,5,3,5,4,5,4,4,3,3,5,5,3,2,3,3,4,3,2};

    static String NetworkName[] = {"USAnetwork", "Cost239", "NSFnetwork", "Opticalnetwork"};
    static int startIndex[] = {0, 1, 1, 0};
    static int endIndex[] = {23, 11, 14, 13};
    static int noOFNodes[] = {24, 11, 14, 14};

    static int noOFEdges[]={43,26,23,25};
    static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.weight = wt;
        }
    }

    static void createGraph1(ArrayList<Edge> g1[]) {
        for (int i = 0; i < g1.length; i++)
            g1[i] = new ArrayList<>();

        g1[0].add(new Edge(0, 1, 800));
        g1[0].add(new Edge(0, 5, 1000));

        g1[1].add(new Edge(1, 0, 800));
        g1[1].add(new Edge(1, 2, 1100));
        g1[1].add(new Edge(1, 5, 950));

        g1[2].add(new Edge(2, 1, 1100));
        g1[2].add(new Edge(2, 3, 250));
        g1[2].add(new Edge(2, 4, 800));
        g1[2].add(new Edge(2, 6, 1000));

        g1[3].add(new Edge(3, 2, 250));
        g1[3].add(new Edge(3, 4, 800));
        g1[3].add(new Edge(3, 6, 850));

        g1[4].add(new Edge(4, 2, 800));
        g1[4].add(new Edge(4, 3, 800));
        g1[4].add(new Edge(4, 7, 1200));

        g1[5].add(new Edge(5, 0, 1000));
        g1[5].add(new Edge(5, 1, 950));
        g1[5].add(new Edge(5, 6, 1000));
        g1[5].add(new Edge(5, 8, 1200));
        g1[5].add(new Edge(5, 10, 1900));

        g1[6].add(new Edge(6, 2, 1000));
        g1[6].add(new Edge(6, 3, 850));
        g1[6].add(new Edge(6, 5, 1000));
        g1[6].add(new Edge(6, 7, 1150));
        g1[6].add(new Edge(6, 8, 1000));

        g1[7].add(new Edge(7, 4, 1200));
        g1[7].add(new Edge(7, 6, 1150));
        g1[7].add(new Edge(7, 9, 900));

        g1[8].add(new Edge(8, 5, 1200));
        g1[8].add(new Edge(8, 6, 1000));
        g1[8].add(new Edge(8, 9, 1000));
        g1[8].add(new Edge(8, 10, 1400));
        g1[8].add(new Edge(8, 11, 1000));

        g1[9].add(new Edge(9, 7, 900));
        g1[9].add(new Edge(9, 8, 1000));
        g1[9].add(new Edge(9, 12, 950));
        g1[9].add(new Edge(9, 13, 850));

        g1[10].add(new Edge(10, 5, 1900));
        g1[10].add(new Edge(10, 8, 1400));
        g1[10].add(new Edge(10, 11, 900));
        g1[10].add(new Edge(10, 14, 1300));
        g1[10].add(new Edge(10, 18, 2600));

        g1[11].add(new Edge(11, 8, 1000));
        g1[11].add(new Edge(11, 10, 900));
        g1[11].add(new Edge(11, 12, 900));
        g1[11].add(new Edge(11, 15, 1000));

        g1[12].add(new Edge(12, 9, 950));
        g1[12].add(new Edge(12, 11, 900));
        g1[12].add(new Edge(12, 13, 650));
        g1[12].add(new Edge(12, 16, 1100));

        g1[13].add(new Edge(13, 9, 850));
        g1[13].add(new Edge(13, 12, 650));
        g1[13].add(new Edge(13, 17, 1200));

        g1[14].add(new Edge(14, 10, 1300));
        g1[14].add(new Edge(14, 15, 600));
        g1[14].add(new Edge(14, 19, 1300));

        g1[15].add(new Edge(15, 11, 1000));
        g1[15].add(new Edge(15, 14, 600));
        g1[15].add(new Edge(15, 16, 1000));
        g1[15].add(new Edge(15, 20, 1000));
        g1[15].add(new Edge(15, 21, 800));

        g1[16].add(new Edge(16, 12, 1100));
        g1[16].add(new Edge(16, 15, 1000));
        g1[16].add(new Edge(16, 17, 800));
        g1[16].add(new Edge(16, 21, 850));
        g1[16].add(new Edge(16, 22, 1000));

        g1[17].add(new Edge(17, 13, 1200));
        g1[17].add(new Edge(17, 16, 800));
        g1[17].add(new Edge(17, 23, 900));

        g1[18].add(new Edge(18, 10, 2600));
        g1[18].add(new Edge(18, 19, 1200));

        g1[19].add(new Edge(19, 14, 1300));
        g1[19].add(new Edge(19, 18, 1200));
        g1[19].add(new Edge(19, 20, 700));

        g1[20].add(new Edge(20, 15, 1000));
        g1[20].add(new Edge(20, 19, 700));
        g1[20].add(new Edge(20, 21, 300));

        g1[21].add(new Edge(21, 15, 800));
        g1[21].add(new Edge(21, 16, 850));
        g1[21].add(new Edge(21, 20, 300));
        g1[21].add(new Edge(21, 22, 600));

        g1[22].add(new Edge(22, 16, 1000));
        g1[22].add(new Edge(22, 21, 600));
        g1[22].add(new Edge(22, 23, 900));

        g1[23].add(new Edge(23, 17, 900));
        g1[23].add(new Edge(23, 22, 900));

    }

    static void createGraph2(ArrayList<Edge> g2[]) {
        for (int i = 0; i < g2.length; i++)
            g2[i] = new ArrayList<>();

        g2[1].add(new Edge(1, 2, 1310));
        g2[1].add(new Edge(1, 3, 760));
        g2[1].add(new Edge(1, 4, 390));
        g2[1].add(new Edge(1, 7, 740));

        g2[2].add(new Edge(2, 1, 1310));
        g2[2].add(new Edge(2, 3, 550));
        g2[2].add(new Edge(2, 5, 390));
        g2[2].add(new Edge(2, 8, 450));

        g2[3].add(new Edge(3, 1, 760));
        g2[3].add(new Edge(3, 2, 550));
        g2[3].add(new Edge(3, 4, 660));
        g2[3].add(new Edge(3, 5, 210));
        g2[3].add(new Edge(3, 6, 390));

        g2[4].add(new Edge(4, 1, 390));
        g2[4].add(new Edge(4, 3, 660));
        g2[4].add(new Edge(4, 7, 340));
        g2[4].add(new Edge(4, 8, 1090));
        g2[4].add(new Edge(4, 10, 660));

        g2[5].add(new Edge(5, 2, 390));
        g2[5].add(new Edge(5, 3, 210));
        g2[5].add(new Edge(5, 6, 220));
        g2[5].add(new Edge(5, 8, 300));
        g2[5].add(new Edge(5, 11, 930));

        g2[6].add(new Edge(6, 3, 390));
        g2[6].add(new Edge(6, 5, 220));
        g2[6].add(new Edge(6, 7, 730));
        g2[6].add(new Edge(6, 8, 400));
        g2[6].add(new Edge(6, 9, 350));

        g2[7].add(new Edge(7, 1, 740));
        g2[7].add(new Edge(7, 4, 340));
        g2[7].add(new Edge(7, 6, 730));
        g2[7].add(new Edge(7, 9, 565));
        g2[7].add(new Edge(7, 10, 320));

        g2[8].add(new Edge(8, 2, 450));
        g2[8].add(new Edge(8, 4, 1090));
        g2[8].add(new Edge(8, 5, 300));
        g2[8].add(new Edge(8, 6, 400));
        g2[8].add(new Edge(8, 9, 600));
        g2[8].add(new Edge(8, 11, 820));

        g2[9].add(new Edge(9, 6, 350));
        g2[9].add(new Edge(9, 7, 565));
        g2[9].add(new Edge(9, 8, 600));
        g2[9].add(new Edge(9, 10, 730));
        g2[9].add(new Edge(9, 11, 320));

        g2[10].add(new Edge(10, 4, 660));
        g2[10].add(new Edge(10, 7, 320));
        g2[10].add(new Edge(10, 9, 730));
        g2[10].add(new Edge(10, 11, 820));

        g2[11].add(new Edge(11, 5, 930));
        g2[11].add(new Edge(11, 8, 820));
        g2[11].add(new Edge(11, 9, 320));
        g2[11].add(new Edge(11, 10, 820));
    }

    static void createGraph3(ArrayList<Edge> g3[]) {
        for (int i = 0; i < g3.length; i++)
            g3[i] = new ArrayList<>();

        g3[1].add(new Edge(1, 2, 1100));
        g3[1].add(new Edge(1, 3, 600));
        g3[1].add(new Edge(1, 4, 1000));

        g3[2].add(new Edge(2, 1, 1100));
        g3[2].add(new Edge(2, 3, 600));
        g3[2].add(new Edge(2, 8, 2800));

        g3[3].add(new Edge(3, 1, 600));
        g3[3].add(new Edge(3, 2,600));
        g3[3].add(new Edge(3, 6, 2000));

        g3[4].add(new Edge(4, 1, 1000));
        g3[4].add(new Edge(4, 5, 600));
        g3[4].add(new Edge(4, 11, 2400));

        g3[5].add(new Edge(5, 4, 600));
        g3[5].add(new Edge(5, 6, 1100));
        g3[5].add(new Edge(5, 7, 800));

        g3[6].add(new Edge(6, 3, 2000));
        g3[6].add(new Edge(6, 5, 1100));
        g3[6].add(new Edge(6, 10, 1200));
        g3[6].add(new Edge(6, 14, 2000));

        g3[7].add(new Edge(7, 5, 800));
        g3[7].add(new Edge(7, 8, 700));
        g3[7].add(new Edge(7, 10, 1300));

        g3[8].add(new Edge(8, 2, 2800));
        g3[8].add(new Edge(8, 7, 700));
        g3[8].add(new Edge(8, 9, 700));

        g3[9].add(new Edge(9, 8, 700));
        g3[9].add(new Edge(9, 10, 900));
        g3[9].add(new Edge(9, 12, 500));
        g3[9].add(new Edge(9, 13, 500));

        g3[10].add(new Edge(10, 6, 1200));
        g3[10].add(new Edge(10, 7, 1300));
        g3[10].add(new Edge(10, 9, 900));

        g3[11].add(new Edge(11, 4, 2400));
        g3[11].add(new Edge(11, 12, 800));
        g3[11].add(new Edge(11, 13, 1000));

        g3[12].add(new Edge(12, 9, 500));
        g3[12].add(new Edge(12, 11, 800));
        g3[12].add(new Edge(12, 14, 500));

        g3[13].add(new Edge(13, 9, 500));
        g3[13].add(new Edge(13, 11, 1000));
        g3[13].add(new Edge(13, 14, 300));

        g3[14].add(new Edge(14, 6, 2000));
        g3[14].add(new Edge(14, 12, 500));
        g3[14].add(new Edge(14, 13, 300));

    }

    static void createGraph4(ArrayList<Edge> g4[]) {
        for (int i = 0; i < g4.length; i++)
            g4[i] = new ArrayList<>();

        g4[0].add(new Edge(0, 1, 238));
        g4[0].add(new Edge(0, 3, 408));
        g4[0].add(new Edge(0, 4, 744));

        g4[1].add(new Edge(1, 0, 238));
        g4[1].add(new Edge(1, 2, 687));
        g4[1].add(new Edge(1, 5, 1153));

        g4[2].add(new Edge(2, 1, 687));
        g4[2].add(new Edge(2, 3, 77));
        g4[2].add(new Edge(2, 8,980 ));
        g4[2].add(new Edge(2, 9, 1479));

        g4[3].add(new Edge(3, 0, 408));
        g4[3].add(new Edge(3, 2, 77));
        g4[3].add(new Edge(3, 4, 601));

        g4[4].add(new Edge(4, 0, 744));
        g4[4].add(new Edge(4, 3, 601));
        g4[4].add(new Edge(4, 5, 549));
        g4[4].add(new Edge(4, 9, 1416));
        g4[4].add(new Edge(4, 12, 839));

        g4[5].add(new Edge(5, 1, 1153));
        g4[5].add(new Edge(5, 4, 549));
        g4[5].add(new Edge(5, 6, 545));

        g4[6].add(new Edge(6, 5, 545));
        g4[6].add(new Edge(6, 7, 163));
        g4[6].add(new Edge(6, 8, 1987));

        g4[7].add(new Edge(7, 6, 163));
        g4[7].add(new Edge(7, 11, 835));
        g4[7].add(new Edge(7, 13, 1221));

        g4[8].add(new Edge(8, 2, 980));
        g4[8].add(new Edge(8, 6, 1987));
        g4[8].add(new Edge(8, 9, 1081));
        g4[8].add(new Edge(8, 10, 1676));

        g4[9].add(new Edge(9, 2, 1479));
        g4[9].add(new Edge(9, 4, 1416));
        g4[9].add(new Edge(9, 8, 1081));

        g4[10].add(new Edge(10, 8, 1676));
        g4[10].add(new Edge(10, 11, 331));
        g4[10].add(new Edge(10, 12, 688));
        g4[10].add(new Edge(10, 13, 684));

        g4[11].add(new Edge(11, 7, 835));
        g4[11].add(new Edge(11, 10, 331));
        g4[11].add(new Edge(11, 12, 562));
        g4[11].add(new Edge(11, 13, 533));

        g4[12].add(new Edge(12, 4, 839));
        g4[12].add(new Edge(12, 10, 688));
        g4[12].add(new Edge(12, 11, 562));

        g4[13].add(new Edge(13, 7, 1221));
        g4[13].add(new Edge(13, 10, 684));
        g4[13].add(new Edge(13, 11, 533));

    }

    static class Pair implements Comparable<Pair>
    {
        int n;
        int path;
        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }
        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }
    public static int[][] dijkstra(ArrayList<Edge> graph[], int src)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[graph.length];
        boolean vis[] = new boolean[graph.length];
        int parent[]=new int[graph.length];
        int answer[][]=new int[2][graph.length];
        for(int i=0; i<dist.length; i++)
        {
            if(i != src)
            {
                dist[i] = INF;
                parent[i]=-1;
            }
            else
            {
                dist[i]=0;
                parent[i]=i;
            }
        }
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty())
        {
            Pair curr = pq.remove();
            if(!vis[curr.n])
            {
                vis[curr.n] = true;
                for(int i=0; i<graph[curr.n].size(); i++)
                {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if(!vis[v] && dist[u]+e.weight < dist[v])
                    {
                        dist[v] = dist[u] + e.weight;
                        parent[v]=u;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        answer[0]=parent;
        answer[1]=dist;
        return answer;
    }
    static void delEdge(ArrayList<Edge> adj[],int u, int v)
    {
        // Traversing through the first vector list
        // and removing the second element from it
        for (int i = 0; i < adj[u].size(); i++)
        {
            Edge e=adj[u].get(i);
            if (e.dest== v)
            {
                adj[u].remove(i);
                break;
            }
        }

        // Traversing through the second vector list
        // and removing the first element from it
        for (int i = 0; i < adj[v].size(); i++)
        {
            Edge e=adj[v].get(i);
            if (e.dest == u)
            {
                adj[v].remove(i);
                break;
            }
        }
    }
    static void generateRequestMenu(String NetworkName[], int startInd[], int endInd[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("------Category Of Request-------");
            System.out.println("1.FSD");
            System.out.println("2.VSD");
            System.out.println("3.Exit");
            System.out.println("---------------------------------");
            System.out.println("Enter Your Choice: ");
            int n = sc.nextInt();
            int datarate;

            switch (n) {
                case 1:
                    datarate = 80;
                    for (int i = 0; i < NetworkName.length; i++)
                        generateRequest(NetworkName[i], startInd[i], endInd[i], datarate, "FSD");
                    break;
                case 2:
                    datarate = 30;
                    for (int i = 0; i < NetworkName.length; i++)
                        generateRequest(NetworkName[i], startInd[i], endInd[i], datarate, "VSD");
                    break;

                case 3:
                    flag = false;
                    break;

            }
        } while (flag == true);

    }

    static void generateRequest(String NetworkName, int startInd, int endInd, int dataRate, String categoryOfDemand) throws IOException {
        Random rand = new Random();
        int noOfRequest;
        for (noOfRequest = 50; noOfRequest <= 300; noOfRequest += 50) {
            try {
                File fileObj = new File(String.format("%s_%s_%d", NetworkName, categoryOfDemand, noOfRequest));
                fileObj.createNewFile();
                FileWriter fileob = new FileWriter(String.format("%s_%s_%d", NetworkName, categoryOfDemand, noOfRequest), false);
                for (int j = 1; j <= noOfRequest; j++) {
                    String source = String.valueOf(rand.nextInt(startInd, endInd + 1));
                    String dest = String.valueOf(rand.nextInt(startInd, endInd + 1));
                    String data;
                    while (source.equals(dest)) {
                        dest = String.valueOf(rand.nextInt(startInd, endInd));
                    }
                    if (categoryOfDemand.equals("VSD")) {
                        int x = rand.nextInt(2, 7);
                        data = String.valueOf(dataRate * x);
                    } else {
                        data = String.valueOf(dataRate);
                    }
                    String s = source + "," + dest + "," + data;
                    fileob.write(s + "\n");

                }
                fileob.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    static void generateAllPath(String NetworkName[],int startInd[],int endInd[])
    {
        try{
            //Intialization

            ArrayList<Edge> graph[];
            //Load the driver

            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection
            String url="jdbc:mysql://localhost:3306/all_path";
            Connection con=DriverManager.getConnection(url,"root","");

            for(int network=0;network<NetworkName.length;network++) {
                int start = startInd[network];
                int V = endInd[network] + 1;
                int src;
                int ShortestPath[][] = new int[2][V];
                int parent[] = new int[V];
                int parent2[] = new int[V];
                int distance[] = new int[V];
                int distance2[] = new int[V];
                String p1="";
                String p2="";
                String p3="";
                String q1,q2,q3;
                PreparedStatement pstmt1;
                PreparedStatement pstmt2;
                PreparedStatement pstmt3;

                ArrayList<Integer> path1 = new ArrayList<>();
                ArrayList<Integer> path2 = new ArrayList<>();
                graph=new ArrayList[V];
                switch (network)
                {
                    case 0:

                        createGraph1(graph);
                        break;
                    case 1:
                        //graph=new ArrayList[V];
                        createGraph2(graph);
                        break;
                    case 2:
                        //graph=new ArrayList[V];
                        createGraph3(graph);
                        break;
                    case 3:
                        //graph=new ArrayList[V];
                        createGraph4(graph);
                        break;

                }

                for (src = start; src < V; src++) {
                    ShortestPath = dijkstra(graph, src);
                    System.arraycopy(ShortestPath[0], 0, parent, 0, V);
                    System.arraycopy(ShortestPath[1], 0, distance, 0, V);

                    int node;
                    for (int i = start; i < V; i++) {
                        node = i;
                        path1.add(i);
                        p1="";
                        p1=p1+i+',';
                        while (parent[node] != node) {
                            if (parent[node] == -1) {
                                //System.out.println("not reachable");
                                break;
                            }
                            path1.add(parent[node]);
                            p1=p1+parent[node]+',';
                            node = parent[node];
                        }

                        String key = String.format("%s,%s", src, i);
                        //key = key + ",0";
                        if(network==0) {

                            q1="insert into usa_network(pair,path1,distance1) values (?,?,?)";

                            //get the PreparedStatment object
                            pstmt1=con.prepareStatement(q1);
                            pstmt1.setString(1,key);
                            pstmt1.setString(2,p1);
                            pstmt1.setInt(3,distance[i]);

                            pstmt1.executeUpdate();
                        }
                        else if(network==1)
                        {
                            q1="insert into cost239_network(pair,path1,distance1) values (?,?,?)";

                            //get the PreparedStatment object
                            pstmt1=con.prepareStatement(q1);
                            pstmt1.setString(1,key);
                            pstmt1.setString(2,p1);
                            pstmt1.setInt(3,distance[i]);

                            pstmt1.executeUpdate();
                        }
                        else if(network==2)
                        {

                            q1="insert into nsf_network(pair,path1,distance1) values (?,?,?)";

                            //get the PreparedStatment object
                            pstmt1=con.prepareStatement(q1);
                            pstmt1.setString(1,key);
                            pstmt1.setString(2,p1);
                            pstmt1.setInt(3,distance[i]);

                            pstmt1.executeUpdate();
                        }
                        else if(network==3)
                        {
                            q1="insert into optical_network(pair,path1,distance1) values (?,?,?)";

                            //get the PreparedStatment object
                            pstmt1=con.prepareStatement(q1);
                            pstmt1.setString(1,key);
                            pstmt1.setString(2,p1);
                            pstmt1.setInt(3,distance[i]);

                            pstmt1.executeUpdate();
                        }

                        for (int len = path1.size() - 1; len > 0; len--)
                            delEdge(graph, path1.get(len), path1.get(len - 1));

                        path1.clear();
                        ShortestPath = dijkstra(graph, src);
                        System.arraycopy(ShortestPath[0], 0, parent2, 0, V);
                        System.arraycopy(ShortestPath[1], 0, distance2, 0, V);
                        node = i;
                        p2="";
                        path2.add(i);
                        p2+=i+",";
                        while (parent2[node] != node) {
                            if (parent2[node] == -1) {
                                //System.out.println("not reachable");
                                break;
                            }
                            path2.add(parent2[node]);
                            p2+=parent2[node]+",";
                            node = parent2[node];
                        }

                        String key2 = String.format("%s,%s", src, i);
                        //key2 += ",1";
                        if(network==0) {
                            q2="update usa_network set path2=?,distance2=? where pair=?";

                            //get the PreparedStatment object
                            pstmt2=con.prepareStatement(q2);
                            pstmt2.setString(1,p2);
                            pstmt2.setInt(2,distance2[i]);
                            pstmt2.setString(3,key2);

                            pstmt2.executeUpdate();
                        }
                        else if(network==1)
                        {

                            q2="update cost239_network set path2=?,distance2=? where pair=?";

                            //get the PreparedStatment object
                            pstmt2=con.prepareStatement(q2);
                            pstmt2.setString(1,p2);
                            pstmt2.setInt(2,distance2[i]);
                            pstmt2.setString(3,key2);

                            pstmt2.executeUpdate();
                        }
                        else if(network==2)
                        {
                            q2="update nsf_network set path2=?,distance2=? where pair=?";

                            //get the PreparedStatment object
                            pstmt2=con.prepareStatement(q2);
                            pstmt2.setString(1,p2);
                            pstmt2.setInt(2,distance2[i]);
                            pstmt2.setString(3,key2);

                            pstmt2.executeUpdate();
                        }
                        else if(network==3)
                        {
                            q2="update optical_network set path2=?,distance2=? where pair=?";

                            //get the PreparedStatment object
                            pstmt2=con.prepareStatement(q2);
                            pstmt2.setString(1,p2);
                            pstmt2.setInt(2,distance2[i]);
                            pstmt2.setString(3,key2);

                            pstmt2.executeUpdate();
                        }
                        for (int len = path2.size() - 1; len > 0; len--)
                            delEdge(graph, path2.get(len), path2.get(len - 1));
                        path2.clear();
                        ShortestPath = dijkstra(graph, src);
                        System.arraycopy(ShortestPath[0], 0, parent2, 0, V);
                        System.arraycopy(ShortestPath[1], 0, distance2, 0, V);
                        node = i;
                        p3="";
                        path2.add(i);
                        p3+=i+",";
                        while (parent2[node] != node) {
                            if (parent2[node] == -1) {
                                //System.out.println("not reachable");
                                break;
                            }
                            path2.add(parent2[node]);
                            p3+=parent2[node]+",";
                            node = parent2[node];
                        }

                        String key3 = String.format("%s,%s", src, i);
                        //key3 += ",2";
                        if(network==0) {
                            q3="update usa_network set path3=?,distance3=? where pair=?";

                            //get the PreparedStatment object
                            pstmt3=con.prepareStatement(q3);
                            pstmt3.setString(1,p3);
                            pstmt3.setInt(2,distance2[i]);
                            pstmt3.setString(3,key3);

                            pstmt3.executeUpdate();
                        }
                        else if(network==1)
                        {
                            q3="update cost239_network set path3=?,distance3=? where pair=?";

                            //get the PreparedStatment object
                            pstmt3=con.prepareStatement(q3);
                            pstmt3.setString(1,p3);
                            pstmt3.setInt(2,distance2[i]);
                            pstmt3.setString(3,key3);

                            pstmt3.executeUpdate();
                        }
                        else if(network==2)
                        {
                            q3="update nsf_network set path3=?,distance3=? where pair=?";

                            //get the PreparedStatment object
                            pstmt3=con.prepareStatement(q3);
                            pstmt3.setString(1,p3);
                            pstmt3.setInt(2,distance2[i]);
                            pstmt3.setString(3,key3);

                            pstmt3.executeUpdate();
                        }
                        else if(network==3)
                        {
                            q3="update optical_network set path3=?,distance3=? where pair=?";

                            //get the PreparedStatment object
                            pstmt3=con.prepareStatement(q3);
                            pstmt3.setString(1,p3);
                            pstmt3.setInt(2,distance2[i]);
                            pstmt3.setString(3,key3);

                            pstmt3.executeUpdate();
                        }
                        path2.clear();
                        for (int j = 0; j < graph.length; j++)
                            graph[j].clear();

                        switch(network)
                        {
                            case 0:
                                createGraph1(graph);
                                break;
                            case 1:
                                createGraph2(graph);
                                break;
                            case 2:
                                createGraph3(graph);
                                break;
                            case 3:
                                createGraph4(graph);
                                break;

                        }

                        System.arraycopy(parent, 0, ShortestPath[0], 0, V);
                        System.arraycopy(distance, 0, ShortestPath[1], 0, V);

                    }

                }

            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Connection Failed");
        }
    }
    public static  int getWeight(ArrayList<Edge> adj[],int u, int v)
    {
        // Traversing through the first vector list
        // and  get the weight of the edge to the destination
        for (int i = 0; i < adj[u].size(); i++)
        {
            Edge e=adj[u].get(i);
            if (e.dest== v)
            {
                return e.weight;
            }
        }
        return -1;
    }
    public static String reverseString(String str){
        char ch[]=str.toCharArray();
        String rev="";
        for(int i=ch.length-1;i>=0;i--){
            rev+=ch[i];
        }
        return rev;
    }
    static void mapEdges(ArrayList<Edge> graph[],String NetworkName)
    {
        int count=0;
        int n= graph.length;
        int src,dest,weight;
        String key="";
        String reversekey="";
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<graph[i].size();j++)
            {
                Edge e=graph[i].get(j);
                src=e.src;
                dest=e.dest;
                weight=e.weight;
                key=src+","+dest;
                reversekey=dest+","+src;
                if(NetworkName=="USAnetwork") {
                    if (USAnetwork_edge.containsKey(reversekey)) {
                        USAnetwork_edge.put(key, USAnetwork_edge.get(reversekey));
                    } else {
                        USAnetwork_edge.put(key, count);

                        count++;
                    }
                }
                else if(NetworkName=="Cost239") {
                    if (Cost239_edge.containsKey(reversekey)) {
                        Cost239_edge.put(key, Cost239_edge.get(reversekey));
                    } else {
                        Cost239_edge.put(key, count);

                        count++;
                    }
                }
                else if(NetworkName=="NSFnetwork") {
                    if (NSFnetwork_edge.containsKey(reversekey)) {
                        NSFnetwork_edge.put(key, NSFnetwork_edge.get(reversekey));
                    } else {
                        NSFnetwork_edge.put(key, count);
                        count++;
                    }
                }
                if(NetworkName=="Opticalnetwork") {
                    if (Opticalnetwork_edge.containsKey(reversekey)) {
                        Opticalnetwork_edge.put(key, Opticalnetwork_edge.get(reversekey));
                    } else {
                        Opticalnetwork_edge.put(key, count);

                        count++;
                    }
                }

            }
        }
    }
    static void mapMenu()
    {
        int ch;
        Scanner sc=new Scanner(System.in);
        do {
            System.out.println("1.USA Network");
            System.out.println("2.Cost239 Network");
            System.out.println("3.NSF Network");
            System.out.println("4.Optical Network");
            System.out.println("0.Exit");
            System.out.println("Enter Your Choice: ");
            ch=sc.nextInt();

            switch(ch)
            {
                case 1:
                    mapEdges(USAnetwork,"USAnetwork");
                    break;
                case 2:
                    mapEdges(Cost239,"Cost239");
                    break;
                case 3:
                    mapEdges(NSFnetwork,"NSFnetwork");
                    break;
                case 4:
                    mapEdges(Opticalnetwork,"Opticalnetwork");
                    break;
                case 0:
                    break;
            }
        }while(ch!=0);
    }
    public static void main(String[] args) throws IOException {
        //Creating graph 1 whose number of nodes is 24 but we are creating an array of 25 as node number starts with 1
        USAnetwork= new ArrayList[24];
        createGraph1(USAnetwork);
        //Creating graph 2 whose number of node is 11 but we are creating an array of of 12 as node number start with 1
        Cost239 = new ArrayList[12];
        createGraph2(Cost239);
        //Creating graph 3 whose number of node is 14 and start index=0
        NSFnetwork = new ArrayList[15];
        createGraph3(NSFnetwork);
        //Creating graph 4 whose number of nodes is 14 but we are creating an array of 15 as node number starts with 1
        Opticalnetwork = new ArrayList[14];
        createGraph4(Opticalnetwork);


        // generateRequestMenu(NetworkName, startIndex, endIndex);
        generateAllPath(NetworkName,startIndex,endIndex);
      // EnergyCalculate obj=new EnergyCalculate();
       // obj.calculateEnergyForPath(1,3,80,"Cost239");
       // EnergyCalculate.readFileForEnergy();
    //    mapMenu();

       //CrosstalkCalculate.calculateXTMenu();
        //CoreAllocation obj=new CoreAllocation();
       /*
        int subcarrier=(int)EnergyCalculate.cal_N(80,37.5,2);

        System.out.println(subcarrier);

       System.out.println();
       */
    //    CoreAllocation.readFileForCoreAllocation();
        //CoreAllocation.display_slots(CoreAllocation.core_slots);
       /* CoreAllocation.initializeSlots("USAnetwork");
        //CoreAllocation.mark_all_slots(CoreAllocation.core_slots);
        CoreAllocation.copy_edge_map=USAnetwork_edge;
        int path[]={1,0};
        System.out.println(CoreAllocation.allocateCoreLeastFrequentModified(200,path));

    */
    }
}
class CrosstalkCalculate extends Main
{
    static int AdjacentCore[]={6,3,3,3,3,3,3};
    static final double cop_coeff=2*Math.pow(10,-5);
    static final double prop_const=4*Math.pow(10,6);
    static final double bending_radius=50*Math.pow(10,-6);

    static final double core_pitch=45*Math.pow(10,-9);
   //CIPL stands for Cross Talk Increase Per Unit Length
    static final double CIPL=(2*(Math.pow(cop_coeff,2))*bending_radius)/(prop_const*core_pitch);

    static double USAnetwork_XT[][]=new double[43][7];
    static double Cost239_XT[][]=new double[26][7];
    static double NSFnetwork_XT[][]=new double[23][7];
    static double Opticalnetwork_XT[][]=new double[25][7];



    static double calculateXT(double length,double AdjCore)
    {
        double val;
        double helper=AdjCore*(Math.exp((-1)*(AdjCore+1)*2*CIPL*length));
        System.out.println("Value of helper: "+helper);
        //double numerator=AdjCore*(1-Math.exp((-1)*(AdjCore+1)*2*CIPL*length));
        double numerator=AdjCore-helper;
        System.out.println("Value of CIPL: "+CIPL);
        System.out.println(numerator);

        //double denominator=1+AdjCore*Math.exp((-1)*(AdjCore+1)*2*CIPL*length);
        double denominator=1+helper;
        System.out.println(denominator);
        val=(numerator/denominator);
        return val;
    }
    static void calculateXTForALl(ArrayList<Edge> graph[],String networkName)
    {
        int n=graph.length;
        int visited[]=new int[0] ;
        if(networkName=="USAnetwork")
            visited=new int[43];
        else if(networkName=="Cost239")
            visited=new int[26];
        else if(networkName=="NSFnetwork")
            visited=new int[23];
        else if(networkName=="Opticalnetwork")
            visited=new int[25];
       // for (int b : visited) b = 0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<graph[i].size();j++)
            {
                Edge e=graph[i].get(j);
                int src=e.src;
                int dest=e.dest;
                int weight=e.weight;
                String key=src+","+dest;
                int edge_number=0;
                if(networkName=="USAnetwork")
                    edge_number=USAnetwork_edge.get(key);
                else if(networkName=="Cost239")
                    edge_number=Cost239_edge.get(key);
                else if(networkName=="NSFnetwork")
                    edge_number=NSFnetwork_edge.get(key);
                else if(networkName=="Opticalnetwork")
                    edge_number=Opticalnetwork_edge.get(key);

                if(visited[edge_number]==0)
                {
                    visited[edge_number]=1;
                    for(int k=0;k<AdjacentCore.length;k++)
                    {
                        if(networkName=="USAnetwork")
                            USAnetwork_XT[edge_number][k]=calculateXT(weight,AdjacentCore[k]);
                        else if(networkName=="Cost239")
                            Cost239_XT[edge_number][k]=calculateXT(weight,AdjacentCore[k]);
                        else if(networkName=="NSFnetwork")
                            NSFnetwork_XT[edge_number][k]=calculateXT(weight,AdjacentCore[k]);
                        else if(networkName=="Opticalnetwork")
                            Opticalnetwork_XT[edge_number][k]=calculateXT(weight,AdjacentCore[k]);
                    }

                }
            }
        }
    }
    static void printArray(double arr[][])
    {
        int m= arr.length;;
        int n=arr[0].length;
        System.out.println("Given Array Is:\n");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
              System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void calculateXTMenu()
    {
        int ch;
        Scanner sc=new Scanner(System.in);
        do {
            System.out.println("1.USA Network");
            System.out.println("2.Cost239 Network");
            System.out.println("3.NSF Network");
            System.out.println("4.Optical Network");
            System.out.println("0.Exit");
            System.out.println("Enter Your Choice: ");
            ch=sc.nextInt();

            switch(ch)
            {
                case 1:
                    calculateXTForALl(USAnetwork,"USAnetwork");
                    printArray(USAnetwork_XT);
                    break;
                case 2:
                    calculateXTForALl(Cost239,"Cost239");
                    printArray(Cost239_XT);
                    break;
                case 3:
                    calculateXTForALl(NSFnetwork,"NSFnetwork");
                    printArray(NSFnetwork_XT);
                    break;
                case 4:
                    calculateXTForALl(Opticalnetwork,"Opticalnetwork");
                    printArray(Opticalnetwork_XT);
                    break;
                case 0:
                    break;
            }
        }while(ch!=0);
    }

}
class EnergyCalculate extends Main
{
    static final int drop_degree=50;
    static final int total_slots=500;
    static double cal_e_m(double s_m)
    {
        double em=1.683*s_m+91.333;
        return em;
    }
    static double cal_N(int D, double S_m, double g)
    {
        double n = (double)Math.ceil(D/(S_m));
        return  n + g;
    }

    static double cal_Ebvt(double e_m, double cal_N)
    {
        return (2* e_m *cal_N);
    }
     static double calculateSm(int dist) {

        if (dist <=500) {
            return 50;
        } else if (dist > 500 && dist <= 1000) {
            return 37.5;
        } else if (dist > 1000 && dist <=2000) {
            return 25;
        } else if (dist > 2000) {
            return 12.5;
        }
        return 0;
    }
    static double[] cal_EOXCandEDFA(String network_name,int path[],int Data,double S_m,int slot_used)
    {
        int n=path.length;
        double eoxc=0.0d;
        double edfa=0.0d;
        double ea=0.0d;
        double eo=0.0d;
        int j;
        for(int i=n-1;i>=1;i--)
        {
            j=i-1;
            int weight=0;
            if(network_name.equals("USAnetwork")) {
                eo = 85 * USnetwork_nodaldeg[path[i]] + 100 * drop_degree + 150;
                //Number of frequency slots used
                weight = getWeight(USAnetwork, path[i], path[j]);
            }
            else if(network_name.equals("Cost239")) {
                eo = 85 * Cost239_nodaldeg[path[i]] + 100 * drop_degree + 150;
                //Number of frequency slots used
                weight = getWeight(Cost239, path[i], path[j]);
            }
            else if(network_name.equals("NSFnetwork")) {
                eo = 85 * NSFnetwork_nodaldeg[path[i]] + 100 * drop_degree + 150;
                //Number of frequency slots used
                weight = getWeight(NSFnetwork, path[i], path[j]);
            }
            else if(network_name.equals("Opticalnetwork")) {
                eo = 85 * Opticalnetwork_nodaldeg[path[i]] + 100 * drop_degree + 150;
                //Number of frequency slots used
                weight = getWeight(Opticalnetwork, path[i], path[j]);
            }
            ea=Math.abs((weight/80.0)+1.0)*100;

            eoxc+=((slot_used*eo)/total_slots);
            edfa+=((slot_used*ea)/total_slots);

        }

        return new double[]{eoxc,edfa};
    }
     static double calculateTotalEnergy(String NetworkName,int Path[],int Data,int Distance)
    {
        double  ebvt=0.0;
        double  eoxc=0.0;
        double  edfa=0.0;
        double total=0.0;
        double S_m=calculateSm(Distance);
        double em=cal_e_m(S_m);
        int slot_used=(int)cal_N(Data,S_m,2.0);
        ebvt=cal_Ebvt(em,slot_used);
        double[] eoxc_edfa = cal_EOXCandEDFA(NetworkName, Path, Data, S_m, slot_used);
        eoxc=eoxc_edfa[0];
        edfa=eoxc_edfa[1];
        total=(ebvt+eoxc+edfa)/1000;

        return total;
    }
  static int[] ConvertArray(String str)
  {

      String[] splitArray = str.split(",");
      int[] array = new int[splitArray.length];

      // parsing the String argument as a signed decimal
      // integer object and storing that integer into the
      // array
      for (int i = 0; i < splitArray.length; i++) {
          array[i] = Integer.parseInt(splitArray[i]);
      }
      return array;
  }
  static void readFileForEnergy() throws IOException
  {
      String flag,line;
      do {
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter File name: ");
          String fname = sc.nextLine();
          fname="C:\\Users\\Joyti\\Project1\\"+fname;
          FileReader fr = new FileReader(fname);
          BufferedReader br = new BufferedReader(fr);
          line = br.readLine();
          int request[] = ConvertArray(line);

          while (line != null) {
              System.out.println("Src: "+request[0]+" Dest: "+request[1]+" Demand: "+request[2]);
              if (fname.contains("USAnetwork")) {
                  calculateEnergyForPath(request[0], request[1], request[2], "USAnetwork");
              }
              else if (fname.contains("Cost239"))
                  calculateEnergyForPath(request[0], request[1], request[2], "Cost239");
              else if (fname.contains("NSFnetwork"))
                  calculateEnergyForPath(request[0], request[1], request[2], "NSFnetwork");
              else if (fname.contains("Opticalnetwork"))
                  calculateEnergyForPath(request[0], request[1], request[2], "Opticalnetwork");


                  line = br.readLine();
                  if(line!=null)
                    request = ConvertArray(line);

          }
          br.close();
          System.out.println("Do You Want To Continue, type yes or no: ");
          flag=sc.next();
      }while(flag.equalsIgnoreCase("yes"));

  }
    static void calculateEnergyForPath(int src,int dest,int dataDemand,String NetworkName)
    {
        try{
            //Load the driver

            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection
            String url="jdbc:mysql://localhost:3306/all_path";
            Connection con=DriverManager.getConnection(url,"root","");
            String q1;
            String key=src+","+dest;
            PreparedStatement pstmt1;
            ResultSet rs=null;
            HashMap<String,Double> result=new HashMap<>();
            if(NetworkName.equals("USAnetwork")) {
                q1 = "select * from usa_network where pair=?";
                pstmt1=con.prepareStatement(q1);
                pstmt1.setString(1,key);
                rs=pstmt1.executeQuery();

            }
            else if(NetworkName.equals("Cost239")) {
                q1 = "select * from cost239_network where pair=?";
                pstmt1=con.prepareStatement(q1);
                pstmt1.setString(1,key);
                rs=pstmt1.executeQuery();

            }
            else if(NetworkName.equals("NSFnetwork")) {
                q1 = "select * from nsf_network where pair=?";
                pstmt1=con.prepareStatement(q1);
                pstmt1.setString(1,key);
                rs=pstmt1.executeQuery();

            }
            else if(NetworkName.equals("Opticalnetwork")) {
                q1 = "select * from optical_network where pair=?";
                pstmt1=con.prepareStatement(q1);
                pstmt1.setString(1,key);
                rs=pstmt1.executeQuery();

            }

                rs.next();
                int path1[] = ConvertArray(rs.getString(2));
                int path2[] = ConvertArray(rs.getString(4));
                int path3[] = ConvertArray(rs.getString(6));
                int dist1 = rs.getInt(3);
                int dist2 = rs.getInt(5);
                int dist3 = rs.getInt(7);
                //System.out.println("path1: " + path1 + " path2: " + path2 + " path3: " + path3);
                //System.out.println(caculateTotalEnergy(NetworkName,path1,dataDemand,dist1));
                //Calculating Energy for first combination
                double energy_path1=calculateTotalEnergy(NetworkName,path1,dataDemand,dist1);
                double energy_path2=0.0d;
                double energy_path3=0.0d;
               if(dist2!=Integer.MAX_VALUE)
                     energy_path2=calculateTotalEnergy(NetworkName,path2,dataDemand,dist2);
                else
                {
                    System.out.println("Second Path Not Exist");
                }
                //System.out.println("Energy of path1 and path2: "+(energy_path1+energy_path2));
                result.put("c1",(energy_path1+energy_path2));
                if(dist3!=Integer.MAX_VALUE)
                {
                    //Calculating energy for 2nd combination
                    energy_path3=calculateTotalEnergy(NetworkName,path3,dataDemand,dist3);
                   // System.out.println("Energy of path2 and path3: "+(energy_path2+energy_path3));
                    result.put("c2",(energy_path2+energy_path3));
                    //calculating energy for 3rd combination
                   // System.out.println("Energy of path3 and path1: "+(energy_path3+energy_path1));
                    result.put("c3",(energy_path3+energy_path1));
                    //Calculating energy for 4th combination
                    double p1=calculateTotalEnergy(NetworkName,path1,(dataDemand/2),dist1);
                    double p2=calculateTotalEnergy(NetworkName,path2,(dataDemand/2),dist2);
                    double p3=calculateTotalEnergy(NetworkName,path3,(dataDemand/2),dist3);
                    //System.out.println("Energy of path1,path2 and path3: "+(p1+p2+p3));
                    result.put("c4",(p1+p2+p3));
                }
                result=sortByValue(result);
                for (Map.Entry<String, Double> en : result.entrySet()) {
                System.out.println("Key = " + en.getKey() + ", Value = " + en.getValue());
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    public static HashMap<String, Double> sortByValue(HashMap<String, Double> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Double> > list =
                new LinkedList<>(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Double> >() {
            public int compare(Map.Entry<String, Double> o1,
                               Map.Entry<String, Double> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Double> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}

class CoreAllocation extends Main
{
   static  int core_size[]={1,1,2,3,5,7,11};
   static final int total_slots=150;
    static final  int number_of_cores=7;
    static int last_allocated_slot_core0=0;
   static int core_slots[][][];
    static HashMap<String,Integer> copy_edge_map=new HashMap<>();

    static int frequencyOfCore[]=new int[number_of_cores];

    static void initializeFrequency()
    {
        for(int i=0;i<number_of_cores;i++)
            frequencyOfCore[i]=0;
    }
   static void initializeSlots(String networkName)
   {

       if(networkName.equalsIgnoreCase("USAnetwork"))
           core_slots=new int[noOFEdges[0]][number_of_cores][total_slots+1];

       else if(networkName.equalsIgnoreCase("Cost239"))
           core_slots=new int[noOFEdges[1]][number_of_cores][total_slots+1];
       else if(networkName.equalsIgnoreCase("NSFnetwork"))
           core_slots=new int[noOFEdges[2]][number_of_cores][total_slots+1];
       else if(networkName.equalsIgnoreCase("Opticalnetwork"))
           core_slots=new int[noOFEdges[3]][number_of_cores][total_slots+1];

       for(int i=0;i<core_slots.length;i++)
       {
           for(int j=0;j<number_of_cores;j++)
           {
               for(int k=0;k<total_slots+1;k++)
                   core_slots[i][j][k]=0;
           }
       }

      // display_slots(core_slots);
   }
   static void display_slots(int core_slots[][][])
   {
       for(int i=0;i<core_slots.length;i++)
       {
           System.out.println("For Node Number: "+i);
           for(int j=0;j<number_of_cores;j++)
           {
               System.out.println("For Core Number: "+j);
               for(int k=0;k<total_slots+1;k++)
                   System.out.print(core_slots[i][j][k]+"   ");
               System.out.println();
           }
       }
   }

    static int allocateCoreLeastFrequent(int requested_slot,int path[])
    {
        int flag=1;
        for(int i=number_of_cores-1;i>=2;i--)
        {
            if(requested_slot>=core_size[i])
            {
                int max = i;
                int min = i - 1;
                //Random random = new Random();
                //int ind = random.nextInt(max - min + 1) + min;
                int ind;
                ind=frequencyOfCore[max]<=frequencyOfCore[min]?max:min;
               // System.out.println(frequencyOfCore[ind]+" ");

                int no_of_slot_needed = (requested_slot / core_size[ind])*core_size[ind]+2;
                int start_index=isSafe(path,ind,no_of_slot_needed);
                int slot_given=0;
                if(start_index!=-1) {
                    slot_given = no_of_slot_needed;
                    markSlot(path,ind,start_index,start_index+slot_given-1);
                    frequencyOfCore[ind]++;
                }

                if(slot_given!=0)
                    System.out.println("core: "+ind+" Group: "+(requested_slot / core_size[ind]));
                requested_slot = requested_slot - (slot_given-2);
                if(requested_slot==0)
                    break;
            }
        }
        if(requested_slot==1)
        {
            //indicate upto slot ind needed
            int slot=requested_slot+2;
            int start_ind=isSafe(path,1,slot);
            if(start_ind!=-1)
            {
                markSlot(path,1,start_ind,start_ind+slot-1);
                frequencyOfCore[1]++;
                System.out.println("core :"+1+" slot: "+requested_slot);
                requested_slot=0;
            }

        }
        if(requested_slot!=0)
        {
            //indicate upto slot ind needed
            int slot=requested_slot+2;
            int start_ind=isSafe(path,0,slot);
            if(start_ind!=-1)
            {
                markSlot(path,0,start_ind,start_ind+slot-1);
                frequencyOfCore[0]++;
                System.out.println("core :"+0+" slot: "+requested_slot);
            }
            else {
                System.out.println("Allocation Not Possible");
                flag=0;
            }

        }
        if(flag==1)
            return 1;
        else
            return 0;
    }

     static int allocateCore(int requested_slot,int path[])
     {
         int flag=1;

        for(int i=number_of_cores-1;i>=2;i--)
        {
            if(requested_slot>=core_size[i])
            {
                int max = i;
                int min = i - 1;
                Random random = new Random();
                int ind = random.nextInt(max - min + 1) + min;

                int no_of_slot_needed = (requested_slot / core_size[ind])*core_size[ind]+2;
                int start_index=isSafe(path,ind,no_of_slot_needed);
                int slot_given=0;
                if(start_index!=-1) {
                    slot_given = no_of_slot_needed;
                    markSlot(path,ind,start_index,start_index+slot_given-1);
                }

                if(slot_given!=0)
                    System.out.println("core: "+ind+" Group: "+(requested_slot / core_size[ind]));
                requested_slot = requested_slot - (slot_given-2);
                if(requested_slot==0)
                    break;
            }
        }
         if(requested_slot==1)
         {
             //indicate upto slot ind needed
             int slot=requested_slot+2;
             int start_ind=isSafe(path,1,slot);
             if(start_ind!=-1)
             {
                 markSlot(path,1,start_ind,start_ind+slot-1);
                 System.out.println("core :"+1+" slot: "+requested_slot);
                 requested_slot=0;
             }

         }
        if(requested_slot!=0)
        {
            //indicate upto slot ind needed
            int slot=requested_slot+2;
            int start_ind=isSafe(path,0,slot);
            if(start_ind!=-1)
            {
                markSlot(path,0,start_ind,start_ind+slot-1);
                System.out.println("core :"+0+" slot: "+requested_slot);
            }
            else {
                System.out.println("Allocation Not Possible");
                flag=0;
            }

        }
        if(flag==0)
            return 0;
        else
            return 1;

    }
    static int isSafe(int path[],int core_number,int slot)
    {
        int flag=1;
        int max_last_index=-1;
        int Nodenum;
        for(int i=path.length-1;i>=1;i--)
        {
            int j=i-1;
            String key=path[i]+","+path[j];
            //Node num denotes the edge number corresponding to the key
            Nodenum=copy_edge_map.get(key);
            max_last_index=Math.max(max_last_index,core_slots[Nodenum][core_number][total_slots+1-1]);

        }
        int start=max_last_index+1;
        int end=max_last_index+slot-1;
        if(end>=total_slots)
            return -1;
        for(int i=path.length-1;i>=1;i--)
        {
            int k=i-1;
            String key=path[i]+","+path[k];
            //Node num denotes the edge number corresponding to the key
            Nodenum=copy_edge_map.get(key);
            for(int j=start;j<=end;j++) {
                if(core_slots[Nodenum][core_number][j] == 1) {
                    flag =-1;
                    return flag;
                }
            }

        }
        flag=start;
        return flag;
    }
    static void markSlot(int path[],int core_number,int start,int end)
    {
        int Nodenum;
        for(int j=path.length-1;j>=1;j--) {
            int k=j-1;
            String key=path[j]+","+path[k];
            //Node num denotes the edge number corresponding to the key
            Nodenum=copy_edge_map.get(key);

            for (int i = start; i <= end; i++)
                core_slots[Nodenum][core_number][i] = 1;
            core_slots[Nodenum][core_number][total_slots]=end;
        }
    }
    static void readFileForCoreAllocation() throws IOException
    {
        try {
            String flag, line;
            //Load the driver

            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection
            String url = "jdbc:mysql://localhost:3306/all_path";
            Connection con = DriverManager.getConnection(url, "root", "user@123");
            String q1;
            String key;
            PreparedStatement pstmt1;
            ResultSet rs = null;
            do {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter File name: ");
                String fname = sc.nextLine();
                fname = "/Users/sumankumari/Desktop/Suman/project/NSFnetwork_VSD_150" + fname;
                FileReader fr = new FileReader(fname);
                BufferedReader br = new BufferedReader(fr);
                line = br.readLine();
                int request[] = EnergyCalculate.ConvertArray(line);
                int noofrequest=0;
                int served_requests=0;
                int dist1;
                if(fname.contains("USAnetwork")) {
                    initializeSlots("USAnetwork");
                    copy_edge_map.putAll(USAnetwork_edge);
                }
                else if(fname.contains("Cost239")) {
                    initializeSlots("Cost239");
                    copy_edge_map.putAll(Cost239_edge);
                }
                else if(fname.contains("NSFnetwork")) {
                    initializeSlots("NSFnetwork");
                    copy_edge_map.putAll(NSFnetwork_edge);
                }
                else if(fname.contains("Opticalnetwork")) {
                    initializeSlots("Opticalnetwork");
                    copy_edge_map.putAll(Opticalnetwork_edge);
                }

                while (line != null) {
                    System.out.println("Src: " + request[0] + " Dest: " + request[1] + " Demand: " + request[2]);
                    key=request[0]+","+request[1];
                    if (fname.contains("USAnetwork")) {
                        q1 = "select * from usa_network where pair=?";
                        pstmt1=con.prepareStatement(q1);
                        pstmt1.setString(1,key);
                        rs=pstmt1.executeQuery();

                    }
                    else if(fname.contains("Cost239")) {
                        q1 = "select * from cost239_network where pair=?";
                        pstmt1=con.prepareStatement(q1);
                        pstmt1.setString(1,key);
                        rs=pstmt1.executeQuery();

                    }
                    else if(fname.contains("NSFnetwork")) {
                        q1 = "select * from nsf_network where pair=?";
                        pstmt1=con.prepareStatement(q1);
                        pstmt1.setString(1,key);
                        rs=pstmt1.executeQuery();

                    }
                    else if(fname.contains("Opticalnetwork")) {
                        q1 = "select * from optical_network where pair=?";
                        pstmt1=con.prepareStatement(q1);
                        pstmt1.setString(1,key);
                        rs=pstmt1.executeQuery();

                    }
                    rs.next();
                    dist1 = rs.getInt(3);
                    if(dist1==Integer.MAX_VALUE)
                    {
                        System.out.println("Path Not Exists!!");
                        line = br.readLine();
                        continue;
                    }
                    String p=rs.getString(4);
                    int path[]=EnergyCalculate.ConvertArray(p);
                    double s_m=EnergyCalculate.calculateSm(dist1);
                    int subCarrier=(int)EnergyCalculate.cal_N(request[2],s_m,2);
                    System.out.println("Sub Carrier: "+subCarrier);
                   // allocateCore(subCarrier,path);

                    noofrequest++;

                  //served_requests+=allocateCore(subCarrier,path);
                  // served_requests+=allocateCoreLeastFrequent(subCarrier,path);
                   served_requests+=allocateCoreLeastFrequentModified(subCarrier,path);
                    //int dist2 = rs.getInt(5);
                    //int dist3 = rs.getInt(7);

                    line = br.readLine();
                    if (line != null)
                        request = EnergyCalculate.ConvertArray(line);

                }
                br.close();
                System.out.println("\n Total Requests: "+noofrequest+" served_requests: "+served_requests+" Blocked Request: "+(noofrequest-served_requests));
                display_slots(core_slots);
                copy_edge_map.clear();
                System.out.println("Do You Want To Continue, type yes or no: ");
                flag = sc.next();
            } while (flag.equalsIgnoreCase("yes"));
            con.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    static int allocateCoreLeastFrequentModified(int requested_slot, int path[])
    {

        int[] visited;
        visited = new int[number_of_cores];
        for(int i=0;i<number_of_cores;i++)
            visited[i]=0;
        while (requested_slot > 0)
        {
            int selected_core = -1;
            int min_frequency = Integer.MAX_VALUE;


            // Try to find a core other than core 0 with the least frequency
            for (int i = number_of_cores - 1; i >= 1; i--) {
                if (requested_slot >= core_size[i] &&visited[i]!=1) {
                    if (frequencyOfCore[i] < min_frequency || (frequencyOfCore[i] == min_frequency && i > selected_core)) {
                        min_frequency = frequencyOfCore[i];
                        selected_core = i;
                        visited[i]=1;
                    }
                }
            }

            // If no suitable core found and core 0 is available, try core 0
            if (selected_core == -1) {
                selected_core = 0;
                if (requested_slot < core_size[selected_core]) {
                    System.out.println("Allocation Not Possible");
                    return 0;
                }
            }

            // Calculate number of slots needed based on core_size[selected_core]
            int no_of_slot_needed =(requested_slot / core_size[selected_core])*core_size[selected_core]+2 ;

            // Check if there's enough space in the path for allocation
            int start_index = isSafe(path, selected_core, no_of_slot_needed);
            int slot_given = 0;
            if (start_index != -1) {
                slot_given = no_of_slot_needed;
                markSlot(path, selected_core, start_index, start_index + slot_given - 1);
                frequencyOfCore[selected_core]++;
            }

            if (slot_given != 0) {
                System.out.println("core: " + selected_core + " Group: " + (requested_slot / core_size[selected_core]));
            }
            requested_slot -= (slot_given - 2);
            if(requested_slot<=0)
                break;
            // If requested_slot is still not allocated, try remaining cores again
            if (requested_slot > 0 && selected_core != 0) {
                continue;
            }

            // If allocation still not possible and core 0 already used or not sufficient, print message
             if (requested_slot > 0 && selected_core == 0) {
                System.out.println("Allocation Not Possible");
                return 0;
            }


        }
        if (requested_slot == 0)
            return 1;
        else
            return 0;
    }

}