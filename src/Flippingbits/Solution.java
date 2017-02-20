package Flippingbits;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			int p = Integer.parseUnsignedInt(in.next());
			System.out.println(Integer.toUnsignedString(~p));
		}
    }
}