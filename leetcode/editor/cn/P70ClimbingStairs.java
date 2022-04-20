//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 2342 👎 0


package leetcode.editor.cn;
//Java：爬楼梯
public class P70ClimbingStairs{
    public static void main(String[] args) {
        Solution solution = new P70ClimbingStairs().new Solution();
        // TO TEST
        System.out.println(solution.climbStairs(4));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.3 MB,击败了24.23% 的Java用户
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int first = 0,second = 0, result = 1;
        for (int i = 0; i < n; i++){
            first = second;
            second = result;
            result = first + second;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}