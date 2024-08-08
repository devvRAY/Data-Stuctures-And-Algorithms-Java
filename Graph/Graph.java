import java.util.HashMap;
import java.util.Map;

/*
    Graph data structure is implemented in the following way:
        1. A class of type Vertex is created as HashMap<String, Integer>
           This class is used to store the neighbours of each vertex and stores the name of the neighbouring vertex
           as well as the cost associated with travelling to that vertex from the current vertex.

        2. A HashMap<String,Vertex> is maintained which has the name of all the vertices as well as the information related
           to neighbours stored in the Vertex class.
*/

public class Graph {

    private class Vertex {

        HashMap<String, Integer> nbrs;

        Vertex() {
            nbrs = new HashMap<>();
        }
    }

    HashMap<String, Vertex> vertices;

    Graph() {
        vertices = new HashMap<>();
    }

    /*
        1. int getNumOfVertex() -> Used to retrieve the number of vertices currently present in the Graph
    */

   private int getNumOfVertex() {

        return this.vertices.size();
    
   }

    /*
        2. boolean containsVertex(String vname) -> Used to check if a vertex with a given name is present in the graph
    */

   private boolean containsVertex(String vname) {

        return this.vertices.containsKey(vname);
    
   }

   /*
        3. void addVertex(String vname) -> Used to add a vertex to the graph
   */

   private void addVertex(String vname) {

        if(containsVertex(vname)) {
            return;
        }
        Vertex vtx = new Vertex();
        this.vertices.put(vname,vtx);
   }

   /*
        4. void removeVertex(String vname) -> Used to remove a vertex from the graph:
            a. Fetch the Vertex from the vertices hashmap
            b. Iterate the neighbours of the vertex
            c. For every neigbouring vertex, remove the entry of the vertexToRemove from nbrs HashMap
   */

   private void removeVertex(String vname) {

        Vertex vtxToRemove = this.vertices.get(vname);
        Vertex vtxTemp;
        
        if(null == vtxToRemove) {
            return;
        }

        for(String key : vtxToRemove.keySet()) {
            vtxTemp = this.vertices.get(key);
            vtxTemp.nbrs.remove(vname);
        }

        this.vertices.remove(vname);
   }

   /*
        5. int numOfEdges() -> Used to return the number of edges in the graph:
            a. Initialize num to 0 and Iterate the Vertices hashmap
            b. For Every vertex, add the size of its nbrs hashmap to num
            c. Return num/2 (Since every edge is diplicated in the nbrs hashmap of its )
   */
    private int numOfEdges() {
        int num = 0;
        Vertex vtxTemp;
        for(String vname: this.vertices.keySet()) {
            vtxTemp = this.vertices.get(vname);
            num += vtxTemp.nbrs.size();
        }
        return num/2;
    }

    /*
        6. boolean containsEdge(String vname1, String vname2) -> Used to check if an edge exists between
           two vertices
    */
    private boolean containsEdge(String vname1, String vname2) {
        Vertex vtx1 = this.vertices.get(vname1);
        Vertex vtx2 = this.vertices.get(vname2);

        if(null == vtx1 || null == vtx2) {
            return false;
        }
        if(vtx1.nbrs.containsKey(vname2) && vtx2.nbrs.containsKey(vname1)) {
            return true;
        }
        return false;
    }

    /*
        7. void addEdge(String vname1, String vname2) -> Used to add an edge to a graph
    */
    private void addEdge(String vname1, String vname2, int cost) {
        Vertex vtx1 = this.vertices.get(vname1);
        Vertex vtx2 = this.vertices.get(vname2);

        if(null == vtx1 || null == vtx2) {
            return;
        }
        if(vtx1.nbrs.containsKey(vname2) || vtx2.nbrs.containsKey(vname1)) {
            return;
        }
        vtx1.nbrs.put(vname2, cost);
        vtx2.nbrs.put(vname1, cost);
    }

    /*
        8. void removeEdge(String vname1, String vname2) -> Used to remove an edge from graph
    */
    private void removeEdge(String vname1, String vname2, int cost) {
        Vertex vtx1 = this.vertices.get(vname1);
        Vertex vtx2 = this.vertices.get(vname2);

        if(null == vtx1 || null == vtx2) {
            return;
        }
        if(!vtx1.nbrs.containsKey(vname2) || !vtx2.nbrs.containsKey(vname1)) {
            return;
        }
        vtx1.nbrs.remove(vname2);
        vtx2.nbrs.remove(vname1);
    }

    /*
        9. void display() -> Used to print a graph
    */
}
