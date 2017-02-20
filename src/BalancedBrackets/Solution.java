package BalancedBrackets;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            boolean flag = true;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++){
                
                if  (s.charAt(i) == '{'  || s.charAt(i) == '[' || s.charAt(i) == '('){
                    stack.push(s.charAt(i));
                }
                else if ( stack.isEmpty() || (stack.peek() == '(' && s.charAt(i)!= ')') || (stack.peek() == '[' && s.charAt(i)!= ']') ||(stack.peek() == '{' && s.charAt(i)!= '}') ){
                    
                    System.out.println("NO");
                    flag = false;
                    break;
                } else{
                    stack.pop();
                    
                }
            }
            if (flag) {
               if (stack.isEmpty()) System.out.println("YES"); 
               else System.out.println("NO"); 
            } 
        }
        
    }
}
