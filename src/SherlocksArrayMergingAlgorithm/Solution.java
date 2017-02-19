package SherlocksArrayMergingAlgorithm;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public static int ans;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] m = new int[n];
        for(int m_i=0; m_i < n; m_i++){
            m[m_i] = in.nextInt();
        }
        // your code goes here
        ans = 0;
        dfs(m,1,1,1,1,0,1);
        System.out.println(ans);
  
    }
    public static void dfs(int[] m,int i, int j,int k, int nowRow, int preRow, int count){
    	if (i == m.length){
    		ans += count;
    		return;
    	}
    	if (j!=1 && preRow == 0){
    		ans += count;
    		return;
    	}
    	if (m[i]>m[i-1]){
	    	if (j == 1){
	    		dfs(m,i+1,j,k+1,nowRow+1,preRow+1,count);
	    	}else{
	    		if (nowRow < k && preRow > 0){
	    			dfs(m,i+1,j,k,nowRow+1,preRow-1,count*preRow);
	    		}
	    	}
    	}
    	dfs(m,i+1,j+1,k,1,nowRow-1,count*nowRow);
    }
}

