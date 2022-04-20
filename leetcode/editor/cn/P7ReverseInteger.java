//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2970 👎 0


package leetcode.editor.cn;
//Java：整数反转
public class P7ReverseInteger{
    public static void main(String[] args) {
        Solution solution = new P7ReverseInteger().new Solution();
        // TO TEST
        System.out.println( solution.reverse(1534236469));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 执行耗时:1 ms,击败了100.00% 的Java用户
         * 内存消耗:35.3 MB,击败了93.22% 的Java用户
          * @param x
         * @return
         */
    public int reverse(int x) {
        long result = 0;
        while (x != 0){
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }
        return (int)result;
    }

        /**
         *执行耗时:2 ms,击败了26.57% 的Java用户
         *内存消耗:35.7 MB,击败了27.63% 的Java用户
         * @param x
         * @return
         */
    public int reverse2(int x) {
        //记录符号
        int symbol = x > 0 ? 1 : -1;
        //转正
        x = Math.abs(x);
        //转字符串
        String str = String.valueOf(x);
        //字符串翻转
        String reverseStr = new StringBuilder(str).reverse().toString();
        //转整数 添加符号
        int result = 0;
        try {
            result = Integer.valueOf(reverseStr) * symbol;
        }catch (Exception e){

        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}