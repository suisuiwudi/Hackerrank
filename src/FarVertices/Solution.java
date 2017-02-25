package FarVertices;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static class Graph {
		private List[] adj;
		public boolean[] searched;
		public int searchNum;
		private int V;
		private int E;

		public Graph(int V) {
			this.V = V;
			adj = new LinkedList[V];
			searchNum = 0;
			searched = new boolean[V];
			for (int i = 0; i < V; i++) {
				adj[i] = new LinkedList<Integer>();
				searched[i] = false;
			}
		}

		public void addEdge(int v, int w) {
			E++;
			adj[v].add(w);
			adj[w].add(v);
		}

		public Iterable<Integer> adj(int v) {
			return adj[v];
		}

		public void rangeSearch(int v,int d,int k) {
			searched[v] = true;
			searchNum++;
			if (d == k) return;
			for (int w : this.adj(v)) {
				if (!searched[w]) {
					rangeSearch(w,d+1,k);
				}
			}
		}

	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		Graph graph = new Graph(n);
		for (int i = 0; i < n - 1 ; i++){
			int v = in.nextInt();
			int w = in.nextInt();
			graph.addEdge(v-1, w-1);
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n ; i++){
			graph.searchNum = 0;
			Arrays.fill(graph.searched, false);
			graph.rangeSearch(i,0,k);
			System.out.println(graph.searchNum);
			ans = Math.min(ans, n - graph.searchNum);
		}
		System.out.println(ans);
		
	}
}