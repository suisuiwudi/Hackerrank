package RichieRich;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		String number = in.next();
		int diff = 0;
		for (int i = 0; i < n / 2; i++) {
			if (number.charAt(i) != number.charAt(n - i - 1)) {
				diff++;
			}
		}
		if (diff > k)
			System.out.println(-1);
		else if (diff == k) {
			StringBuffer ans = new StringBuffer();
			for (int i = 0; i < n / 2; i++) {
				if (number.charAt(i) >= number.charAt(n - i - 1)) {
					ans.append(number.charAt(i));
				} else {
					ans.append(number.charAt(n - i - 1));
				}
			}
			if (n % 2 == 1) {
				ans.append(number.charAt(n / 2));
			}
			for (int i = n / 2 - 1; i >= 0; i--) {
				ans.append(ans.charAt(i));
			}
			System.out.println(ans.toString());
		} else {
			StringBuffer ans = new StringBuffer();
			for (int i = 0; i < n / 2; i++) {
				if (k > diff && (k > 1 || number.charAt(i) == '9' || number.charAt(n - i - 1) == '9')) {
					ans.append('9');
					if (number.charAt(i) != number.charAt(n - i - 1)) diff--;
					k = k - 2;
					if (number.charAt(i) == '9') k++;
					if (number.charAt(n - i - 1) == '9') k++;
				} else if (number.charAt(i) > number.charAt(n - i - 1)) {
					ans.append(number.charAt(i));
					k--;
					diff--;
				} else if (number.charAt(i) == number.charAt(n - i - 1)) {
					ans.append(number.charAt(i));
				} else {
					ans.append(number.charAt(n - i - 1));
					k--;
					diff--;
				}
			}
			if (n % 2 == 1) {
				if (k > 0) {
					ans.append('9');
				} else {
					ans.append(number.charAt(n / 2));
				}
			}
			for (int i = n / 2 - 1; i >= 0; i--) {
				ans.append(ans.charAt(i));
			}
			System.out.println(ans.toString());
		}
	}
}
