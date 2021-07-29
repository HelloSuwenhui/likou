import java.util.HashMap;
import java.util.Map;

public class 无重复字符的最大子串 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aaab"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring("cdd"));
        System.out.println(lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring("bceba"));
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }

    private static int lengthOfLongestSubstring(String s) {
        //
        if (s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int maxLength = 0;
        int startIndex = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (map.containsKey(aChar)) {
                //重复 调整startIndex位置
                startIndex = Math.max(map.get(aChar) + 1, startIndex);
            }
            //不重复
            maxLength = Math.max(i - startIndex + 1, maxLength);

            map.put(aChar, i);
        }
        return maxLength;
/*        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
//                    System.out.println(lengthOfLongestSubstring("bceba"));
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(alpha, end + 1);
        }
        return ans;*/

    }
}
