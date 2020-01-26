package util;

/**
 * The {@code DisjointSet} class represents a <em>union–find data type</em>
 * (also known as the <em>disjoint-sets data type</em>). It supports the classic
 * <em>union</em> and <em>find</em> operations.
 * <p>
 * The union-find data type models a collection of sets containing <em>n</em>
 * elements, with each element in exactly one set. The elements are named 0
 * through <em>n</em>–1. Initially, there are <em>n</em> sets, with each element
 * in its own set. The <em>cannonical elemement</em> of a set (also known as the
 * <em>root</em>, <em>identifier</em>, <em>leader</em>, or
 * <em>set representative</em>) is one distinguished element in the set. Here is
 * a summary of the operations:
 * <ul>
 * <li><em>find</em>(<em>p</em>) returns the canonical element of the set
 * containing <em>p</em>. The <em>find</em> operation returns the same value for
 * two elements if and only if they are in the same set.
 * <li><em>union</em>(<em>p</em>, <em>q</em>) merges the set containing element
 * <em>p</em> with the set containing element <em>q</em>. That is, if <em>p</em>
 * and <em>q</em> are in different sets, replace these two sets with a new set
 * that is the union of the two.
 * <li><em>count</em>() returns the number of sets.
 * </ul>
 * <p>
 * The canonical element of a set can change only when the set itself changes
 * during a call to <em>union</em>&mdash;it cannot change during a call to
 * either <em>find</em>.
 * 
 * @author Akash Tewari
 */
public class DisjointSet {

	private int[] parent;
	private byte[] rank;

	public DisjointSet(int n) {
		if (n < 0)
			throw new IllegalArgumentException();

		parent = new int[n];
		rank = new byte[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}
	
	public int find(int p){
		validate(p);
		if(parent[p]==p){
			return p;
		}
		return find(parent[p]);
	}
	
	public void union(int p,int q){
		int pRoot=find(p);
		int qRoot=find(q);
		
		if(pRoot==qRoot)
			return;
		
		// make root of smaller rank point to root of larger rank
		if(rank[pRoot]>rank[qRoot])
			parent[qRoot]=pRoot;
			else if(rank[qRoot]>rank[pRoot])
				parent[pRoot]=qRoot;
			else{
				parent[qRoot]=pRoot;
				rank[pRoot]++;
			}
		
	}
	
	  // validate that p is a valid index
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));  
        }
    }

}
