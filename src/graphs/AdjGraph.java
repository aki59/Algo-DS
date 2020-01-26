package graphs;

import java.util.LinkedList;

public class AdjGraph<E> {

	private int vertices;
	private LinkedList<E>[] adjacencyList;

	public AdjGraph(int vertices) {
		this.vertices = vertices+1;
		this.adjacencyList = new LinkedList[vertices+1];

		for (int i = 0; i < (vertices+1); i++) {
			adjacencyList[i] = new LinkedList<>();
		}
	}

	public LinkedList<E>[] getAdjacencyList() {
		return adjacencyList;
	}

	public void addEdge(int source, int destination, Integer weight) {

		if (weight != null) {
			Edge edge = new Edge(source, destination, weight);
			adjacencyList[source].add((E) edge);

		} else {
			Edge edge = new Edge(source, destination);
			adjacencyList[source].add((E) edge);
		}
	}

	public int getVertices() {
		return vertices;
	}

}
