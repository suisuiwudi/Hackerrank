package TheLongestIncreasingSubsequence;

import java.io.*;
import java.util.*;

public class Solution {
    public static int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums.length == 0){
            return 0;
        }
        // len表示当前最长的升序序列长度（为了方便操作tails我们减1）
        int len = 0;
        // tails[i]表示长度为i的升序序列其末尾的数字
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        // 根据三种情况更新不同升序序列的集合
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < tails[0]){
                tails[0] = nums[i];
            } else if (nums[i] >= tails[len]){
                tails[++len] = nums[i];
            } else {
            // 如果在中间，则二分搜索
                tails[binarySearch(tails, 0, len, nums[i])] = nums[i];
            }
        }
        return len + 1;
    }
    
    public static int binarySearch(int[] tails, int min, int max, int target){
        while(min <= max){
            int mid = min + (max - min) / 2;
            if(tails[mid] == target){
                return mid;
            }
            if(tails[mid] < target){
                min = mid + 1;
            }
            if(tails[mid] > target){
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