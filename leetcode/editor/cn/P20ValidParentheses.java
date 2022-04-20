//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2532 👎 0


package leetcode.editor.cn;

import java.util.Stack;

//Java：有效的括号
public class P20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        // TO TEST
        System.out.println(solution.isValid("]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 			执行耗时:1 ms,击败了99.28% 的Java用户
         * 			内存消耗:36.6 MB,击败了50.82% 的Java用户
         * @param s
         * @return
         */
        public boolean isValid(String s) {
            if (s.length() == 0) {
                return true;
            }
            //设计字符串正括号为出栈，反括号为入栈。 定义类型1为（ 2为{ 3为[ 负数为对应的出栈
            Stack<Integer> stack = new Stack<>();
            //出栈如果与当前类型不一致返回false
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int stackData = getStackData(chars[i]);
                try {
                    if (stackData == 0){
                        continue;
                    }else if (stackData > 0){
                        //入栈
                        stack.push(stackData);
                    }else {
                        //出栈
                        if (stack.pop() != stackData * -1){
                            return false;
                        }
                    }
                }catch (Exception e){
                    return false;
                }
            }
            //遍历完成栈中为空返回true
            if (stack.isEmpty()){
                return true;
            }
            return false;
        }

        private Integer getStackData(char aChar) {
            int result = 0;
            switch (aChar){
                case '(':
                    result = 1;
                    break;
                case ')':
                    result = -1;
                    break;
                case '{':
                    result = 2;
                    break;
                case '}':
                    result = -2;
                    break;
                case '[':
                    result = 3;
                    break;
                case ']':
                    result = -3;
                    break;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}