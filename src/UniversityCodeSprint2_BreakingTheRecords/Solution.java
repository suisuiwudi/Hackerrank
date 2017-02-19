package UniversityCodeSprint2_BreakingTheRecords;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] score = new int[n];
        for(int score_i=0; score_i < n; score_i++){
            score[score_i] = in.nextInt();
        }
        // your code goes here
        int highestScore = score[0];
        int lowestScore = score[0];
        int high = 0;
        int low = 0;
        for (int i=1; i < n; i++){
        	if (score[i] > highestScore){
        		highestScore = score[i];
        		high++;
        	} else if (score[i]<lowestScore){
        		lowestScore = score[i];
        		low++;
        	}
        }
        System.out.println(high+" "+low);
    }
}
