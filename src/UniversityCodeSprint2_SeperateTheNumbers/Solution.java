package UniversityCodeSprint2_SeperateTheNumbers;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            // your code goes here
            boolean flag = false;
            for (int i = 0 ; i < Math.min(s.length() / 2,16) ; i++){
            	if (check(s,Long.parseLong(s.substring(0,i+1)))){
            		System.out.println("YES "+ Long.parseLong(s.substring(0,i+1)) );
            		flag = true;
            		break;
            	}        	
            }
            if (!flag) {
            	System.out.println("NO");
            }
        }
    }
    public static boolean check(String s, long firstNum){
    	long now = firstNum;
    	for (int i = 0; i < s.length();){
    		String numS = "" + now;
    		if (s.charAt(i)=='0') return false;
    		if (i+ numS.length()>s.length()) return false;
    		if (!numS.equals(s.substring(i, i+ numS.length()))){
    			return false;
    		}
    		now++;
    		i += numS.length();
    	}
    	return true;
    }
}
