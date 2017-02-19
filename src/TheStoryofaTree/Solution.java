package TheStoryofaTree;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public static final String NEWLINE = "\n";

	public static class Graph {
		private List[] adj;
		private Set[] sonGuess;
		private Set[] parentGuess;
		public boolean[] searched;
		public boolean[] parent;
		public int[] rightGuess;
		public int win;
		public int searchNum;
		private int V;
		private int E;

		public Graph(int V) {
			this.V = V;
			adj = new LinkedList[V];
			sonGuess = new HashSet[V];
			parentGuess = new HashSet[V];
			rightGuess = new int[V];
			searchNum = 0;
			searched = new boolean[V];
			for (int i = 0; i < V; i++) {
				adj[i] = new LinkedList<Integer>();
				sonGuess[i] = new HashSet<Integer>();
				parentGuess[i] = new HashSet<Integer>();
				rightGuess[i] = 0;
				searched[i] = false;
			}
		}

		public void addEdge(int v, int w) {
			E++;
			adj[v].add(w);
			adj[w].add(v);
		}
		public void addGuess(int v, int w){
			this.parentGuess[w].add(v);
			this.sonGuess[v].add(w);
		}
		public Iterable<Integer> adj(int v) {
			return adj[v];
		}

		public void guessSearch(int v) {
			searched[v] = true;
			searchNum++;
			for (int w : this.adj(v)) {
				if (!searched[w]) {
					if (this.sonGuess[v].contains(w)) rightGuess[v]++;
					guessSearch(w);
					rightGuess[v] += rightGuess[w];
				}
			}
		}
		public void rightNodeCount(int v, int k, int right){
			searched[v] = true;
			if (right >= k) win++;
			for (int w : this.adj(v)) {
				if (!searched[w]) {
					int nextRight = right;
					if (this.parentGuess[v].contains(w)) nextRight++;
					if (this.sonGuess[v].contains(w)) nextRight--;
					this.rightNodeCount(w,k,nextRight);
				}
			}
		}
	}
	public static int gcd(int m, int n){
		int r;
		while (true){
			r = m % n;
			if (r == 0)
				break;
			m = n;
			n = r;
		}
		return n;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int n = in.nextInt();
			Graph graph = new Graph(n);
			for (int a1 = 0; a1 < n - 1; a1++) {
				int u = in.nextInt();
				int v = in.nextInt();
				graph.addEdge(u - 1, v - 1);
			}
			int g = in.nextInt();
			int k = in.nextInt();
			graph.win = 0;
			for (int a1 = 0; a1 < g; a1++) {
				int u = in.nextInt();
				int v = in.nextInt();
				u--;
				v--;
				graph.addGuess(u,v);
			}
			graph.guessSearch(0);
			for (int i = 0; i < graph.V; i++){
				graph.searched[i] = false;
			}
			graph.rightNodeCount(0,k,graph.rightGuess[0]);
			int gcd = gcd(graph.win,n);
			System.out.println(graph.win/gcd+"/"+n/gcd);
		}
	}

}