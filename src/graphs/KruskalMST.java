package graphs;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

import javafx.util.Pair;

public class KruskalMST {
	
	private int[] parent;

	public int getMinimumCost(AdjGraph<Edge> graph){
		int cost=0;
		int vertices=graph.getVertices();
		PriorityQueue<Edge> minHeap	=new PriorityQueue<>(10, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				int k1= o1.getWeight();
				int k2=o2.getWeight();
				return k1-k2;
			}
		});

		LinkedList<Edge>[] adjList=graph.getAdjacencyList();
		
		for(int i=0;i<adjList.length;i++){
			LinkedList<Edge> extractedVertex=adjList[i];
			
			for(int j=0;j<extractedVertex.size();j++){
				Edge edge=extractedVertex.get(j);
				minHeap.add(edge);
				
			}
			
		}
		
		parent=new int[vertices+1];
		
		for(int i=0;i<(vertices+1);i++){
			parent[i]=-1;
		}
		int minHeapSize=minHeap.size();
		for(int i=0;i<minHeapSize;i++){
			Edge polledEdge=minHeap.poll();
			boolean isCycle = detectCycle(polledEdge);
			if(!isCycle){
				cost+=polledEdge.getWeight();
			}
			
		}
		
		
		return cost;
	}

	private boolean detectCycle(Edge edge) {
		int x=find(parent,edge.getSource());
		int y=find(parent,edge.getDestination());
		
		if(x==y)
			return true;
		
		union(x,y);
		return false;
	}

	private void union(int x, int y) {
	parent[x]=y;
		
	}

	private int find(int[] parent, int vertex) {
		
		if(parent[vertex]== -1){
			return vertex;
		}
		return find(parent,parent[vertex]);
	}



}
