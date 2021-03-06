//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。 
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 231 - 1 
// 
// Related Topics 数学 二分查找 
// 👍 930 👎 0


package leetcode.editor.cn;

//Java：x 的平方根
public class P69Sqrtx {
    public static void main(String[] args) {
        Solution solution = new P69Sqrtx().new Solution();
        System.out.println(solution.mySqrt(2147395599));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 	执行耗时:1 ms,击败了94.80% 的Java用户
         * 	内存消耗:38.6 MB,击败了43.57% 的Java用户
         */
        public int mySqrt1(int x) {
            int begin = 0;
            int end = x;
            int result = -1;

            while (begin <= end) {
                int mid = begin + (end - begin)/2;
                if ((long) mid * mid <= x){
                    result = mid;
                    begin = mid +1;
                }else {
                    end = mid - 1;
                }
            }
            return result;
        }

        /**
         * 执行耗时:1 ms,击败了94.80% 的Java用户
         * 	内存消耗:38.8 MB,击败了25.46% 的Java用户
         */
        public int mySqrt(int x) {
            if (x == 0) {
                return 0;
            }

            double C = x, x0 = x;
            while (true) {
                double xi = 0.5 * (x0 + C / x0);
                if (Math.abs(x0 - xi) < 1e-7) {
                    break;
                }
                x0 = xi;
            }
            return (int) x0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}