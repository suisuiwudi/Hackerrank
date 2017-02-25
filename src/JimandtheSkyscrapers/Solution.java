package JimandtheSkyscrapers;
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	int[] num = new int[n];
    	for (int i = 0; i < n; i++){
    		num[i] = in.nextInt();
    	}
    	int ans = 0;
    	for (int i = 0; i < n; i++){
    		for (int j = i + 1; j < n; j++){
    			if (num[j]>num[i]) break;
    			if (num[j] == num[i]) ans++;
    		}
    	}
    	System.out.println(ans*2);
    }
}
