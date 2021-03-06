package DemandingMoney;

import java.io.*;
import java.util.*;

public class Solution {
	public static class Graph {
		private List[] adj;
		public int[] money;
		public int ans;
		public int win;
		public int searchNum;
		public int[][] getMoney;
		public int[][] count;
		public boolean[] searched;
		private int V;
		private int E;

		public Graph(int V) {
			this.V = V;
			adj = new LinkedList[V];
			money = new int[V];
			searchNum = 0;
			ans = 0;
			for (int i = 0; i < V; i++) {
				adj[i] = new LinkedList<Integer>();
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

		public void setMoney(int v, int value) {
			money[v] = value;
		}

		public void search(int v) {
			searched[v] = true;
			if (value > ans) {
				ans = value;
				count = 1;
			} else if (value == ans)
				count++;
			for (int w : this.adj(v)) {
				if (!searched[w]) {
					search(w);
					getMoney[v][0] = getMoney[w][1]  getMoney[w][0]
							
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
		int m = in.nextInt();
		Graph g = new Graph(n);
		for (int i = 0; i < n; i++) {
			g.money[i] = in.nextInt();
		}
		for (int i = 0; i < m; i++) {
			int v = in.nextInt();
			int w = in.nextInt();
			g.addEdge(v - 1, w - 1);
		}
		Arrays.fill(g.searched, false);
		g.search(0, false, 0);
		System.out.println(g.ans + " " + g.count);
	}
}
