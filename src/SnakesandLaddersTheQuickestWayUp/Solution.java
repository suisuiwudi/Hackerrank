package SnakesandLaddersTheQuickestWayUp;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0 ; i < t; i++){
			int next[] = new int[101];
			int step[] = new int[101];
			Arrays.fill(step, Integer.MAX_VALUE);
			boolean inQue[] = new boolean[101];
			Arrays.fill(inQue, false);
			int n = in.nextInt();
			
			for (int j = 0; j < n; j++) {
				int start = in.nextInt();
				int end = in.nextInt();
				next[start] = end;
			}
			n = in.nextInt();
			for (int j = 0; j < n; j++){
				int start = in.nextInt();
				int end = in.nextInt();
				next[start] = end;
			}
			List<Integer> queue = new ArrayList<>();
			inQue[1] = true;
			step[1] = 0;
			queue.add(1);
			while (!queue.isEmpty()){
				int now = queue.get(0);
				for (int k = 1; k <= 6; k++){
					if (now+k < 101){
						int nextP = now+k;
						if (next[nextP] != 0) nextP = next[nextP];
						if (step[now] + 1 < step[nextP]){
							step[nextP] = step[now] + 1;
							if (!inQue[nextP]){
								inQue[nextP] = true;
								queue.add(nextP);
							}
						}
					}
				}
				queue.remove(0);
				inQue[now] = false;
			}
			if (step[100] != Integer.MAX_VALUE) System.out.println(step[100]);
			else System.out.println(-1);
		}
    }
}