package TheLongestIncreasingSubsequence;

import java.io.*;
import java.util.*;

public class Solution {
    public static int longestIncreasingSubsequence(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int len = 0;
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < tails[0]){
                tails[0] = nums[i];
            } else if (nums[i] >= tails[len]){
                tails[++len] = nums[i];
            } else {
                tails[binarySearch(tails, 0, len, nums[i])] = nums[i];
            }
        }
        return len + 1;
    }
    
    public static int binarySearch(int[] nums, int min, int max, int find){
        while(min <= max){
            int mid = min + (max - min) / 2;
            if(nums[mid] == find){
                return mid;
            }
            if(nums[mid] < find){
                min = mid + 1;
            }
            if(nums[mid] > find){
                max = mid - 1;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] num = new int[n];
    	for (int i = 0 ; i < n ; i++)
    		num[i] = in.nextInt();
    	System.out.println(longestIncreasingSubsequence(num));
    }
}