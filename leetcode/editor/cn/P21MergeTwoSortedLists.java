//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1825 👎 0


package leetcode.editor.cn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Java：合并两个有序链表
public class P21MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode firstListNode1 = new ListNode(1);
        ListNode firstListNode2 = new ListNode(2);
        ListNode firstListNode3 = new ListNode(4);

        firstListNode1.next = firstListNode2;
        firstListNode2.next = firstListNode3;

        ListNode secondListNode1 = new ListNode(1);
        ListNode secondListNode2 = new ListNode(3);
        ListNode secondListNode3 = new ListNode(4);

        secondListNode1.next = secondListNode2;
        secondListNode2.next = secondListNode3;

        Solution solution = new P21MergeTwoSortedLists().new Solution();
        ListNode listNode = solution.mergeTwoLists(firstListNode1, secondListNode1);

        System.out.println("[" + (listNode!=null ? listNode.toString() : "") + "]");
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        /**
         * 递归的方式
         *
         执行耗时:3 ms,击败了10.30% 的Java用户
         内存消耗:37.9 MB,击败了38.93% 的Java用户
         * @return
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1== null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1.val <= l2.val) {
                l1.next = mergeTwoLists2(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists2(l2.next, l1);
                return l2;
            }
        }

        /**
         * 非递归的方式
         *
         执行耗时:0 ms,击败了100.00% 的Java用户
         内存消耗:37.6 MB,击败了84.03% 的Java用户
         */
        public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(-1);//头结点

            ListNode pointer = result;

            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    pointer.next = l2;
                    l2 = l2.next;
                } else if (l2 == null) {
                    pointer.next = l1;
                    l1 = l1.next;
                } else {
                    if (l1.val <= l2.val) {
                        pointer.next = l1;
                        l1 = l1.next;
                    } else {
                        pointer.next = l2;
                        l2 = l2.next;
                    }
                }
                pointer = pointer.next;
            }
            return result.next;
        }

        /**
         执行耗时:0 ms,击败了100.00% 的Java用户
         内存消耗:37.7 MB,击败了69.26% 的Java用户
         * @return
         */
        public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
            ListNode prehead = new ListNode(-1);

            ListNode prev = prehead;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }

            // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
            prev.next = l1 == null ? l2 : l1;

            return prehead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


class ListNode {
    Integer val;
    ListNode next;

    ListNode() {
    }

    ListNode(Integer x) {
        this.val = x;
    }

    @Override
    public String toString() {
        ListNode node = this;
        String result = "";
        while (node.next != null) {
            result += node.val + ",";
            node = node.next;
        }
        result += node.val;
        return result;
    }
}