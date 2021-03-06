package me.minei.leetcode.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class Q3 {
    public static void main(String[] args) {
        String s = "abscbaaa";
        long start = System.currentTimeMillis();
        System.out.println(lengthOfLongestSubstring(s));
        long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - start) + "ms");
        System.out.println("string length" + s.length());
    }

    // one signal O(n*n)
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        List<Character> str = new ArrayList<>(s.length());
        for (int i = 0; i < s.length();) {
            char tmp = s.charAt(i);
            if (!str.contains(tmp)) {
                str.add(tmp);
                i++;
            } else {
                if (str.size() > maxLen) {
                    maxLen = str.size();
                }
                int jumpIndex = str.indexOf(tmp) + 1;
                i -= str.size() - jumpIndex;
                str.clear();
            }
        }
        maxLen = str.size() > maxLen ? str.size() : maxLen;

        return maxLen;
    }

    // two signal O(n)
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

}
