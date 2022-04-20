//给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。 
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Hello World"
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：s = "   fly me   to   the moon  "
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：s = "luffy is still joyboy"
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅有英文字母和空格 ' ' 组成 
// s 中至少存在一个单词 
// 
// Related Topics 字符串 
// 👍 393 👎 0


package leetcode.editor.cn;

//Java：最后一个单词的长度
public class P58LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new P58LengthOfLastWord().new Solution();
        System.out.println(solution.lengthOfLastWord("   fly me   to   the moon  "));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 			执行耗时:0 ms,击败了100.00% 的Java用户
         * 			内存消耗:36.4 MB,击败了81.74% 的Java用户
         * @param s
         * @return
         */
        public int lengthOfLastWord(String s) {
            char[] chars = s.toCharArray();
            int l = 0;
            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] != ' '){
                    l++;
                }else if(chars[i] ==' ' && l > 0){
                    return l;
                }
            }
            return l;
        }

        /**
         * 执行耗时:4 ms,击败了5.92% 的Java用户
         * 内存消耗:37.2 MB,击败了5.03% 的Java用户
         *
         * @param s
         * @return
         */
        public int lengthOfLastWord1(String s) {
            String[] split = s.split("\\s+");
            return split[split.length - 1].length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}