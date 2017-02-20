package FindtheRunningMedian;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT
		 */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(n / 2 + 1);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(n / 2 + 1, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		int num = in.nextInt();
		maxHeap.add(num);
		System.out.println((double) maxHeap.peek() + "");
		for (int i = 1; i < n; i++) {
			num = in.nextInt();
			if (num > maxHeap.peek()) {
				if (maxHeap.size() > minHeap.size())
					minHeap.add(num);
				else {
					int tmp = minHeap.poll();
					minHeap.add(Math.max(tmp, num));
					maxHeap.add(Math.min(tmp, num));
				}
			} else {
				if (maxHeap.size() == minHeap.size())
					maxHeap.add(num);
				else{
					int tmp = maxHeap.poll();
					minHeap.add(Math.max(tmp, num));
					maxHeap.add(Math.min(tmp, num));
				}
			}
			if (i % 2 == 0)
				System.out.println((double) maxHeap.peek() + "");
			else {
				System.out.println(((double) minHeap.peek() + maxHeap.peek()) / 2 + "");
			}
		}
	}
}
