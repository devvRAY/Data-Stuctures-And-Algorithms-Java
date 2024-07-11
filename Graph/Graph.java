import java.util.HashMap;
import java.util.Map;

/*
    Graph data structure is implemented in the following way:
        1. A class of type Vertex is created as HashMap<String, Integer>
           This class is used to store the neighbours of each vertex and stores the name of the neighbouring vertex
           as well as the cost associated with travelling to that vertex from the current vertex.

        1. A HashMap<String,Vertex> is maintained which has the name of all the vertices as well as the information related
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
}
