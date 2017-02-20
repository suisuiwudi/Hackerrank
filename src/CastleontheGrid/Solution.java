package CastleontheGrid;

import java.io.*;
import java.util.*;

public class Solution {
	public static final int[] dx = { 1, 0, -1, 0 };
	public static final int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] graph = new String[n];
		for (int i = 0; i < n; i++) {
			graph[i] = in.next();
		}

		List<Pos> queue = new ArrayList<>();
		int[][] step = new int[n][n];
		boolean[][] inQue = new boolean[n][n];
		for (int[] row : step)
			Arrays.fill(row, Integer.MAX_VALUE);
		int startX = in.nextInt();
		int startY = in.nextInt();
		int endX = in.nextInt();
		int endY = in.nextInt();
		Pos start = new Pos(startX, startY);
		queue.add(start);
		inQue[startX][startY] = true;
		step[startX][startY] = 0;
		while (!queue.isEmpty()) {
			Pos now = new Pos(queue.get(0));
			int nowX = now.getX();
			int nowY = now.getY();

			for (int k = 0; k < 4; k++) {
				int nextX = nowX + dx[k];
				int nextY = nowY + dy[k];
				while (nextX < n && nextX >= 0 && nextY < n && nextY >= 0 && graph[nextX].charAt(nextY) == '.') {
					if (step[nowX][nowY] + 1 < step[nextX][nextY]) {
						step[nextX][nextY] = step[nowX][nowY] + 1;
						if (!inQue[nextX][nextY]) {
							Pos next = new Pos(nextX, nextY);
							queue.add(next);
							inQue[nextX][nextY] = true;
						}
					}
					nextX += dx[k];
					nextY += dy[k];
				}
			}
			inQue[nowX][nowY] = false;
			queue.remove(0);
		}
		System.out.println(step[endX][endY]);

	}

	public static class Pos {
		private int x;
		private int y;

		Pos(Pos a) {
			this.x = a.getX();
			this.y = a.getY();
		}

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}
}