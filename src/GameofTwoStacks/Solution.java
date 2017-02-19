package GameofTwoStacks;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int g = in.nextInt();
		for (int a0 = 0; a0 < g; a0++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int x = in.nextInt();
			int[] a = new int[n];
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
			}
			int[] b = new int[m];
			for (int b_i = 0; b_i < m; b_i++) {
				b[b_i] = in.nextInt();
			}
			// your code goes here
			long[] suma = new long[n + 1];
			suma[0] = 0;
			for (int i = 0; i < n; i++) {
				suma[i + 1] = suma[i] + a[i];
			}
			long[] sumb = new long[m + 1];
			sumb[0] = 0;
			for (int i = 0; i < m; i++) {
				sumb[i + 1] = sumb[i] + b[i];
			}
			int lowNums = 0;
			int upNums = n + m + 1;
			while (lowNums + 1 < upNums) {
				int middle = (lowNums + upNums) / 2;
				boolean flag = false;
				for (int i = Math.max(0, middle - m); i <= Math.min(n, middle); i++) {
					if (suma[i] + sumb[middle - i] <= x) {
						flag = true;
						break;
					}
				}
				if (flag) {
					lowNums = middle;
				} else {
					upNums = middle;
				}
			}
			System.out.println(lowNums);
		}
	}

}
