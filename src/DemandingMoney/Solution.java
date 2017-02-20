package DemandingMoney;

import java.io.*;
import java.util.*;

public class Solution {
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
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}
