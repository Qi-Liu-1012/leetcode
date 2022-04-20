//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。 
//
// 
//字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
//I 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。 
//
// 
//
// 示例 1: 
//
// 
//输入: "III"
//输出: 3 
//
// 示例 2: 
//
// 
//输入: "IV"
//输出: 4 
//
// 示例 3: 
//
// 
//输入: "IX"
//输出: 9 
//
// 示例 4: 
//
// 
//输入: "LVIII"
//输出: 58
//解释: L = 50, V= 5, III = 3.
// 
//
// 示例 5: 
//
// 
//输入: "MCMXCIV"
//输出: 1994
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 15 
// s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M') 
// 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内 
// 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。 
// IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。 
// 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。 
// 
// Related Topics 哈希表 数学 字符串 
// 👍 1436 👎 0


package leetcode.editor.cn;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

//Java：罗马数字转整数
public class P13RomanToInteger {
    public static void main(String[] args) {
        Solution solution = new P13RomanToInteger().new Solution();
        // TO TEST
        System.out.println(solution.romanToInt("LVIII"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         执行耗时:5 ms,击败了80.45% 的Java用户
         内存消耗:38.7 MB,击败了45.00% 的Java用户
         * @param s
         * @return
         */
        public int romanToInt1(String s) {
            int result = 0;
            char[] chars = s.toCharArray();
            List<Object> list = new ArrayList<>();
            for (char aChar : chars) {
                list.add(aChar);
            }
            for (ListIterator it = list.listIterator(); it.hasNext(); ) {
                char c = (char) it.next();
                boolean isOperation = true;
                if (it.hasNext()) {
                    char c2 = chars[it.nextIndex()];
                    isOperation = c == 'I' && (c2 == 'V' || c2 == 'X') ? false :
                            c == 'X' && (c2 == 'L' || c2 == 'C') ? false :
                                    c == 'C' && (c2 == 'D' || c2 == 'M') ? false : true;
                }
                switch (c) {
                    case 'I':
                        result += isOperation ? 1 : -1;
                        break;
                    case 'V':
                        result += isOperation ? 5 : -5;
                        break;
                    case 'X':
                        result += isOperation ? 10 : -10;
                        break;
                    case 'L':
                        result += isOperation ? 50 : -50;
                        break;
                    case 'C':
                        result += isOperation ? 100 : -100;
                        break;
                    case 'D':
                        result += isOperation ? 500 : -500;
                        break;
                    case 'M':
                        result += isOperation ? 1000 : -1000;
                        break;

                }
            }
            return result;
        }


        /**
         * 			执行耗时:6 ms,击败了65.89% 的Java用户
         * 			内存消耗:39 MB,击败了16.65% 的Java用户
         * @param s
         * @return
         */
        public int romanToInt(String s){
            Map<Character,Integer> map = new HashMap();
            map.put('I',1);
            map.put('V',5);
            map.put('X',10);
            map.put('L',50);
            map.put('C',100);
            map.put('D',500);
            map.put('M',1000);
//        System.out.println(map.values());
            int sum = 0;
            //从右往左遍历，左小做减法，否则加法
            char[] chars = s.toCharArray();
            sum = map.get(chars[s.length()-1]) ;
            for (int i = s.length()-2; i >=0 ; --i) {
                if(map.get(chars[i])<map.get(chars[i+1])){
                    sum -=map.get(chars[i]);
                }else{
                    sum +=map.get(chars[i]);
                }
            }

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}