import java.util.HashMap;
import java.util.Map;

public class Graph {
    /*
        1. Uses a hashmap of String and Vertex type to store data
        2. Vertex class itself is a hashmap of string and Integer which stores the name of the adjacent
           vertices as well as the distance/cost of a particular vertex from the parent hashmap vertex
     */
    public class Vertex {
        HashMap<String, Integer> neighbours;
        Vertex() {
            this.neighbours = new HashMap<>();
        }
    }
    HashMap<String, Vertex> vertices;
    Graph() {
        this.vertices = new HashMap<>();
    }

    //Method 1: Find the number of Vertices -> int numOfVertex()
    public int numOfVertex() {
        return this.vertices.size();
    }
    //Method 2: Find if the map contains a vertex -> boolean containsVertex(String vName)
    public boolean containsVertex(String vName) {
        return this.vertices.containsKey(vName);
    }
    //Method 3: Add a vertex -> void addVertex(String vName)
    public void addVertex(String vName) throws Exception {
        if(containsVertex(vName)) {
            throw new Exception("Vertex with given name already present");
        }
        this.vertices.put(vName, new Vertex());
    }
    //Method 4: Remove a vertex -> void removeVertex(Sting vName)
    public void removeVertex(String vName) throws Exception{
        if(!containsVertex(vName)) {
            throw new Exception("Vertex with given name not present");
        }
        Vertex v = this.vertices.get(vName);
        for(Map.Entry<String, Integer> entry : v.neighbours.entrySet()) {
            this.vertices.get(entry.getKey()).neighbours.remove(vName);
        }
        this.vertices.remove(vName);
    }
    //Method 5: Find number of edges -> int numOfEdges()
    public int numOfEdges() {
        int edges = 0;
        for(Map.Entry<String, Vertex> entry: this.vertices.entrySet()) {
            edges = edges + entry.getValue().neighbours.size();
        }
        return edges/2;
    }
    //Method 6: Find if the map contains an edge -> boolean containsEdge(String vName1, String vName2)
    public boolean containsEdge(String vName1, String vName2) throws Exception{
        Vertex v1 = this.vertices.get(vName1);
        Vertex v2 = this.vertices.get(vName2);
        if(null == v1 || null == v2) {
            throw new Exception("Vertices with given name not found");
        }
        if(!v1.neighbours.containsKey(vName2)) {
            return false;
        }
        return true;
    }
    //Method 7: Add an edge -> void addEdge(String vName1, String vName2, int cost)
    public void addEdge(String vName1, String vName2, int cost) throws Exception {
        Vertex v1 = this.vertices.get(vName1);
        Vertex v2 = this.vertices.get(vName2);
        if(null == v1 || null == v2) {
            throw new Exception("Vertices with given name not found");
        }
        if(v1.neighbours.containsKey(vName2)) {
            throw new Exception("Edge already present");
        }
        v1.neighbours.put(vName2, cost);
        v2.neighbours.put(vName1, cost);
    }
    //Method 8: Remove an edge -> void removeEdge(String vName1, String vName2)
    public void removeEdge(String vName1, String vName2) throws Exception {
        Vertex v1 = this.vertices.get(vName1);
        Vertex v2 = this.vertices.get(vName2);
        if(null == v1 || null == v2) {
            throw new Exception("Vertices with given name not found");
        }
        if(!v1.neighbours.containsKey(vName2)) {
            throw new Exception("Edge does not exist");
        }
        v1.neighbours.remove(vName2);
        v2.neighbours.remove(vName1);
    }
    //Method 9: Display -> void display()
    public void display() {
        for(Map.Entry<String, Vertex> entry: this.vertices.entrySet()) {
            System.out.println("Vertex: " + entry.getKey() + " Neighbours: " + entry.getValue().neighbours);
        }
    }
}
