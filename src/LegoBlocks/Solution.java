package LegoBlocks;

import java.io.*;
import java.util.*;

public class Solution {
	public static final long modulo = 1000000007;

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int n[] = new int[t];
		int m[] = new int[t];
		int maxN = 0;
		int maxM = 0;
		for (int i = 0; i < t; i++) {
			n[i] = in.nextInt();
			m[i] = in.nextInt();
			maxN = Math.max(maxN, n[i]);
			maxM = Math.max(maxM, m[i]);
		}
		long[] singleRow = new long[maxM + 1];
		long[][] solid = new long[maxN + 1][maxM + 1];
		for (long[] row : solid)
			Arrays.fill(row, 0);
		long[][] unsolid = new long[maxN + 1][maxM + 1];
		for (long[] row : unsolid)
			Arrays.fill(row, 0);
		singleRow[1] = 1;
		singleRow[0] = 1;
		solid[1][0] = 1;
		solid[1][1] = 1;
		unsolid[1][0] = 1;
		unsolid[1][1] = 1;
		for (int i = 2; i <= maxM; i++) {
			for (int j = i - 1; j >= Math.max(0, i - 4); j--) {
				singleRow[i] = (singleRow[i] + singleRow[j]) % modulo;
			}
			unsolid[1][i] = singleRow[i];
			if (i <= 4) solid[1][i] = 1;
			else solid[1][i] = 0;
		}
		for (int i = 0; i < t; i++) {
			if (solid[n[i]][m[i]] != 0)
				System.out.println(solid[n[i]][m[i]]);
			else {
				int ni = n[i];
				for (int mi = 1; mi <= m[i]; mi++) {
					unsolid[ni][mi] = singleRow[mi];
					for (int k = 1; k < ni; k++) {
						unsolid[ni][mi] = (unsolid[ni][mi] * singleRow[mi]) % modulo;
					}
					solid[ni][mi] = unsolid[ni][mi];
					for (int j = 1; j < mi; j++) {
						long tmp = (solid[ni][j] * unsolid[ni][mi - j]) % modulo;
						while (solid[ni][mi] - tmp < 0) solid[ni][mi] += modulo;
						solid[ni][mi] = (solid[ni][mi] - tmp) % modulo;
					}
				}
				System.out.println(solid[n[i]][m[i]]);
			}
		}

	}
}