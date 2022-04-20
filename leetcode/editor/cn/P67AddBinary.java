//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 位运算 数学 字符串 模拟 
// 👍 743 👎 0


package leetcode.editor.cn;

import java.math.BigInteger;

//Java：二进制求和
public class P67AddBinary {
    public static void main(String[] args) {
        Solution solution = new P67AddBinary().new Solution();
        // TO TEST
        System.out.println(solution.addBinary("11", "1"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 执行耗时:1 ms,击败了99.99% 的Java用户
         * 内存消耗:40.1 MB,击败了33.87% 的Java用户
         */
        public String addBinary(String a, String b) {
            StringBuffer ans = new StringBuffer();

            int n = Math.max(a.length(), b.length()), carry = 0;
            for (int i = 0; i < n; ++i) {
                carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
                carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
                ans.append((char) (carry % 2 + '0'));
                carry /= 2;
            }

            if (carry > 0) {
                ans.append('1');
            }
            ans.reverse();

            return ans.toString();
        }

        /**
         * 执行耗时:8 ms,击败了7.53% 的Java用户
         * 内存消耗:41.5 MB,击败了5.58% 的Java用户
         */
        public String addBinary1(String a, String b) {
            StringBuilder aBuilder = new StringBuilder(a);
            aBuilder = aBuilder.reverse();
            StringBuilder bBuilder = new StringBuilder(b);
            bBuilder = bBuilder.reverse();


            char[] aChars = aBuilder.toString().toCharArray();
            char[] bChars = bBuilder.toString().toCharArray();

            int aLength = aChars.length;
            int bLength = bChars.length;

            String result = "";

            int carryNum = 0;
            for (int i = 0; ; i++) {
                if (i >= aLength && i >= bLength) {
                    break;
                }
                int sum = 0;
                if (i < aLength && i < bLength) {
                    sum = Integer.parseInt(String.valueOf(aChars[i])) + Integer.parseInt(String.valueOf(bChars[i]));
                } else {
                    if (aLength > bLength) {
                        sum = Integer.parseInt(String.valueOf(aChars[i]));
                    } else {
                        sum = Integer.parseInt(String.valueOf(bChars[i]));
                    }
                }
                sum += carryNum;
                carryNum = sum / 2;
                result = result + "" + sum % 2;
            }
            if (carryNum != 0) {
                result = result + "" + carryNum;
            }
            StringBuilder resultBuilder = new StringBuilder(result);
            resultBuilder = resultBuilder.reverse();
            return resultBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}