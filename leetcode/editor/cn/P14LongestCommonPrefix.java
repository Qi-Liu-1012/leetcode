//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1707 👎 0


package leetcode.editor.cn;

//Java：最长公共前缀
public class P14LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        // TO TEST
        String[] arr = {"a"};
        System.out.println(solution.longestCommonPrefix(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 			执行耗时:0 ms,击败了100.00% 的Java用户
         * 			内存消耗:36.6 MB,击败了28.46% 的Java用户
         * @param strs
         * @return
         */
        public String longestCommonPrefix(String[] strs) {
            //获取最小的字符串
            int minStrIndex = 0;
            int minLength = 201;

            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() < minLength) {
                    minLength = strs[i].length();
                    minStrIndex = i;
                }
            }

            //循环排序列表（排除最小字符串）
            String result = strs[minStrIndex];

            for (int j = 0; j < strs.length; j++) {
                //以最小字符串为基础判断当前数组从0到当前长度是否相等，相等以此判断，不相等推一个字符继续判断
                if (j == minStrIndex) {
                    continue;
                }

                if (!result.equals(strs[j].substring(0, result.length()))) {
                    while (result.length() > 0){
                        result = result.substring(0, result.length() - 1);
                        if (result.equals(strs[j].substring(0, result.length()))){
                            break;
                        }
                    }
                    if (result.length() == 0){
                        result = "";
                        break;
                    }

                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}