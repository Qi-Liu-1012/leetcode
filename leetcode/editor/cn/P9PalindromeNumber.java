//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 示例 4： 
//
// 
//输入：x = -101
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1568 👎 0


package leetcode.editor.cn;

//Java：回文数
public class P9PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new P9PalindromeNumber().new Solution();
        // TO TEST
        System.out.println(solution.isPalindrome(121));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 			执行耗时:14 ms,击败了17.46% 的Java用户
         * 			内存消耗:38.1 MB,击败了19.51% 的Java用户
         * @param x
         * @return
         */
        public boolean isPalindrome1(int x) {
            if (x < 0) {
                return false;
            }
            StringBuilder xStr = new StringBuilder(String.valueOf(x));

            StringBuilder reverseStr = new StringBuilder(String.valueOf(x)).reverse();

            if (reverseStr.toString().equals(xStr.toString())) {
                return true;
            }
            return false;
        }


        /**
         * 			执行耗时:9 ms,击败了89.41% 的Java用户
         * 			内存消耗:38.1 MB,击败了18.83% 的Java用户
         * @param x
         * @return
         */
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            int num = x;
            int next = 0;
            while (num != 0) {
                next = next * 10 + num % 10;
                num = num / 10;
            }
            return next == x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}