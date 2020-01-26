package runner;

import graphs.AdjGraph;
import graphs.Edge;
import graphs.KruskalMST;

public class KruskalRunner {

	public static void main(String[] args) {
		AdjGraph<Edge> graph=new AdjGraph<>(7);
		KruskalMST kruskal=new KruskalMST();
		graph.addEdge(1, 2, 28);
		graph.addEdge(1, 6, 10);
		graph.addEdge(2, 3, 16);
		graph.addEdge(2, 7, 14);
		graph.addEdge(3, 4, 12);
		graph.addEdge(4, 5, 22);
		graph.addEdge(4, 7, 18);
		graph.addEdge(5, 6, 25);
		graph.addEdge(5, 7, 24);
		
		int cost=kruskal.getMinimumCost(graph);
		System.out.println(cost);
		

	}

}
