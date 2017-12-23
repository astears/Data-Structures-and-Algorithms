/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3.

Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/
class LongestSubstringNoRepeats {
    public int lengthOfLongestSubstring(String s) {
        int counter = 0;
        int max = 0;
        int begin = 0;
        int end = 0;
        HashSet<Character> set = null;

        for (begin = 0; begin < s.length(); /*nothing*/) {
            if (set == null) {
                set = new HashSet<Character>();
            }
            else if (!set.contains(s.charAt(end))) {
                counter++;
                max = Math.max(counter, max);
                set.add(s.charAt(end));
                if (end != s.length() - 1) {
                    end++;
                }
            }
            else {
                set = null;
                counter = 0;
                begin++;
                end = begin;
            }
        }
        return max;
    }
}
