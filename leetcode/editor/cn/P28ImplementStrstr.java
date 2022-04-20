//实现 strStr() 函数。 
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 104 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 字符串匹配 
// 👍 1062 👎 0


package leetcode.editor.cn;
//Java：实现 strStr()
public class P28ImplementStrstr{
    public static void main(String[] args) {
        Solution solution = new P28ImplementStrstr().new Solution();
        // TO TEST
        System.out.println(solution.strStr("mississippi", "issipi"));;
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 		执行耗时:432 ms,击败了40.60% 的Java用户
         * 			内存消耗:38.3 MB,击败了77.98% 的Java用户
         * @param haystack
         * @param needle
         * @return
         */
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)){
            return 0;
        }
        if (needle.length() > haystack.length()){
            return -1;
        }
        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();
        int t = -1;
        for (int i = 0; i < chars1.length; i++){
            if (chars1[i] == chars2[0]) {
                t = i;
                boolean isSuccess = true;
                for (int j = 0; j < chars2.length; j++) {
                    if (i+j >= chars1.length){
                        return -1;
                    }
                    if (chars1[i+j] != chars2[j]) {
                        isSuccess = false;
                        break;
                    }
                }
                if (isSuccess){
                    return t;
                }
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}